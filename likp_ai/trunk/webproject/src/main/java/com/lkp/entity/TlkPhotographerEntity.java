package com.lkp.entity;

import com.lkp.bean.SQLDefautValue;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.Date;
import java.util.UUID;

/**
 *
 * 摄影师信息实体表
 */
@Entity
@Table(name = "tlk_photographer", schema = "lkp", catalog = "")
@Access(AccessType.PROPERTY)
public class TlkPhotographerEntity implements Serializable {
    private String parent;
    private Date lastmodified = new Date();
    private String formname = "lkp/社区产品/用户管理/Photographer";
    private String state;
    private String audituser;
    private Date auditdate;
    private String author = SQLDefautValue.author;
    private String authorDeptIndex = SQLDefautValue.author_dept_index;
    private Date created = new Date();
    private String formid = "11e6-9463-a6e41f51-ad8b-11472dfbd6fd";
    private Boolean istmp = false;
    private Integer versions = 1;
    private String applicationid = SQLDefautValue.applicationid;
    private Integer stateint = 0;
    private String statelabel;
//    private String auditornames;
    private String lastflowoperation;
    private String lastmodifier = SQLDefautValue.author;
    private String domainid = SQLDefautValue.domain;
//    private String auditorlist = "{}";
//    private String statelabelinfo;
//    private String prevauditnode;
//    private String prevaudituser;
    private String itemName;
    private String itemPhone;
    private String itemHeadimg;
    private String itemSex;
    private String id;
    private String itemBh = UUID.randomUUID().toString();
    private Set<TlkOrderproductEntity> orderproductEntities;
    private String itemNc;
    private TlkWechatuserEntity itemOpenid;
    private String itemSyshdlx;
    private String itemGrjj;
    private String Fmbjtp;

    @Basic
    @Column(name = "ITEM_GRJJ", nullable = true, length = 200)
    public String getItemGrjj() {
        return itemGrjj;
    }
    public void setItemGrjj(String itemGrjj) {
        this.itemGrjj = itemGrjj;
    }

    @Basic
    @Column(name = "ITEM_FMBJTP", nullable = true, length = 200)
    public String getFmbjtp() {
        return Fmbjtp;
    }
    public void setFmbjtp(String fmbjtp) {
        Fmbjtp = fmbjtp;
    }

    @Basic
    @Column(name = "PARENT", nullable = true, length = 200)
    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
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
    @Temporal(TemporalType.TIMESTAMP)
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
    @Temporal(TemporalType.TIMESTAMP)
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

//    @Basic
//    @Column(name = "AUDITORNAMES", nullable = true, length = -1)
//    public String getAuditornames() {
//        return auditornames;
//    }
//
//    public void setAuditornames(String auditornames) {
//        this.auditornames = auditornames;
//    }

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

//    @Basic
//    @Column(name = "AUDITORLIST", nullable = true, length = -1)
//    public String getAuditorlist() {
//        return auditorlist;
//    }
//
//    public void setAuditorlist(String auditorlist) {
//        this.auditorlist = auditorlist;
//    }

//    @Basic
//    @Column(name = "STATELABELINFO", nullable = true, length = -1)
//    public String getStatelabelinfo() {
//        return statelabelinfo;
//    }
//
//    public void setStatelabelinfo(String statelabelinfo) {
//        this.statelabelinfo = statelabelinfo;
//    }

//    @Basic
//    @Column(name = "PREVAUDITNODE", nullable = true, length = -1)
//    public String getPrevauditnode() {
//        return prevauditnode;
//    }
//
//    public void setPrevauditnode(String prevauditnode) {
//        this.prevauditnode = prevauditnode;
//    }
//
//    @Basic
//    @Column(name = "PREVAUDITUSER", nullable = true, length = -1)
//    public String getPrevaudituser() {
//        return prevaudituser;
//    }
//
//    public void setPrevaudituser(String prevaudituser) {
//        this.prevaudituser = prevaudituser;
//    }

    @Basic
    @Column(name = "ITEM_NAME", nullable = true, length = 200)
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Basic
    @Column(name = "ITEM_PHONE", nullable = true, length = 200)
    public String getItemPhone() {
        return itemPhone;
    }

    public void setItemPhone(String itemPhone) {
        this.itemPhone = itemPhone;
    }

    @Basic
    @Column(name = "ITEM_HEADIMG", nullable = true, length = 200)
    public String getItemHeadimg() {
        return itemHeadimg;
    }

