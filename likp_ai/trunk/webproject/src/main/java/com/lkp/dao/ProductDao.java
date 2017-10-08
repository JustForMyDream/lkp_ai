package com.lkp.dao;

import com.lkp.entity.TlkProductEntity;

import java.io.Serializable;
import java.util.List;

/**
 *
 * 产品信息接口
 */
public interface ProductDao extends BaseDao<TlkProductEntity> {
    /**
     * 获取产品信息(分页查询)
     *
     * @return 查询结果数组
     * @param page 页数
     * @param pagesize 每页显示数量
     */
    List<TlkProductEntity> getProducts(Integer page, Integer pagesize);

    TlkProductEntity getProdctsById(Serializable id);

    /**
     * 通过摄影师编号的到产品信息
     *
     * @return
     */
    List<TlkProductEntity> getProductsBySysId(Serializable Sysid);

    List<TlkProductEntity> getZuoyeInforBySysid(Serializable id);

    /**
     * 通过产品编号获取产品信息
     *
     * @param cpbh
     * @return
     */
    TlkProductEntity getProdctsByCPBH(String cpbh);

    List<TlkProductEntity> getProdutOderderByCount();

    TlkProductEntity getCollectionProduct(String id);

    /**
     * 通过活动编号获取产品
     *
     * @param hdbh
     * @return
     */
    TlkProductEntity getProductByHDBH(String hdbh);

    /**
     * 通过摄影师编号得到摄影师的产品
     *
     * @param itemSys
     * @return
     */
    List<TlkProductEntity> getProductBySys(String itemSys);

    /**
     * 通过摄影师编号得到产品上线的数量
     * @param itemSys
     * @return
     */
    List<TlkProductEntity> getProductNum(String itemSys);
}
