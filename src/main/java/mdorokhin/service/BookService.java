package mdorokhin.service;

import mdorokhin.model.Book;
import mdorokhin.utils.exeption.NotFoundException;

import java.util.List;

/**
 * @author Maxim Dorokhin
 *         08.09.2016.
 */
public interface BookService {

    void save(Book book, Integer authorId);
    void delete(Integer id) throws NotFoundException;
    Book getById(Integer id, Integer authorId) throws NotFoundException;
    List<Book> getByAuthor(Integer authorId);
    List<Book> getByTitle(String title);
    List<Book> getAll();

}
