package edu.rit.swen253.page.tiger;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import edu.rit.swen253.page.AbstractAngularPage;
import edu.rit.swen253.utils.DomElement;

public class GPAPage extends AbstractAngularPage {
    public GPAPage(){
        super("gpa-calc");
    }

    public void clickFirstGrade(String grade){
        DomElement grades = angularView.findChildBy(By.className("gradeDropDown"));
        grades.click();
        DomElement gradeOption = grades.findChildBy(By.cssSelector("option[value='" + grade + "']"));
        gradeOption.click();
    }

    public void clickSecondGrade(String grade){
        List<DomElement> gradeButtons = angularView.findChildrenBy(By.className("gradeDropDown"));
        DomElement grades = gradeButtons.get(2);
        grades.click();
        DomElement gradeOption = grades.findChildBy(By.cssSelector("option[value='" + grade + "']"));
        gradeOption.click();
    }

    public void clickFirstPastGrade(String grade){
        List<DomElement> gradeButtons = angularView.findChildrenBy(By.className("gradeDropDown"));
        DomElement grades = gradeButtons.get(1);
        grades.click();
        DomElement gradeOption = grades.findChildBy(By.cssSelector("option[value='" + grade + "']"));
        gradeOption.click();
    }

    public void clickCalculate(){
        DomElement calculate = angularView.findChildBy(By.className("primaryButton"));
        calculate.click();
    }

    public void clickAddCourse(){
        List<DomElement> buttons = angularView.findChildrenBy(By.className("secondaryButton"));
        buttons.get(1).click(); 
    }

    public void changeSecondCredits(String credits){
        List<DomElement> inputBox = angularView.findChildrenBy(By.className("inputBox"));
        DomElement creditField = inputBox.get(5);
        creditField.sendKeys(Keys.BACK_SPACE);
        creditField.sendKeys(credits);
    }

    public void changeCourseCredits(String credits){
        DomElement creditField = angularView.findChildBy(By.className("inputBox"));
        creditField.sendKeys(Keys.BACK_SPACE);
        creditField.sendKeys(credits);
    }

    public void changeGPA(String GPA){
        List<DomElement> inputBox = angularView.findChildrenBy(By.className("inputBox"));
        DomElement gpaField = inputBox.get(1);
        gpaField.sendKeys(Keys.BACK_SPACE);
        gpaField.sendKeys(GPA);
    }

    public String getTermGPA(){
        DomElement termGPA = angularView.findChildBy(By.className("results"));
        return termGPA.getText();
    }

    public String getCumulativeGPA(){
        List<DomElement> GPAs = angularView.findChildrenBy(By.className("results"));
        DomElement cumulativeGPA = GPAs.get(1);
        return cumulativeGPA.getText();
    }
}
