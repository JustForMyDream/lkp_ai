package com.lkp.dao.impl;

import com.lkp.dao.ProductShowEntityDao;
import com.lkp.entity.TlkProductshowEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
@Repository
public class ProductShowEntityDaoImpl extends BaseDaoImpl<TlkProductshowEntity> implements ProductShowEntityDao {
    String QUERY_FIND_PRODUCTSHOWENTITY_BY_ID = "from "+TlkProductshowEntity.class.getName()+" pw left join fetch pw.tlkProductEntity p left join fetch pw.tlkProductshowpicEntities s where pw.id=:id";

    String QUERY_FIND_PRODUCTSHOWENTITY_BY_SYSID = "select distinct pw from "+TlkProductshowEntity.class.getName()+" pw left join fetch pw.tlkProductEntity p join fetch pw.tlkProductshowpicEntities s where pw.itemSysbh=:id and pw.itemZpzt = '上线' group by pw.id";

    /**
     * 通过主键获取产品展示信息
     * @param id
     * @return
     */
    public TlkProductshowEntity findById(Serializable id) {
        Query query = getSession().createQuery(QUERY_FIND_PRODUCTSHOWENTITY_BY_ID);
        query.setParameter("id",id);
        return (TlkProductshowEntity) query.uniqueResult();
    }

    @Override
    public List<TlkProductshowEntity> findBySysId(String sys) {
        Query query = getSession().createQuery(QUERY_FIND_PRODUCTSHOWENTITY_BY_SYSID);
        query.setParameter("id",sys);
        return query.list();
    }
}
