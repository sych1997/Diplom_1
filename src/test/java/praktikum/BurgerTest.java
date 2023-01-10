package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;

    @Before
    public void createBurger() {
        burger = new Burger();
    }
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient1;

    @Test
    public void setBuns() {
        burger.setBuns(bun);
        Bun expected = bun;
        Bun actual = burger.bun;
        assertEquals(expected, actual);
    }
    @Test
    public void addIngredient() {
        burger.addIngredient(ingredient);
        boolean expected = true;
        boolean actual = burger.ingredients.size() != 0;
        assertEquals("Ингредиент не добавился",expected, actual);
    }
    @Test
    public void removeIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        boolean expected = true;
        boolean actual = burger.ingredients.size() == 0;
        assertEquals("Ингредиент не удалился",expected, actual);
    }
    @Test
    public void moveIngredient() {
        List<Ingredient> expected = List.of(ingredient1, ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.moveIngredient(1, 0);
        List<Ingredient> actual = burger.ingredients;
        assertEquals("Ингредиенты не поменялись местами",expected, actual);
    }
    @Test
    public void getPrice() {
        Mockito.when(bun.getPrice()).thenReturn(35.00f);
        Mockito.when(ingredient.getPrice()).thenReturn(120.00f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float expected = 190.00f;
        float actual = burger.getPrice();
        assertEquals("Не правильно рассчиталась цена бургера",expected, actual, 0.001f);
    }
    @Test
    public void getReceipt() {
        String expected = String.format("(==== Black bun ====)%n" +
                "= filling котлета =%n" +
                "(==== Black bun ====)%n" +
                "%nPrice: 190,000000%n");
        Mockito.when(bun.getName()).thenReturn("Black bun");
        Mockito.when(ingredient.getName()).thenReturn("котлета");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(bun.getPrice()).thenReturn(35.00f);
        Mockito.when(ingredient.getPrice()).thenReturn(120.00f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String actual = burger.getReceipt();
        assertEquals("Не правильный состав или цена бургера",expected, actual);
    }
}
