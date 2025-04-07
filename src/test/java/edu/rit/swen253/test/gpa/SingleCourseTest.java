package edu.rit.swen253.test.gpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import edu.rit.swen253.page.tiger.GPAPage;
import edu.rit.swen253.test.AbstractWebTest;

class SingleCourseTest extends AbstractWebTest{
    @Test
    @Order(1)
    @DisplayName("Scenario #1: Adding one course will increase GPA")
    void scenario1(){
        GPAPage gpaPage = navigateToPage("https://tigercenter.rit.edu/tigerCenterApp/api/gpa-calc", GPAPage::new);
        assertNotNull(gpaPage);
        gpaPage.changeCourseCredits("30");
        gpaPage.changeGPA("3");
        gpaPage.clickFirstGrade("1: 4.00");
        gpaPage.clickCalculate();
        assertEquals("4.00", gpaPage.getTermGPA());
        assertEquals("3.09", gpaPage.getCumulativeGPA());
    }
}
