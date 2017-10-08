package com.lkp.entity;

import com.lkp.bean.SQLDefautValue;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 *
 */
@Entity
@Table(name = "tlk_wechatpay", schema = "lkp", catalog = "")
@Access(AccessType.PROPERTY)
public class TlkWechatpayEntity {
    private String parent;
    private Date lastmodified = new Date();
    private String formname = "lkp/社区产品/订单管理/wechatpay";
    private String state;
    private String audituser;
    private Date auditdate;
    private String author = SQLDefautValue.author;
    private String authorDeptIndex = SQLDefautValue.author_dept_index;
    private Date created = new Date();
    private String formid = "11e6-9513-cd773e87-ad8b-11472dfbd6fd";
    private Boolean istmp = false;
    private Integer versions = 2;
    private String applicationid = SQLDefautValue.applicationid;
    private Integer stateint = 0;
    private String statelabel;
    private String auditornames;
    private String lastflowoperation;
    private String lastmodifier = SQLDefautValue.author;
    private String domainid = SQLDefautValue.domain;
    private String auditorlist = "{}";
    private String statelabelinfo;
    private String prevauditnode;
    private String prevaudituser;
    private String appid;
    private String nonce_str;
    private String mch_id;
    private String device_info;
    private String body;
    private String sign;
    private String attach;
    private String out_trade_no;
    private String total_fee;
    private String spbill_create_ip;
    private Date time_start;
    private Date time_expire;
    private String goods_tag;
    private String notify_url;
    private String trade_type;
    private String product_id;
    private String itemHbzl;
    private String return_code;
    private String return_msg;
    private String openid;
    private String prepay_id;
    private String id;
    private String itemResultCode;
    private String itemErrCode;
    private String itemErrCodeDes;
    private String itemCodeUrl;

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

    @Basic
    @Column(name = "AUDITORNAMES", nullable = true, length = 200)
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
    @Column(name = "AUDITORLIST", nullable = true, length = 200)
    public String getAuditorlist() {
        return auditorlist;
    }

    public void setAuditorlist(String auditorlist) {
        this.auditorlist = auditorlist;
    }

    @Basic
    @Column(name = "STATELABELINFO", nullable = true, length = 200)
    public String getStatelabelinfo() {
        return statelabelinfo;
    }

    public void setStatelabelinfo(String statelabelinfo) {
        this.statelabelinfo = statelabelinfo;
    }

    @Basic
    @Column(name = "PREVAUDITNODE", nullable = true, length = 200)
    public String getPrevauditnode() {
        return prevauditnode;
    }

    public void setPrevauditnode(String prevauditnode) {
        this.prevauditnode = prevauditnode;
    }

    @Basic
    @Column(name = "PREVAUDITUSER", nullable = true, length = 200)
    public String getPrevaudituser() {
        return prevaudituser;
    }

    public void setPrevaudituser(String prevaudituser) {
        this.prevaudituser = prevaudituser;
    }

    @Basic
    @Column(name = "ITEM_APPID", nullable = true, length = 200)
    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    @Basic
    @Column(name = "ITEM_NONCE_STR", nullable = true, length = 200)
    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    @Basic
    @Column(name = "ITEM_MCH_ID", nullable = true, length = 200)
    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    @Basic
    @Column(name = "ITEM_DEVICE_INFO", nullable = true, length = 200)
    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    @Basic
    @Column(name = "ITEM_BODY", nullable = true, length = 200)
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Basic
    @Column(name = "ITEM_SIGN", nullable = true, length = 200)
    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Basic
    @Column(name = "ITEM_ATTACH", nullable = true, length = 200)
    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    @Basic
    @Column(name = "ITEM_OUT_TRADE_NO", nullable = true, length = 200)
    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    @Basic
    @Column(name = "ITEM_TOTAL_FEE", nullable = true, length = 200)
    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    @Basic
    @Column(name = "ITEM_SPBILL_CREATE_IP", nullable = true, length = 200)
    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ITEM_TIME_START", nullable = true)
    public Date getTime_start() {
        return time_start;
    }

    public void setTime_start(Date time_start) {
        this.time_start = time_start;
    }

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ITEM_TIME_EXPIRE", nullable = true)
    public Date getTime_expire() {
        return time_expire;
    }

    public void setTime_expire(Date time_expire) {
        this.time_expire = time_expire;
    }

    @Basic
    @Column(name = "ITEM_GOODS_TAG", nullable = true, length = 200)
    public String getGoods_tag() {
        return goods_tag;
    }

    public void setGoods_tag(String goods_tag) {
        this.goods_tag = goods_tag;
    }

    @Basic
    @Column(name = "ITEM_NOTIFY_URL", nullable = true, length = 200)
    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    @Basic
    @Column(name = "ITEM_TRADE_TYPE", nullable = true, length = 200)
    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    @Basic
    @Column(name = "ITEM_PRODUCT_ID", nullable = true, length = 200)
    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    @Basic
    @Column(name = "ITEM_HBZL", nullable = true, length = 200)
    public String getItemHbzl() {
        return itemHbzl;
    }

    public void setItemHbzl(String itemHbzl) {
        this.itemHbzl = itemHbzl;
    }

    @Basic
    @Column(name = "ITEM_RETURN_CODE", nullable = true, length = 200)
    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    @Basic
    @Column(name = "ITEM_RETURN_MSG", nullable = true, length = 200)
    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    @Id
    @Column(name = "ID", nullable = false, length = 200)
    @GenericGenerator(name = "uuid", strategy = "uuid.hex")
    @GeneratedValue(generator = "uuid")
    public String getId() {
        return id;
    }

