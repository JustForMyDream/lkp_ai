package com.lkp.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wanggan on 2016/11/4.
 */
@Entity
@Table(name = "t_cxt_pc_userscan", schema = "lkp", catalog = "")
public class UserScanRecord {
    private String id;
    private Date created;
    private Date lastdate;
    private String itemOpenid;
    private String itemTicket;
    private Boolean used;

    @Id
    @Column(name = "ID")
    @GenericGenerator(name = "uuid",strategy = "uuid.hex")
    @GeneratedValue(generator = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CREATED")
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Basic
    @Column(name = "LASTDATE")
    public Date getLastdate() {
        return lastdate;
    }

    public void setLastdate(Date lastdate) {
        this.lastdate = lastdate;
    }

    @Basic
    @Column(name = "ITEM_OPENID")
    public String getItemOpenid() {
        return itemOpenid;
    }

    public void setItemOpenid(String itemOpenid) {
        this.itemOpenid = itemOpenid;
    }

    @Basic
    @Column(name = "ITEM_TICKET")
    public String getItemTicket() {
        return itemTicket;
    }

    public void setItemTicket(String itemTicket) {
        this.itemTicket = itemTicket;
    }

    @Basic
    @Column(name = "USED")
    public Boolean getUsed() {
        return used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserScanRecord that = (UserScanRecord) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (lastdate != null ? !lastdate.equals(that.lastdate) : that.lastdate != null) return false;
        if (itemOpenid != null ? !itemOpenid.equals(that.itemOpenid) : that.itemOpenid != null) return false;
        if (itemTicket != null ? !itemTicket.equals(that.itemTicket) : that.itemTicket != null) return false;
        if (used != null ? !used.equals(that.used) : that.used != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (lastdate != null ? lastdate.hashCode() : 0);
        result = 31 * result + (itemOpenid != null ? itemOpenid.hashCode() : 0);
        result = 31 * result + (itemTicket != null ? itemTicket.hashCode() : 0);
        result = 31 * result + (used != null ? used.hashCode() : 0);
        return result;
    }
}
