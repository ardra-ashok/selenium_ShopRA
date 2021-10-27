package Objects;


import org.openqa.selenium.By;

public class SearchObjects {
    public static By searchField = By.id("search_query_top");
    public static By searchEnter = By.name("submit_search");
    public static By productNames = By.xpath("//*/div[@class='right-block']//*/a[@class='product-name']");
}
