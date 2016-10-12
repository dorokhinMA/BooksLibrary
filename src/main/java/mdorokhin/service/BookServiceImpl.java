package mdorokhin.service;

import mdorokhin.dao.BookDAO;
import mdorokhin.model.Book;
import mdorokhin.utils.exeption.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Maxim Dorokhin
 *         08.09.2016.
 */

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;


    @Override
    public void save(Book book, Integer authorId) {
        bookDAO.insert(book, authorId);
    }

    @Override
    public void delete(Integer id) throws NotFoundException {
        bookDAO.remove(id);
    }

    @Override
    public Book getById(Integer id, Integer authorId) throws NotFoundException {
        return bookDAO.getById(id, authorId);
    }

    @Override
    public List<Book> getByAuthor(Integer authorId) {
        return bookDAO.getAllByAuthor(authorId);
    }

    @Override
    public List<Book> getByTitle(String title) {
        return bookDAO.getByTitle(title);
    }

    @Override
    public List<Book> getAll() {
        return bookDAO.getAll();
    }


}

