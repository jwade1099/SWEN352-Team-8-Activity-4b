package edu.rit.swen253.page.tiger;

import java.util.List;

import org.openqa.selenium.By;

import edu.rit.swen253.page.AbstractPage;
import edu.rit.swen253.utils.DomElement;

public class Sidebar extends AbstractPage{
    DomElement waitElement;

    public Sidebar(){
        super();
    }

    public void clickHamburger(){
        DomElement hamburger = findOnPage(By.cssSelector(".mat-focus-indicator.row.visible-lg.mat-icon-button.mat-button-base"));
        hamburger.click();
    }

    public void clickClassSearch(){
        List<DomElement> sidebarItems = findAllOnPage(By.className("appSidenavExpandedText"));
        sidebarItems.get(1).click();
    }

    public void clickHoursAndLocations(){
        List<DomElement> sidebarItems = findAllOnPage(By.className("appSidenavExpandedText"));
        sidebarItems.get(4).click();
    }

    public void setWaitElement(String domClass){
        this.waitElement = findOnPage(By.className(domClass));
    }

    public DomElement getWaitElement(){
        return this.waitElement;
    }
}
