package ru.dexsys;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class YandexMarketSaveButtonTest extends WebDriverSettings {
    @Test
    public void checkSaveButtonAddsItem() throws InterruptedException {
        driver.get("https://market.yandex.ru");

        WebElement searchField = driver.findElement(By.id("header-search"));
        WebElement searchButton = driver.findElement(new By.ByXPath("/html/body/div[1]/div/div[1]/noindex/div/div/div[2]/div/div[1]/form/span/span[2]/button"));

        searchField.sendKeys("intel xeon e3-1220 e3 1220");
        searchButton.click();

        WebElement product = driver.findElement(new By.ByXPath("//*[@id=\"product-1729869620\"]/div[4]/div[1]/div[1]/a"));

        product.click();

        WebElement saveButton = driver.findElement(new By.ByXPath("/html/body/div[1]/div[5]/div[2]/div/div/div/div[2]/div/a/span[1]"));
        saveButton.click();

        WebElement moveToSavedButton = driver.findElement(new By.ByCssSelector("body > div.popup-informer.i-bem.popup-informer_js_inited > div > div > div.popup-informer__controls > a"));
        moveToSavedButton.click();

    }

}
