package com.lkp.service.impl;

import com.cxt.wechat.pay.transfers.TransformPay;
import com.cxt.wechat.pay.transfers.entity.Check_Name_Type;
import com.cxt.wechat.pay.transfers.entity.Transform;
import com.cxt.wechat.pay.unifiedorder.util.WeChatSingUtil;
import com.cxt.wechat.util.StringUtil;
import com.google.gson.Gson;
import com.lkp.bean.WeChatCfg;
import com.lkp.dao.TLkPhotographerDao;
import com.lkp.dao.TlkOrderproductEntityDao;
import com.lkp.dao.TlkProductshowEntityDao;
import com.lkp.dao.TlkProductshowpicEntityDao;
import com.lkp.entity.*;
import com.lkp.entity.vo.SelectXJEntity;
import com.lkp.service.TLkPhotograoherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.Serializable;
import java.util.*;

/**
 *
 */
@Service
@Transactional
public class TLkPhotograoherServiceImpl implements TLkPhotograoherService {

    @Autowired
    TLkPhotographerDao tLkPhotographerDao;

    @Autowired
    WeChatCfg weChatCfg;

    @Autowired
    TlkOrderproductEntityDao tlkOrderproductEntityDao;

    @Autowired
    TlkProductshowEntityDao tlkProductshowEntityDao;

    @Autowired
    TlkProductshowpicEntityDao tlkProductshowpicEntityDao;

    @Override
    public TlkPhotographerEntity getPhotographerByOpenid(String openid) {
        return tLkPhotographerDao.getPhotoGrapherByOpenid(openid);
    }

    @Override
    public TlkPhotographerEntity getPhotographerBySysid(String sysid) {
        return tLkPhotographerDao.getPhotoGrapherBySysid(sysid);
    }

    @Override
    public TlkPhotographerEntity getPhotoGrapherByID(String id) {
        return tLkPhotographerDao.getPhotoGrapherByID(id);
    }

    @Override
    public List<TlkOrderproductEntity> getPhotographerOrderListByBh(String itemBh) {
        return tLkPhotographerDao.getPhotographerOrderListByBh(itemBh);
    }

    @Override
    public List<TlkOrderproductEntity> getUnfinishOrder(String userid) {
        return tLkPhotographerDao.getUnfinishOrder(userid);
    }

    @Override
    public List<TlkOrderproductEntity> getfinishOrder(String userid) {
        return tLkPhotographerDao.getfinishOrder(userid);
    }

    @Override
    public List<TlkOrderproductEntity> getCanceledOrder(String userid) {
        return tLkPhotographerDao.getCanceledOrder(userid);
    }

    @Override
    public Serializable saveHdSys(TlkPhotographerEntity tlkPhotographerEntity) {
        return tLkPhotographerDao.save(tlkPhotographerEntity);
    }

    @Override
    public TlkPhotographerEntity findById(Serializable id) {
        return tLkPhotographerDao.findById(id);
    }

    @Override
    public int getOrderCountByStateSysId(OrderState state, String sysid) {
        return (int) tLkPhotographerDao.getOrderCountByStateSysId(state, sysid);
    }

    @Override
    public List<TlkOrderproductEntity> getOrderByStateSysId(OrderState state, String sysid) {
        return tLkPhotographerDao.getOrderByStateSysId(state, sysid);
    }

    @Override
    public List<TlkOrderproductEntity> getOrderListOnlyOne(String sysid) {
        return tLkPhotographerDao.getOrderListOnlyOne(sysid);
    }

    @Override
    public List<TlkOrderproductEntity> getOrderBySysId(String sysid) {
        return tLkPhotographerDao.getOrderListBySysid(sysid);
    }

    @Override
    public int getOrderNumBySysId(String sysid) {
        return tLkPhotographerDao.getOrderNumBySysid(sysid);
    }


    @Override
    public int getCountAllOrder(String sysid) {
        return (int) tLkPhotographerDao.getCountAllOrder(sysid);
    }

    @Override
    public void UpdateSysInfo(TlkPhotographerEntity tlkPhotographerEntity) {
        tLkPhotographerDao.update(tlkPhotographerEntity);
    }

    @Override
    public double getHisZzSum(String sysid) {
        return tLkPhotographerDao.getHisZzSum(sysid);
    }

    @Override
    public double getZhyeBySysid(String sysid) {
        return tLkPhotographerDao.getZhyeBySysid(sysid);
    }
    @Override
    public double getIncome(String sysid) {
        return tLkPhotographerDao.getIncome( sysid);
    }


    @Override
    public List<TlkPhotographerEntity> GetAllSys() {
        return tLkPhotographerDao.findAll();
    }

