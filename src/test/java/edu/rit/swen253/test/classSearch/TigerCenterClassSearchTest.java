package edu.rit.swen253.test.classSearch;

import edu.rit.swen253.page.SimplePage;
import edu.rit.swen253.page.tiger.CLASS_TERM;
import edu.rit.swen253.page.tiger.TigerCenterClassSearchPage;
import edu.rit.swen253.page.tiger.TigerCenterHomePage;
import edu.rit.swen253.test.AbstractWebTest;
import edu.rit.swen253.utils.BrowserWindow;
import edu.rit.swen253.utils.SeleniumUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static edu.rit.swen253.utils.BrowserType.FIREFOX;
import static edu.rit.swen253.utils.BrowserType.onBrowser;
import static edu.rit.swen253.utils.TimingUtils.sleep;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;

public class TigerCenterClassSearchTest extends AbstractWebTest {
    private TigerCenterHomePage homePage;
    private BrowserWindow<TigerCenterHomePage> homeWindow;
    private TigerCenterClassSearchPage searchPage;

    @Test
    @Order(1)
    @DisplayName("First, navigate to the Tiger Center Home page.")
    void navigateToHomePage() {
        homePage = navigateToPage("https://tigercenter.rit.edu", TigerCenterHomePage::new);
        assertNotNull(homePage);
        homeWindow = getCurrentWindow();
    }

    @Test
    @Order(2)
    @DisplayName("Second, click on the Class Search button and validate navigation.")
    void navigateToClassSearch() {
        homePage.selectClassSearch();
        final SimplePage searchPage = assertNewPage(SimplePage::new);

        // having timing issues
        sleep(2);
        assertEquals("https://tigercenter.rit.edu/tigerCenterApp/api/class-search", searchPage.getURL());
    }

    @Test
    @Order(3)
    @DisplayName("Perform Simple Search for A Valid Class Code within Fall Semester")
    void validCourseCodeSearch() {
        TigerCenterClassSearchPage searchPage = navigateToPage("https://tigercenter.rit.edu/tigerCenterApp/api/class-search", TigerCenterClassSearchPage::new);
        List<TCClassSearchResult> results = searchPage.submitSearch(CLASS_TERM.FALL24_25, "SWEN 352");
        sleep(2);
        assertFalse(results.isEmpty());
        assertEquals(1, results.size());
        assertEquals("Software Testing", results.getFirst().getCourseDisplayName());
        assert results.getFirst().getCourseCodeAndSection().toLowerCase().contains("swen 352");
    }

    @Test
    @Order(4)
    @DisplayName("Perform Simple Search for A Valid Class Name within Fall Semester")
    void validCourseNameSearch() {
//        TigerCenterClassSearchPage searchPage = new TigerCenterClassSearchPage();
        TigerCenterClassSearchPage searchPage = navigateToPage("https://tigercenter.rit.edu/tigerCenterApp/api/class-search", TigerCenterClassSearchPage::new);
        List<TCClassSearchResult> results = searchPage.submitSearch(CLASS_TERM.FALL24_25, "Software Testing");
        sleep(2);
        assertFalse(results.isEmpty());
        assertEquals(50, results.size());
        assertEquals("Software Testing", results.getFirst().getCourseDisplayName());
        assert results.getFirst().getCourseCodeAndSection().toLowerCase().contains("swen 352");
    }

    @Test
    @Order(5)
    @DisplayName("Perform Simple Search for an Invalid Class Code within Fall Semester")
    void invalidCourseCodeSearch() {
        TigerCenterClassSearchPage searchPage = navigateToPage("https://tigercenter.rit.edu/tigerCenterApp/api/class-search", TigerCenterClassSearchPage::new);
        List<TCClassSearchResult> results = searchPage.submitSearch(CLASS_TERM.FALL24_25, "SW3N 999");
        sleep(2);
        assertTrue(results.isEmpty());
    }
    @Test
    @Order(6)
    @DisplayName("Perform Simple Search for an Invalid Class Name within Fall Semester")
    void invalidCourseNameSearch() {
        TigerCenterClassSearchPage searchPage = navigateToPage("https://tigercenter.rit.edu/tigerCenterApp/api/class-search", TigerCenterClassSearchPage::new);
        List<TCClassSearchResult> results = searchPage.submitSearch(CLASS_TERM.FALL24_25, "foobar");
        sleep(2);
        assertTrue(results.isEmpty());
    }

}
