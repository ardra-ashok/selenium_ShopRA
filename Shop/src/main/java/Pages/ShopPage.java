package Pages;


import DriverHandler.Helpers;
import Exceptions.ParentException;
import Objects.SearchObjects;
import Objects.ShopObjects;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class ShopPage extends Helpers {


    public ShopPage() {
    }

    public void shop(String[] itemsNeeded) throws ParentException {

        SearchPage search = new SearchPage();
        click(ShopObjects.linkTextWomen);
        List<String> itemsNeededList = Arrays.asList(itemsNeeded);
        for(String itemNeeded: itemsNeededList) {
            List<WebElement> products = search.searchFor(itemNeeded);
            for(WebElement product:products){
                String productName = product.getText();
                if(checkEquality(productName,itemNeeded)) {
                    String availability = getTextLabel(ShopObjects.availabilityStatus);
                    if(checkEquality(availability,ShopObjects.availableQuery)) {
                        JsExecutorClick(ShopObjects.viewMoreButton);
                        click(ShopObjects.plusButton);
                        click(ShopObjects.plusButton);
                        click(ShopObjects.plusButton);
                        click(ShopObjects.minusButton);
                        selectDropDown(ShopObjects.selectSizeId,"M");
                        click(ShopObjects.addToCartButton);
                        eWaitForVisibility(ShopObjects.continueButton,20);
                        click(ShopObjects.continueButton);
                        clear(SearchObjects.searchField);
                    }
                }

            }
        }

    }
}
