package mdorokhin.service;

import mdorokhin.model.Author;
import mdorokhin.utils.exeption.NotFoundException;

import java.util.List;

/**
 * @author Maxim Dorokhin
 *         08.09.2016.
 */
public interface AuthorService {

    void save(Author author);
    void delete(Integer id) throws NotFoundException;
    Author getById(Integer id) throws NotFoundException;
    List<Author> getAll();

}
