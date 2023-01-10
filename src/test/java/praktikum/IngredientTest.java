package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    IngredientType ingredientType;
    String name;
    float price;

    public IngredientTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тип ингредиента = {0}, Название ингредиента ={1}, Цена ингредиента ={2}")
    public static Object[][] getIngredientType() {
        return new Object[][]{
                {SAUCE, "spicy sauce", 45.00f},
                {FILLING, "beef patty", 120.00f},
        };
    }
    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        String expected = name;
        String actual = ingredient.getName();
        assertEquals("Не правильное название ингредиента",expected, actual);
    }
    @Test
    public void getPrice() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        float expected = price;
        float actual = ingredient.getPrice();
        assertEquals("Не правильная цена ингредиента",expected, actual, 0.001f);
    }
    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        IngredientType expected = ingredientType;
        IngredientType actual = ingredient.getType();
        assertEquals("Не правильный тип ингредиента",expected, actual);
    }
}
