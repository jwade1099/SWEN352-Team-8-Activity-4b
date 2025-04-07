package edu.rit.swen253.test.gpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import edu.rit.swen253.page.tiger.GPAPage;
import edu.rit.swen253.test.AbstractWebTest;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ZeroCreditsTest extends AbstractWebTest {
    @Test
    @Order(1)
    @DisplayName("Scenario #3: Adding two courses with different credits and different grades while having zero credits")
    void scenario3(){
        GPAPage gpaPage = navigateToPage("https://tigercenter.rit.edu/tigerCenterApp/api/gpa-calc", GPAPage::new);
        assertNotNull(gpaPage);
        gpaPage.clickFirstGrade("4: 3.00");
        gpaPage.clickAddCourse();
        gpaPage.clickSecondGrade("1: 4.00");
        gpaPage.changeSecondCredits("4");
        gpaPage.clickCalculate();
        assertEquals("3.57", gpaPage.getTermGPA());
    }
}
