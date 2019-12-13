package app.controller;

import app.entity.Book;
import app.model.BookBean;
import app.service.AuthorService;
import app.service.BookService;
import app.service.PublisherService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * BookController.class
 */
@RestController
public class BookController extends BaseController {
    private static final Log LOG = LogFactory.getLog(BookController.class.getName());

    @Autowired
    BookService bookService;

    @Autowired
    AuthorService authorService;

    @Autowired
    PublisherService publisherService;

    @RequestMapping(value = "/books", method = RequestMethod.GET, produces = "application/json")
    public List<Book> getBookListingPage() {
        return bookService.getAllBooks();
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET, produces = "application/json")
    public BookBean getBookPage(@PathVariable String id) {
        BookBean bean = new BookBean();
        if (StringUtils.isNotBlank(id)) {
            Book book = bookService.getBookById(new Long(id)).get();
            BeanUtils.copyProperties(book,bean);
        }
        return bean;
    }

    @PostMapping(path = "/books/book-add", consumes = "application/json", produces = "application/json")
    public void addBookPage(@RequestBody BookBean bean) {
        bean.setId(new Long(0));

        Book book = new Book();

        BeanUtils.copyProperties(bean,book);
        book.setCreatedDt(getCurrentDate());
        book.setCreatedBy("Admin");
        book.setUpdatedDt(getCurrentDate());
        book.setUpdatedBy("Admin");

        Book recentlyAddedBook = bookService.addBook(book);

        LOG.debug("Latest book added id ["+recentlyAddedBook.getId()+"]");
    }

    @PostMapping(path = "/books/book-edit", consumes = "application/json", produces = "application/json")
    public void editBookPage(@RequestBody BookBean bean) {
        Book book = new Book();
        BeanUtils.copyProperties(bean,book);
        book.setUpdatedDt(getCurrentDate());
        book.setUpdatedBy("Admin");

        Book recentlyEditedBook = bookService.addBook(book);

        LOG.debug("Latest book edited id ["+recentlyEditedBook.getId()+"]");
    }
}