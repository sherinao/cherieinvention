package app.service;

import app.dao.PublisherDao;
import app.entity.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * PublisherService.class
 */

@Service
public class PublisherService {
    @Autowired
    private PublisherDao publisherRepository;

    public Publisher addPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    public Optional<Publisher> getPublisherById(Long id) { return publisherRepository.findById(id); }
}