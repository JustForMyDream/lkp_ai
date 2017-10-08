package com.lkp.entity;

import com.lkp.bean.SQLDefautValue;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 *
 */
@Entity
@Table(name = "tlk_orderproduct", schema = "lkp", catalog = "")
public class TlkOrderproductEntity {
    public Set<TlkOrderproductimgEntity> orderproductimgEntities;
    private String parent;
    private Date lastmodified = new Date();
    private String formname = "lkp/社区产品/订单管理/orderproduct";
    private String state;
    private String audituser = SQLDefautValue.author;
    private Date auditdate=new Date();
    private String author = SQLDefautValue.author;
    private String authorDeptIndex = SQLDefautValue.author_dept_index;
    private Date created = new Date();
    private String formid = "11e6-9507-3c01a8b0-ad8b-11472dfbd6fd";
    private Boolean istmp = false;
    private Integer versions = 1;
    private String applicationid = SQLDefautValue.applicationid;
    private Integer stateint = 0;
    private String statelabel;
    private String auditornames;
    private String lastflowoperation;
    private String lastmodifier = SQLDefautValue.author;
    private String domainid = "11e1-81e2-37f74759-9124-47aada6b7467";
    private String auditorlist = "{}";
    private String statelabelinfo;
    private String prevauditnode;
    private String prevaudituser;
    //订单编号
    private String itemOrderid;
    //产品编号
    private TlkProductEntity itemProductid;
    //产品数量
    private String itemProductnum;
    //预约日期
    private Date itemOrdertime;
    //主键
    private String id;
    //位置
    private String itemPosition;
    //详细地址
    private String itemDetailposition;
    //用户编号
    private TlkUserEntity itemUserid;
    //用户电话
    private String itemPhone;
    //下单日期
    private Date itemXdrq;
    //下单用户姓名
    private String itemName;
    //订单状态
    private OrderState itemState;
    //用户性别
    private String itemSex;
    //产品单价
    private String itemPrice;
    //摄影师编号
    private TlkPhotographerEntity itemSysid;
    //微信支付数据
    private Set<TlkWechatpayEntity> tlkWechatpayEntitys;
    private String itemSysxm;
    private String itemYjdh;
    private String itemYjdz;
    private Date itemQrsj;
    private String itemZzje;
    private String itemZzzt;
    private Date itemZzsj;
    private String itemPjxj;
    private String itemPjnr;
    private Date itemPjsj;
    private String itemPjyd;

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
    @Column(name = "ITEM_ORDERID")
    public String getItemOrderid() {
        return itemOrderid;
    }

    public void setItemOrderid(String itemOrderid) {
        this.itemOrderid = itemOrderid;
    }

    @OneToOne
    @JoinColumn(name = "ITEM_PRODUCTID",foreignKey = @ForeignKey(name = "null"),referencedColumnName = "ITEM_CPBH")
    public TlkProductEntity getItemProductid() {
        return itemProductid;
    }

    public void setItemProductid(TlkProductEntity itemProductid) {
        this.itemProductid = itemProductid;
    }

    @Basic
    @Column(name = "ITEM_PRODUCTNUM")
    public String getItemProductnum() {
        return itemProductnum;
    }

    public void setItemProductnum(String itemProductnum) {
        this.itemProductnum = itemProductnum;
    }

    @Basic
    @Column(name = "ITEM_ORDERTIME")
    public Date getItemOrdertime() {
        return itemOrdertime;
    }

