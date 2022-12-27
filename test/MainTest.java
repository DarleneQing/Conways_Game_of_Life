package test;

import exceptions.InvalidAttack;
import exceptions.InvalidNewCell;
import model.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MainTest {

    @Test
    void testMain() throws Exception {
        // Setup
        // Run the test
        Main.main(new String[]{"args"});

        // Verify the results
    }

    @Test
    void testMain_ThrowsInvalidAttack() {
        // Setup
        // Run the test
        assertThrows(InvalidAttack.class, () -> Main.main(new String[]{"args"}));
    }

    @Test
    void testMain_ThrowsInvalidNewCell() {
        // Setup
        // Run the test
        assertThrows(InvalidNewCell.class, () -> Main.main(new String[]{"args"}));
    }
}
