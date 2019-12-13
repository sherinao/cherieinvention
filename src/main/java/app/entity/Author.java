package app.entity;

import javax.persistence.*;

/**
 * Author.class
 */
@Entity
@Table( name="TB_AUTHOR" )
public class Author extends AuditEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "author_Sequence")
    @SequenceGenerator(name = "author_Sequence", sequenceName = "TB_AUTHOR_SEQ", allocationSize = 1)
    @Column(name="ID")
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}