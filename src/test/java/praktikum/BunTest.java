package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun;

    @Before
    public void newBun() {
        bun = new Bun("Black bun", 35.00f);
    }

    @Test
    public void getName() {
        String expected = "Black bun";
        String actual = bun.getName();
        assertEquals("Не правильное название булочки", expected, actual);
    }

    @Test
    public void getPrice() {
        float expected = 35.00f;
        float actual = bun.getPrice();
        assertEquals("Не правильная стоимость булочки", expected, actual, 0.001f);
    }

}
