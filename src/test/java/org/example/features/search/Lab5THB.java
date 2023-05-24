package org.example.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import org.example.steps.serenity.MyEndUserSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class Lab5THB {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public MyEndUserSteps anna;

    @Test
    public void searching_by_keyword_mylittlepony_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("mylittlepony");
        anna.should_see_resultTitle("Nici un rezultat");
    }

    @Test
    public void searching_by_keyword_newyork_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("new york");
        anna.should_see_resultTitle("6 rezultate in Destinatii");
    }
} 