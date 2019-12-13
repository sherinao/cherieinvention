package app.dao;

import app.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * PublisherDao.class
 */
@Repository
public interface PublisherDao extends JpaRepository<Publisher, Long> {
}