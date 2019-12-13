package app.controller;

import app.entity.BookInventory;
import app.model.BookInvBean;
import app.service.AuthorService;
import app.service.BookInvService;
import app.service.PublisherService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * BookInvController.class
 */
@RestController
public class BookInvController extends BaseController {
    private static final Log LOG = LogFactory.getLog(BookInvController.class.getName());

    @Autowired
    BookInvService bookInvService;

    @Autowired
    AuthorService authorService;

    @Autowired
    PublisherService publisherService;

    @RequestMapping(value = "/inventories", method = RequestMethod.GET, produces = "application/json")
    public List<BookInventory> getInventoriesPage() {
        return bookInvService.getAllBookInventories();
    }

    @RequestMapping(value = "/inventories/{id}", method = RequestMethod.GET, produces = "application/json")
    public BookInvBean getInventoryPage(@PathVariable String id) {
        BookInvBean bean = new BookInvBean();
        if (StringUtils.isNotBlank(id)) {
            BookInventory book = bookInvService.getBookInventoryById(new Long(id)).get();
            BeanUtils.copyProperties(book,bean);
            bean.setAuthorId(book.getAuthor().getId());
            bean.setPublisherId(book.getPublisher().getId());
        }
        return bean;
    }

    @PostMapping(path = "/inventory-add", consumes = "application/json", produces = "application/json")
    public void addInventoryPage(@RequestBody BookInvBean bean) {
        bean.setId(new Long(0));
        bean.setTotal(new Long(0));

        BookInventory inventory = new BookInventory();

        BeanUtils.copyProperties(bean,inventory);

        if (bean.getAuthorId() != null)
            inventory.setAuthor(authorService.getAuthorById(bean.getAuthorId()).get());

        if (bean.getPublisherId() != null)
            inventory.setPublisher(publisherService.getPublisherById(bean.getPublisherId()).get());

        inventory.setCreatedDt(getCurrentDate());
        inventory.setCreatedBy("Admin");
        inventory.setUpdatedDt(getCurrentDate());
        inventory.setUpdatedBy("Admin");

        BookInventory recentlyAddedInventory = bookInvService.addBook(inventory);

        LOG.debug("Latest inventory added id ["+recentlyAddedInventory.getId()+"]");
    }

    @PostMapping(path = "/inventory-edit", consumes = "application/json", produces = "application/json")
    public void editInventoryPage(@RequestBody BookInvBean bean) {
        BookInventory inventory = new BookInventory();
        bean.setTotal(new Long(0));
        BeanUtils.copyProperties(bean,inventory);

        if (bean.getAuthorId() != null)
            inventory.setAuthor(authorService.getAuthorById(bean.getAuthorId()).get());

        if (bean.getPublisherId() != null)
            inventory.setPublisher(publisherService.getPublisherById(bean.getPublisherId()).get());

        inventory.setUpdatedDt(getCurrentDate());
        inventory.setUpdatedBy("Admin");

        BookInventory recentlyEditedInventory = bookInvService.addBook(inventory);

        LOG.debug("Latest inventory edited id ["+recentlyEditedInventory.getId()+"]");
    }
}