    public void setItemHeadimg(String itemHeadimg) {
        this.itemHeadimg = itemHeadimg;
    }

    @Basic
    @Column(name = "ITEM_SEX", nullable = true, length = 200)
    public String getItemSex() {
        return itemSex;
    }

    public void setItemSex(String itemSex) {
        this.itemSex = itemSex;
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
    @Column(name = "ITEM_BH", nullable = true, length = 200)
    public String getItemBh() {
        return itemBh;
    }

    public void setItemBh(String itemBh) {
        this.itemBh = itemBh;
    }

    @OneToMany(mappedBy = "itemSysid")
    public Set<TlkOrderproductEntity> getOrderproductEntities() {
        return orderproductEntities;
    }

    public void setOrderproductEntities(Set<TlkOrderproductEntity> orderproductEntities) {
        this.orderproductEntities = orderproductEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TlkPhotographerEntity that = (TlkPhotographerEntity) o;

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
//        if (auditornames != null ? !auditornames.equals(that.auditornames) : that.auditornames != null) return false;
        if (lastflowoperation != null ? !lastflowoperation.equals(that.lastflowoperation) : that.lastflowoperation != null)
            return false;
        if (lastmodifier != null ? !lastmodifier.equals(that.lastmodifier) : that.lastmodifier != null) return false;
        if (domainid != null ? !domainid.equals(that.domainid) : that.domainid != null) return false;
//        if (auditorlist != null ? !auditorlist.equals(that.auditorlist) : that.auditorlist != null) return false;
//        if (statelabelinfo != null ? !statelabelinfo.equals(that.statelabelinfo) : that.statelabelinfo != null)
//            return false;
//        if (prevauditnode != null ? !prevauditnode.equals(that.prevauditnode) : that.prevauditnode != null)
//            return false;
//        if (prevaudituser != null ? !prevaudituser.equals(that.prevaudituser) : that.prevaudituser != null)
//            return false;
        if (itemName != null ? !itemName.equals(that.itemName) : that.itemName != null) return false;
        if (itemPhone != null ? !itemPhone.equals(that.itemPhone) : that.itemPhone != null) return false;
        if (itemHeadimg != null ? !itemHeadimg.equals(that.itemHeadimg) : that.itemHeadimg != null) return false;
        if (itemSex != null ? !itemSex.equals(that.itemSex) : that.itemSex != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (itemBh != null ? !itemBh.equals(that.itemBh) : that.itemBh != null) return false;

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
//        result = 31 * result + (auditornames != null ? auditornames.hashCode() : 0);
        result = 31 * result + (lastflowoperation != null ? lastflowoperation.hashCode() : 0);
        result = 31 * result + (lastmodifier != null ? lastmodifier.hashCode() : 0);
        result = 31 * result + (domainid != null ? domainid.hashCode() : 0);
//        result = 31 * result + (auditorlist != null ? auditorlist.hashCode() : 0);
//        result = 31 * result + (statelabelinfo != null ? statelabelinfo.hashCode() : 0);
//        result = 31 * result + (prevauditnode != null ? prevauditnode.hashCode() : 0);
//        result = 31 * result + (prevaudituser != null ? prevaudituser.hashCode() : 0);
        result = 31 * result + (itemName != null ? itemName.hashCode() : 0);
        result = 31 * result + (itemPhone != null ? itemPhone.hashCode() : 0);
        result = 31 * result + (itemHeadimg != null ? itemHeadimg.hashCode() : 0);
        result = 31 * result + (itemSex != null ? itemSex.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (itemBh != null ? itemBh.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "ITEM_NC", nullable = true, length = 200)
    public String getItemNc() {
        return itemNc;
    }

    public void setItemNc(String itemNc) {
        this.itemNc = itemNc;
    }

    @ManyToOne
    @JoinColumn(name = "ITEM_OPENID", referencedColumnName = "ITEM_OPENID", foreignKey = @ForeignKey(name = "null"))
    public TlkWechatuserEntity getItemOpenid() {
        return itemOpenid;
    }

    public void setItemOpenid(TlkWechatuserEntity itemOpenid) {
        this.itemOpenid = itemOpenid;
    }

    @Basic
    @Column(name = "ITEM_SYSHDLX", nullable = true, length = 200)
    public String getItemSyshdlx() {
        return itemSyshdlx;
    }

    public void setItemSyshdlx(String itemSyshdlx) {
        this.itemSyshdlx = itemSyshdlx;
    }
}
