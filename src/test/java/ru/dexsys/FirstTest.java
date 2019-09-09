package ru.dexsys;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FirstTest extends WebDriverSettings {

    @Test
    public void Test() throws InterruptedException {
        driver.get("https://market.yandex.ru");
        WebElement searchField = driver.findElement(By.id("header-search"));
        WebElement searchButton = driver.findElement(new By.ByXPath("/html/body/div[1]/div/div[1]/noindex/div/div/div[2]/div/div[1]/form/span/span[2]/button"));

        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header-search")));
        searchField.sendKeys("intel xeon e3-1220 e3 1220");
        searchButton.click();
    }

}
