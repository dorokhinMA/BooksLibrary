package mdorokhin.service;

import mdorokhin.dao.AuthorDAO;
import mdorokhin.model.Author;
import mdorokhin.utils.exeption.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Maxim Dorokhin
 *         08.09.2016.
 */

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDAO authorDAO;


    @Override
    public void save(Author author) {
        authorDAO.insert(author);
    }

    @Override
    public void delete(Integer id) throws NotFoundException {
        authorDAO.remove(id);
    }

    @Override
    public Author getById(Integer id) throws NotFoundException {
        return authorDAO.getById(id);
    }

    @Override
    public List<Author> getAll() {
        return authorDAO.getAll();
    }
}
