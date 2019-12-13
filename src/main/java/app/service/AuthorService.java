package app.service;

import app.dao.AuthorDao;
import app.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * AuthorService.class
 */
@Service
public class AuthorService {
    @Autowired
    private AuthorDao authorRepository;

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorById(Long id) { return authorRepository.findById(id); }
}