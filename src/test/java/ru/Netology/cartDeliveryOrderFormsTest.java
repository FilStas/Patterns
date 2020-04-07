package ru.Netology;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class cartDeliveryOrderFormsTest {

        Faker faker = new Faker(new Locale("ru"));

    @Test
    void cardDeliveryOrder() {
        open("http://localhost:9999");
        String[] city = new String[]{"Ижевск", "Казань", "Рязань", "Ставрополь", "Ярославль", "Москва", "Магадан", "Нижний Новгород", "Нальчик"};
        int n = (int) Math.floor(Math.random() * city.length);
        $("[data-test-id=city] .input__control").setValue(city[n]);
        $("[data-test-id=date] .icon").click();
        String name = faker.name().fullName();
        $("[data-test-id=name] .input__control").setValue(name);
        String tel = faker.phoneNumber().phoneNumber();
        $("[data-test-id=phone] .input__control").setValue(tel);
        $("[data-test-id=agreement] .checkbox__box").click();
        $(".button__text").click();
        $(withText("Успешно!")).waitUntil(Condition.visible, 12000);
    }


}
