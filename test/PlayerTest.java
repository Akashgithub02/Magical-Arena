import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    public void testReduceHealth() {
        Player player = new Player(50, 5, 10);
        player.reduceHealth(20);
        assertEquals(30, player.getHealth());
    }

    @Test
    public void testIsAlive() {
        Player player = new Player(50, 5, 10);
        player.reduceHealth(50);
        assertFalse(player.isAlive());
    }
}
