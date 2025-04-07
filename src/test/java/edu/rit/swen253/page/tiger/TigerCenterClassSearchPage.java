package edu.rit.swen253.page.tiger;

import edu.rit.swen253.page.AbstractAngularPage;
import edu.rit.swen253.test.classSearch.TCClassSearchResult;
import edu.rit.swen253.utils.DomElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TigerCenterClassSearchPage extends AbstractAngularPage  {
    public TigerCenterClassSearchPage() {
        super("class-search");
    }

    public List<TCClassSearchResult> submitSearch(CLASS_TERM term, String query) {
        DomElement selector = angularView.findChildBy(By.cssSelector("select[name=termSelector]"));
        selector.click();

        Select termSelector = new Select(selector.getWebElement());
        termSelector.selectByVisibleText(term.getTermText());

        DomElement searchField = angularView.findChildBy(By.cssSelector("input[type=search]"));
        searchField.click();
        searchField.clear();
        searchField.sendKeys(query);
        searchField.sendKeys(Keys.ENTER);

        List<TCClassSearchResult> elements = angularView.findChildrenBy(By.tagName("app-class-search-row")).stream()
                .map(TCClassSearchResult::new).toList();
        return elements;
    }
}
