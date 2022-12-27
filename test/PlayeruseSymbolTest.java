package test;

import model.PlayeruseSymbol;
import org.junit.jupiter.api.BeforeEach;

class PlayeruseSymbolTest {

    private PlayeruseSymbol playeruseSymbolUnderTest;

    @BeforeEach
    void setUp() {
        playeruseSymbolUnderTest = new PlayeruseSymbol("name", "symbol");
    }
}
