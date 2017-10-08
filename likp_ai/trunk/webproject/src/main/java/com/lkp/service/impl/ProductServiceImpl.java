package com.lkp.service.impl;

import com.cxt.wechat.media.MediaOperate;
import com.cxt.wechat.media.MediaUtil;
import com.google.gson.Gson;
import com.lkp.controller.UserController;
import com.lkp.dao.*;
import com.lkp.entity.*;
import com.lkp.entity.webJsonSolution.*;
import com.lkp.service.AccessTokenService;
import com.lkp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private TlkProductmainEntityDao productmainEntityDao;
    @Autowired
    UserController userController;
    @Autowired
    AccessTokenService accessTokenService;
    @Autowired
    YingjiDao yingjiDao;
    @Autowired
    TlkCpfwxqDao tlkCpfwxqDao;
    @Autowired
    YingjiPicDao yingjiPicDao;
    @Autowired
    ProductShowEntityDao productShowEntityDao;
    @Autowired
    ProductShowPicDao productShowPicDao;
    @Autowired
    TlkProductshowEntityDao tlkProductshowEntityDao;
    MediaUtil mediaUtil =  new MediaUtil();
    Gson gson = new Gson();
    @Transactional
    public List<TlkProductEntity> getProduct(Integer page, Integer pagesize) {
        List<TlkProductEntity> list = new ArrayList<TlkProductEntity>();
        List queryList = productDao.getProducts(page, pagesize);
        for(Object o : queryList){
            list.add((TlkProductEntity) o);
        }
        return list;
    }
    @Transactional
    public Serializable save(TlkProductEntity tlkProductEntity) {
        return productDao.save(tlkProductEntity);
    }
    @Transactional
    public TlkProductEntity find(Serializable id) {
        return productDao.getProdctsById(id);
    }

    @Override
    public List<TlkProductEntity> getProductsBySysId(Serializable id) {
        return productDao.getProductsBySysId(id);
    }

    @Override
    public List<TlkProductEntity> getZuoyeInforBySysId(Serializable  id) {
        return productDao.getZuoyeInforBySysid(id);
    }

    @Override
    public List<TlkProductmainEntity> getProductMains() {
        return productmainEntityDao.getAllEnabled();
    }

    @Override
    public List<TlkProductmainEntity> findByid(String id) {
        return productmainEntityDao.findByid(id);
    }

    /**
     * 根据订单数量排序产品
     * @return
     */
    @Override
    public List<TlkProductEntity> getOderbyProductCount() {return productDao.getProdutOderderByCount();}

    @Override
    public TlkProductEntity getCollectionProduct(String id) {
        return productDao.getCollectionProduct(id);
    }

    @Override
    public TlkProductEntity getProductByHDBH(String hdbh) {
        return productDao.getProductByHDBH(hdbh);
    }

    @Override
    public List<TlkProductEntity> getProductBySys(String itemSys) {
        return productDao.getProductBySys(itemSys);
    }

    @Override
    public List<TlkProductEntity> getProductNum(String itemSys) {
        return productDao.getProductNum(itemSys);
    }

    @Override
    public Serializable saveProduct(Product p, ProductShow ps,String sys) {
        Gson gson = new Gson();
        String id = null;
        if(p!=null){
            TlkProductEntity productEntity ;
            //是修改或者新建
            if(p.getId()!=null&&productDao.findById(p.getId())!=null){
                productEntity = productDao.findById(p.getId());
            }else{
                productEntity = new TlkProductEntity();
            }
            productEntity.setItemName(p.getProductName());
            productEntity.setItemPrice(String.valueOf(p.getProductPrice()));
            productEntity.setItemShzt("0");
            productEntity.setItemCpzt("下线");
            productEntity.setItemCpbh(UUID.randomUUID().toString());
            productEntity.setItemSys(sys);
            MeidaUtilOperate meidaUtilOperate = new MeidaUtilOperate();
            if(p.getProductCover().getType().equals("user")){
                mediaUtil.getMedia(accessTokenService.getAccessToken(),p.getProductCover().getTargetId(),meidaUtilOperate);
                productEntity.setItemCover("[{\"name\":\"产品封面\",\"path\":\""+meidaUtilOperate.getImgPath()+"\"}]");
            }else if(p.getProductCover().getType().equals("service")){
                productEntity.setItemCover(p.getProductCover().getTargetId());
            }
            TlkCpfwxqEntity tlkCpfwxqEntity;
            if(p.getCpfwId()!=null&&tlkCpfwxqDao.findById(p.getCpfwId())!=null){
                tlkCpfwxqEntity = tlkCpfwxqDao.findById(p.getCpfwId());
            }else{
                tlkCpfwxqEntity = new TlkCpfwxqEntity();
            }
            tlkCpfwxqEntity.setItemTime(p.getProductTime());
            tlkCpfwxqEntity.setItemDress(p.getProductSute());
            tlkCpfwxqEntity.setItemFee(String.valueOf(p.getProductPrice()));
            tlkCpfwxqEntity.setItemJingxiunumber(p.getFixPicNum());
            tlkCpfwxqEntity.setItemPicturenumber(p.getOrgPicNum());
            tlkCpfwxqEntity.setItemMakeup(p.getProductMakeUp());
            tlkCpfwxqEntity.setItemSection(p.getProductSituation());
            tlkCpfwxqEntity.setItemPhotonumber(p.getProductPeople());
            if(p.getShiwujiaofu().size()>0){
                tlkCpfwxqEntity.setItemFjswjf(gson.toJson(p.getShiwujiaofu()));
            }
            if(p.getProductOrther().size()>0){
                tlkCpfwxqEntity.setItemZdyxq(gson.toJson(p.getProductOrther()));
            }
            List<ImageObj> imageObjs = new ArrayList<>();
            for(Shiwu shiwu : p.getShiwu()){
                if(shiwu.getType().equals("user")){
                    mediaUtil.getMedia(accessTokenService.getAccessToken(),shiwu.getTargetId(),meidaUtilOperate);
                    imageObjs.add(new ImageObj("附加图片",meidaUtilOperate.getImgPath()));
                }else if(shiwu.getType().equals("service")){
                    imageObjs.add(gson.fromJson(shiwu.getTargetId(),ImageObj.class));
                }
            }
            if(imageObjs.size()>0){
                tlkCpfwxqEntity.setItemFjtp(gson.toJson(imageObjs));
            }
            if(productEntity.getId()==null){
                id = (String) productDao.save(productEntity);
                productEntity = productDao.findById(id);
            }else{
                id = p.getId();
            }
            tlkCpfwxqEntity.setParent(id);
            if(tlkCpfwxqEntity.getId()==null){
                tlkCpfwxqDao.save(tlkCpfwxqEntity);
            }
            if(ps!=null){
                TlkProductshowEntity productshowEntity;
                if(ps.getId()!=null&&productShowEntityDao.findById(ps.getId())!=null){
                    productshowEntity = productShowEntityDao.findById(ps.getId());
                }else{
                    productshowEntity = new TlkProductshowEntity();
                }
                //产品展示设置和影集设置
                productshowEntity.setItemTitle(ps.getProductShowTitle());
                if(ps.getProductShowCover()!=null){
                    String cover = null;
                    if(ps.getProductShowCover().getType().equals("user")){
                        mediaUtil.getMedia(accessTokenService.getAccessToken(),ps.getProductShowCover().getTargetId(),meidaUtilOperate);
                        cover = "["+gson.toJson(new ImageObj("封面图片",meidaUtilOperate.getImgPath()))+"]";
                    }else if(ps.getProductShowCover().getType().equals("service")){
                        cover = ps.getProductShowCover().getTargetId();
                    }
                    productshowEntity.setItemZpfm(cover);
                }
                productshowEntity.setTlkProductEntity(productEntity);
                if(productshowEntity.getId()==null){
                    productShowEntityDao.save(productshowEntity);
                }else{
                    for(TlkProductshowpicEntity tlkProductshowpicEntity : productshowEntity.getTlkProductshowpicEntities()){
                        tlkProductshowpicEntity.setTlkProductshowEntity(null);
                    }
                }
                Integer i = 0;
                for(ProducteShowItem producteShowItem : ps.getProductShowItem()){
                    String cover = null;
                    TlkProductshowpicEntity tlkProductshowpicEntity = null;
                    if(producteShowItem.getType().equals("user")){
                        tlkProductshowpicEntity = new TlkProductshowpicEntity();
                        mediaUtil.getMedia(accessTokenService.getAccessToken(),producteShowItem.getTargetId(),meidaUtilOperate);
                        tlkProductshowpicEntity.setItemPicurl("["+gson.toJson(new ImageObj("展示图片",meidaUtilOperate.getImgPath()))+"]");
                    }else if(producteShowItem.getType().equals("service")){
                        tlkProductshowpicEntity = productShowPicDao.findById(producteShowItem.getTargetId());
                    }
                    tlkProductshowpicEntity.setItemDescript(producteShowItem.getDes());
                    tlkProductshowpicEntity.setItemOrder(i);
                    tlkProductshowpicEntity.setTlkProductshowEntity(productshowEntity);
                    if(tlkProductshowpicEntity.getId()==null)
                    productShowPicDao.save(tlkProductshowpicEntity);
                    i++;
                }
            }
        }
        return id;
    }

    @Override
    public List<TlkProductshowEntity> getShowBySySId(String sys) {
        return productShowEntityDao.findBySysId(sys);
    }

    @Override
    public void updateProductState(Serializable id, String state) {
        TlkProductEntity productEntity = productDao.findById(id);
        productEntity.setItemShzt(state);
        if(!state.equals("2")) productEntity.setItemCpzt("下线");
        else productEntity.setItemCpzt("上线");
    }

    @Override
    public void DeleteProductById(Serializable id) {
        productDao.delete(id);
    }

    @Override
    public List<TlkProductshowEntity> getZuopingBySysid(String id) {
        return tlkProductshowEntityDao.getZuopingBySysid(id);
    }

    class MeidaUtilOperate implements MediaOperate{
        private String imgPath;

        @Override
        public void InputstreamOperate(InputStream inputStream) {
            File file = new File(userController.filepath + UUID.randomUUID() + ".jpg");
            try {
                OutputStream outputStream = new FileOutputStream(file);
                byte[] data = new byte[1048576];
                boolean index = false;

                int index1;
                while ((index1 = inputStream.read(data)) != -1) {
                    outputStream.write(data, 0, index1);
                }
                inputStream.close();
                outputStream.close();
                imgPath = userController.imgpre + file.getName() ;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String getImgPath() {
            return imgPath;
        }

        public void setImgPath(String imgPath) {
            this.imgPath = imgPath;
        }
    }
}
