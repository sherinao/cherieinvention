package app.dao;

import app.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * AuthorDao.class
 */
@Repository
public interface AuthorDao extends JpaRepository<Author, Long> {
}