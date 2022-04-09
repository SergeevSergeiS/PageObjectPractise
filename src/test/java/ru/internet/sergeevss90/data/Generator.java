package ru.internet.sergeevss90.data;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.StringUtils;
import ru.internet.sergeevss90.data.enums.*;

import java.time.LocalDate;
import java.util.Random;

public class Generator {
    Faker faker = new Faker();

    public LocalDate getDate() {
        return new java.sql.Date(faker.date().birthday().getTime()).toLocalDate();
    }

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public String getGender() {
        return StringUtils.capitalize(faker.dog().gender());
    }

    public String getPhoneNumber() {
        String temp =  faker.numerify("##########");
        if ("0".equals(temp.substring(0))) {
            temp = temp.replaceFirst("0", "9");
        }
        return temp;
    }

    public String getSubject() {
        return Subjects.values()[new Random().nextInt(Subjects.values().length)].toString();
    }

    public String getHobby() {
        return Hobbies.values()[new Random().nextInt(Hobbies.values().length)].toString();
    }

    public String getAddress() {
        return faker.address().fullAddress();
    }

    public String getState() {
        return States.values()[new Random().nextInt(States.values().length)].toString();
    }

    public String getCity(String state) {
        switch (state) {
            case "NCR":
                return NCRCities.values()[new Random().nextInt(NCRCities.values().length)].toString();
            case "Haryana":
                return HarCities.values()[new Random().nextInt(HarCities.values().length)].toString();
            case "Rajasthan":
                return RajCities.values()[new Random().nextInt(RajCities.values().length)].toString();
        }
        return "Delhi";
    }
}
