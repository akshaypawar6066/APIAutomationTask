package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import utils.ConfigReader;

import java.io.IOException;

public class HomePageTest extends BaseClass {

    @Story("weatherAPI- 01- validateSearchFunctionalityForWeatherInformation")
    @Description("validateSearchFunctionalityForWeatherInformation")
    @Test(priority = 1, enabled = true)
    public void validateSearchFunctionalityForWeatherInformation() throws InterruptedException {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.verifyFunctionalityOfSearchWeatherInformation("city", "Navi Mumbai");
    }

    @Story("weatherAPI- 02- validateWeatherDetailsForSearchedCity")
    @Description("validateWeatherDetailsForSearchedCity")
    @Test(priority = 2, enabled = true)
    public void validateWeatherDetailsForSearchedCity() throws InterruptedException {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.verifyFunctionalityOfSearchWeatherInformation("city", "Navi Mumbai");
        homePage.verifySearchedCityWeatherInformation("°C");
    }

    @Story("weatherAPI- 03- validateWeatherDetailsForSearchedCity")
    @Description("validateWeatherDetailsForSearchedCity")
    @Test(priority = 3, enabled = true)
    public void validateWeatherInYourCitySearchBoxFunctionality() throws InterruptedException {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.verifyFunctionalityOfWeatherInYourCitySearchBox("Pune");
    }

    @Story("weatherAPI- 04- verifyWeatherInYourCityDetails")
    @Description("verifyWeatherInYourCityDetails")
    @Test(priority = 4, enabled = true)
    public void verifyWeatherInYourCityDetails() throws InterruptedException, IOException {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.verifyWeatherDetailsAfterSearchedThroughWeatherInYourCitySearchBox(ConfigReader.readPropData("CityName"), ConfigReader.readPropData("ExpectedTextOnNavigation"), ConfigReader.readPropData("expectedCityOnNavigation"));
    }

    @Story("weatherAPI- 05- verifySearchBoxFunctionalitiesByEnteringInvalidCityName")
    @Description("verifySearchBoxFunctionalitiesByEnteringInvalidCityName")
    @Test(priority = 5, enabled = true)
    public void verifySearchBoxFunctionalitiesByEnteringInvalidCityName() throws InterruptedException, IOException {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.verifyFunctionalityOfSearchBoxesAfterEnteringInvalidCityNames("ABC", "No results for ABC", "Not found");
    }

    @Story("weatherAPI- 06- verifyClickOnMapSectionFunctionality")
    @Description("verifyClickOnMapSectionFunctionality")
    @Test(priority = 6, enabled = true)
    public void verifyClickOnMapSectionFunctionality() throws InterruptedException, IOException {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.verifyNavigateToMapFunctionality("https://openweathermap.org/weathermap");
    }

    @Story("weatherAPI- 07- VerifyGlobalPrecipitationLayersUnderMapSectionCanToggle")
    @Description("VerifyGlobalPrecipitationLayersUnderMapSectionCanToggle")
    @Test(priority = 7, enabled = true)
    public void VerifyGlobalPrecipitationLayersUnderMapSectionCanToggle() throws InterruptedException, IOException {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnDifferentLayersOfMapSectionAndVerify("Global Precipitation", "radar");
    }

    @Story("weatherAPI- 08- VerifyPressureLayersUnderMapSectionCanToggle")
    @Description("VerifyPressureLayersUnderMapSectionCanToggle")
    @Test(priority = 8, enabled = true)
    public void VerifyPressureLayersUnderMapSectionCanToggle() throws InterruptedException, IOException {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnDifferentLayersOfMapSectionAndVerify("Pressure", "pressure");
    }

    @Story("weatherAPI- 09- VerifyTemperatureLayersUnderMapSectionCanToggle")
    @Description("VerifyTemperatureLayersUnderMapSectionCanToggle")
    @Test(priority = 9, enabled = true)
    public void VerifyTemperatureLayersUnderMapSectionCanToggle() throws InterruptedException, IOException {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnDifferentLayersOfMapSectionAndVerify("Temperature", "temperature");
    }

    @Story("weatherAPI- 10- VerifyWindspeedLayersUnderMapSectionCanToggle")
    @Description("VerifyWindspeedLayersUnderMapSectionCanToggle")
    @Test(priority = 10, enabled = true)
    public void VerifyWindspeedLayersUnderMapSectionCanToggle() throws InterruptedException, IOException {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnDifferentLayersOfMapSectionAndVerify("Wind speed", "windspeed");
    }

    @Story("weatherAPI- 11- VerifyCloudsLayersUnderMapSectionCanToggle")
    @Description("VerifyCloudsLayersUnderMapSectionCanToggle")
    @Test(priority = 11, enabled = true)
    public void VerifyCloudsLayersUnderMapSectionCanToggle() throws InterruptedException, IOException {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnDifferentLayersOfMapSectionAndVerify("Clouds", "clouds");
    }


}
