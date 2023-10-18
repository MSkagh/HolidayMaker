import databaseConnection.Database;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class BasicTesting {

    protected Database db;

    @BeforeEach
    void setUp(){
        db = new Database();
    }

    @Test
    void getAllPackages(){
    }
    @Test
    void checkConnection(){
        Assertions.assertNotNull(db);
    }
    @Test
    void hello(){
        String hello = "hello";
        Assertions.assertEquals(hello, "hello");
    }

}


