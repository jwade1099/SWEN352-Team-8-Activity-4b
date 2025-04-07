package edu.rit.swen253.test.gpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import edu.rit.swen253.page.tiger.GPAPage;
import edu.rit.swen253.test.AbstractWebTest;

class MultipleCourseTest extends AbstractWebTest{
    @Test
    @Order(1)
    @DisplayName("Scenario #2: Adding multiple courses lowers GPA")
    void scenario2(){
        GPAPage gpaPage = navigateToPage("https://tigercenter.rit.edu/tigerCenterApp/api/gpa-calc", GPAPage::new);
        assertNotNull(gpaPage);
        gpaPage.changeCourseCredits("30");
        gpaPage.changeGPA("4");
        gpaPage.clickFirstGrade("4: 3.00");
        gpaPage.clickAddCourse();
        gpaPage.clickSecondGrade("4: 3.00");
        gpaPage.clickCalculate();
        assertEquals("3.00", gpaPage.getTermGPA());
        assertEquals("3.83", gpaPage.getCumulativeGPA());
    }
}
