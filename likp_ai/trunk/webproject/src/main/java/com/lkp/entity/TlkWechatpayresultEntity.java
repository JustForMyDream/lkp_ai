package com.lkp.entity;

import com.lkp.bean.SQLDefautValue;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 */
@Entity
@javax.persistence.Table(name = "tlk_wechatpayresult", schema = "lkp", catalog = "")
@Access(AccessType.PROPERTY)
public class TlkWechatpayresultEntity {
    private String parent;
    private Date lastmodified = new Date();
    private String formname = "lkp/社区产品/订单管理/wechatpayresult";
    private String state;
    private String audituser;
    private Date auditdate;
    private String author = SQLDefautValue.author;
    private String authorDeptIndex = SQLDefautValue.author_dept_index;
    private Date created = new Date();
    private Boolean istmp = false;
    private String formid = "11e6-9516-1d1fa18e-ad8b-11472dfbd6fd";
    private Integer versions = 2;
    private String applicationid = SQLDefautValue.applicationid;
    private Integer stateint = 0;
    private String statelabel;
    private String auditornames;
    private String lastflowoperation;
    private String lastmodifier = SQLDefautValue.author;
    private String domainid;
    private String auditorlist = "{}";
    private String statelabelinfo;
    private String prevauditnode;
    private String prevaudituser;
    private String itemReturnCode;
    private String itemReturnMsg;
    private String itemAppid;
    private String itemMchId;
    private String itemDeviceInfo;
    private String itemNonceStr;
    private String itemSign;
    private String itemResultCode;
    private String itemErrCode;
    private String itemErrCodeDes;
    private String itemOpenid;
    private String itemIsSubscribe;
    private String itemTradeType;
    private String itemBankType;
    private BigDecimal itemTotalFee;
    private String itemCashFee;
    private String itemCashFeeType;
    private String itemTransactionId;
    private String itemOutTradeNo;
    private String itemAttach;
    private Date itemTimeEnd;
    private String id;

    @Basic
    @javax.persistence.Column(name = "PARENT", nullable = true, length = 200)
    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @javax.persistence.Column(name = "LASTMODIFIED", nullable = true)
    public Date getLastmodified() {
        return lastmodified;
    }

    public void setLastmodified(Date lastmodified) {
        this.lastmodified = lastmodified;
    }

    @Basic
    @javax.persistence.Column(name = "FORMNAME", nullable = true, length = 200)
    public String getFormname() {
        return formname;
    }

    public void setFormname(String formname) {
        this.formname = formname;
    }


    @Basic
    @javax.persistence.Column(name = "STATE", nullable = true, length = 200)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    @Basic
    @javax.persistence.Column(name = "AUDITUSER", nullable = true, length = 200)
    public String getAudituser() {
        return audituser;
    }

    public void setAudituser(String audituser) {
        this.audituser = audituser;
    }


    @Temporal(TemporalType.TIMESTAMP)
    @javax.persistence.Column(name = "AUDITDATE", nullable = true)
    public Date getAuditdate() {
        return auditdate;
    }

    public void setAuditdate(Date auditdate) {
        this.auditdate = auditdate;
    }


    @Basic
    @javax.persistence.Column(name = "AUTHOR", nullable = true, length = 200)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    @Basic
    @javax.persistence.Column(name = "AUTHOR_DEPT_INDEX", nullable = true, length = 2000)
    public String getAuthorDeptIndex() {
        return authorDeptIndex;
    }

    public void setAuthorDeptIndex(String authorDeptIndex) {
        this.authorDeptIndex = authorDeptIndex;
    }


