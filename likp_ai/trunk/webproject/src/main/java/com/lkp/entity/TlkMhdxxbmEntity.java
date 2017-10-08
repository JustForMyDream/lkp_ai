package com.lkp.entity;

import com.lkp.bean.SQLDefautValue;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 *
 */
@Entity
@Table(name = "tlk_mhdxxbm", schema = "lkp", catalog = "")
public class TlkMhdxxbmEntity {
    private String parent;
    private Date lastmodified=new Date();
    private String formname = "lkp/社区产品/活动管理/MHDXXBM";
    private String state;
    private String audituser;
    private Date auditdate;
    private String author=SQLDefautValue.author;
    private String authorDeptIndex=SQLDefautValue.author_dept_index;
    private Date created = new Date();
    private String formid="11e6-cb5f-4ce2c3d2-b8b6-cf6b4149162c";
    private Boolean istmp = false;
    private Integer versions = 1;
    private String applicationid = SQLDefautValue.applicationid;
    private Integer stateint;
    private String statelabel;
    private String auditornames;
    private String lastflowoperation;
    private String lastmodifier = SQLDefautValue.author;
    private String domainid = SQLDefautValue.domain;
    private String auditorlist = "{}";
    private String statelabelinfo;
    private String prevauditnode;
    private String prevaudituser;
    private String itemHdbh;
    private String itemYhbh;
    private String itemAgree;
    private String itemName;
    private String itemSex;
    private String itemLxfs;
    private String id;
    private String itemBmxq;
    private String itemFjtp;
    private String itemSfgz;

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

    @Basic
    @Column(name = "ITEM_HDBH", nullable = true, length = 200)
    public String getItemHdbh() {
        return itemHdbh;
    }

    public void setItemHdbh(String itemHdbh) {
        this.itemHdbh = itemHdbh;
    }

    @Basic
    @Column(name = "ITEM_YHBH", nullable = true, length = 200)
    public String getItemYhbh() {
        return itemYhbh;
    }

    public void setItemYhbh(String itemYhbh) {
        this.itemYhbh = itemYhbh;
    }

    @Basic
    @Column(name = "ITEM_AGREE", nullable = true, length = 200)
    public String getItemAgree() {
        return itemAgree;
    }

    public void setItemAgree(String itemAgree) {
        this.itemAgree = itemAgree;
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
    @Column(name = "ITEM_SEX", nullable = true, length = 200)
    public String getItemSex() {
        return itemSex;
    }

    public void setItemSex(String itemSex) {
        this.itemSex = itemSex;
    }

    @Basic
    @Column(name = "ITEM_LXFS", nullable = true, length = 200)
    public String getItemLxfs() {
        return itemLxfs;
    }

    public void setItemLxfs(String itemLxfs) {
        this.itemLxfs = itemLxfs;
    }

    @Id
    @Column(name = "ID", nullable = false, length = 200)
    @GenericGenerator(name = "uuid", strategy = "uuid.hex")
    @GeneratedValue(generator = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ITEM_BMXQ", nullable = true, length = -1)
    public String getItemBmxq() {
        return itemBmxq;
    }

    public void setItemBmxq(String itemBmxq) {
        this.itemBmxq = itemBmxq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TlkMhdxxbmEntity that = (TlkMhdxxbmEntity) o;

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
        if (itemHdbh != null ? !itemHdbh.equals(that.itemHdbh) : that.itemHdbh != null) return false;
        if (itemYhbh != null ? !itemYhbh.equals(that.itemYhbh) : that.itemYhbh != null) return false;
        if (itemAgree != null ? !itemAgree.equals(that.itemAgree) : that.itemAgree != null) return false;
        if (itemName != null ? !itemName.equals(that.itemName) : that.itemName != null) return false;
        if (itemSex != null ? !itemSex.equals(that.itemSex) : that.itemSex != null) return false;
        if (itemLxfs != null ? !itemLxfs.equals(that.itemLxfs) : that.itemLxfs != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (itemBmxq != null ? !itemBmxq.equals(that.itemBmxq) : that.itemBmxq != null) return false;

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
        result = 31 * result + (itemHdbh != null ? itemHdbh.hashCode() : 0);
        result = 31 * result + (itemYhbh != null ? itemYhbh.hashCode() : 0);
        result = 31 * result + (itemAgree != null ? itemAgree.hashCode() : 0);
        result = 31 * result + (itemName != null ? itemName.hashCode() : 0);
        result = 31 * result + (itemSex != null ? itemSex.hashCode() : 0);
        result = 31 * result + (itemLxfs != null ? itemLxfs.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (itemBmxq != null ? itemBmxq.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "ITEM_FJTP", nullable = true, length = 200)
    public String getItemFjtp() {
        return itemFjtp;
    }

    public void setItemFjtp(String itemFjtp) {
        this.itemFjtp = itemFjtp;
    }

    @Basic
    @Column(name = "ITEM_SFGZ", nullable = true, length = 200)
    public String getItemSfgz() {
        return itemSfgz;
    }

    public void setItemSfgz(String itemSfgz) {
        this.itemSfgz = itemSfgz;
    }
}
