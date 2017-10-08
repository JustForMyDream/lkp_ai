package com.lkp.entity;

import com.lkp.bean.SQLDefautValue;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 *
 */
@Entity
@javax.persistence.Table(name = "tlk_wechat_setting", schema = "lkp", catalog = "")
@Access(AccessType.PROPERTY)
public class TlkWechatSettingEntity {
    private String parent;

    @Basic
    @javax.persistence.Column(name = "PARENT", nullable = true, length = 200)
    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    private Date lastmodified = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @javax.persistence.Column(name = "LASTMODIFIED", nullable = true)
    public Date getLastmodified() {
        return lastmodified;
    }

    public void setLastmodified(Date lastmodified) {
        this.lastmodified = lastmodified;
    }

    private String formname = "lkp/网站设置/wechat_setting";

    @Basic
    @javax.persistence.Column(name = "FORMNAME", nullable = true, length = 200)
    public String getFormname() {
        return formname;
    }

    public void setFormname(String formname) {
        this.formname = formname;
    }

    private String state;

    @Basic
    @javax.persistence.Column(name = "STATE", nullable = true, length = 200)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    private String audituser;

    @Basic
    @javax.persistence.Column(name = "AUDITUSER", nullable = true, length = 200)
    public String getAudituser() {
        return audituser;
    }

    public void setAudituser(String audituser) {
        this.audituser = audituser;
    }

    private Date auditdate;

    @Temporal(TemporalType.TIMESTAMP)
    @javax.persistence.Column(name = "AUDITDATE", nullable = true)
    public Date getAuditdate() {
        return auditdate;
    }

    public void setAuditdate(Date auditdate) {
        this.auditdate = auditdate;
    }

    private String author = SQLDefautValue.author;

    @Basic
    @javax.persistence.Column(name = "AUTHOR", nullable = true, length = 200)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    private String authorDeptIndex = SQLDefautValue.author_dept_index;

    @Basic
    @javax.persistence.Column(name = "AUTHOR_DEPT_INDEX", nullable = true, length = 2000)
    public String getAuthorDeptIndex() {
        return authorDeptIndex;
    }

    public void setAuthorDeptIndex(String authorDeptIndex) {
        this.authorDeptIndex = authorDeptIndex;
    }

    private Date created = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @javax.persistence.Column(name = "CREATED", nullable = true)
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    private String formid = "11e6-91d4-b6143336-ad8b-11472dfbd6fd";

    @Basic
    @javax.persistence.Column(name = "FORMID", nullable = true, length = 200)
    public String getFormid() {
        return formid;
    }

    public void setFormid(String formid) {
        this.formid = formid;
    }

    private Boolean istmp = false;

    @Basic
    @javax.persistence.Column(name = "ISTMP", nullable = true)
    public Boolean getIstmp() {
        return istmp;
    }

    public void setIstmp(Boolean istmp) {
        this.istmp = istmp;
    }

    private Integer versions = 2;

    @Basic
    @javax.persistence.Column(name = "VERSIONS", nullable = true)
    public Integer getVersions() {
        return versions;
    }

    public void setVersions(Integer versions) {
        this.versions = versions;
    }

    private String applicationid = SQLDefautValue.applicationid;

    @Basic
    @javax.persistence.Column(name = "APPLICATIONID", nullable = true, length = 200)
    public String getApplicationid() {
        return applicationid;
    }

    public void setApplicationid(String applicationid) {
        this.applicationid = applicationid;
    }

    private Integer stateint = 0;

    @Basic
    @javax.persistence.Column(name = "STATEINT", nullable = true)
    public Integer getStateint() {
        return stateint;
    }

    public void setStateint(Integer stateint) {
        this.stateint = stateint;
    }

    private String statelabel;

    @Basic
    @javax.persistence.Column(name = "STATELABEL", nullable = true, length = 200)
    public String getStatelabel() {
        return statelabel;
    }

    public void setStatelabel(String statelabel) {
        this.statelabel = statelabel;
    }

    private String auditornames;

    @Basic
    @javax.persistence.Column(name = "AUDITORNAMES", nullable = true, length = 200)
    public String getAuditornames() {
        return auditornames;
    }

