import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CraftTest {
    @Test
    public void testPriceRange(){
        Crafts lowPrice = new Crafts("Low", 1, 10, "test","test");
        Crafts mediumPrice = new Crafts("Medium", 1, 70, "test","test");
        Crafts highPrice = new Crafts("High", 1, 150, "test","test");
    
        assertEquals("Low", lowPrice.getPriceRange());
        assertEquals("Medium", mediumPrice.getPriceRange());
        assertEquals("High", highPrice.getPriceRange());
    }
}

