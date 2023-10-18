import CLASSES.Package;
import databaseConnection.Database;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class BasicTesting {

    protected Database db;

    @BeforeEach
    void setUp(){
        this.db = new Database();
    }

    @Test
    void getAllPackages(){

        for (int i = 0; i < db.getAllPackages(). size(); i++){
            System.out.println(db.getAllPackages().get(i).toString());
        }
        Assertions.assertEquals(db.getAllPackages().get(0).getDestination().getName(), "Biryulëvo Zapadnoye");

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