    public void setAuditornames(String auditornames) {
        this.auditornames = auditornames;
    }

    private String lastflowoperation;

    @Basic
    @javax.persistence.Column(name = "LASTFLOWOPERATION", nullable = true, length = 200)
    public String getLastflowoperation() {
        return lastflowoperation;
    }

    public void setLastflowoperation(String lastflowoperation) {
        this.lastflowoperation = lastflowoperation;
    }

    private String lastmodifier = SQLDefautValue.author;

    @Basic
    @javax.persistence.Column(name = "LASTMODIFIER", nullable = true, length = 200)
    public String getLastmodifier() {
        return lastmodifier;
    }

    public void setLastmodifier(String lastmodifier) {
        this.lastmodifier = lastmodifier;
    }

    private String domainid = SQLDefautValue.domain;

    @Basic
    @javax.persistence.Column(name = "DOMAINID", nullable = true, length = 200)
    public String getDomainid() {
        return domainid;
    }

    public void setDomainid(String domainid) {
        this.domainid = domainid;
    }

    private String auditorlist = "{}";

    @Basic
    @javax.persistence.Column(name = "AUDITORLIST", nullable = true, length = 200)
    public String getAuditorlist() {
        return auditorlist;
    }

    public void setAuditorlist(String auditorlist) {
        this.auditorlist = auditorlist;
    }

    private String statelabelinfo;

    @Basic
    @javax.persistence.Column(name = "STATELABELINFO", nullable = true, length = 200)
    public String getStatelabelinfo() {
        return statelabelinfo;
    }

    public void setStatelabelinfo(String statelabelinfo) {
        this.statelabelinfo = statelabelinfo;
    }

    private String prevauditnode;

    @Basic
    @javax.persistence.Column(name = "PREVAUDITNODE", nullable = true, length = 200)
    public String getPrevauditnode() {
        return prevauditnode;
    }

    public void setPrevauditnode(String prevauditnode) {
        this.prevauditnode = prevauditnode;
    }

    private String prevaudituser;

    @Basic
    @javax.persistence.Column(name = "PREVAUDITUSER", nullable = true, length = 200)
    public String getPrevaudituser() {
        return prevaudituser;
    }

    public void setPrevaudituser(String prevaudituser) {
        this.prevaudituser = prevaudituser;
    }

    private String itemAppid;

    @Basic
    @javax.persistence.Column(name = "ITEM_APPID", nullable = true, length = 200)
    public String getItemAppid() {
        return itemAppid;
    }

    public void setItemAppid(String itemAppid) {
        this.itemAppid = itemAppid;
    }

    private String itemToken;

    @Basic
    @javax.persistence.Column(name = "ITEM_TOKEN", nullable = true, length = 200)
    public String getItemToken() {
        return itemToken;
    }

    public void setItemToken(String itemToken) {
        this.itemToken = itemToken;
    }

    private String itemAppsecret;

    @Basic
    @javax.persistence.Column(name = "ITEM_APPSECRET", nullable = true, length = 200)
    public String getItemAppsecret() {
        return itemAppsecret;
    }

    public void setItemAppsecret(String itemAppsecret) {
        this.itemAppsecret = itemAppsecret;
    }

    private String itemEncrypt;

    @Basic
    @javax.persistence.Column(name = "ITEM_ENCRYPT", nullable = true, length = 200)
    public String getItemEncrypt() {
        return itemEncrypt;
    }

    public void setItemEncrypt(String itemEncrypt) {
        this.itemEncrypt = itemEncrypt;
    }

    private String id;

