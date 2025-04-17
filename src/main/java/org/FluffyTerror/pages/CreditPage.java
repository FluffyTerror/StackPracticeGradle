package org.FluffyTerror.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CreditPage extends BasePage {

    @FindBy(xpath = "//h1[contains(text(),'по кредиту')]")
    private WebElement credit;

    @FindBy(xpath = "//h1[contains(text(),'Соберите свой кешбэк')]")
    private WebElement cashback;

    @FindBy(xpath = "//div[@class='css-ykndue']//p[contains(text(), 'Сумма кредита')]/following-sibling::input[@type='text']")
    private WebElement creditSum;

    @FindBy(xpath = "//div[@class='css-ykndue']//p[contains(text(), 'Срок кредита')]/following-sibling::input[@type='text']")
    private WebElement creditDuration;

    @FindBy(xpath = "//span[contains(text(), 'Получаю зарплату в Банке Санкт-Петербург')]")
    private WebElement bankSalaryCheckbox;

    @FindBy(xpath = "//span[contains(text(), 'Получаю пенсию в Банке Санкт-Петербург')]")
    private WebElement bankPensionCheckbox;

    @FindBy(css = "h2.css-1linwur")
    public static WebElement monthlyPayment;


    public void checkOpenCreditPage() {
        waitUtilElementToBeVisible(cashback);
        waitUtilElementToBeVisible(credit);
        String title = cashback.getText() + ' ' + credit.getText();
        assertThat(title)
                .as("Заголовок отсутствует/не соответствует требуемому")
                .isEqualTo("Соберите свой кешбэк по кредиту");

    }


    public void scrollToCreditCalc() {
        sleep(200);
        scrollToElement(creditSum);
    }

    public static void checkCreditCalc(String sum) {
        sleep(1000);
        String value = monthlyPayment.getText();
        assertThat(value)
                .as("Сумма кредита не соответствует ожидаемому!")
                .isEqualTo(sum + " ₽");
    }

}