    public void setItemOrdertime(Date itemOrdertime) {
        this.itemOrdertime = itemOrdertime;
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

    @Basic
    @Column(name = "ITEM_POSITION")
    public String getItemPosition() {
        return itemPosition;
    }

    public void setItemPosition(String itemPosition) {
        this.itemPosition = itemPosition;
    }

    @Basic
    @Column(name = "ITEM_DETAILPOSITION")
    public String getItemDetailposition() {
        return itemDetailposition;
    }

    public void setItemDetailposition(String itemDetailposition) {
        this.itemDetailposition = itemDetailposition;
    }

    @ManyToOne
    @JoinColumn(name = "ITEM_USERID",foreignKey = @ForeignKey(name = "null"),referencedColumnName = "ITEM_BH")
    public TlkUserEntity getItemUserid() {
        return itemUserid;
    }

    public void setItemUserid(TlkUserEntity itemUserid) {
        this.itemUserid = itemUserid;
    }

    @Basic
    @Column(name = "ITEM_PHONE")
    public String getItemPhone() {
        return itemPhone;
    }

    public void setItemPhone(String itemPhone) {
        this.itemPhone = itemPhone;
    }

    @Basic
    @Column(name = "ITEM_XDRQ")
    public Date getItemXdrq() {
        return itemXdrq;
    }

    public void setItemXdrq(Date itemXdrq) {
        this.itemXdrq = itemXdrq;
    }

    @Basic
    @Column(name = "ITEM_NAME")
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "ITEM_STATE")
    public OrderState getItemState() {
        return itemState;
    }

    public void setItemState(OrderState itemState) {
        this.itemState = itemState;
    }

    @Basic
    @Column(name = "ITEM_SEX")
    public String getItemSex() {
        return itemSex;
    }

    public void setItemSex(String itemSex) {
        this.itemSex = itemSex;
    }

    @Basic
    @Column(name = "ITEM_PRICE")
    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    @OneToMany
    @JoinColumn(name = "ITEM_ATTACH",foreignKey = @ForeignKey(name = "null"))
    public Set<TlkWechatpayEntity> getTlkWechatpayEntitys() {
        return tlkWechatpayEntitys;
    }

    public void setTlkWechatpayEntitys(Set<TlkWechatpayEntity> tlkWechatpayEntitys) {
        this.tlkWechatpayEntitys = tlkWechatpayEntitys;
    }

    @OneToMany
    @JoinColumn(name = "PARENT",foreignKey = @ForeignKey(name = "null"))
    public Set<TlkOrderproductimgEntity> getOrderproductimgEntities() {
        return orderproductimgEntities;
    }

    public void setOrderproductimgEntities(Set<TlkOrderproductimgEntity> orderproductimgEntities) {
        this.orderproductimgEntities = orderproductimgEntities;
    }

    @ManyToOne
    @JoinColumn(name = "ITEM_SYSID",foreignKey = @ForeignKey(name = "null"),referencedColumnName = "ITEM_BH")
    public TlkPhotographerEntity getItemSysid() {
        return itemSysid;
    }

