package junit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author cuijingbo
 * @date 2021/1/25 22:39
 */
public class TestAssertion {
    @Test
    void assertion(){
        assertAll("demo asstions",
                () -> {
                    System.out.println("测试一下");assertEquals(1,2);
                    }, //括起来后，可以添加步骤，进行断言
                () -> assertEquals(2,2),
                () -> assertEquals(2,5));
    }

}


