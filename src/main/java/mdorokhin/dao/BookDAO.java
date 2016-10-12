package mdorokhin.dao;

import mdorokhin.model.Book;

import java.util.List;

/**
 * @author Maxim Dorokhin
 *         08.09.2016.
 */
public interface BookDAO {

    Book insert(Book book, Integer authorId);

    boolean remove(Integer id);

    Book getById(Integer id, Integer authorId);

    List<Book> getByTitle(String title);

    List<Book> getAllByAuthor(Integer authorId);

    List<Book> getAll();


}
