package pages;

import org.openqa.selenium.By;

public class CartPage {

    // Cart page elements
    public static final By CART_LIST = By.className("cart_list");
    public static final By CART_ITEM = By.className("cart_item");
    public static final By CART_QUANTITY = By.className("cart_quantity");

    // Cart item details
    public static final By INVENTORY_ITEM_NAME = By.className("inventory_item_name");
    public static final By INVENTORY_ITEM_PRICE = By.className("inventory_item_price");
    public static final By INVENTORY_ITEM_DESCRIPTION = By.className("inventory_item_desc");

    // Cart buttons
    public static final By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");
    public static final By CHECKOUT_BUTTON = By.id("checkout");

    // Remove buttons (specific items)
    public static final By REMOVE_BACKPACK = By.id("remove-sauce-labs-backpack");
    public static final By REMOVE_BIKE_LIGHT = By.id("remove-sauce-labs-bike-light");

    private CartPage() {
    }
}
