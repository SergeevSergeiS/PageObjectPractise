package ru.internet.sergeevss90.pages.components;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(LocalDate birth) {
        String month = StringUtils.capitalize(birth.getMonth().toString().toLowerCase());
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(String.valueOf(birth.getYear()));
        if (birth.getDayOfMonth() < 10) {       //additional '0' is required if day is less than 10
            $(".react-datepicker__day--00" + birth.getDayOfMonth() + ":not(.react-datepicker__day--outside-month)").click();
        } else {
            $(".react-datepicker__day--0" + birth.getDayOfMonth() + ":not(.react-datepicker__day--outside-month)").click();
        }
    }
}
