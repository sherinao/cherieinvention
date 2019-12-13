package app.dao;

import app.entity.BookInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * BookInventoryDao.class
 */
@Repository
public interface BookInventoryDao extends JpaRepository<BookInventory, Long> {
}