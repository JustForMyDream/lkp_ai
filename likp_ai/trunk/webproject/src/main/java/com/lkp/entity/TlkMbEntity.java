package com.lkp.entity;

import javax.persistence.*;
import java.util.Date;

/**
 *
 */
@Entity
@Table(name = "tlk_mb", schema = "lkp", catalog = "")
public class TlkMbEntity {
    private String parent;
    private Date lastmodified;
    private String formname;
    private String state;
    private String audituser;
    private Date auditdate;
    private String author;
    private String authorDeptIndex;
    private Date created;
    private String formid;
    private Boolean istmp;
    private Integer versions;
    private String applicationid;
    private Integer stateint;
    private String statelabel;
    private String auditornames;
    private String lastflowoperation;
    private String lastmodifier;
    private String domainid;
    private String auditorlist;
    private String statelabelinfo;
    private String prevauditnode;
    private String prevaudituser;
    private String itemMbtp;
    private String itemMbzb;
    private String id;

    @Basic
    @Column(name = "PARENT")
    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    @Basic
    @Column(name = "LASTMODIFIED")
    public Date getLastmodified() {
        return lastmodified;
    }

    public void setLastmodified(Date lastmodified) {
        this.lastmodified = lastmodified;
    }

    @Basic
    @Column(name = "FORMNAME")
    public String getFormname() {
        return formname;
    }

    public void setFormname(String formname) {
        this.formname = formname;
    }

    @Basic
    @Column(name = "STATE")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "AUDITUSER")
    public String getAudituser() {
        return audituser;
    }

    public void setAudituser(String audituser) {
        this.audituser = audituser;
    }

    @Basic
    @Column(name = "AUDITDATE")
    public Date getAuditdate() {
        return auditdate;
    }

    public void setAuditdate(Date auditdate) {
        this.auditdate = auditdate;
    }

    @Basic
    @Column(name = "AUTHOR")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "AUTHOR_DEPT_INDEX")
    public String getAuthorDeptIndex() {
        return authorDeptIndex;
    }

    public void setAuthorDeptIndex(String authorDeptIndex) {
        this.authorDeptIndex = authorDeptIndex;
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
    @Column(name = "FORMID")
    public String getFormid() {
        return formid;
    }

    public void setFormid(String formid) {
        this.formid = formid;
    }

    @Basic
    @Column(name = "ISTMP")
    public Boolean getIstmp() {
        return istmp;
    }

    public void setIstmp(Boolean istmp) {
        this.istmp = istmp;
    }

    @Basic
    @Column(name = "VERSIONS")
    public Integer getVersions() {
        return versions;
    }

    public void setVersions(Integer versions) {
        this.versions = versions;
    }

    @Basic
    @Column(name = "APPLICATIONID")
    public String getApplicationid() {
        return applicationid;
    }

    public void setApplicationid(String applicationid) {
        this.applicationid = applicationid;
    }

    @Basic
    @Column(name = "STATEINT")
    public Integer getStateint() {
        return stateint;
    }

    public void setStateint(Integer stateint) {
        this.stateint = stateint;
    }

    @Basic
    @Column(name = "STATELABEL")
    public String getStatelabel() {
        return statelabel;
    }

    public void setStatelabel(String statelabel) {
        this.statelabel = statelabel;
    }

    @Basic
    @Column(name = "AUDITORNAMES")
    public String getAuditornames() {
        return auditornames;
    }

    public void setAuditornames(String auditornames) {
        this.auditornames = auditornames;
    }

    @Basic
    @Column(name = "LASTFLOWOPERATION")
    public String getLastflowoperation() {
        return lastflowoperation;
    }

    public void setLastflowoperation(String lastflowoperation) {
        this.lastflowoperation = lastflowoperation;
    }

    @Basic
    @Column(name = "LASTMODIFIER")
    public String getLastmodifier() {
        return lastmodifier;
    }

    public void setLastmodifier(String lastmodifier) {
        this.lastmodifier = lastmodifier;
    }

    @Basic
    @Column(name = "DOMAINID")
    public String getDomainid() {
        return domainid;
    }

    public void setDomainid(String domainid) {
        this.domainid = domainid;
    }

    @Basic
    @Column(name = "AUDITORLIST")
    public String getAuditorlist() {
        return auditorlist;
    }

    public void setAuditorlist(String auditorlist) {
        this.auditorlist = auditorlist;
    }

    @Basic
    @Column(name = "STATELABELINFO")
    public String getStatelabelinfo() {
        return statelabelinfo;
    }

    public void setStatelabelinfo(String statelabelinfo) {
        this.statelabelinfo = statelabelinfo;
    }

    @Basic
    @Column(name = "PREVAUDITNODE")
    public String getPrevauditnode() {
        return prevauditnode;
    }

    public void setPrevauditnode(String prevauditnode) {
        this.prevauditnode = prevauditnode;
    }

    @Basic
    @Column(name = "PREVAUDITUSER")
    public String getPrevaudituser() {
        return prevaudituser;
    }

    public void setPrevaudituser(String prevaudituser) {
        this.prevaudituser = prevaudituser;
    }

    @Basic
    @Column(name = "ITEM_MBTP")
    public String getItemMbtp() {
        return itemMbtp;
    }

    public void setItemMbtp(String itemMbtp) {
        this.itemMbtp = itemMbtp;
    }

    @Basic
    @Column(name = "ITEM_MBZB")
    public String getItemMbzb() {
        return itemMbzb;
    }

    public void setItemMbzb(String itemMbzb) {
        this.itemMbzb = itemMbzb;
    }

    @Id
    @Column(name = "ID")
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

        TlkMbEntity that = (TlkMbEntity) o;

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
        if (itemMbtp != null ? !itemMbtp.equals(that.itemMbtp) : that.itemMbtp != null) return false;
        if (itemMbzb != null ? !itemMbzb.equals(that.itemMbzb) : that.itemMbzb != null) return false;
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
        result = 31 * result + (itemMbtp != null ? itemMbtp.hashCode() : 0);
        result = 31 * result + (itemMbzb != null ? itemMbzb.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
