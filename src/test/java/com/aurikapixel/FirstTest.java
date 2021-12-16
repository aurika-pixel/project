package com.aurikapixel;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.open;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FirstTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize="1920x1080";
    }

    @Test
    void firstTest () {
        open("https://demoqa.com/automation-practice-form");
    }
}