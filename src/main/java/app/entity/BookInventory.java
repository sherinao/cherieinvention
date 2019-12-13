package app.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * BookInventory.class
 */
@Entity
@Table( name="TB_BOOK_INVENTORY" )
public class BookInventory extends AuditEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "bookInventory_Sequence")
    @SequenceGenerator(name = "bookInventory_Sequence", sequenceName = "TB_BOOK_INVENTORY_SEQ", allocationSize = 1)
    @Column(name="ID")
    private long id;

    @JoinColumn(name = "AUTHOR_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(targetEntity = Author.class)
    private Author author;

    @JoinColumn(name = "PUBLISHER_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(targetEntity = Publisher.class)
    private Publisher publisher;

    @Column(name="PRICE")
    private BigDecimal price;

    @Column(name="AMT_PAGES")
    private long amtPages;

    @Column(name="TOTAL")
    private long total;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public long getAmtPages() {
        return amtPages;
    }

    public void setAmtPages(long amtPages) {
        this.amtPages = amtPages;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookInventory)) return false;
        if (!super.equals(o)) return false;
        BookInventory that = (BookInventory) o;
        return getId() == that.getId() &&
                getPrice() == that.getPrice() &&
                getAmtPages() == that.getAmtPages() &&
                getTotal() == that.getTotal() &&
                Objects.equals(getAuthor(), that.getAuthor()) &&
                Objects.equals(getPublisher(), that.getPublisher());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getAuthor(), getPublisher(), getPrice(), getAmtPages(), getTotal());
    }
}