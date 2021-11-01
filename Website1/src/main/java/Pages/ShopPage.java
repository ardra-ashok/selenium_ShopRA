package Pages;


import Exceptions.ParentException;
import Handler.Helpers;
import Objects.SearchObjects;
import Objects.ShopObjects;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class ShopPage {

    public void shop(String[] itemsNeeded) throws ParentException {
    try{
        SearchPage search = new SearchPage();
       // Helpers.click(ShopObjects.linkTextWomen);
        List<String> itemsNeededList = Arrays.asList(itemsNeeded);
        for(String itemNeeded: itemsNeededList) {
            List<WebElement> products = search.searchFor(itemNeeded);
            for(WebElement product:products){
                String productName = product.getText();
                if(Helpers.checkEquality(productName,itemNeeded)) {
                    String availability = Helpers.getTextLabel(ShopObjects.availabilityStatus);
                    if(Helpers.checkEquality(availability,ShopObjects.availableQuery)) {

                        Helpers.JsExecutorClick(ShopObjects.viewMoreButton);
                        Helpers.click(ShopObjects.plusButton);
                        Helpers.click(ShopObjects.plusButton);
                        Helpers.click(ShopObjects.plusButton);
                        Helpers.click(ShopObjects.minusButton);
                        Helpers.selectDropDown(ShopObjects.selectSizeId,"M");
                        Helpers.click(ShopObjects.addToCartButton);
                        Helpers.eWaitForVisibility(ShopObjects.continueButton,20);
                        Helpers.click(ShopObjects.continueButton);
                        Helpers.clear(SearchObjects.searchField);
                    }
                }

            }
        }

    }
    catch (ParentException e){
        e.log();
    }


    }
}
