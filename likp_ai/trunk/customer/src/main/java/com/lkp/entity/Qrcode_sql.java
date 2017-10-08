package com.lkp.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wanggan on 2016/11/4.
 */
@Entity
@Table(name = "t_cxt_qrcode", schema = "lkp", catalog = "")
public class Qrcode_sql {
    private String id;
    private String expire_seconds;
    private Date overDate;
    private String sceneId;
    private String sceneStr;
    private String ticket;
    private String type;
    private Date updateDate;
    private String url;
    private Boolean useful;
    private int version;

    @Id
    @Column(name = "id")
    @GenericGenerator(name = "uuid",strategy = "uuid.hex")
    @GeneratedValue(generator = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    @Basic
    @Column(name = "expire_seconds")
    public String getExpire_seconds() {
        return expire_seconds;
    }

    public void setExpire_seconds(String expire_seconds) {
        this.expire_seconds = expire_seconds;
    }

    @Basic
    @Column(name = "overDate")
    public Date getOverDate() {
        return overDate;
    }

    public void setOverDate(Date overDate) {
        this.overDate = overDate;
    }

    @Basic
    @Column(name = "scene_id")
    public String getSceneId() {
        return sceneId;
    }

    public void setSceneId(String sceneId) {
        this.sceneId = sceneId;
    }

    @Basic
    @Column(name = "scene_str")
    public String getSceneStr() {
        return sceneStr;
    }

    public void setSceneStr(String sceneStr) {
        this.sceneStr = sceneStr;
    }

    @Basic
    @Column(name = "ticket")
    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "updateDate")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "useful")
    public Boolean getUseful() {
        return useful;
    }

    public void setUseful(Boolean useful) {
        this.useful = useful;
    }

    @Basic
    @Column(name = "version")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Qrcode_sql that = (Qrcode_sql) o;

        if (id != that.id) return false;
        if (version != that.version) return false;
        if (expire_seconds != null ? !expire_seconds.equals(that.expire_seconds) : that.expire_seconds != null)
            return false;
        if (overDate != null ? !overDate.equals(that.overDate) : that.overDate != null) return false;
        if (sceneId != null ? !sceneId.equals(that.sceneId) : that.sceneId != null) return false;
        if (sceneStr != null ? !sceneStr.equals(that.sceneStr) : that.sceneStr != null) return false;
        if (ticket != null ? !ticket.equals(that.ticket) : that.ticket != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (useful != null ? !useful.equals(that.useful) : that.useful != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id!= null ? id.hashCode() : 0;
        result = 31 * result + (expire_seconds != null ? expire_seconds.hashCode() : 0);
        result = 31 * result + (overDate != null ? overDate.hashCode() : 0);
        result = 31 * result + (sceneId != null ? sceneId.hashCode() : 0);
        result = 31 * result + (sceneStr != null ? sceneStr.hashCode() : 0);
        result = 31 * result + (ticket != null ? ticket.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (useful != null ? useful.hashCode() : 0);
        result = 31 * result + version;
        return result;
    }
}
