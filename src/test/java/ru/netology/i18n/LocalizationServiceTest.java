package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

public class LocalizationServiceTest {

    @Test
    void locateTest(){

        String expected = "Добро пожаловать";

        String result = new LocalizationServiceImpl().locale(Country.RUSSIA);

        Assertions.assertEquals(expected, result);

    }
}
