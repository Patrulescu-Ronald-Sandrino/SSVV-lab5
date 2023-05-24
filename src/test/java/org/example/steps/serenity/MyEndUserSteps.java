package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.example.pages.MyDictionaryPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class MyEndUserSteps {

    MyDictionaryPage myDictionaryPage;

    @Step
    public void enters(String keyword) {
        myDictionaryPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        myDictionaryPage.lookup_terms();
    }

    @Step
    public void should_see_definition(String definition) {
        assertThat(myDictionaryPage.getDefinitions(), hasItem(containsString(definition)));
    }

    @Step
    public void should_see_resultTitle(String title) {
        assertThat(myDictionaryPage.getResultTitle(), containsString(title));
    }

    @Step
    public void is_the_home_page() {
        myDictionaryPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }
}