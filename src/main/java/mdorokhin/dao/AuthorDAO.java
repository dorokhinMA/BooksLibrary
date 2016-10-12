package mdorokhin.dao;

import mdorokhin.model.Author;

import java.util.List;


/**
 * @author Maxim Dorokhin
 *         08.09.2016.
 */
public interface AuthorDAO {

    Author insert(Author author);

    boolean remove(Integer id);

    Author getById(Integer id);

    List<Author> getAll();

}
