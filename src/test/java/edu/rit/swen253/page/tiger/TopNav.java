package edu.rit.swen253.page.tiger;

import java.util.List;

import org.openqa.selenium.By;

import edu.rit.swen253.page.AbstractPage;
import edu.rit.swen253.utils.DomElement;

public class TopNav extends AbstractPage{
    public TopNav(){
        super();
    }

    public void clickHome(){
        DomElement top = findOnPage(By.className("headerLinks"));
        List<DomElement> links = top.findChildrenBy(By.tagName("a"));
        links.get(3).click();
    }
}
