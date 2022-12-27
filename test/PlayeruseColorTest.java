package test;

import model.PlayeruseColor;
import org.junit.jupiter.api.BeforeEach;

class PlayeruseColorTest {

    private PlayeruseColor playeruseColorUnderTest;

    @BeforeEach
    void setUp() {
        playeruseColorUnderTest = new PlayeruseColor("name", "color");
    }
}
