package app.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * BookInvBean.class
 */
public class BookInvBean extends ModelBean {

    private Long authorId;
    private Long publisherId;
    private BigDecimal price;
    private Long amtPages;
    private Long total;
    private List<String> isbns;

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public BigDecimal getPrice() { return price; }

    public void setPrice(BigDecimal price) {  this.price = price; }

    public Long getAmtPages() {
        return amtPages;
    }

    public void setAmtPages(Long amtPages) {
        this.amtPages = amtPages;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<String> getIsbns() {
        return isbns;
    }

    public void setIsbns(List<String> isbns) {
        this.isbns = isbns;
    }
}