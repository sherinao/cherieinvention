
package app.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Book.class
 */
@Entity
@Table( name="TB_BOOK" )
public class Book extends AuditEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "book_Sequence")
    @SequenceGenerator(name = "book_Sequence", sequenceName = "TB_BOOK_SEQ", allocationSize = 1)
    @Column(name="ID")
    private long id;
    @Column(name = "ISBN")
    private String isbn;

    @JoinColumn(name = "INVENTORY_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(targetEntity = BookInventory.class)
    private BookInventory bookInventory;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BookInventory getBookInventory() {
        return bookInventory;
    }

    public void setBookInventory(BookInventory bookInventory) {
        this.bookInventory = bookInventory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return getId() == book.getId() &&
                Objects.equals(getIsbn(), book.getIsbn()) &&
                Objects.equals(getBookInventory(), book.getBookInventory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getIsbn(), getBookInventory());
    }
}