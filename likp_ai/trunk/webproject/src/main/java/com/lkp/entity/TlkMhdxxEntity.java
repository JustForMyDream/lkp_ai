package com.lkp.entity;

import javax.persistence.*;
import java.util.Date;

/**
 *
 */
@Entity
@Table(name = "tlk_mhdxx", schema = "lkp", catalog = "")
public class TlkMhdxxEntity {
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
    private String id;
    private String itemName;
    private String itemHdtp;
    private String itemHdxy;
    private String itemUserchar;
    private String itemPage;
    private String itemPagename;
    private Date itemStartdate;
    private Date itemEnddate;
    private Date itemDate;
    private String itemQrcode;
    private String itemDetail;
    private String itemBmtp;

    @Basic
    @Column(name = "PARENT", nullable = true, length = 200)
    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    @Basic
    @Column(name = "LASTMODIFIED", nullable = true)
    public Date getLastmodified() {
        return lastmodified;
    }

    public void setLastmodified(Date lastmodified) {
        this.lastmodified = lastmodified;
    }

    @Basic
    @Column(name = "FORMNAME", nullable = true, length = 200)
    public String getFormname() {
        return formname;
    }

    public void setFormname(String formname) {
        this.formname = formname;
    }

    @Basic
    @Column(name = "STATE", nullable = true, length = 200)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "AUDITUSER", nullable = true, length = 200)
    public String getAudituser() {
        return audituser;
    }

    public void setAudituser(String audituser) {
        this.audituser = audituser;
    }

    @Basic
    @Column(name = "AUDITDATE", nullable = true)
    public Date getAuditdate() {
        return auditdate;
    }

    public void setAuditdate(Date auditdate) {
        this.auditdate = auditdate;
    }

    @Basic
    @Column(name = "AUTHOR", nullable = true, length = 200)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "AUTHOR_DEPT_INDEX", nullable = true, length = 2000)
    public String getAuthorDeptIndex() {
        return authorDeptIndex;
    }

    public void setAuthorDeptIndex(String authorDeptIndex) {
        this.authorDeptIndex = authorDeptIndex;
    }

    @Basic
    @Column(name = "CREATED", nullable = true)
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Basic
    @Column(name = "FORMID", nullable = true, length = 200)
    public String getFormid() {
        return formid;
    }

    public void setFormid(String formid) {
        this.formid = formid;
    }

    @Basic
    @Column(name = "ISTMP", nullable = true)
    public Boolean getIstmp() {
        return istmp;
    }

    public void setIstmp(Boolean istmp) {
        this.istmp = istmp;
    }

    @Basic
    @Column(name = "VERSIONS", nullable = true)
    public Integer getVersions() {
        return versions;
    }

    public void setVersions(Integer versions) {
        this.versions = versions;
    }

    @Basic
    @Column(name = "APPLICATIONID", nullable = true, length = 200)
    public String getApplicationid() {
        return applicationid;
    }

    public void setApplicationid(String applicationid) {
        this.applicationid = applicationid;
    }

    @Basic
    @Column(name = "STATEINT", nullable = true)
    public Integer getStateint() {
        return stateint;
    }

    public void setStateint(Integer stateint) {
        this.stateint = stateint;
    }

    @Basic
    @Column(name = "STATELABEL", nullable = true, length = 200)
    public String getStatelabel() {
        return statelabel;
    }

    public void setStatelabel(String statelabel) {
        this.statelabel = statelabel;
    }

    @Basic
    @Column(name = "AUDITORNAMES", nullable = true, length = -1)
    public String getAuditornames() {
        return auditornames;
    }

    public void setAuditornames(String auditornames) {
        this.auditornames = auditornames;
    }

    @Basic
    @Column(name = "LASTFLOWOPERATION", nullable = true, length = 200)
    public String getLastflowoperation() {
        return lastflowoperation;
    }

    public void setLastflowoperation(String lastflowoperation) {
        this.lastflowoperation = lastflowoperation;
    }

    @Basic
    @Column(name = "LASTMODIFIER", nullable = true, length = 200)
    public String getLastmodifier() {
        return lastmodifier;
    }

    public void setLastmodifier(String lastmodifier) {
        this.lastmodifier = lastmodifier;
    }

    @Basic
    @Column(name = "DOMAINID", nullable = true, length = 200)
    public String getDomainid() {
        return domainid;
    }

    public void setDomainid(String domainid) {
        this.domainid = domainid;
    }

    @Basic
    @Column(name = "AUDITORLIST", nullable = true, length = -1)
    public String getAuditorlist() {
        return auditorlist;
    }

    public void setAuditorlist(String auditorlist) {
        this.auditorlist = auditorlist;
    }

    @Basic
    @Column(name = "STATELABELINFO", nullable = true, length = -1)
    public String getStatelabelinfo() {
        return statelabelinfo;
    }

    public void setStatelabelinfo(String statelabelinfo) {
        this.statelabelinfo = statelabelinfo;
    }

    @Basic
    @Column(name = "PREVAUDITNODE", nullable = true, length = -1)
    public String getPrevauditnode() {
        return prevauditnode;
    }

    public void setPrevauditnode(String prevauditnode) {
        this.prevauditnode = prevauditnode;
    }

    @Basic
    @Column(name = "PREVAUDITUSER", nullable = true, length = -1)
    public String getPrevaudituser() {
        return prevaudituser;
    }

    public void setPrevaudituser(String prevaudituser) {
        this.prevaudituser = prevaudituser;
    }

    @Id
    @Column(name = "ID", nullable = false, length = 200)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ITEM_NAME", nullable = true, length = 200)
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Basic
    @Column(name = "ITEM_HDTP", nullable = true, length = 200)
    public String getItemHdtp() {
        return itemHdtp;
    }

    public void setItemHdtp(String itemHdtp) {
        this.itemHdtp = itemHdtp;
    }

    @Basic
    @Column(name = "ITEM_HDXY", nullable = true, length = 200)
    public String getItemHdxy() {
        return itemHdxy;
    }

    public void setItemHdxy(String itemHdxy) {
        this.itemHdxy = itemHdxy;
    }

    @Basic
    @Column(name = "ITEM_USERCHAR", nullable = true, length = 200)
    public String getItemUserchar() {
        return itemUserchar;
    }

    public void setItemUserchar(String itemUserchar) {
        this.itemUserchar = itemUserchar;
    }

    @Basic
    @Column(name = "ITEM_PAGE", nullable = true, length = 200)
    public String getItemPage() {
        return itemPage;
    }

    public void setItemPage(String itemPage) {
        this.itemPage = itemPage;
    }

    @Basic
    @Column(name = "ITEM_PAGENAME", nullable = true, length = 200)
    public String getItemPagename() {
        return itemPagename;
    }

    public void setItemPagename(String itemPagename) {
        this.itemPagename = itemPagename;
    }

    @Basic
    @Column(name = "ITEM_STARTDATE", nullable = true)
    public Date getItemStartdate() {
        return itemStartdate;
    }

    public void setItemStartdate(Date itemStartdate) {
        this.itemStartdate = itemStartdate;
    }

    @Basic
    @Column(name = "ITEM_ENDDATE", nullable = true)
    public Date getItemEnddate() {
        return itemEnddate;
    }

    public void setItemEnddate(Date itemEnddate) {
        this.itemEnddate = itemEnddate;
    }

    @Basic
    @Column(name = "ITEM_DATE", nullable = true)
    public Date getItemDate() {
        return itemDate;
    }

    public void setItemDate(Date itemDate) {
        this.itemDate = itemDate;
    }

    @Basic
    @Column(name = "ITEM_QRCODE", nullable = true, length = 200)
    public String getItemQrcode() {
        return itemQrcode;
    }

    public void setItemQrcode(String itemQrcode) {
        this.itemQrcode = itemQrcode;
    }

    @Basic
    @Column(name = "ITEM_DETAIL", nullable = true, length = -1)
    public String getItemDetail() {
        return itemDetail;
    }

    public void setItemDetail(String itemDetail) {
        this.itemDetail = itemDetail;
    }

    @Basic
    @Column(name = "ITEM_BMTP", nullable = true, length = 200)
    public String getItemBmtp() {
        return itemBmtp;
    }

    public void setItemBmtp(String itemBmtp) {
        this.itemBmtp = itemBmtp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TlkMhdxxEntity that = (TlkMhdxxEntity) o;

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
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (itemName != null ? !itemName.equals(that.itemName) : that.itemName != null) return false;
        if (itemHdtp != null ? !itemHdtp.equals(that.itemHdtp) : that.itemHdtp != null) return false;
        if (itemHdxy != null ? !itemHdxy.equals(that.itemHdxy) : that.itemHdxy != null) return false;
        if (itemUserchar != null ? !itemUserchar.equals(that.itemUserchar) : that.itemUserchar != null) return false;
        if (itemPage != null ? !itemPage.equals(that.itemPage) : that.itemPage != null) return false;
        if (itemPagename != null ? !itemPagename.equals(that.itemPagename) : that.itemPagename != null) return false;
        if (itemStartdate != null ? !itemStartdate.equals(that.itemStartdate) : that.itemStartdate != null)
            return false;
        if (itemEnddate != null ? !itemEnddate.equals(that.itemEnddate) : that.itemEnddate != null) return false;
        if (itemDate != null ? !itemDate.equals(that.itemDate) : that.itemDate != null) return false;
        if (itemQrcode != null ? !itemQrcode.equals(that.itemQrcode) : that.itemQrcode != null) return false;
        if (itemDetail != null ? !itemDetail.equals(that.itemDetail) : that.itemDetail != null) return false;
        if (itemBmtp != null ? !itemBmtp.equals(that.itemBmtp) : that.itemBmtp != null) return false;

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
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (itemName != null ? itemName.hashCode() : 0);
        result = 31 * result + (itemHdtp != null ? itemHdtp.hashCode() : 0);
        result = 31 * result + (itemHdxy != null ? itemHdxy.hashCode() : 0);
        result = 31 * result + (itemUserchar != null ? itemUserchar.hashCode() : 0);
        result = 31 * result + (itemPage != null ? itemPage.hashCode() : 0);
        result = 31 * result + (itemPagename != null ? itemPagename.hashCode() : 0);
        result = 31 * result + (itemStartdate != null ? itemStartdate.hashCode() : 0);
        result = 31 * result + (itemEnddate != null ? itemEnddate.hashCode() : 0);
        result = 31 * result + (itemDate != null ? itemDate.hashCode() : 0);
        result = 31 * result + (itemQrcode != null ? itemQrcode.hashCode() : 0);
        result = 31 * result + (itemDetail != null ? itemDetail.hashCode() : 0);
        result = 31 * result + (itemBmtp != null ? itemBmtp.hashCode() : 0);
        return result;
    }
}
