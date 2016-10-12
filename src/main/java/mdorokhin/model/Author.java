package mdorokhin.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author Maxim Dorokhin
 *         08.09.2016.
 */

@Entity
@Table(name = "authors")
@NamedQueries({
        @NamedQuery(name = Author.ALL_SORTED, query = "SELECT a FROM Author a LEFT JOIN FETCH a.books ORDER BY a.fio"),
        @NamedQuery(name = Author.REMOVE, query = "DELETE FROM Author a WHERE a.id=:id")
})
public class Author extends BaseEntity {

    public static final String ALL_SORTED = "Author.getAllSorted";
    public static final String REMOVE = "Author.remove";

    @Column(name = "fio", nullable = false, unique = true)
    private String fio;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "author", fetch = FetchType.EAGER)
    private List<Book> books;

    public Author() {
    }

    public Author(String fio){
        this.fio = fio;
    }

    public Author(Integer id, String fio, List<Book> books) {
        super(id);
        this.fio = fio;
        this.books = books;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" + "fio='" + fio + '\'' +
                ", books=" + books +
                '}';
    }
}
