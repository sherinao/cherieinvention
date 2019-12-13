package app.service;

import app.dao.BookInventoryDao;
import app.entity.BookInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * BookInvService.class
 */
@Service
public class BookInvService {
    @Autowired
    private BookInventoryDao bookInvRepository;

    public BookInventory addBook(BookInventory bookInventory) {
        return bookInvRepository.save(bookInventory);
    }

    public List<BookInventory> getAllBookInventories() {
        return bookInvRepository.findAll();
    }

    public Optional<BookInventory> getBookInventoryById(Long id) { return bookInvRepository.findById(id); }
}
