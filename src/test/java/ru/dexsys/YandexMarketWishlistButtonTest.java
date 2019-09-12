package ru.dexsys;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexMarketWishlistButtonTest extends WebDriverSettings {
    @Test
    public void checkSaveButtonAddsItem() throws InterruptedException {
        driver.get("https://market.yandex.ru");

        WebElement searchField = driver.findElement(By.id("header-search"));
        WebElement searchButton = driver.findElement(new By.ByXPath("/html/body/div[1]/div/div[1]/noindex/div/div/div[2]/div/div[1]/form/span/span[2]/button"));

        searchField.sendKeys("intel xeon e3-1220 e3 1220");
        searchButton.click();

        driver.findElement(new By.ByCssSelector("[data-id =\"model-1729869620\"]"));
        WebElement productRef = driver.findElement(By.xpath("//*[@id=\"product-1729869620\"]/div[4]/div[1]/div[1]/a"));
        productRef.click();

        WebElement wishlistButton = driver.findElement(new By.ByXPath("/html/body/div[1]/div[5]/div[2]/div/div/div/div[2]/div/a/span[1]"));
        wishlistButton.click();

        WebElement moveToWishlist = driver.findElement(new By.ByCssSelector("body > div.popup-informer.i-bem.popup-informer_js_inited > div > div > div.popup-informer__controls > a"));
        moveToWishlist.click();

        if (driver.findElement(By.cssSelector("[data-id =\"model-1729869620\"]")).getSize() != null)
            System.out.println("Success, item was added to saved");
    }

    @Test
    public void isClickable(){
        driver.get("https://market.yandex.ru");
        WebElement wishlistButton = driver.findElement(By.cssSelector("[data-title = \"Отложенные\""));
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(wishlistButton));
    }

    @Test
    public void isCounterWork() throws InterruptedException {
        driver.get("https://market.yandex.ru/catalog/54726/list?hid=91491&utm_source=adfox_desktop&utm_medium=banner_regular&utm_campaign=electron_smartphone_305x238&glfilter=4940921%3A13475069&local-offers-first=0&onstock=1");
        WebElement wishlistButton = driver.findElementByXPath("/html/body/div[1]/div[5]/div[2]/div[1]/div[2]/div/div[1]/div[3]/div[1]/div/div/a/i[1]");
        wishlistButton.click();

        WebElement counter = wishlistButton.findElement(By.xpath("/html/body/div[1]/div[1]/noindex/div/div/div[2]/div/div[2]/div[1]/a[1]/span[1]/span[1]"));

        Thread.sleep(2000);
        if (Integer.parseInt(counter.getText()) == 1 )
            System.out.println("Success");
    }
}
