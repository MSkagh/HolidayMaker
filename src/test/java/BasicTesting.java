import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class BasicTesting {

    @Test
    void hello(){
        String hello = "hello";
        Assertions.assertEquals(hello, "hello");
    }

}


