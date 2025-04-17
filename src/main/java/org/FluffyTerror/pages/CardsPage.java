package org.FluffyTerror.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class CardsPage extends BasePage {

    @FindBy(css = "div.css-x7ci5t")
    private WebElement cardTitle;

    @FindBy(xpath = "//div[@class ='css-1jk9zdi'] / a[@href='/retail/cards/debit/mcworld']")
//не уверен, что стоило трогать...
    private WebElement aboutYarkaya;

    public void checkOpenCardsPage() {
        waitUtilElementToBeVisible(cardTitle);
        assertThat(cardTitle.getText())
                .as("Заголовок отсутствует/не соответствует требуемому")
                .isEqualTo("Дебетовые карты");

    }

    public void selectYarkayaCardPage() {
        waitUtilElementToBeClickable(aboutYarkaya).click();
        pageManager.getYarkayaCardPage();
    }

}
