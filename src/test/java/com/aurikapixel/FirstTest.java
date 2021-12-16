package com.aurikapixel;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.time.format.DateTimeFormatter;

public class FirstTest {
    String name = "Julia";
    String lastName = "Test";
    String userEmail = "fdsfsd@mail.ru";
    String gender = "Female";
    String mobile = "9254454534";
    String dateOfBirth = "12 Sep 1990";
    String subjects = "Maths";
    String hobbies = "Reading";
    String picture = "test.png";
    String adress = "bla-bla";
    String state = "NCR";
    String city = "Delhi";

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize="1920x1080";
    }

    @Test
    void firstTest () {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue(name);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(byText(gender)).click();
        $("#userNumber").setValue(mobile);
        $("#dateOfBirthInput").sendKeys(Keys.CONTROL + "a");
        $("#dateOfBirthInput").sendKeys(dateOfBirth + Keys.ENTER);
        $("#subjectsInput").sendKeys(subjects);
        $("#subjectsInput").sendKeys(Keys.ENTER);
        $(byText(hobbies)).click();
        $("#uploadPicture").uploadFile(new File("C:\\project\\project\\test.png"));
        $("#currentAddress").setValue(adress);
        $("#react-select-3-input").sendKeys(state);
        $("#react-select-3-input").pressEnter();
        $("#react-select-4-input").sendKeys(city);
        $("#react-select-4-input").pressEnter();

        $("#submit").click();

        $(By.xpath("//tbody/tr[1]/td[2]")).shouldHave(text(name + " " + lastName));
        $(By.xpath("//tbody/tr[2]/td[2]")).shouldHave(text(userEmail));
        $(By.xpath("//tbody/tr[3]/td[2]")).shouldHave(text(gender));
        $(By.xpath("//tbody/tr[4]/td[2]")).shouldHave(text(mobile));
        $(By.xpath("//tbody/tr[5]/td[2]")).shouldHave(text("12 September,1990"));
        $(By.xpath("//tbody/tr[6]/td[2]")).shouldHave(text(subjects));
        $(By.xpath("//tbody/tr[7]/td[2]")).shouldHave(text(hobbies));
        $(By.xpath("//tbody/tr[8]/td[2]")).shouldHave(text(picture));
        $(By.xpath("//tbody/tr[9]/td[2]")).shouldHave(text(adress));
        $(By.xpath("//tbody/tr[10]/td[2]")).shouldHave(text(state + " " + city));
    }
}