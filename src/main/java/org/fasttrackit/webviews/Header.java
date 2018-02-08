package org.fasttrackit.webviews;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header {
    //ctrl p pentru sugestii
    @FindBy (id = "search")
    private WebElement searchField;

    //selectlanguage sau language drop down list
    @FindBy (id= "select-language")
    private WebElement languageDropDownList;

    public void search(String keyword) {
        searchField.sendKeys(keyword + Keys.ENTER);
        System.out.println("pressed enter in search field");
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getLanguageDropDownList() {
        return languageDropDownList;
    }
}
