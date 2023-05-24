package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("https://www.eximtur.ro/")
public class MyDictionaryPage extends PageObject {

    @FindBy(name="q")
    private WebElementFacade searchTerms;

    public void enter_keywords(String keyword) {
        searchTerms.type(keyword);
    }

    public void lookup_terms() {
        System.out.println("searchTerms contine textul: " + searchTerms.getValue());
        for (int i = 0; i < 50; i++) {
            searchTerms.sendKeys(Keys.ENTER);
        }
        System.out.println("Am apasat ENTER");
    }

    public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.tagName("ol"));
        return definitionList.findElements(By.tagName("li")).stream()
                .map( element -> element.getText() )
                .collect(Collectors.toList());
    }

    public String getResultTitle() {
        return find(By.cssSelector("div.panel-container > div > h4")).getText();
    }
}