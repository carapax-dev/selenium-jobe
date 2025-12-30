package pages;

import org.openqa.selenium.By;


public class ProductsPage {

    // Header elements
    public static final By APP_LOGO = By.className("app_logo");
    public static final By SHOPPING_CART_BADGE = By.className("shopping_cart_badge");
    public static final By SHOPPING_CART_LINK = By.className("shopping_cart_link");
    public static final By BURGER_MENU = By.id("react-burger-menu-btn");

    // Product list elements
    public static final By INVENTORY_CONTAINER = By.id("inventory_container");
    public static final By INVENTORY_ITEM = By.className("inventory_item");
    public static final By PRODUCT_SORT_CONTAINER = By.className("product_sort_container");

    // Product item elements (use these with indexes or specific product names)
    public static final By INVENTORY_ITEM_NAME = By.className("inventory_item_name");
    public static final By INVENTORY_ITEM_PRICE = By.className("inventory_item_price");
    public static final By INVENTORY_ITEM_DESCRIPTION = By.className("inventory_item_desc");

    // Add to cart buttons
    public static final By ADD_TO_CART_BACKPACK = By.id("add-to-cart-sauce-labs-backpack");
    public static final By ADD_TO_CART_BIKE_LIGHT = By.id("add-to-cart-sauce-labs-bike-light");
    public static final By ADD_TO_CART_BOLT_TSHIRT = By.id("add-to-cart-sauce-labs-bolt-t-shirt");

    // Remove from cart buttons
    public static final By REMOVE_BACKPACK = By.id("remove-sauce-labs-backpack");
    public static final By REMOVE_BIKE_LIGHT = By.id("remove-sauce-labs-bike-light");

    // Menu items
    public static final By LOGOUT_LINK = By.id("logout_sidebar_link");
    public static final By RESET_APP_STATE = By.id("reset_sidebar_link");
    public static final By ALL_ITEMS_LINK = By.id("inventory_sidebar_link");

    private ProductsPage() {
    }
}
