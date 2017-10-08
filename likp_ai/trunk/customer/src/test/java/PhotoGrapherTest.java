import com.google.gson.Gson;
import com.lkp.service.TLkPhotograoherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by chuan on 2016/11/14.
 */
/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})*/
public class PhotoGrapherTest {
   /* @Autowired*/
    TLkPhotograoherService photograoherService;

    @Test
    public void t(){
        //System.out.println(new Gson().toJson(photograoherService.getPhotographerByOpenid("olp-hvxdut0amfHZpWOGioqKQjxw")));
    }
}
