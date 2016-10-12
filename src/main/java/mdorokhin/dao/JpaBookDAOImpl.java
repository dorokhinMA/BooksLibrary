package mdorokhin.dao;

import mdorokhin.model.Author;
import mdorokhin.model.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Maxim Dorokhin
 *         08.09.2016.
 */

@Repository
@Transactional(readOnly = true)
public class JpaBookDAOImpl implements BookDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Book insert(Book book, Integer authorId) {

        Author reference = em.getReference(Author.class, authorId);
        book.setAuthor(reference);

        if(book.isNew()){
            em.persist(book);
        } else {
            em.merge(book);
        }
        return book;
    }

    @Override
    @Transactional
    public boolean remove(Integer id) {
        return em.createNamedQuery(Book.BOOK_REMOVE).setParameter("id", id).executeUpdate() != 0;
    }

    @Override
    public Book getById(Integer id, Integer authorId) {

        Book book = em.find(Book.class, id);
        book.setAuthor(em.getReference(Author.class, authorId));

        return book;

    }

    @Override
    public List<Book> getByTitle(String title) {
        return em.createNamedQuery(Book.BOOK_BY_TITLE, Book.class).setParameter("title", title).getResultList();
    }

    @Override
    public List<Book> getAllByAuthor(Integer authorId) {
        return em.createNamedQuery(Book.BOOKS_BY_AUTHOR, Book.class).setParameter("authorId", authorId).getResultList();
    }

    @Override
    public List<Book> getAll() {
        return em.createNamedQuery(Book.BOOK_ALL, Book.class).getResultList();
    }


}
