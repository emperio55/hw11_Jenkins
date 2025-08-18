package pages;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableResultComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    TableResultComponent tableResultComponent = new TableResultComponent();


    private final SelenideElement firstNameInput  = $("#firstName");
    private final SelenideElement lastNameInput  =  $("#lastName");
    private final SelenideElement userEmail = $("#userEmail");
    private final SelenideElement userGender =   $("#genterWrapper");
    private final SelenideElement birthInput =   $("#dateOfBirthInput");
    private final SelenideElement userPhone =   $("#userNumber");
    private final SelenideElement userSubjects =   $("#subjectsContainer");
    private final SelenideElement userSubjectsInput =   $("#subjectsInput");
    private final SelenideElement userHobbies =   $("#hobbiesWrapper");
    private final SelenideElement selectPicture =   $("#uploadPicture");
    private final SelenideElement addressInput =   $("textarea#currentAddress");
    private final SelenideElement setState =   $("#state");
    private final SelenideElement chooseStateOfList =   $(".css-26l3qy-menu");
    private final SelenideElement setCity =   $("#city");
    private final SelenideElement chooseCityOfList =   $(".css-26l3qy-menu");
    private final SelenideElement submitButton =   $("button#submit");
    private final String ERROR_BORDER_COLOR = "rgb(220, 53, 69)";

    CalendarComponent calendarComponent = new CalendarComponent();
    public RegistrationPage openPage(){
        open("/automation-practice-form");
        return this;
    }
    public RegistrationPage cleanBannersOnPage(){
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
            return this;
        }

    public RegistrationPage setFirsName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value){
        userEmail.setValue(value);
        return this;
    }

    public RegistrationPage setUserGender(String value) {
        userGender.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserPhone(String value) {
        userPhone.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(int day, String month, int year) {
        birthInput.click();
        calendarComponent.setDate(day, month, String.valueOf(year));
        return this;
    }

    public RegistrationPage setUserSubjects(String value) {
        userSubjects.click();
        userSubjectsInput.setValue(value);
        $$("#react-select-2-option-0").findBy(text(value)).click();
        return this;
    }

    public RegistrationPage chooseHobbies(String hobbies) {
        userHobbies.$(byText(hobbies)).click();
        return this;
    }

    public RegistrationPage uploadFile(String fileName) {
        selectPicture.uploadFromClasspath(fileName);
        return this;
    }
    public RegistrationPage setCurrentAddress(String address) {
        addressInput.scrollTo().click();
        addressInput.setValue(address);
        return this;
    }
    public RegistrationPage setStateAndCity(String state, String city) {
        setState.scrollTo().click();
        chooseStateOfList.$(byText(state)).click();
        setCity.click();
        chooseCityOfList.$(byText(city)).click();
        return this;
    }
    public RegistrationPage clickSubmitButton(){
        submitButton.click();
        return this;
    }
    public RegistrationPage checkTableResultVisible(){
        tableResultComponent.checkTableVisible();
        return this;
    }
    public RegistrationPage checkTableResultUnvisible(){
        tableResultComponent.checkTableUnvisible();
        return this;
    }

    public RegistrationPage checkResult(String key, String value){
        tableResultComponent.compareUserData(key,value);
        return this;
    }
    public RegistrationPage checkValidationEmailField(){
        userEmail.shouldHave(cssValue("border-color", ERROR_BORDER_COLOR));
        return this;
    }
}