    @Temporal(TemporalType.TIMESTAMP)
    @javax.persistence.Column(name = "CREATED", nullable = true)
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }


    @Basic
    @javax.persistence.Column(name = "FORMID", nullable = true, length = 200)
    public String getFormid() {
        return formid;
    }

    public void setFormid(String formid) {
        this.formid = formid;
    }

    @Basic
    @javax.persistence.Column(name = "ISTMP", nullable = true)
    public Boolean getIstmp() {
        return istmp;
    }

    public void setIstmp(Boolean istmp) {
        this.istmp = istmp;
    }


    @Basic
    @javax.persistence.Column(name = "VERSIONS", nullable = true)
    public Integer getVersions() {
        return versions;
    }

    public void setVersions(Integer versions) {
        this.versions = versions;
    }


    @Basic
    @javax.persistence.Column(name = "APPLICATIONID", nullable = true, length = 200)
    public String getApplicationid() {
        return applicationid;
    }

    public void setApplicationid(String applicationid) {
        this.applicationid = applicationid;
    }


    @Basic
    @javax.persistence.Column(name = "STATEINT", nullable = true)
    public Integer getStateint() {
        return stateint;
    }

    public void setStateint(Integer stateint) {
        this.stateint = stateint;
    }


    @Basic
    @javax.persistence.Column(name = "STATELABEL", nullable = true, length = 200)
    public String getStatelabel() {
        return statelabel;
    }

    public void setStatelabel(String statelabel) {
        this.statelabel = statelabel;
    }


    @Basic
    @javax.persistence.Column(name = "AUDITORNAMES", nullable = true, length = 200)
    public String getAuditornames() {
        return auditornames;
    }

    public void setAuditornames(String auditornames) {
        this.auditornames = auditornames;
    }


    @Basic
    @javax.persistence.Column(name = "LASTFLOWOPERATION", nullable = true, length = 200)
    public String getLastflowoperation() {
        return lastflowoperation;
    }

    public void setLastflowoperation(String lastflowoperation) {
        this.lastflowoperation = lastflowoperation;
    }


    @Basic
    @javax.persistence.Column(name = "LASTMODIFIER", nullable = true, length = 200)
    public String getLastmodifier() {
        return lastmodifier;
    }

    public void setLastmodifier(String lastmodifier) {
        this.lastmodifier = lastmodifier;
    }


    @Basic
    @javax.persistence.Column(name = "DOMAINID", nullable = true, length = 200)
    public String getDomainid() {
        return domainid;
    }

    public void setDomainid(String domainid) {
        this.domainid = domainid;
    }


    @Basic
    @javax.persistence.Column(name = "AUDITORLIST", nullable = true, length = 200)
    public String getAuditorlist() {
        return auditorlist;
    }

    public void setAuditorlist(String auditorlist) {
        this.auditorlist = auditorlist;
    }


    @Basic
    @javax.persistence.Column(name = "STATELABELINFO", nullable = true, length = 200)
    public String getStatelabelinfo() {
        return statelabelinfo;
    }

    public void setStatelabelinfo(String statelabelinfo) {
        this.statelabelinfo = statelabelinfo;
    }


    @Basic
    @javax.persistence.Column(name = "PREVAUDITNODE", nullable = true, length = 200)
    public String getPrevauditnode() {
        return prevauditnode;
    }

    public void setPrevauditnode(String prevauditnode) {
        this.prevauditnode = prevauditnode;
    }


    @Basic
    @javax.persistence.Column(name = "PREVAUDITUSER", nullable = true, length = 200)
    public String getPrevaudituser() {
        return prevaudituser;
    }

    public void setPrevaudituser(String prevaudituser) {
        this.prevaudituser = prevaudituser;
    }


    @Basic
    @javax.persistence.Column(name = "ITEM_RETURN_CODE", nullable = true, length = 200)
    public String getItemReturnCode() {
        return itemReturnCode;
    }

    public void setItemReturnCode(String itemReturnCode) {
        this.itemReturnCode = itemReturnCode;
    }


    @Basic
    @javax.persistence.Column(name = "ITEM_RETURN_MSG", nullable = true, length = 200)
    public String getItemReturnMsg() {
        return itemReturnMsg;
    }

    public void setItemReturnMsg(String itemReturnMsg) {
        this.itemReturnMsg = itemReturnMsg;
    }


    @Basic
    @javax.persistence.Column(name = "ITEM_APPID", nullable = true, length = 200)
    public String getItemAppid() {
        return itemAppid;
    }

    public void setItemAppid(String itemAppid) {
        this.itemAppid = itemAppid;
    }


    @Basic
    @javax.persistence.Column(name = "ITEM_MCH_ID", nullable = true, length = 200)
    public String getItemMchId() {
        return itemMchId;
    }

    public void setItemMchId(String itemMchId) {
        this.itemMchId = itemMchId;
    }


    @Basic
    @javax.persistence.Column(name = "ITEM_DEVICE_INFO", nullable = true, length = 200)
    public String getItemDeviceInfo() {
        return itemDeviceInfo;
    }

    public void setItemDeviceInfo(String itemDeviceInfo) {
        this.itemDeviceInfo = itemDeviceInfo;
    }


    @Basic
    @javax.persistence.Column(name = "ITEM_NONCE_STR", nullable = true, length = 200)
    public String getItemNonceStr() {
        return itemNonceStr;
    }

    public void setItemNonceStr(String itemNonceStr) {
        this.itemNonceStr = itemNonceStr;
    }


    @Basic
    @javax.persistence.Column(name = "ITEM_SIGN", nullable = true, length = 200)
    public String getItemSign() {
        return itemSign;
    }

    public void setItemSign(String itemSign) {
        this.itemSign = itemSign;
    }


    @Basic
    @javax.persistence.Column(name = "ITEM_RESULT_CODE", nullable = true, length = 200)
    public String getItemResultCode() {
        return itemResultCode;
    }

    public void setItemResultCode(String itemResultCode) {
        this.itemResultCode = itemResultCode;
    }


    @Basic
    @javax.persistence.Column(name = "ITEM_ERR_CODE", nullable = true, length = 200)
    public String getItemErrCode() {
        return itemErrCode;
    }

    public void setItemErrCode(String itemErrCode) {
        this.itemErrCode = itemErrCode;
    }


    @Basic
    @javax.persistence.Column(name = "ITEM_ERR_CODE_DES", nullable = true, length = 200)
    public String getItemErrCodeDes() {
        return itemErrCodeDes;
    }

    public void setItemErrCodeDes(String itemErrCodeDes) {
        this.itemErrCodeDes = itemErrCodeDes;
    }


    @Basic
    @javax.persistence.Column(name = "ITEM_OPENID", nullable = true, length = 200)
    public String getItemOpenid() {
        return itemOpenid;
    }

    public void setItemOpenid(String itemOpenid) {
        this.itemOpenid = itemOpenid;
    }


    @Basic
    @javax.persistence.Column(name = "ITEM_IS_SUBSCRIBE", nullable = true, length = 200)
    public String getItemIsSubscribe() {
        return itemIsSubscribe;
    }

    public void setItemIsSubscribe(String itemIsSubscribe) {
        this.itemIsSubscribe = itemIsSubscribe;
    }


    @Basic
    @javax.persistence.Column(name = "ITEM_TRADE_TYPE", nullable = true, length = 200)
    public String getItemTradeType() {
        return itemTradeType;
    }

    public void setItemTradeType(String itemTradeType) {
        this.itemTradeType = itemTradeType;
    }


    @Basic
    @javax.persistence.Column(name = "ITEM_BANK_TYPE", nullable = true, length = 200)
    public String getItemBankType() {
        return itemBankType;
    }

    public void setItemBankType(String itemBankType) {
        this.itemBankType = itemBankType;
    }


    @Basic
    @javax.persistence.Column(name = "ITEM_TOTAL_FEE", nullable = true, precision = 10)
    public BigDecimal getItemTotalFee() {
        return itemTotalFee;
    }

    public void setItemTotalFee(BigDecimal itemTotalFee) {
        this.itemTotalFee = itemTotalFee;
    }


    @Basic
    @javax.persistence.Column(name = "ITEM_CASH_FEE", nullable = true, length = 200)
    public String getItemCashFee() {
        return itemCashFee;
    }

    public void setItemCashFee(String itemCashFee) {
        this.itemCashFee = itemCashFee;
    }


    @Basic
    @javax.persistence.Column(name = "ITEM_CASH_FEE_TYPE", nullable = true, length = 200)
    public String getItemCashFeeType() {
        return itemCashFeeType;
    }

    public void setItemCashFeeType(String itemCashFeeType) {
        this.itemCashFeeType = itemCashFeeType;
    }


    @Basic
    @javax.persistence.Column(name = "ITEM_TRANSACTION_ID", nullable = true, length = 200)
    public String getItemTransactionId() {
        return itemTransactionId;
    }

    public void setItemTransactionId(String itemTransactionId) {
        this.itemTransactionId = itemTransactionId;
    }


    @Basic
    @javax.persistence.Column(name = "ITEM_OUT_TRADE_NO", nullable = true, length = 200)
    public String getItemOutTradeNo() {
        return itemOutTradeNo;
    }

    public void setItemOutTradeNo(String itemOutTradeNo) {
        this.itemOutTradeNo = itemOutTradeNo;
    }


    @Basic
    @javax.persistence.Column(name = "ITEM_ATTACH", nullable = true, length = 200)
    public String getItemAttach() {
        return itemAttach;
    }

    public void setItemAttach(String itemAttach) {
        this.itemAttach = itemAttach;
    }


    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @javax.persistence.Column(name = "ITEM_TIME_END", nullable = true)
    public Date getItemTimeEnd() {
        return itemTimeEnd;
    }

    public void setItemTimeEnd(Date itemTimeEnd) {
        this.itemTimeEnd = itemTimeEnd;
    }


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

        TlkWechatpayresultEntity that = (TlkWechatpayresultEntity) o;

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
        if (itemReturnCode != null ? !itemReturnCode.equals(that.itemReturnCode) : that.itemReturnCode != null)
            return false;
        if (itemReturnMsg != null ? !itemReturnMsg.equals(that.itemReturnMsg) : that.itemReturnMsg != null)
            return false;
        if (itemAppid != null ? !itemAppid.equals(that.itemAppid) : that.itemAppid != null) return false;
        if (itemMchId != null ? !itemMchId.equals(that.itemMchId) : that.itemMchId != null) return false;
        if (itemDeviceInfo != null ? !itemDeviceInfo.equals(that.itemDeviceInfo) : that.itemDeviceInfo != null)
            return false;
        if (itemNonceStr != null ? !itemNonceStr.equals(that.itemNonceStr) : that.itemNonceStr != null) return false;
        if (itemSign != null ? !itemSign.equals(that.itemSign) : that.itemSign != null) return false;
        if (itemResultCode != null ? !itemResultCode.equals(that.itemResultCode) : that.itemResultCode != null)
            return false;
        if (itemErrCode != null ? !itemErrCode.equals(that.itemErrCode) : that.itemErrCode != null) return false;
        if (itemErrCodeDes != null ? !itemErrCodeDes.equals(that.itemErrCodeDes) : that.itemErrCodeDes != null)
            return false;
        if (itemOpenid != null ? !itemOpenid.equals(that.itemOpenid) : that.itemOpenid != null) return false;
        if (itemIsSubscribe != null ? !itemIsSubscribe.equals(that.itemIsSubscribe) : that.itemIsSubscribe != null)
            return false;
        if (itemTradeType != null ? !itemTradeType.equals(that.itemTradeType) : that.itemTradeType != null)
            return false;
        if (itemBankType != null ? !itemBankType.equals(that.itemBankType) : that.itemBankType != null) return false;
        if (itemTotalFee != null ? !itemTotalFee.equals(that.itemTotalFee) : that.itemTotalFee != null) return false;
        if (itemCashFee != null ? !itemCashFee.equals(that.itemCashFee) : that.itemCashFee != null) return false;
        if (itemCashFeeType != null ? !itemCashFeeType.equals(that.itemCashFeeType) : that.itemCashFeeType != null)
            return false;
        if (itemTransactionId != null ? !itemTransactionId.equals(that.itemTransactionId) : that.itemTransactionId != null)
            return false;
        if (itemOutTradeNo != null ? !itemOutTradeNo.equals(that.itemOutTradeNo) : that.itemOutTradeNo != null)
            return false;
        if (itemAttach != null ? !itemAttach.equals(that.itemAttach) : that.itemAttach != null) return false;
        if (itemTimeEnd != null ? !itemTimeEnd.equals(that.itemTimeEnd) : that.itemTimeEnd != null) return false;
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
        result = 31 * result + (itemReturnCode != null ? itemReturnCode.hashCode() : 0);
        result = 31 * result + (itemReturnMsg != null ? itemReturnMsg.hashCode() : 0);
        result = 31 * result + (itemAppid != null ? itemAppid.hashCode() : 0);
        result = 31 * result + (itemMchId != null ? itemMchId.hashCode() : 0);
        result = 31 * result + (itemDeviceInfo != null ? itemDeviceInfo.hashCode() : 0);
        result = 31 * result + (itemNonceStr != null ? itemNonceStr.hashCode() : 0);
        result = 31 * result + (itemSign != null ? itemSign.hashCode() : 0);
        result = 31 * result + (itemResultCode != null ? itemResultCode.hashCode() : 0);
        result = 31 * result + (itemErrCode != null ? itemErrCode.hashCode() : 0);
        result = 31 * result + (itemErrCodeDes != null ? itemErrCodeDes.hashCode() : 0);
        result = 31 * result + (itemOpenid != null ? itemOpenid.hashCode() : 0);
        result = 31 * result + (itemIsSubscribe != null ? itemIsSubscribe.hashCode() : 0);
        result = 31 * result + (itemTradeType != null ? itemTradeType.hashCode() : 0);
        result = 31 * result + (itemBankType != null ? itemBankType.hashCode() : 0);
        result = 31 * result + (itemTotalFee != null ? itemTotalFee.hashCode() : 0);
        result = 31 * result + (itemCashFee != null ? itemCashFee.hashCode() : 0);
        result = 31 * result + (itemCashFeeType != null ? itemCashFeeType.hashCode() : 0);
        result = 31 * result + (itemTransactionId != null ? itemTransactionId.hashCode() : 0);
        result = 31 * result + (itemOutTradeNo != null ? itemOutTradeNo.hashCode() : 0);
        result = 31 * result + (itemAttach != null ? itemAttach.hashCode() : 0);
        result = 31 * result + (itemTimeEnd != null ? itemTimeEnd.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
