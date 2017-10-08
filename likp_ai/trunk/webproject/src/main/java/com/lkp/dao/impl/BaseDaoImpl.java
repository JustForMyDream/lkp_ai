package com.lkp.dao.impl;

import com.lkp.dao.BaseDao;
import com.lkp.entity.TDocumentEntity;
import org.hibernate.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;

/**
 * 通用Dao
 *
 */

@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {

    private Class<T> clazz;

    @Resource
    private SessionFactory sessionFactory;

    protected Session getSession() {
        Session s = sessionFactory.getCurrentSession();
        return s;
    }

    public BaseDaoImpl() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class<T>) type.getActualTypeArguments()[0];
    }

    public Serializable save(T object) {
        TDocumentEntity tDocumentEntity = new TDocumentEntity();
        Field[] ofields = object.getClass().getDeclaredFields();
        for (Field field : ofields) {
            field.setAccessible(true);
            try {
                if ("lastmodified".equals(field.getName()) && field.get(object) != null) {
                    tDocumentEntity.setLastmodified((Date) field.get(object));
                }
                if ("formname".equals(field.getName()) && field.get(object) != null) {
                    tDocumentEntity.setFormname((String) field.get(object));
                }
                if ("auditdate".equals(field.getName()) && field.get(object) != null) {
                    tDocumentEntity.setAuditdate((Date) field.get(object));
                }
                if ("author".equals(field.getName()) && field.get(object) != null) {
                    tDocumentEntity.setAuthor((String) field.get(object));
                }
                if ("authorDeptIndex".equals(field.getName()) && field.get(object) != null) {
                    tDocumentEntity.setAuthorDeptIndex((String) field.get(object));
                }
                if ("created".equals(field.getName()) && field.get(object) != null) {
                    tDocumentEntity.setCreated((Date) field.get(object));
                }
                if ("formid".equals(field.getName()) && field.get(object) != null) {
                    tDocumentEntity.setFormid((String) field.get(object));
                }
                if ("istmp".equals(field.getName()) && field.get(object) != null) {
                    tDocumentEntity.setIstmp((Boolean) field.get(object));
                }
                if ("versions".equals(field.getName()) && field.get(object) != null) {
                    tDocumentEntity.setVersions((Integer) field.get(object));
                }
                if ("sortid".equals(field.getName()) && field.get(object) != null) {
                    tDocumentEntity.setSortid((String) field.get(object));
                }
                if ("applicationid".equals(field.getName()) && field.get(object) != null) {
                    tDocumentEntity.setApplicationid((String) field.get(object));
                }
                if ("statelabel".equals(field.getName()) && field.get(object) != null) {
                    tDocumentEntity.setStatelabel((String) field.get(object));
                }
                if ("initiator".equals(field.getName()) && field.get(object) != null) {
                    tDocumentEntity.setInitiator((String) field.get(object));
                }
                if ("audituser".equals(field.getName()) && field.get(object) != null) {
                    tDocumentEntity.setAudituser((String) field.get(object));
                }
                if ("auditornames".equals(field.getName()) && field.get(object) != null) {
                    tDocumentEntity.setAuditornames((String) field.get(object));
                }
                if ("lastflowoperation".equals(field.getName()) && field.get(object) != null) {
                    tDocumentEntity.setLastflowoperation((String) field.get(object));
                }
                if ("parent".equals(field.getName()) && field.get(object) != null) {
                    tDocumentEntity.setParent((String) field.get(object));
                }
                if ("state".equals(field.getName()) && field.get(object) != null) {
                    tDocumentEntity.setState((String) field.get(object));
                }
                if ("stateint".equals(field.getName()) && field.get(object) != null) {
                    tDocumentEntity.setStateint((Integer) field.get(object));
                }
                if ("lastmodifier".equals(field.getName()) && field.get(object) != null) {
                    tDocumentEntity.setLastmodifier((String) field.get(object));
                }
                if ("domainid".equals(field.getName()) && field.get(object) != null) {
                    tDocumentEntity.setDomainid((String) field.get(object));
                }
                if ("auditorlist".equals(field.getName()) && field.get(object) != null) {
                    tDocumentEntity.setAuditorlist((String) field.get(object));
                }
                if ("statelabelinfo".equals(field.getName()) && field.get(object) != null) {
                    tDocumentEntity.setStatelabelinfo((String) field.get(object));
                }
                if ("prevauditnode".equals(field.getName()) && field.get(object) != null) {
                    tDocumentEntity.setPrevauditnode((String) field.get(object));
                }
                if ("prevaudituser".equals(field.getName()) && field.get(object) != null) {
                    tDocumentEntity.setPrevaudituser((String) field.get(object));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        Serializable id = getSession().save(object);
        tDocumentEntity.setId((String) id);
        tDocumentEntity.setMappingid((String) id);
        System.out.println(tDocumentEntity.getFormid());
        getSession().save(tDocumentEntity);
        return id;

    }

    public void update(T entity) {
        this.getSession().update(entity);
    }

    public void saveOrupdate(T entity) {
        this.getSession().saveOrUpdate(entity);
    }

    public void delete(T object) {
        Field[] ofields = object.getClass().getFields();
        Serializable id = null;
        for (Field field : ofields) {
            field.setAccessible(true);
            try {
                if ("ID".equals(field.getName())) {
                    id = (Serializable) field.get(object);
                    break;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        getSession().delete(object);
        getSession().delete(TDocumentEntity.class.getName(), id);

    }

    public void delete(Serializable id) {
        this.getSession().delete(this.findById(id));
    }

    public T findById(Serializable id) {
        return (T) this.getSession().get(this.clazz, id);
    }

    public List<T> findByHQL(final String hql, String... params) {
        Query query = this.getSession().createQuery(hql);
        for (int i = 0; params != null && i < params.length; i++) {
            query.setParameter(i, params[i]);
        }
        return query.list();
    }

    public List<T> findByHQL(final String hql, Object... params) {
        Query query = this.getSession().createQuery(hql);
        for (int i = 0; params != null && i < params.length; i++) {
            query.setParameter(i, params[i]);
        }
        return query.list();


//        List list = (List) getHibernateTemplate().executeWithNativeSession(
//                new HibernateCallback() {
//                    public Object doInHibernate(Session session)
//                            throws HibernateException {
//                        SQLQuery query = session
//                                .createSQLQuery(hql);
//                        return query.list();
//                    }
//                });

    }

    public List<T> findAll() {
        return this.getSession().createQuery("from " + clazz.getName()).list();
    }

}
