package app.dao;

import app.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * BookDao.class
 */
@Repository
public interface BookDao extends JpaRepository<Book, Long> {
}