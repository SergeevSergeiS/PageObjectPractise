package ru.internet.sergeevss90.pages;

import com.codeborne.selenide.SelenideElement;
import ru.internet.sergeevss90.pages.components.CalendarComponent;
import ru.internet.sergeevss90.pages.components.StateAndCityComponent;

import java.time.LocalDate;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {
    CalendarComponent calendar = new CalendarComponent();
    StateAndCityComponent stateAndCity = new StateAndCityComponent();
    // locators - not like I'm using them more than once, but let's create some variables for long names
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement emailInput = $("#userEmail");
    SelenideElement genderInput = $("#genterWrapper");
    SelenideElement phoneNumberInput = $("#userNumber");
    SelenideElement tableTitle = $("#example-modal-sizes-title-lg");
    SelenideElement tableOutput = $(".table-responsive");
    SelenideElement dateOfBirth = $("#dateOfBirthInput");
    SelenideElement subjectInput = $("#subjectsInput");
    SelenideElement hobbyInput = $("#hobbiesWrapper");
    SelenideElement pictureInsert = $("#uploadPicture");
    SelenideElement addressInput = $("#currentAddress");

    //actions
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationFormPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public RegistrationFormPage setGender(String gender) {
        genderInput.$(byText(gender)).click();
        return this;
    }

    public RegistrationFormPage setPhoneNumber(String phoneNumber) {
        phoneNumberInput.setValue(phoneNumber);
        return this;
    }

    public RegistrationFormPage setBirthDate(LocalDate birth) {
        dateOfBirth.click();
        calendar.setDate(birth);
        return this;
    }

    public RegistrationFormPage setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationFormPage setHobby(String hobby) {
        hobbyInput.$(byText(hobby)).click();
        return this;
    }

    public RegistrationFormPage uploadPicture(String imgPath) {
        pictureInsert.uploadFromClasspath(imgPath);
        return this;
    }

    public RegistrationFormPage setAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    public RegistrationFormPage setStateAndCity(String state, String city) {
        $("#state").click();
        stateAndCity.setState(state);
        $("#city").click();
        stateAndCity.setCity(city);
        return this;
    }

    public RegistrationFormPage submitForm() {
        $("#submit").click();
        return this;
    }

    public RegistrationFormPage checkTitle(String value) {
        tableTitle.shouldHave(text(value));
        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        tableOutput.$(byText(key))
                .parent().shouldHave(text(value));
        return this;
    }
}
