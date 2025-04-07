package edu.rit.swen253.test.classSearch;

import edu.rit.swen253.utils.DomElement;
import org.openqa.selenium.By;

public class TCClassSearchResult {
    private final DomElement element;
    public TCClassSearchResult(DomElement searchRowElement) {
        this.element = searchRowElement;
    }
    public String getCourseDisplayName() {
        return element.findChildrenBy(By.className("classSearchResultsDisplayName")).getFirst().getText();
    }

    public String getCourseCodeAndSection() {
        return element.findChildrenBy(By.className("classSearchResultsDisplayName")).getLast().getText();
    }
}
