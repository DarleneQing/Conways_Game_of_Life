package test;

import model.Player;
import org.junit.jupiter.api.BeforeEach;

class PlayerTest {

    private Player playerUnderTest;

    @BeforeEach
    void setUp() {
        playerUnderTest = new Player("name", "symbol", "color") {
        };
    }
}
