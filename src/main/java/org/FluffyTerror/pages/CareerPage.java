package org.FluffyTerror.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CareerPage extends BasePage {
    @FindBy(xpath = "//h3[@class = 'css-bipdn9']/span[contains(text(),'IT & Digital')]")
    private WebElement itCareer;

    @FindBy(xpath = "//h1[contains(text(), 'Твоя карьера.')]")
    private WebElement career;

    @FindBy(xpath = "//h1[contains(text(), 'Твой банк.')]")
    private WebElement bank;

    @FindBy(xpath = "//h3[@class = 'css-bipdn9']/span[contains(text(),'IT & Digital')]")
    private WebElement it;


    public CareerPage checkOpenCareerPage() {
        waitUtilElementToBeVisible(bank);
        waitUtilElementToBeVisible(career);
        String title = bank.getText() + ' ' + career.getText();
        assertThat(title)
                .as("Заголовок отсутствует/не соответствует требуемому")
                .isEqualTo("Твой банк. Твоя карьера.");

        return this;
    }

    public CareerPage scrollToIt() {
        return (CareerPage) scrollToElement(itCareer);
    }

    public ItPage selectItPage() {
        waitUtilElementToBeVisible(it);
        waitUtilElementToBeClickable(it).click();
        return pageManager.getItPage();
    }

}