    /*    private TlkOrderwechatpayEntity tlkOrderwechatpayEntity;

    @OneToOne(mappedBy = "tlkWechatpayEntity",targetEntity = TlkOrderwechatpayEntity.class)
    public TlkOrderwechatpayEntity getTlkOrderwechatpayEntity() {
        return tlkOrderwechatpayEntity;
    }

    public void setTlkOrderwechatpayEntity(TlkOrderwechatpayEntity tlkOrderwechatpayEntity) {
        this.tlkOrderwechatpayEntity = tlkOrderwechatpayEntity;
    }*/

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ITEM_OPENID", nullable = true, length = 200)
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Basic
    @Column(name = "ITEM_PREPAY_ID" ,nullable = true)
    public String getPrepay_id() {
        return prepay_id;
    }

    public void setPrepay_id(String prepay_id) {
        this.prepay_id = prepay_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TlkWechatpayEntity that = (TlkWechatpayEntity) o;

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
        if (appid != null ? !appid.equals(that.appid) : that.appid != null) return false;
        if (nonce_str != null ? !nonce_str.equals(that.nonce_str) : that.nonce_str != null) return false;
        if (mch_id != null ? !mch_id.equals(that.mch_id) : that.mch_id != null) return false;
        if (device_info != null ? !device_info.equals(that.device_info) : that.device_info != null)
            return false;
        if (body != null ? !body.equals(that.body) : that.body != null) return false;
        if (sign != null ? !sign.equals(that.sign) : that.sign != null) return false;
        if (attach != null ? !attach.equals(that.attach) : that.attach != null) return false;
        if (out_trade_no != null ? !out_trade_no.equals(that.out_trade_no) : that.out_trade_no != null)
            return false;
        if (total_fee != null ? !total_fee.equals(that.total_fee) : that.total_fee != null) return false;
        if (spbill_create_ip != null ? !spbill_create_ip.equals(that.spbill_create_ip) : that.spbill_create_ip != null)
            return false;
        if (time_start != null ? !time_start.equals(that.time_start) : that.time_start != null)
            return false;
        if (time_expire != null ? !time_expire.equals(that.time_expire) : that.time_expire != null)
            return false;
        if (goods_tag != null ? !goods_tag.equals(that.goods_tag) : that.goods_tag != null) return false;
        if (notify_url != null ? !notify_url.equals(that.notify_url) : that.notify_url != null)
            return false;
        if (trade_type != null ? !trade_type.equals(that.trade_type) : that.trade_type != null)
            return false;
        if (product_id != null ? !product_id.equals(that.product_id) : that.product_id != null)
            return false;
        if (itemHbzl != null ? !itemHbzl.equals(that.itemHbzl) : that.itemHbzl != null) return false;
        if (return_code != null ? !return_code.equals(that.return_code) : that.return_code != null)
            return false;
        if (return_msg != null ? !return_msg.equals(that.return_msg) : that.return_msg != null)
            return false;
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
        result = 31 * result + (appid != null ? appid.hashCode() : 0);
        result = 31 * result + (nonce_str != null ? nonce_str.hashCode() : 0);
        result = 31 * result + (mch_id != null ? mch_id.hashCode() : 0);
        result = 31 * result + (device_info != null ? device_info.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (sign != null ? sign.hashCode() : 0);
        result = 31 * result + (attach != null ? attach.hashCode() : 0);
        result = 31 * result + (out_trade_no != null ? out_trade_no.hashCode() : 0);
        result = 31 * result + (total_fee != null ? total_fee.hashCode() : 0);
        result = 31 * result + (spbill_create_ip != null ? spbill_create_ip.hashCode() : 0);
        result = 31 * result + (time_start != null ? time_start.hashCode() : 0);
        result = 31 * result + (time_expire != null ? time_expire.hashCode() : 0);
        result = 31 * result + (goods_tag != null ? goods_tag.hashCode() : 0);
        result = 31 * result + (notify_url != null ? notify_url.hashCode() : 0);
        result = 31 * result + (trade_type != null ? trade_type.hashCode() : 0);
        result = 31 * result + (product_id != null ? product_id.hashCode() : 0);
        result = 31 * result + (itemHbzl != null ? itemHbzl.hashCode() : 0);
        result = 31 * result + (return_code != null ? return_code.hashCode() : 0);
        result = 31 * result + (return_msg != null ? return_msg.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "ITEM_RESULT_CODE")
    public String getItemResultCode() {
        return itemResultCode;
    }

    public void setItemResultCode(String itemResultCode) {
        this.itemResultCode = itemResultCode;
    }

    @Basic
    @Column(name = "ITEM_ERR_CODE")
    public String getItemErrCode() {
        return itemErrCode;
    }

    public void setItemErrCode(String itemErrCode) {
        this.itemErrCode = itemErrCode;
    }

    @Basic
    @Column(name = "ITEM_ERR_CODE_DES")
    public String getItemErrCodeDes() {
        return itemErrCodeDes;
    }

    public void setItemErrCodeDes(String itemErrCodeDes) {
        this.itemErrCodeDes = itemErrCodeDes;
    }


    @Basic
    @Column(name = "ITEM_CODE_URL")
    public String getItemCodeUrl() {
        return itemCodeUrl;
    }

    public void setItemCodeUrl(String itemCodeUrl) {
        this.itemCodeUrl = itemCodeUrl;
    }
}
