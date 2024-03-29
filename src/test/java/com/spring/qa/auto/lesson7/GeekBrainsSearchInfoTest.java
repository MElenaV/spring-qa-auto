package com.spring.qa.auto.lesson7;

import com.spring.qa.auto.lesson7.config.GeekBrainsTestConfig;
import com.spring.qa.auto.lesson7.page.GeekBrainsMainPage;
import com.spring.qa.auto.lesson7.page.JavaProfessionPage;
import com.spring.qa.auto.lesson7.page.JavaQaAutomationProfessionPage;
import com.spring.qa.auto.lesson7.page.MobileApplicationsJavaPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = GeekBrainsTestConfig.class)
@TestPropertySource(locations = "/application.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class GeekBrainsSearchInfoTest {

    @Autowired
    private GeekBrainsMainPage mainPage;

    @Autowired
    private JavaQaAutomationProfessionPage javaQaAutomationProfessionPage;

    @Autowired
    private JavaProfessionPage javaProfessionPage;

    @Autowired
    private MobileApplicationsJavaPage mobileApplicationsJavaPage;

    @Test
    public void getJavaQaAutomationProfessionTest() {

        mainPage.getMainPage()
                .search("Java")
                .getProfession("Автоматизация тестирования на Java");

        Assertions.assertThat(javaQaAutomationProfessionPage.getFormOffer().getText())
                .containsIgnoringCase("Освоите основы Java, научитесь автоматизировать тестирование Web UI и бэкенда на Java.");

    }

    @Test
    public void getJavaProfessionTest() {

        mainPage.getMainPage()
                .search("Java")
                .getProfession("Программист Java");

        Assertions.assertThat(javaProfessionPage.getFormOffer().getText())
                .containsIgnoringCase("Пройдите обучение на инженера-программиста на Java.");

    }

    @Test
    public void getMobileApplicationsJavaTest() {

        mainPage.getMainPage()
                .search("Java")
                .getProfession("Мобильные приложения на Java");

        Assertions.assertThat(mobileApplicationsJavaPage.getMobileApplicationsDescr().getText())
                .containsIgnoringCase("Создай с нуля интересную викторину и разработай своё приложение для android-смартфона");
    }

}
