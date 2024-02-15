package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    public WebDriverWait waitCreate(WebDriver driver, int duration){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        return wait;
    }
}
