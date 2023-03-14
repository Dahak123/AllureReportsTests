package io.github.qaguru.allure;


import io.qameta.allure.Allure;
public class ParametersTest {


    @ParameterizedTest(name = "{displayName} {0}")
    @ValueSource(strings = {"Санкт-Петербург", "Москва"})
    public void testLambda(String city) {
        Allure.parameter("Город", city);
    }
}
