package com.lkp.service;

import com.lkp.entity.TlkProductEntity;
import com.lkp.entity.TlkProductmainEntity;
import com.lkp.entity.TlkProductshowEntity;
import com.lkp.entity.webJsonSolution.Product;
import com.lkp.entity.webJsonSolution.ProductShow;

import java.io.Serializable;
import java.util.List;

/**
 *
 * 产品业务类.
 */
public interface ProductService {
    /**
     * 产品分页查询
     *
     * @param page
     * @param pagesize
     * @return
     */
    List<TlkProductEntity> getProduct(Integer page, Integer pagesize);

    Serializable save(TlkProductEntity tlkProductEntity);

    TlkProductEntity find(Serializable id);

    /**
     * 通过摄影师编号获得产品信息
     *
     * @return
     */
    List<TlkProductEntity> getProductsBySysId(Serializable id);

    List<TlkProductEntity> getZuoyeInforBySysId(Serializable id);

    /**
     * 获取产品主题
     *
     * @return
     */
    List<TlkProductmainEntity> getProductMains();

    /**
     * 通过主题编号获取主题和产品
     *
     * @param id
     * @return
     */
    List<TlkProductmainEntity> findByid(String id);


    /**
     * 根据订单数量排序产品
     *
     * @return
     */
    List<TlkProductEntity> getOderbyProductCount();

    TlkProductEntity getCollectionProduct(String id);

    /**
     * 过活动编号获取产品
     * 通
     */
    TlkProductEntity getProductByHDBH(String hdbh);

    /**
     * 通过摄影师id（即编号）的到摄影师的信息
     *
     * @param itemSys
     * @return
     */
    List<TlkProductEntity> getProductBySys(String itemSys);

    List<TlkProductEntity> getProductNum(String itemSys);


    /**
     * @param p
     * @param ps
     * @param sys
     * @return
     */
    Serializable saveProduct(Product p, ProductShow ps, String sys);

    List<TlkProductshowEntity> getShowBySySId(String sys);

    /**
     * 更新产品状态
     *
     * @param id
     * @param state
     */
    void updateProductState(Serializable id, String state);

    /**
     * 通过id删除产品
     * @param id
     */
    void DeleteProductById(Serializable id);


    /**
     *以下为作品的新建修改删除
     */

    /**
     * 通过摄影师编号查询摄影师的所有作品
     * @param id
     * @return
     */
    List<TlkProductshowEntity> getZuopingBySysid(String id);

}
