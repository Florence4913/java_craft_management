import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class AuthenticationTest {
    private Authentication au;

    @BeforeEach
    public void setUp(){
        User testUser = new User("testUser","testPassword"){
            @Override
            public String verifyLogin(String loginName, String loginPassword) {
                return super.verifyLogin(loginName, loginPassword);
            }
        };
        
    }

    @Test
    public void testNullUserLogin() {
        assertThrows(NullPointerException.class, () -> {
            au.loginStatus("user", "pass", null);
        }, "User cannot be null");
    }
}
