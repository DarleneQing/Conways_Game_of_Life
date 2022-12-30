import main.Main;
import org.junit.jupiter.api.Test;
import main.Game.Game;
import main.exceptions.InvalidAttack;
import main.exceptions.InvalidNewCell;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    void test() {
        assertEquals(1, Main.test());
    }

}

