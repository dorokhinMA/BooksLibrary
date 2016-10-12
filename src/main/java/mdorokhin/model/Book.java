package mdorokhin.model;

import javax.persistence.*;

/**
 * @author Maxim Dorokhin
 *         08.09.2016.
 */

@Entity
@Table(name = "books")
@NamedQueries({
        @NamedQuery(name = Book.BOOK_GET, query = "SELECT b FROM Book b WHERE b.id=:id AND b.author.id=:authorId"),
        @NamedQuery(name = Book.BOOK_REMOVE, query = "DELETE FROM Book b WHERE b.id=:id"),
        @NamedQuery(name = Book.BOOK_BY_TITLE, query = "SELECT b FROM Book b WHERE b.title=:title"),
        @NamedQuery(name = Book.BOOKS_BY_AUTHOR, query = "SELECT b FROM Book b WHERE b.author.id=:authorId ORDER BY b.title"),
        @NamedQuery(name = Book.BOOK_ALL, query = "SELECT b FROM Book b ORDER BY b.title"),
})
public class Book extends BaseEntity {

    public static final String BOOK_GET = "Book.get";
    public static final String BOOK_REMOVE = "Book.remove";
    public static final String BOOK_BY_TITLE = "Book.getByTitle";
    public static final String BOOKS_BY_AUTHOR = "Book.byAuthor";
    public static final String BOOK_ALL = "Book.getAll";

    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @Lob
    @Basic(fetch=FetchType.LAZY)
    @Column(name = "image")
    private byte[] image;

    @Column(name ="text", nullable = false)
    private String text;

    public Book() {
    }

    public Book(Integer id, String title, Author author, byte[] image, String text) {
        super(id);
        this.title = title;
        this.author = author;
        this.image = image;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                "} " + super.toString();
    }
}
