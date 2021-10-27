package Pages;

import Exceptions.ParentException;
import Handler.Helpers;
import Objects.SearchObjects;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchPage {
    public List<WebElement> searchFor(String searchQuery) throws ParentException {
        Helpers.type(searchQuery,SearchObjects.searchField);
        Helpers.click(SearchObjects.searchEnter);
        List<WebElement> products = Helpers.findList(SearchObjects.productNames);
        List<String> searchResult = new ArrayList<>();
        List<WebElement> searchResultElement = new ArrayList<>();
        for(WebElement product: products) {
            String productName = product.getText();
            if(Helpers.checkEquality(productName,searchQuery)) {
                searchResult.add(productName);
                searchResultElement.add(product);
            }

        }
        return searchResultElement;
    }
}
