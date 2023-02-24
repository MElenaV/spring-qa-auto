package com.spring.qa.auto.lesson7.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MobileApplicationsJavaPage {

    private final WebDriver driver;

    @FindBy(xpath = "//div[@class='java-hero-container']//p")
    private List<WebElement> mobileApplicationsDescr;

    public MobileApplicationsJavaPage(@Lazy WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getMobileApplicationsDescr() {
        return mobileApplicationsDescr.get(0);
    }

}
