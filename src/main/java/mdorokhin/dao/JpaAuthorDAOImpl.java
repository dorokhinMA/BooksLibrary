package mdorokhin.dao;

import mdorokhin.model.Author;
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
public class JpaAuthorDAOImpl implements AuthorDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Author insert(Author author) {

        if (author.isNew()) {
            em.persist(author);
        } else {
            em.merge(author);
        }
        return author;
    }

    @Override
    @Transactional
    public boolean remove(Integer id) {
        return em.createNamedQuery(Author.REMOVE).setParameter("id", id).executeUpdate() != 0;
    }

    @Override
    public Author getById(Integer id) {
        return em.find(Author.class, id);
    }

    @Override
    public List<Author> getAll() {
        return em.createNamedQuery(Author.ALL_SORTED, Author.class).getResultList();
    }
}
