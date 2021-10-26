package Pages;

import java.util.ArrayList;
import java.util.List;

import DriverHandler.Helpers;
import Exceptions.ParentException;
import Objects.SearchObjects;


import org.openqa.selenium.WebElement;

public class SearchPage extends Helpers {


    public SearchPage() {
    }

    public List<WebElement> searchFor(String searchQuery) throws ParentException {
        type(searchQuery,SearchObjects.searchField);
        click(SearchObjects.searchEnter);
        List<WebElement> products = findList(SearchObjects.productNames);
        List<String> searchResult = new ArrayList<>();
        List<WebElement> searchResultElement = new ArrayList<>();
        for(WebElement product: products) {
            String productName = product.getText();
            if(checkEquality(productName,searchQuery)) {
                searchResult.add(productName);
                searchResultElement.add(product);
            }

        }
        return searchResultElement;
    }
}