    public void setItemSysid(TlkPhotographerEntity itemSysid) {
        this.itemSysid = itemSysid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TlkOrderproductEntity that = (TlkOrderproductEntity) o;

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
        if (itemOrderid != null ? !itemOrderid.equals(that.itemOrderid) : that.itemOrderid != null) return false;
        if (itemProductid != null ? !itemProductid.equals(that.itemProductid) : that.itemProductid != null)
            return false;
        if (itemProductnum != null ? !itemProductnum.equals(that.itemProductnum) : that.itemProductnum != null)
            return false;
        if (itemOrdertime != null ? !itemOrdertime.equals(that.itemOrdertime) : that.itemOrdertime != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (itemPosition != null ? !itemPosition.equals(that.itemPosition) : that.itemPosition != null) return false;
        if (itemDetailposition != null ? !itemDetailposition.equals(that.itemDetailposition) : that.itemDetailposition != null)
            return false;
        if (itemUserid != null ? !itemUserid.equals(that.itemUserid) : that.itemUserid != null) return false;
        if (itemPhone != null ? !itemPhone.equals(that.itemPhone) : that.itemPhone != null) return false;
        if (itemXdrq != null ? !itemXdrq.equals(that.itemXdrq) : that.itemXdrq != null) return false;
        if (itemName != null ? !itemName.equals(that.itemName) : that.itemName != null) return false;
        if (itemSex != null ? !itemSex.equals(that.itemSex) : that.itemSex != null) return false;
        if (itemPrice != null ? !itemPrice.equals(that.itemPrice) : that.itemPrice != null) return false;

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
        result = 31 * result + (itemOrderid != null ? itemOrderid.hashCode() : 0);
        result = 31 * result + (itemProductid != null ? itemProductid.hashCode() : 0);
        result = 31 * result + (itemProductnum != null ? itemProductnum.hashCode() : 0);
        result = 31 * result + (itemOrdertime != null ? itemOrdertime.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (itemPosition != null ? itemPosition.hashCode() : 0);
        result = 31 * result + (itemDetailposition != null ? itemDetailposition.hashCode() : 0);
        result = 31 * result + (itemUserid != null ? itemUserid.hashCode() : 0);
        result = 31 * result + (itemPhone != null ? itemPhone.hashCode() : 0);
        result = 31 * result + (itemXdrq != null ? itemXdrq.hashCode() : 0);
        result = 31 * result + (itemName != null ? itemName.hashCode() : 0);
        result = 31 * result + (itemSex != null ? itemSex.hashCode() : 0);
        result = 31 * result + (itemPrice != null ? itemPrice.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "ITEM_SYSXM")
    public String getItemSysxm() {
        return itemSysxm;
    }

    public void setItemSysxm(String itemSysxm) {
        this.itemSysxm = itemSysxm;
    }

    @Basic
    @Column(name = "ITEM_YJDH")
    public String getItemYjdh() {
        return itemYjdh;
    }

    public void setItemYjdh(String itemYjdh) {
        this.itemYjdh = itemYjdh;
    }

    @Basic
    @Column(name = "ITEM_YJDZ")
    public String getItemYjdz() {
        return itemYjdz;
    }

    public void setItemYjdz(String itemYjdz) {
        this.itemYjdz = itemYjdz;
    }

    @Basic
    @Column(name = "ITEM_QRSJ")
    public Date getItemQrsj() {
        return itemQrsj;
    }

    public void setItemQrsj(Date itemQrsj) {
        this.itemQrsj = itemQrsj;
    }

    @Basic
    @Column(name = "ITEM_ZZJE")
    public String getItemZzje() {
        return itemZzje;
    }

    public void setItemZzje(String itemZzje) {
        this.itemZzje = itemZzje;
    }

    @Basic
    @Column(name = "ITEM_ZZZT")
    public String getItemZzzt() {
        return itemZzzt;
    }

    public void setItemZzzt(String itemZzzt) {
        this.itemZzzt = itemZzzt;
    }

    @Basic
    @Column(name = "ITEM_ZZSJ")
    public Date getItemZzsj() {
        return itemZzsj;
    }

    public void setItemZzsj(Date itemZzsj) {
        this.itemZzsj = itemZzsj;
    }

    @Basic
    @Column(name = "ITEM_PJXJ")
    public String getItemPjxj() {
        return itemPjxj;
    }

    public void setItemPjxj(String itemPjxj) {
        this.itemPjxj = itemPjxj;
    }

    @Basic
    @Column(name = "ITEM_PJNR")
    public String getItemPjnr() {
        return itemPjnr;
    }

    public void setItemPjnr(String itemPjnr) {
        this.itemPjnr = itemPjnr;
    }

    @Basic
    @Column(name = "ITEM_PJSJ")
    public Date getItemPjsj() {
        return itemPjsj;
    }

    public void setItemPjsj(Date itemPjsj) {
        this.itemPjsj = itemPjsj;
    }

    @Basic
    @Column(name = "ITEM_PJYD")
    public String getItemPjyd() {
        return itemPjyd;
    }

    public void setItemPjyd(String itemPjyd) {
        this.itemPjyd = itemPjyd;
    }
}
