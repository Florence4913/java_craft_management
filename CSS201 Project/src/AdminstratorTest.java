import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AdminstratorTest {
    private Adminstrator ad;

    @BeforeEach
    void setUp(){
        Adminstrator ad = new Adminstrator("Bob", "pass246");
    }

    @Test
    public void verifyAdminTest(){
        Adminstrator ad = new Adminstrator("Bob", "pass246");
        assertEquals("Admin Login Success",ad.verifyLogin("Bob", "pass246"));
        assertEquals("Unsuccessful Admin Login!", ad.verifyLogin("Wrong Username", "Wrong password"));
    }

}

