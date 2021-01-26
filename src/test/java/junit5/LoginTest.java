package junit5;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author cuijingbo
 * @date 2021/1/25 19:13
 */
public class LoginTest {
    private static HashMap<String,Object>dataMap=new HashMap<String,Object>();

    @Test
    void  loginTest(){
        dataMap.put("login","登录成功");
        System.out.println("登录成功");
    }

    @Nested //倒序执行，从下向上执行
    class PayTest{
        @Test
        void payTest(){
           if (null !=dataMap.get("buy")){
               System.out.println("正在支付，请等待");
           }else {
               System.out.println("你还未购买课程，请等待");
           }
        }
    }



    @Nested
    class BuyTest{
        @Test
        void  buyTest(){
            if (dataMap.get("login").equals("登录成功")){
                System.out.println("登录成功，可以购买东西");
                dataMap.put("buy","购买课程成功");
            }else {
                System.out.println("登录失败，请重新登录");
            }
        }
    }
}
