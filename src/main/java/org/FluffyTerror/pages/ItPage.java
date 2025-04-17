package org.FluffyTerror.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ItPage extends BasePage {
    @FindBy(xpath = "//h1[contains(text(), 'прокачивайте экспертизу')]")
    private WebElement expertise;

    @FindBy(xpath = "//h1[contains(text(), 'Развивайте финтех,')]")
    private WebElement finTech;

    public void checkOpenItPage() {
        sleep(450);//страница не успевает прогрузиться
        waitUtilElementToBeVisible(expertise);
        waitUtilElementToBeVisible(finTech);
        String title = finTech.getText() + ' ' + expertise.getText();
        assertThat(title).as("Заголовок отсутствует/не соответствует требуемому")
                .isEqualTo("Развивайте финтех, прокачивайте экспертизу");
    }
}
