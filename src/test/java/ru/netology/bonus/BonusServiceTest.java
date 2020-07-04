package ru.netology.bonus;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @ParameterizedTest
    @CsvSource()

    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        //подготавливаем данные
        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
    @Test

    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        //подготавливаем данные
        long amount = 1_000_000_60;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }


    @Test
    void shouldCalculateForUnRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        //подготавливаем данные
        long amount = 1000_60;
        boolean registered = false;
        long expected = 10;

        // вызываем целевой метод
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnRegisteredAndUnderLimit2() {
        BonusService service = new BonusService();

        //подготавливаем данные
        long amount = 1_60;
        boolean registered = false;
        long expected = 0;

        // вызываем целевой метод
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        //подготавливаем данные
        long amount = 13_333_300_60;
        boolean registered = false;
        long expected = 500;

        // вызываем целевой метод
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
}