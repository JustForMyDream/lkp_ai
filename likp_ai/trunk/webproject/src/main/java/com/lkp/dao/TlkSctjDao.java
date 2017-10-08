package com.lkp.dao;

import com.lkp.entity.TlkSctjEntity;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
public interface TlkSctjDao extends BaseDao<TlkSctjEntity>{
    /*
    通过输出id查找信息
    * */
    TlkSctjEntity getsctiByid(Serializable id);

    List<TlkSctjEntity> getALlSctj();

}
