package com.lkp.entity;

import javax.persistence.*;

/**
 *
 */
@Entity
@Table(name = "auth_productshow", schema = "lkp", catalog = "")
public class AuthProductshowEntity {
    private String id;
    private String docId;
    private String value;

    @Id
    @Column(name = "ID", nullable = false, length = 200)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "DOC_ID", nullable = true, length = 200)
    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    @Basic
    @Column(name = "VALUE", nullable = true, length = 200)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthProductshowEntity that = (AuthProductshowEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (docId != null ? !docId.equals(that.docId) : that.docId != null) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (docId != null ? docId.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
