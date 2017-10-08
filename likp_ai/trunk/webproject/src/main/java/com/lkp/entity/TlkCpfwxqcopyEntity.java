package com.lkp.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import org.hibernate.annotations.GenericGenerator;
/**
 *
 */
@Entity
@Table(name = "tlk_cpfwxqcopy", schema = "lkp", catalog = "")
public class TlkCpfwxqcopyEntity {
    private String parent;
    private Timestamp lastmodified;
    private String formname;
    private String state;
    private String audituser;
    private Timestamp auditdate;
    private String author;
    private String authorDeptIndex;
    private Timestamp created;
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
    private String itemTime;
    private String itemPicturenumber;
    private String itemJingxiunumber;
    private String itemDress;
    private String itemMakeup;
    private String itemPhotonumber;
    private String itemDescription;
    private String itemSection;
    private String itemFinishdate;
    private String itemSupply;
    private String itemFee;
    private String itemAddfee;
    private String itemPsrs;
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
    public Timestamp getLastmodified() {
        return lastmodified;
    }

    public void setLastmodified(Timestamp lastmodified) {
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
    public Timestamp getAuditdate() {
        return auditdate;
    }

    public void setAuditdate(Timestamp auditdate) {
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
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
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
    @Column(name = "ITEM_TIME")
    public String getItemTime() {
        return itemTime;
    }

    public void setItemTime(String itemTime) {
        this.itemTime = itemTime;
    }

    @Basic
    @Column(name = "ITEM_PICTURENUMBER")
    public String getItemPicturenumber() {
        return itemPicturenumber;
    }

    public void setItemPicturenumber(String itemPicturenumber) {
        this.itemPicturenumber = itemPicturenumber;
    }

    @Basic
    @Column(name = "ITEM_JINGXIUNUMBER")
    public String getItemJingxiunumber() {
        return itemJingxiunumber;
    }

    public void setItemJingxiunumber(String itemJingxiunumber) {
        this.itemJingxiunumber = itemJingxiunumber;
    }

    @Basic
    @Column(name = "ITEM_DRESS")
    public String getItemDress() {
        return itemDress;
    }

    public void setItemDress(String itemDress) {
        this.itemDress = itemDress;
    }

    @Basic
    @Column(name = "ITEM_MAKEUP")
    public String getItemMakeup() {
        return itemMakeup;
    }

    public void setItemMakeup(String itemMakeup) {
        this.itemMakeup = itemMakeup;
    }

    @Basic
    @Column(name = "ITEM_PHOTONUMBER")
    public String getItemPhotonumber() {
        return itemPhotonumber;
    }

    public void setItemPhotonumber(String itemPhotonumber) {
        this.itemPhotonumber = itemPhotonumber;
    }

    @Basic
    @Column(name = "ITEM_DESCRIPTION")
    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    @Basic
    @Column(name = "ITEM_SECTION")
    public String getItemSection() {
        return itemSection;
    }

    public void setItemSection(String itemSection) {
        this.itemSection = itemSection;
    }

    @Basic
    @Column(name = "ITEM_FINISHDATE")
    public String getItemFinishdate() {
        return itemFinishdate;
    }

    public void setItemFinishdate(String itemFinishdate) {
        this.itemFinishdate = itemFinishdate;
    }

    @Basic
    @Column(name = "ITEM_SUPPLY")
    public String getItemSupply() {
        return itemSupply;
    }

    public void setItemSupply(String itemSupply) {
        this.itemSupply = itemSupply;
    }

    @Basic
    @Column(name = "ITEM_FEE")
    public String getItemFee() {
        return itemFee;
    }

    public void setItemFee(String itemFee) {
        this.itemFee = itemFee;
    }

    @Basic
    @Column(name = "ITEM_ADDFEE")
    public String getItemAddfee() {
        return itemAddfee;
    }

    public void setItemAddfee(String itemAddfee) {
        this.itemAddfee = itemAddfee;
    }

    @Basic
    @Column(name = "ITEM_PSRS")
    public String getItemPsrs() {
        return itemPsrs;
    }

    public void setItemPsrs(String itemPsrs) {
        this.itemPsrs = itemPsrs;
    }

    @Id
    @Column(name = "ID")
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

        TlkCpfwxqcopyEntity that = (TlkCpfwxqcopyEntity) o;

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
        if (itemTime != null ? !itemTime.equals(that.itemTime) : that.itemTime != null) return false;
        if (itemPicturenumber != null ? !itemPicturenumber.equals(that.itemPicturenumber) : that.itemPicturenumber != null)
            return false;
        if (itemJingxiunumber != null ? !itemJingxiunumber.equals(that.itemJingxiunumber) : that.itemJingxiunumber != null)
            return false;
        if (itemDress != null ? !itemDress.equals(that.itemDress) : that.itemDress != null) return false;
        if (itemMakeup != null ? !itemMakeup.equals(that.itemMakeup) : that.itemMakeup != null) return false;
        if (itemPhotonumber != null ? !itemPhotonumber.equals(that.itemPhotonumber) : that.itemPhotonumber != null)
            return false;
        if (itemDescription != null ? !itemDescription.equals(that.itemDescription) : that.itemDescription != null)
            return false;
        if (itemSection != null ? !itemSection.equals(that.itemSection) : that.itemSection != null) return false;
        if (itemFinishdate != null ? !itemFinishdate.equals(that.itemFinishdate) : that.itemFinishdate != null)
            return false;
        if (itemSupply != null ? !itemSupply.equals(that.itemSupply) : that.itemSupply != null) return false;
        if (itemFee != null ? !itemFee.equals(that.itemFee) : that.itemFee != null) return false;
        if (itemAddfee != null ? !itemAddfee.equals(that.itemAddfee) : that.itemAddfee != null) return false;
        if (itemPsrs != null ? !itemPsrs.equals(that.itemPsrs) : that.itemPsrs != null) return false;
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
        result = 31 * result + (itemTime != null ? itemTime.hashCode() : 0);
        result = 31 * result + (itemPicturenumber != null ? itemPicturenumber.hashCode() : 0);
        result = 31 * result + (itemJingxiunumber != null ? itemJingxiunumber.hashCode() : 0);
        result = 31 * result + (itemDress != null ? itemDress.hashCode() : 0);
        result = 31 * result + (itemMakeup != null ? itemMakeup.hashCode() : 0);
        result = 31 * result + (itemPhotonumber != null ? itemPhotonumber.hashCode() : 0);
        result = 31 * result + (itemDescription != null ? itemDescription.hashCode() : 0);
        result = 31 * result + (itemSection != null ? itemSection.hashCode() : 0);
        result = 31 * result + (itemFinishdate != null ? itemFinishdate.hashCode() : 0);
        result = 31 * result + (itemSupply != null ? itemSupply.hashCode() : 0);
        result = 31 * result + (itemFee != null ? itemFee.hashCode() : 0);
        result = 31 * result + (itemAddfee != null ? itemAddfee.hashCode() : 0);
        result = 31 * result + (itemPsrs != null ? itemPsrs.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
