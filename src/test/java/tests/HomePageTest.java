package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.HomePage;
import utils.ConfigReader;

import java.io.IOException;

public class HomePageTest extends BaseClass {

	@Story("weatherAPI- 01- validateSearchFunctionalityForWeatherInformation")
	@Description("validateSearchFunctionalityForWeatherInformation")
	@Test(priority = 1, enabled = true)
	public void validateSearchFunctionalityForWeatherInformation() throws InterruptedException, IOException {
		WebDriver driver = getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.verifyFunctionalityOfSearchWeatherInformation(
				ConfigReader.readExcelDataByKey("UrlToBeContainsAfterSearch"),
				ConfigReader.readExcelDataByKey("CItyNameForHomePageSearch"));
	}

	@Story("weatherAPI- 02- validateWeatherDetailsForSearchedCity")
	@Description("validateWeatherDetailsForSearchedCity")
	@Test(priority = 2, enabled = true)
	public void validateWeatherDetailsForSearchedCity() throws InterruptedException, IOException {
		WebDriver driver = getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.verifyFunctionalityOfSearchWeatherInformation(
				ConfigReader.readExcelDataByKey("UrlToBeContainsAfterSearch"),
				ConfigReader.readExcelDataByKey("CItyNameForHomePageSearch"));
		homePage.verifySearchedCityWeatherInformation("°C");
	}

	@Story("weatherAPI- 03- validateWeatherDetailsForSearchedCity")
	@Description("validateWeatherDetailsForSearchedCity")
	@Test(priority = 3, enabled = true)
	public void validateWeatherInYourCitySearchBoxFunctionality() throws InterruptedException, IOException {
		WebDriver driver = getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.verifyFunctionalityOfWeatherInYourCitySearchBox(ConfigReader.readExcelDataByKey("CityName"));
	}

	@Story("weatherAPI- 04- verifyWeatherInYourCityDetails")
	@Description("verifyWeatherInYourCityDetails")
	@Test(priority = 4, enabled = true)
	public void verifyWeatherInYourCityDetails() throws InterruptedException, IOException {
		WebDriver driver = getDriver();
		HomePage homePage = new HomePage(driver);
		String cityName = ConfigReader.readExcelDataByKey("CityName");
		String expectedText = ConfigReader.readExcelDataByKey("ExpectedTextOnNavigation");
		String expectedCity = ConfigReader.readExcelDataByKey("expectedCityOnNavigation");
		homePage.verifyWeatherDetailsAfterSearchedThroughWeatherInYourCitySearchBox(cityName, expectedText,
				expectedCity);
	}

	@Story("weatherAPI- 05- verifySearchBoxFunctionalitiesByEnteringInvalidCityName")
	@Description("verifySearchBoxFunctionalitiesByEnteringInvalidCityName")
	@Test(priority = 5, enabled = true)
	public void verifySearchBoxFunctionalitiesByEnteringInvalidCityName() throws InterruptedException, IOException {
		WebDriver driver = getDriver();
		HomePage homePage = new HomePage(driver);
		String invalidCityName = ConfigReader.readExcelDataByKey("InvalidCityName");
		String noResultMessage = ConfigReader.readExcelDataByKey("NoResultMessage");
		String notFoundMessage = ConfigReader.readExcelDataByKey("NotFoundMessage");
		homePage.verifyFunctionalityOfSearchBoxesAfterEnteringInvalidCityNames(invalidCityName, noResultMessage,
				notFoundMessage);
	}

	@Story("weatherAPI- 06- verifyClickOnMapSectionFunctionality")
	@Description("verifyClickOnMapSectionFunctionality")
	@Test(priority = 6, enabled = true)
	public void verifyClickOnMapSectionFunctionality() throws InterruptedException, IOException {
		WebDriver driver = getDriver();
		HomePage homePage = new HomePage(driver);
		String mapSectionURL = ConfigReader.readExcelDataByKey("MapSectionURL");
		homePage.verifyNavigateToMapFunctionality(mapSectionURL);
	}

	@Story("weatherAPI- 07- VerifyGlobalPrecipitationLayersUnderMapSectionCanToggle")
	@Description("VerifyGlobalPrecipitationLayersUnderMapSectionCanToggle")
	@Test(priority = 7, enabled = true)
	public void VerifyGlobalPrecipitationLayersUnderMapSectionCanToggle() throws InterruptedException, IOException {
		WebDriver driver = getDriver();
		HomePage homePage = new HomePage(driver);
		String layerName = ConfigReader.readExcelDataByKey("GlobalPrecipitationLayer");
		String layerType = ConfigReader.readExcelDataByKey("RadarType");
		homePage.clickOnDifferentLayersOfMapSectionAndVerify(layerName, layerType);
	}

	@Story("weatherAPI- 08- VerifyPressureLayersUnderMapSectionCanToggle")
	@Description("VerifyPressureLayersUnderMapSectionCanToggle")
	@Test(priority = 8, enabled = true)
	public void VerifyPressureLayersUnderMapSectionCanToggle() throws InterruptedException, IOException {
		WebDriver driver = getDriver();
		HomePage homePage = new HomePage(driver);
		String layerName = ConfigReader.readExcelDataByKey("PressureLayer");
		String layerType = ConfigReader.readExcelDataByKey("PressureType");
		homePage.clickOnDifferentLayersOfMapSectionAndVerify(layerName, layerType);
	}

	@Story("weatherAPI- 09- VerifyTemperatureLayersUnderMapSectionCanToggle")
	@Description("VerifyTemperatureLayersUnderMapSectionCanToggle")
	@Test(priority = 9, enabled = true)
	public void VerifyTemperatureLayersUnderMapSectionCanToggle() throws InterruptedException, IOException {
		WebDriver driver = getDriver();
		HomePage homePage = new HomePage(driver);
		String layerName = ConfigReader.readExcelDataByKey("TemperatureLayer");
		String layerType = ConfigReader.readExcelDataByKey("TemperatureType");
		homePage.clickOnDifferentLayersOfMapSectionAndVerify(layerName, layerType);
	}

	@Story("weatherAPI- 10- VerifyWindspeedLayersUnderMapSectionCanToggle")
	@Description("VerifyWindspeedLayersUnderMapSectionCanToggle")
	@Test(priority = 10, enabled = true)
	public void VerifyWindspeedLayersUnderMapSectionCanToggle() throws InterruptedException, IOException {
		WebDriver driver = getDriver();
		HomePage homePage = new HomePage(driver);
		String layerName = ConfigReader.readExcelDataByKey("WindSpeedLayer");
		String layerType = ConfigReader.readExcelDataByKey("WindSpeedType");
		homePage.clickOnDifferentLayersOfMapSectionAndVerify(layerName, layerType);
	}

	@Story("weatherAPI- 11- VerifyCloudsLayersUnderMapSectionCanToggle")
	@Description("VerifyCloudsLayersUnderMapSectionCanToggle")
	@Test(priority = 11, enabled = true)
	public void VerifyCloudsLayersUnderMapSectionCanToggle() throws InterruptedException, IOException {
		WebDriver driver = getDriver();
		HomePage homePage = new HomePage(driver);
		String layerName = ConfigReader.readExcelDataByKey("CloudsLayer");
		String layerType = ConfigReader.readExcelDataByKey("CloudsType");
		homePage.clickOnDifferentLayersOfMapSectionAndVerify(layerName, layerType);
	}
}
