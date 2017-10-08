package Daotest;


import com.lkp.dao.TLkPhotographerDao;
import com.lkp.entity.vo.SelectXJEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 *
 */
/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:applicationContext.xml"})
@Transactional*/
public class ProductDaoTest {
  /* *//* @Autowired*//*
    ProductDao productDao;

*/
 /*   @Autowired*/
    TLkPhotographerDao tLkPhotographerDao;
    /*    @Autowired*//*
    TlkProductmainEntityDao tlkProductmainEntityDao;
    Gson gson = new Gson();
    Gson gson1 = new GsonBuilder().addSerializationExclusionStrategy(new ExclusionStrategy() {
        //按照字段名排除
        public boolean shouldSkipField(FieldAttributes fieldAttributes) {
            return "tlkProductEntity".equals(fieldAttributes.getName())||"tlkProductshowEntity".equals(fieldAttributes.getName());
        }

        //按照类排除
        public boolean shouldSkipClass(Class<?> aClass) {
            return false;
        }
    }).create();

    //@Test
    public void getProducts() {
        List<TlkProductEntity> l = productDao.getProducts(1, 4);
        System.out.println(l.size());
        System.out.println(gson1.toJson(l.get(0)));
    }

    //@Test
    public void save(){
        TlkProductEntity tlkProductEntity = new TlkProductEntity();
        tlkProductEntity.setId("111");
        System.out.println(productDao.save(tlkProductEntity));
    }
    @Test
    public void t(){
*//*        List list = userCollectionEntityDao.findByHQL("from  "+ TlkUserCollectionEntity.class.getName() + " c " );
        System.out.println(gson1.toJson(list));*//*
    }*/

    /*@Test*/
    public void SysInfor() {
        List<SelectXJEntity> list = tLkPhotographerDao.FingTwoSql();
        System.out.println(list);
    }
}
