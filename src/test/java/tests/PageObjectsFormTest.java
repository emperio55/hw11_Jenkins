package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import static tests.TestData.*;

public class PageObjectsFormTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest(){
        registrationPage.openPage()
                .cleanBannersOnPage()
                .setFirsName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setUserGender(userGender)
                .setUserPhone(userPhone)
                .setDateOfBirth(userDayBday,userMonthBday, userYearBday)
                .setUserSubjects(userSubject)
                .chooseHobbies(userHobbies)
                .uploadFile(userFile)
                .setCurrentAddress(streetAddress)
                .setStateAndCity(userState, userCity)
                .clickSubmitButton()
                .checkTableResultVisible()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userPhone )
                .checkResult("Date of Birth", userDayBday + " " + userMonthBday + "," +userYearBday)
                .checkResult("Subjects", userSubject)
                .checkResult("Hobbies", userHobbies)
                .checkResult("Picture", userFile)
                .checkResult("Address", streetAddress)
                .checkResult("State and City", userState + " " + userCity);
    }

    @Test
    void checkOnlyRequeredFieldsTest(){
        registrationPage.openPage()
                .cleanBannersOnPage()
                .setFirsName("Mark")
                .setLastName("Avrelii")
                .setUserGender("Male")
                .setUserPhone("9774599362")
                .setDateOfBirth(userDayBday,userMonthBday, userYearBday)
                .clickSubmitButton()
                .checkTableResultVisible()
                .checkResult("Student Name", "Mark Avrelii")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9774599362")
                .checkResult("Date of Birth", "11 January,1991");
    }

    @Test
    void checkEmailFieldWithoutDomainTest(){
        registrationPage.openPage()
                .cleanBannersOnPage()
                .setFirsName("Mark")
                .setLastName("Avrelii")
                .setUserEmail("markhero")
                .setUserGender("Male")
                .setUserPhone("9774599362")
                .setDateOfBirth(userDayBday,userMonthBday, userYearBday)
                .clickSubmitButton()
                .checkTableResultUnvisible()
                .checkValidationEmailField();
    }
}
