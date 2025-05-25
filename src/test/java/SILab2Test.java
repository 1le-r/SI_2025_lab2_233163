
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    @Test
    void testEveryStatement() {
        // Null item list
        RuntimeException ex1 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, "1234567890123456"));
        assertTrue(ex1.getMessage().contains("allItems list can't be null!"));

        // Invalid item name
        Item invalidItem = new Item(null, 1, 100, 0);
        List<Item> items1 = List.of(invalidItem);
        RuntimeException ex2 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items1, "1234567890123456"));
        assertTrue(ex2.getMessage().contains("Invalid item!"));

        // Valid item with price > 300
        Item expensiveItem = new Item("TV", 1, 400, 0);
        double result1 = SILab2.checkCart(List.of(expensiveItem), "1234567890123456");
        assertEquals(370.0, result1);

        // Item with discount
        Item discounted = new Item("Shoes", 2, 100, 0.2);
        double result2 = SILab2.checkCart(List.of(discounted), "1234567890123456");
        assertEquals(160.0, result2);

        // Invalid card number length
        Item valid = new Item("Book", 1, 50, 0);
        RuntimeException ex3 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(valid), "1234"));
        assertTrue(ex3.getMessage().contains("Invalid card number!"));

        // Invalid character in card number
        RuntimeException ex4 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(valid), "1234abc567891234"));
        assertTrue(ex4.getMessage().contains("Invalid character in card number!"));
    }

    @Test
    void testMultipleCondition() {
        Item onlyPrice = new Item("A", 1, 350, 0);
        Item onlyDiscount = new Item("B", 1, 200, 0.1);
        Item onlyQuantity = new Item("C", 11, 100, 0);
        Item none = new Item("D", 1, 100, 0);

        assertEquals(320.0, SILab2.checkCart(List.of(onlyPrice), "1234567890123456")); // T || F || F
        assertEquals(150.0, SILab2.checkCart(List.of(onlyDiscount), "1234567890123456")); // F || T || F
        assertEquals(1070.0, SILab2.checkCart(List.of(onlyQuantity), "1234567890123456")); // F || F || T
        assertEquals(100.0, SILab2.checkCart(List.of(none), "1234567890123456")); // F || F || F
    }
}
