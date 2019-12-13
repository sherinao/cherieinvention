package app.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * AuditEntity.class
 */
@MappedSuperclass
public abstract class AuditEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "NAME")
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DT")
    private Date createdDt;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_DT")
    private Date updatedDt;

    @Column(name = "UPDATED_BY")
    private String updatedBy;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Date getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedDt() {
        return updatedDt;
    }

    public void setUpdatedDt(Date updatedDt) {
        this.updatedDt = updatedDt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuditEntity)) return false;
        AuditEntity that = (AuditEntity) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getCreatedDt(), that.getCreatedDt()) &&
                Objects.equals(getCreatedBy(), that.getCreatedBy()) &&
                Objects.equals(getUpdatedDt(), that.getUpdatedDt()) &&
                Objects.equals(getUpdatedBy(), that.getUpdatedBy());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCreatedDt(), getCreatedBy(), getUpdatedDt(), getUpdatedBy());
    }
}