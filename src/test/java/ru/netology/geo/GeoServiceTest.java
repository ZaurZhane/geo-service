package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

public class GeoServiceTest {

    @Test
    void determiningLocationByIp() {

        Country expected = Country.RUSSIA;

        Country result = new GeoServiceImpl().byIp("172.0.32.11")
                .getCountry();

        Assertions.assertEquals(expected, result);

    }

}
