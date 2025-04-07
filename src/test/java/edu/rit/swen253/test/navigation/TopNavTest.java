package edu.rit.swen253.test.navigation;

import static edu.rit.swen253.utils.BrowserType.FIREFOX;
import static edu.rit.swen253.utils.BrowserType.onBrowser;
import static edu.rit.swen253.utils.TimingUtils.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import edu.rit.swen253.page.SimplePage;
import edu.rit.swen253.page.tiger.TopNav;
import edu.rit.swen253.test.AbstractWebTest;

class TopNavTest extends AbstractWebTest{
    @Test
    @Order(1)
    @DisplayName("Scenario #4: Navigate to the RIT Home page")
    void scenario4(){
        TopNav topnav = navigateToPage("https://tigercenter.rit.edu/tigerCenterApp/api/gpa-calc", TopNav::new);
        assertNotNull(topnav);
        topnav.clickHome();
        SimplePage page = assertNewWindowAndSwitch(SimplePage::new);
        if (onBrowser(FIREFOX)) {
            sleep(1);
        }
        assertEquals("https://www.rit.edu/", page.getURL());
    }
}
