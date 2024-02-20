package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class PrivateTest {

    WebDriver driver = new ChromeDriver();

    @Test
    public void mapLoader() throws IOException {
        String fileName = "D:\\maps.txt"; // Replace with the path to your file
        String linkBody = "https://osu.ppy.sh/beatmapsets/";
        String fullLink;
        String login = "wataripro";
        String password = "123QWERTY123as";


        String[] content = new String(Files.readAllBytes(Paths.get(fileName))).split(", ");
        fullLink = linkBody + content[4];
        driver.get(fullLink);

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'avatar')]")));

            WebElement avatar = driver.findElement(By.xpath("//button[contains(@class, 'avatar')]"));
            avatar.click();

            WebElement usernameField = driver.findElement(By.name("username"));
            WebElement passwordField = driver.findElement(By.name("password"));
            WebElement loginButton = driver.findElement(By.xpath("//div[contains(@class, 'login-box__action')]"));
            usernameField.sendKeys(login);
            passwordField.sendKeys(password);
            loginButton.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='osu!direct']")));

            WebElement osuDirect = driver.findElement(By.xpath("//span[text()='Download']"));
            osuDirect.click();

            Thread.sleep(5000);
        } catch (TimeoutException e) {
            System.out.println("Map with "+ content[4] +" was not downloaded");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 5625; i < content.length ; i++) {
            try {
                fullLink = linkBody + content[i] + "download";
                driver.get(fullLink);

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='osu!direct']")));

                WebElement osuDirect = driver.findElement(By.xpath("//span[text()='Download']"));
                osuDirect.click();

                System.out.println("map " + i + " is downloaded");

                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (TimeoutException e) {
                System.out.println("Map with "+ content[i] +" was not downloaded");
            }
        }



        System.out.println(content[2]);

    }
}
