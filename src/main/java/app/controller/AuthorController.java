package app.controller;

import app.entity.Author;
import app.model.AuthorBean;
import app.service.AuthorService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AuthorController.class
 */
@RestController
public class AuthorController extends BaseController {
    private static final Log LOG = LogFactory.getLog(AuthorController.class.getName());

    @Autowired
    AuthorService authorService;

    @RequestMapping(value = "/authors", method = RequestMethod.GET, produces = "application/json")
    public List<Author> getAuthorListingPage() {
        return authorService.getAllAuthors();
    }

    @RequestMapping(value = "/authors/{id}", method = RequestMethod.GET, produces = "application/json")
    public AuthorBean getAuthorPage(@PathVariable String id) {
        AuthorBean bean = new AuthorBean();
        if (StringUtils.isNotBlank(id)) {
            Author author = authorService.getAuthorById(new Long(id)).get();
            BeanUtils.copyProperties(author,bean);
        }
        return bean;
    }

    @PostMapping(path = "/authors/author-add", consumes = "application/json", produces = "application/json")
    public void addAuthorPage(@RequestBody AuthorBean bean) {
        bean.setId(new Long(0));

        Author author = new Author();

        BeanUtils.copyProperties(bean,author);

        author.setCreatedDt(getCurrentDate());
        author.setCreatedBy("Admin");
        author.setUpdatedDt(getCurrentDate());
        author.setUpdatedBy("Admin");

        Author recentlyAddedAuthor = authorService.addAuthor(author);
        LOG.debug("Latest author added id ["+recentlyAddedAuthor.getId()+"]");
    }

    @PostMapping(path = "/authors/author-edit", consumes = "application/json", produces = "application/json")
    public void editAuthorPage(@RequestBody AuthorBean bean) {
        Author author = new Author();
        BeanUtils.copyProperties(bean,author);

        author.setUpdatedDt(getCurrentDate());
        author.setUpdatedBy("Admin");

        Author recentlyAddedAuthor = authorService.addAuthor(author);
        LOG.debug("Latest author added id ["+recentlyAddedAuthor.getId()+"]");
    }
}