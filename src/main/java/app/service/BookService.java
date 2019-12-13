package app.service;

import app.dao.BookDao;
import app.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * BookServiceImpl.class
 */
@Service
public class BookService {

    @Autowired
    private BookDao bookRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) { return bookRepository.findById(id); }
}