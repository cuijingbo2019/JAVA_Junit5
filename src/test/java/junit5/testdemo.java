package junit5;


import org.junit.jupiter.api.*;

/**
 * @author cuijingbo
 * @date 2021/1/25 17:55
 */
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
//order 方法，跟进order 后边的value值，从小到大执行测试用例
public class testdemo {
    @Test
    @Order(3)
    //@Disabled
    public  void  testone(){
        System.out.println("disabled testone");
    }
    @Test //测试用例
    @Order(2)
    //@displayname 重新指定类名
    @DisplayName(value = "displayname testafterall")
    public  void  testtwo(){
        System.out.println("disabled testtwo");
    }

    @BeforeAll  //在方法前执行
    public static void beforeAll(){
        System.out.println("beforeAll");
    }
    @BeforeEach //在测试方法前执行
    public void beforeEach(){
        System.out.println("beforeEach");
    }
    @RepeatedTest(value = 1) //执行的次数，=1就是执行1次
    @Test
    @Order(1)
    public void testCore(){
        System.out.println("testCore");
    }
    @AfterEach //在测试方法后每次执行
    public void afterEach(){
        System.out.println("afterEach");
    }


    @AfterAll //在方法后执行
    public static void afterAll(){
        System.out.println("afterAll");
    }
}
