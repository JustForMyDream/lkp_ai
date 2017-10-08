package ServiceTest;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lkp.controller.exclusionStrategys.ProductWithoutShowPicExclusionStrategy;
import com.lkp.dao.TlkProductshowEntityDao;
import com.lkp.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 */
/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:applicationContext.xml"})*/
public class UserServiceTest {
    //@Autowired
            ProductService productService;

    //@Autowired
    TlkProductshowEntityDao tlkProductshowEntityDao;
 /*   @Autowired*/
    YingjiService yingjiService;
    /*@Autowired*/
    UserService userService;
//    @Autowired
    OrderService orderService;
//    @Autowired
    HomePageService homePageService;

 //   @Autowired
    TLkPhotograoherService tLkPhotograoherService;
 //  @Autowired
    EventTemplateService eventTemplateService;
 //   @Autowired
    XXJLService xxjlService;

    Gson gson = new GsonBuilder().addSerializationExclusionStrategy(new ExclusionStrategy() {
        //按照字段名排除
        public boolean shouldSkipField(FieldAttributes fieldAttributes) {
            return "tlkProductEntity".equals(fieldAttributes.getName()) ||
                    "tlkProductshowEntity".equals(fieldAttributes.getName()) ||
                    "tlkUserEntity".equals(fieldAttributes.getName()) ||
                    "tlkYingjipicEntities".equals(fieldAttributes.getName()) ||
                    "tlkOrderEntity".equals(fieldAttributes.getName()) ||
                    "itemUserid".equals(fieldAttributes.getName());
        }

        //按照类排除
        public boolean shouldSkipClass(Class<?> aClass) {
            return false;
        }
    }).create();

    //@Test
    public void testgetUserById() {
        //System.out.println(gson.toJson(userService.getUserById("ff808181583ccd4901583ccd4e6d0000")));
    }

    //@Test
    public void testgetUserByOpenid() {

        //System.out.println(gson.toJson(userService.getUserByOpenid("1111")));
    }

    //@Test
    public void addUserByUserService() {
      //  String id = null;
      //  TlkWechatuserEntity tlkWechatuserEntity = new TlkWechatuserEntity();
      //  tlkWechatuserEntity.setOpenid("1111");
      //  id = (String) userService.addUserByWeChatInfo(tlkWechatuserEntity);
     //   System.out.println(id);
    }

       // @Test
    public void t() {
            Gson gson = new GsonBuilder()
                    .addSerializationExclusionStrategy(new ProductWithoutShowPicExclusionStrategy())
                    .create();
            System.out.println(gson.toJson(tlkProductshowEntityDao.findById("297e9e795a179286015a17aa86b00002")));
    }

   /* @Test*/
    public void test() {
      //  TlkUserEntity tlkUserEntity = userService.getUserById("297e9e79583dc67e01583dd2da5e000b");
      //  System.out.println(tlkUserEntity);
    }

//    @Test
    public void getImgById() {
     //   System.out.println(gson.toJson(orderService.getOrdersByUserBH("43405816-f73a-447e-9da0-4132834e62be")));
    }

//    @Test
    public void getOrderImgList() {
        //Gson gson = new GsonBuilder()
           //     .addSerializationExclusionStrategy(new OrderAlbumExclusionStrategy())
             //   .create();
//        orderService.getOrderImgList("43405816-f73a-447e-9da0-4132834e62be");
        //System.out.println(gson.toJson(orderService.getOrderImgList("43405816-f73a-447e-9da0-4132834e62be")));
    }
  //  @Test
    public void getZdById(){
       // System.out.println(gson.toJson(eventTemplateService.findHdbmzdByHdbh("11e6-cbdf-66a73b59-b281-d9cfbd226387")));
    }
/*    @Test
    public void yingjisavetest(){
        TlkYingjiEntity tlkYingjiEntity = new TlkYingjiEntity();
        Set<TlkYingjipicEntity> yingjipicEntities = new HashSet<TlkYingjipicEntity>();
        for(int i=0;i<10;i++){
            TlkYingjipicEntity tlkYingjipicEntity = new TlkYingjipicEntity();
            tlkYingjipicEntity.setItemOrder(String.valueOf(i));
            tlkYingjipicEntity.setItemImgurl("13243453645");
            tlkYingjipicEntity.setTlkYingjiEntity(tlkYingjiEntity);
            yingjipicEntities.add(tlkYingjipicEntity)   ;
        }
        tlkYingjiEntity.setTlkYingjipicEntities(yingjipicEntities);
        yingjiService.cerateYingji(tlkYingjiEntity);
    }*/
/*    @Test
    public void yingjiquerybyorderid(){
        System.out.println(gson.toJson(yingjiService.getYingjiByItemOrderId("20161125201658hl")));
    }*/

//    @Test
    public void testaaa(){
       /* String id = "297e9e795991b86c01599274b9bc0000";
        String prepay_id = orderService.create_prepay_id_by_id(id, "localhost");
//        String prepay_id = orderService.create_prepay_id_by_id(id, request.getRemoteHost());
        System.out.println(prepay_id);*/
    }
    //@Test
    public void testHomePageService(){
        //System.out.println(new Gson().toJson(eventTemplateService.findByUserOpenidandDate("297e9e7959126f060159160f6bae003f",new Date())));
    }
   // @Test
    public void testTLkPhotograoherService(){
       // System.out.println(productService.getShowBySySId("11e6-d94a-5413ce44-aff6-6ff166f31966").size());
    }


//    @Test
    public void testMSg(){
        // System.out.println(productService.getShowBySySId("11e6-d94a-5413ce44-aff6-6ff166f31966").size());

        System.out.println("未读个数"+new Gson().toJson(xxjlService.getWeiDuMsg("0cd654d1-7ec7-4644-8a33-2c7d9f3f1e10")));

    }
}
