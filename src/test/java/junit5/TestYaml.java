package junit5;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author cuijingbo
 * @date 2021/1/26 14:25
 */
public class TestYaml {


    @ParameterizedTest
    @MethodSource
    public void  testddt(String raw){
        assertTrue(raw.length()>3);
    }

    static Stream<String>testddt(){
        return Stream.of("1","2","123","1234");
    }

    //yaml文件，提供数据
    @ParameterizedTest()
    @MethodSource
    public  void testDDTFromYaml(User user) {
        assertTrue(user.name.length() > 3);

    }
    static List<User> testDDTFromYaml() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        TypeReference typeReference = new TypeReference<List<User>>() {
        };
        List<User> users = mapper.readValue(
                TestYaml.class.getResourceAsStream("/user.yaml"), //填写yaml文件地址
                typeReference
        );
        System.out.println(typeReference);
        System.out.println(users);
        return users;
    }


    //json文件读取
    @ParameterizedTest()
    @MethodSource
    public void testDDTFromJson(User user) {
        assertTrue(user.name.length() > 2);

    }

    static List<User> testDDTFromJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference typeReference = new TypeReference<List<User>>() {
        };
        List<User> users = mapper.readValue(
                TestYaml.class.getResourceAsStream("/user.json"),
                typeReference
        );
        return users;
    }




}
