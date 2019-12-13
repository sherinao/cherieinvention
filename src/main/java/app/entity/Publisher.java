package app.entity;

import javax.persistence.*;

/**
 * Publisher.class
 */
@Entity
@Table( name="TB_PUBLISHER" )
public class Publisher extends AuditEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "publisher_Sequence")
    @SequenceGenerator(name = "publisher_Sequence", sequenceName = "TB_PUBLISHER_SEQ", allocationSize = 1)
    @Column(name="ID")
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}