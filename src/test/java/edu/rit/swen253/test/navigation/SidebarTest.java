package edu.rit.swen253.test.navigation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import edu.rit.swen253.page.SimplePage;
import edu.rit.swen253.page.tiger.Sidebar;
import edu.rit.swen253.test.AbstractWebTest;

class SidebarTest extends AbstractWebTest{
    @Test
    @Order(1)
    @DisplayName("Scenario #2: Navigate to the Class Search page")
    void scenario2(){
        Sidebar sidebar = navigateToPage("https://tigercenter.rit.edu/tigerCenterApp/api/hours-and-locations", Sidebar::new);
        assertNotNull(sidebar);
        sidebar.setWaitElement("hoursAndLocationsTextTitle");
        sidebar.clickHamburger();
        sidebar.clickClassSearch();
        sidebar.getWaitElement().waitUntilGone();
        SimplePage page = new SimplePage();
        assertEquals("https://tigercenter.rit.edu/tigerCenterApp/api/class-search", page.getURL());
    }

    @Test
    @Order(2)
    @DisplayName("Scenario #5: Navigate to the Hours and Locations page")
    void scenario5(){
        Sidebar sidebar = navigateToPage("https://tigercenter.rit.edu/tigerCenterApp/api/gpa-calc", Sidebar::new);
        assertNotNull(sidebar);
        sidebar.setWaitElement("gpaCalcTextTitle");
        sidebar.clickHamburger();
        sidebar.clickHoursAndLocations();
        sidebar.getWaitElement().waitUntilGone();
        SimplePage page = new SimplePage();
        assertEquals("https://tigercenter.rit.edu/tigerCenterApp/api/hours-and-locations", page.getURL());
    }
}
