package pages.components;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Visible;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableResultComponent {
    private static SelenideElement tableResult = $(".table-responsive");

    public TableResultComponent compareUserData(String key, String value) {
        tableResult.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public TableResultComponent checkTableVisible() {
        tableResult.shouldBe(visible);
        return this;
    }

    public TableResultComponent checkTableUnvisible() {
        tableResult.shouldNotBe(visible);
        return this;
    }
}