    @Override
    public List<TlkPhotographerEntity> GetSysFY(Integer page, Integer pagesize) {
        List<TlkPhotographerEntity> list = new ArrayList<TlkPhotographerEntity>();
        List queryList = tLkPhotographerDao.GetSysFY(page, pagesize);
        for (Object o : queryList) {
            list.add((TlkPhotographerEntity) o);
        }
        return list;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = "Exception")
    public String SysTransform(TlkOrderproductEntity tlkOrderproductEntity) {
        String openid = tlkOrderproductEntity.getItemSysid().getItemOpenid().getOpenid();
        double paymoney = Double.parseDouble(tlkOrderproductEntity.getItemPrice());
        System.out.println("转账用户的openid==="+openid);
        System.out.println("paymoney==="+paymoney);
        String zzjg = "";
        if (paymoney <= 0) {
            zzjg = "转账失败，金额小于0";
            System.out.println("paymoney==="+paymoney);
        }
//        String partner_trade_no = UUID.randomUUID().toString();
        String partner_trade_no = tlkOrderproductEntity.getItemOrderid();
        File file = new File("D:/Project/LKP/secretKye/apiclient_cert.p12");
        String ip = "localhost";
        TransformPay transformPay = new TransformPay();
        Transform transform = new Transform();
        transform.setMch_appid(weChatCfg.getAppId());
        transform.setMchid(weChatCfg.getMic_id());
        transform.setNonce_str(StringUtil.getRandomString(16));
        transform.setPartner_trade_no(partner_trade_no);
        transform.setOpenid(openid);
        transform.setCheck_name(Check_Name_Type.NO_CHECK);
        transform.setAmount((int) (paymoney * 100));
        transform.setDesc("立可拍订单金额结算");
        transform.setSpbill_create_ip(ip);
        String a = new WeChatSingUtil().getStringSignTemp(transform, weChatCfg.getKey());
        String sign = new WeChatSingUtil().getMD5(a, "utf-8").toUpperCase();
        transform.setSign(sign);
        System.out.println("sign===="+sign);


        Transform transform1 = transformPay.Refound(transform, file, weChatCfg.getMic_id());
        transform.setReturn_code(transform1.getReturn_code());
        transform.setReturn_msg(transform1.getReturn_msg());
        transform.setResult_code(transform1.getResult_code());
        transform.setErr_code(transform1.getErr_code());
        transform.setErr_code_des(transform1.getErr_code_des());
        System.out.println("transform1===="+new Gson().toJson(transform1));

        if(transform1.getReturn_code().equals("SUCCESS")){
            if(transform1.getResult_code().equals("SUCCESS")){//业务结果成功,查询结果
                Map<String, String> map = transformPay.gettransferinfo(StringUtil.getRandomString(16), partner_trade_no, weChatCfg.getMic_id(), weChatCfg.getAppId(), weChatCfg.getKey(), file, weChatCfg.getMic_id());
                System.out.println("将查询结果约束成类");
                Transform transform2 = new Gson().fromJson(new Gson().toJson(map),Transform.class);
                if(transform2.getReturn_code().equals("SUCCESS")) {
                    if (transform2.getResult_code().equals("SUCCESS")) {//业务结果成功,查询结果
                        String status = map.get("status");
                        tlkOrderproductEntity.setItemZzje(String.valueOf(paymoney));
                        tlkOrderproductEntity.setItemZzsj(new Date());

                        if(status.equals("SUCCESS")){
                            System.out.println("转账成功,转账人姓名:========"+map.get("transfer_name")+"\n转账时间:"+map.get("transfer_time")+"\n转账金额:"+map.get("payment_amount"));
                            zzjg = "转账成功\n" + new Gson().toJson(map);
                            tlkOrderproductEntity.setItemZzzt("转账成功");
                        }else if(status.equals("FAILED")){
                            System.out.println("转账失败"+map.get("reason"));
                            zzjg = "转账失败\n" + new Gson().toJson(map);
                            tlkOrderproductEntity.setItemZzzt("转账失败");
                        }else{
                            System.out.println("处理中");
                            zzjg = "转账处理中\n" + new Gson().toJson(map);
                            tlkOrderproductEntity.setItemZzzt("转账处理中");
                        }
                        tlkOrderproductEntityDao.update(tlkOrderproductEntity);
                    } else {
                        System.out.println("查询失败"+transform2.getResult_code());
                        zzjg = "转账业务处理失败\n" + new Gson().toJson(map);
                    }
                }else{
                    System.out.println("查询失败==="+transform2.getErr_code_des());
                    zzjg = "转账结果获取接口调用失败：\n" + new Gson().toJson(map);

                }
            }else{
                zzjg = "业务结果失败";
                System.out.println("业务结果失败\n");
                System.out.println("ERR_CODE"+transform1.getErr_code()+"ERRCODE_DESC=="+transform1.getErr_code_des());

            }
        }else{
            zzjg = "调用转账接口失败：\n" + new Gson().toJson(transform1);
            System.out.println("调用转账接口失败：" + new Gson().toJson(transform1));

        }
        return zzjg;
    }

    @Override
    public Serializable createZuopin(TlkProductshowEntity tlkProductshowEntity) {
        return tlkProductshowEntityDao.save(tlkProductshowEntity) ;
    }

    @Override
    public Serializable createProductshowpicEntity(TlkProductshowpicEntity tlkProductshowpicEntity) {
        return tlkProductshowpicEntityDao.save(tlkProductshowpicEntity);
    }

    @Override
    public TlkProductshowpicEntity getProductshowpicByPicid(String picid) {
        return tlkProductshowpicEntityDao.findById(picid);
    }

    @Override
    public TlkProductshowEntity getProductshowByZuopingid(String id){
        return tlkProductshowEntityDao.getProductshowByZuopingid(id);
    }

    @Override
    public void updateZuopingCover(TlkProductshowEntity tlkProductshowEntity) {
        tlkProductshowEntityDao.update(tlkProductshowEntity);
    }

    @Override
    public void updateZuopingpic(TlkProductshowpicEntity tlkProductshowpicEntity) {
        tlkProductshowpicEntityDao.update(tlkProductshowpicEntity);
    }

    @Override
    public List<SelectXJEntity> FindAllSysXJ() {
        return tLkPhotographerDao.TestSql();
    }

    @Override
    public void deleteZuopingById(Serializable id) {
        tlkProductshowEntityDao.delete(id);
    }


    @Override
    public List<SelectXJEntity> FindTwoAllSysXJ() {
        return tLkPhotographerDao.FingTwoSql();
    }
}