    @Id
    @javax.persistence.Column(name = "ID", nullable = false, length = 200)
    @GenericGenerator(name = "uuid", strategy = "uuid.hex")
    @GeneratedValue(generator = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TlkWechatSettingEntity that = (TlkWechatSettingEntity) o;

        if (parent != null ? !parent.equals(that.parent) : that.parent != null) return false;
        if (lastmodified != null ? !lastmodified.equals(that.lastmodified) : that.lastmodified != null) return false;
        if (formname != null ? !formname.equals(that.formname) : that.formname != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (audituser != null ? !audituser.equals(that.audituser) : that.audituser != null) return false;
        if (auditdate != null ? !auditdate.equals(that.auditdate) : that.auditdate != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (authorDeptIndex != null ? !authorDeptIndex.equals(that.authorDeptIndex) : that.authorDeptIndex != null)
            return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (formid != null ? !formid.equals(that.formid) : that.formid != null) return false;
        if (istmp != null ? !istmp.equals(that.istmp) : that.istmp != null) return false;
        if (versions != null ? !versions.equals(that.versions) : that.versions != null) return false;
        if (applicationid != null ? !applicationid.equals(that.applicationid) : that.applicationid != null)
            return false;
        if (stateint != null ? !stateint.equals(that.stateint) : that.stateint != null) return false;
        if (statelabel != null ? !statelabel.equals(that.statelabel) : that.statelabel != null) return false;
        if (auditornames != null ? !auditornames.equals(that.auditornames) : that.auditornames != null) return false;
        if (lastflowoperation != null ? !lastflowoperation.equals(that.lastflowoperation) : that.lastflowoperation != null)
            return false;
        if (lastmodifier != null ? !lastmodifier.equals(that.lastmodifier) : that.lastmodifier != null) return false;
        if (domainid != null ? !domainid.equals(that.domainid) : that.domainid != null) return false;
        if (auditorlist != null ? !auditorlist.equals(that.auditorlist) : that.auditorlist != null) return false;
        if (statelabelinfo != null ? !statelabelinfo.equals(that.statelabelinfo) : that.statelabelinfo != null)
            return false;
        if (prevauditnode != null ? !prevauditnode.equals(that.prevauditnode) : that.prevauditnode != null)
            return false;
        if (prevaudituser != null ? !prevaudituser.equals(that.prevaudituser) : that.prevaudituser != null)
            return false;
        if (itemAppid != null ? !itemAppid.equals(that.itemAppid) : that.itemAppid != null) return false;
        if (itemToken != null ? !itemToken.equals(that.itemToken) : that.itemToken != null) return false;
        if (itemAppsecret != null ? !itemAppsecret.equals(that.itemAppsecret) : that.itemAppsecret != null)
            return false;
        if (itemEncrypt != null ? !itemEncrypt.equals(that.itemEncrypt) : that.itemEncrypt != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = parent != null ? parent.hashCode() : 0;
        result = 31 * result + (lastmodified != null ? lastmodified.hashCode() : 0);
        result = 31 * result + (formname != null ? formname.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (audituser != null ? audituser.hashCode() : 0);
        result = 31 * result + (auditdate != null ? auditdate.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (authorDeptIndex != null ? authorDeptIndex.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (formid != null ? formid.hashCode() : 0);
        result = 31 * result + (istmp != null ? istmp.hashCode() : 0);
        result = 31 * result + (versions != null ? versions.hashCode() : 0);
        result = 31 * result + (applicationid != null ? applicationid.hashCode() : 0);
        result = 31 * result + (stateint != null ? stateint.hashCode() : 0);
        result = 31 * result + (statelabel != null ? statelabel.hashCode() : 0);
        result = 31 * result + (auditornames != null ? auditornames.hashCode() : 0);
        result = 31 * result + (lastflowoperation != null ? lastflowoperation.hashCode() : 0);
        result = 31 * result + (lastmodifier != null ? lastmodifier.hashCode() : 0);
        result = 31 * result + (domainid != null ? domainid.hashCode() : 0);
        result = 31 * result + (auditorlist != null ? auditorlist.hashCode() : 0);
        result = 31 * result + (statelabelinfo != null ? statelabelinfo.hashCode() : 0);
        result = 31 * result + (prevauditnode != null ? prevauditnode.hashCode() : 0);
        result = 31 * result + (prevaudituser != null ? prevaudituser.hashCode() : 0);
        result = 31 * result + (itemAppid != null ? itemAppid.hashCode() : 0);
        result = 31 * result + (itemToken != null ? itemToken.hashCode() : 0);
        result = 31 * result + (itemAppsecret != null ? itemAppsecret.hashCode() : 0);
        result = 31 * result + (itemEncrypt != null ? itemEncrypt.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
