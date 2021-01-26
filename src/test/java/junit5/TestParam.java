package junit5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * @author cuijingbo
 * @date 2021/1/26 11:23
 */
public class TestParam {
    @ParameterizedTest
    @ValueSource(ints={1,2,3,4,5})
    void testWithValueSource(int argument){
        assertTrue(argument>0 && argument<5);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings ={"s","aa","\t","\n"})
    void nullEmptyAndBlankStrings(String text){
        assertTrue(text==null || text.trim().isEmpty());//
    }

    @ParameterizedTest
    @EnumSource(ChronoUnit.class)
    void testwithEnumSource(TemporalUnit unit){
        assertNotNull(unit);
    }


    @ParameterizedTest
    @MethodSource("stringProvider")
    void testMethodSource(String argument){
        assertNotNull(argument);
    }
    static Stream<String> stringProvider(){
        return Stream.of("apple","two","three");
    }





    @ParameterizedTest
    @MethodSource
    void testWithDefaultLocalMethodSource(String argument) {
        assertNotNull(argument);
    }

    static Stream<String> testWithDefaultLocalMethodSource() {
        return Stream.of("apple", "banana", "orange");
    }
    @ParameterizedTest
    @MethodSource("stringintAndListProvider")
    void testintAndList(String str, int num, List<String> list){
        assertEquals(5,str.length());
        assertTrue(num>1 && num<2);
        assertEquals(2,list.size());
    }
    static Stream<Arguments> stringintAndListProvider(){
        return Stream.of(
                arguments("apple",1, Arrays.asList("a","b")),
                arguments("apple",1, Arrays.asList("a","b"))
        );
    }


    @ParameterizedTest
    @CsvSource(
            {
             "apple,1",
             "b,2",
             "c,3"
            }
    )
    void testWithCsvSource(String fruit,int rank){
        assertNotNull(fruit);
        assertEquals(2,rank);
    }

    //通过读取Csv文件，获取表格中的值
    @ParameterizedTest
    @CsvFileSource(resources = "/two-column.csv",numLinesToSkip = 1)
    void testWithCsvFileSource(String contry,int reference){
        assertNotNull(contry);
        assertNotEquals(0,reference);
    }

}
