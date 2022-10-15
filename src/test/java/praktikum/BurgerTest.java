package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest extends CreateBurger{
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void burgerAddIngredientsTest(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void burgerRemoveIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void burgerMoveIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 150));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        burger.moveIngredient(0, 1);
        assertEquals("cutlet", burger.ingredients.get(0).name);

    }

    @Test
    public void burgerGetPriceTest(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float price = 200f;
        Mockito.when(bun.getPrice()).thenReturn(price);
        Mockito.when(ingredient.getPrice()).thenReturn(price);
        assertEquals(price * 2 + price, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest(){
        createBurgerWithAllAction();
        String actualReceipt = burger.getReceipt();
        assertEquals(ExpectedReceiptsConstant.EXPECTED_RECEIPT, actualReceipt);
    }
}