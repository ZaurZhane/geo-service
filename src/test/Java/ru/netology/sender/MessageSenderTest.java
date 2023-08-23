package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;


public class MessageSenderTest {

    @Test
    void sendRussianText() {

        String ip = "172.0.0.0";

        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(ip))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));

        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);

        String preferences = messageSender.send(headers);
        String expected = "Добро пожаловать";

        Assertions.assertEquals(expected, preferences);

    }

    @Test
    void sendEnglishText() {

        String ip = "96.0.0.0";

        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(ip))
                .thenReturn(new Location("New York", Country.USA, null, 0));

        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);

        String preferences = messageSender.send(headers);
        String expected = "Welcome";

        Assertions.assertEquals(expected, preferences);

    }

}
