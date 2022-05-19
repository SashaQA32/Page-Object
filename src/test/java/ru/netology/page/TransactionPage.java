package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.valueOf;
import static ru.netology.data.DataHelper.*;

public class TransactionPage {

    private SelenideElement amountField = $("[data-test-id=amount] input");
    private SelenideElement fromField = $("[data-test-id=from] input");
    private SelenideElement transferButton = $("[data-test-id=action-transfer]");

    public DashboardPage transferMoneyFromFirstCard(int amount) {
        amountField.setValue(valueOf(amount));
        fromField.setValue(valueOf(getFirstCardNumber()));
        transferButton.click();
        return new DashboardPage();
    }

    public DashboardPage transferMoneyFromSecondCard(int amount) {
        amountField.setValue(valueOf(amount));
        fromField.setValue(valueOf(getSecondCardNumber()));
        transferButton.click();
        return new DashboardPage();
    }

    public void getErrorLimit() {
        $(byText("Ошибка! Сумма превышает допустимый лимит!")).shouldBe(visible);
    }

    public void getErrorInvalidCard() {
        $(byText("Ошибка! Проверьте номер карты!")).shouldBe(visible);
    }
}
