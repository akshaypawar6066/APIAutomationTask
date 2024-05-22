package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BrowserUtils;
import utils.VerifyUtil;
import utils.WaitUtils;
import utils.WindowUtil;

import java.util.List;

public class HomePage {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Search city']")
	private WebElement homePageSearchBox;

	@FindBy(xpath = "//button[normalize-space()='Search']")
	private WebElement homePageSearchButton;

	@FindBy(xpath = "//ul[@class='search-dropdown-menu']")
	private WebElement homePageSearchedCity;

	@FindBy(xpath = "//div[@class='current-container mobile-padding']//h2")
	private WebElement homePageSearchedCityName;

	@FindBy(xpath = "//span[@class='heading']")
	private WebElement searchedCityTemperature;

	@FindBy(xpath = "//span[normalize-space()='Humidity:']")
	private WebElement searchedCityHumidity;

	@FindBy(xpath = "//span[normalize-space()='Visibility:']")
	private WebElement searchedCityVisibility;

	@FindBy(xpath = "//li[@id='desktop-menu']//input[@placeholder='Weather in your city']")
	private WebElement weatherInYourCitySearchBox;

	@FindBy(xpath = "//div[@class='col-sm-12']/h2")
	private WebElement weatherInYourCityText;

	@FindBy(xpath = "//input[@id='search_str']")
	private WebElement cityOnNavigation;

	@FindBy(xpath = "//p[text()='Geo coords ']")
	private WebElement geoCoords;

	@FindBy(xpath = "//p[contains(text(),'temperature from')]")
	private WebElement weatherInfoOfYourCity;

	@FindBy(xpath = "//div[@class='widget-notification']//span")
	private WebElement errorMessageForInvalidCityOnHomePage;

	@FindBy(xpath = "//div[@role='alert']")
	private WebElement errorMessageForInvalidCityOnWeatherInYourCity;

	@FindBy(xpath = "//a[@class='map-info-block']")
	private WebElement mapSection;

	@FindBy(xpath = "//div[@class='weather-layer-container']//span")
	private List<WebElement> listOfMapLayers;

	public void verifyFunctionalityOfSearchWeatherInformation(String expectedUrlToBeContains, String expectedCityName)
			throws InterruptedException {
		WaitUtils.waitForTheElementToBeVisible(driver, homePageSearchBox, "HomePageSearchBox");
		homePageSearchBox.sendKeys(expectedCityName);
		WaitUtils.waitForTheElementToBeClickable(driver, homePageSearchButton, "HomePageSearchButton");
		WaitUtils.waitForTheFixedTime(2);
		homePageSearchButton.click();
		WaitUtils.waitForTheElementToBeVisible(driver, homePageSearchedCity, "SearchedCityHomePage");
		homePageSearchedCity.click();
		WaitUtils.waitForTheFixedTime(2);
		String currentUrl = BrowserUtils.getCurrentUrlOfBrowser(driver);
		VerifyUtil.checkTwoTextsContainsOrNot(homePageSearchedCityName.getText().trim(), expectedCityName);
		VerifyUtil.checkTwoTextsContainsOrNot(currentUrl, expectedUrlToBeContains);
	}

	public void verifySearchedCityWeatherInformation(String expectedTempText) {
		boolean tempElement = WaitUtils.waitForTheElementToBeVisible(driver, searchedCityTemperature,
				"SearchedCityTemperature");
		boolean humidityEle = WaitUtils.waitForTheElementToBeVisible(driver, searchedCityHumidity,
				"SearchedCityHumidity");
		boolean visibilityEle = WaitUtils.waitForTheElementToBeVisible(driver, searchedCityVisibility,
				"SearchedCityVisibility");
		String tempText = searchedCityTemperature.getText().trim();
		VerifyUtil.checkTwoTextsContainsOrNot(tempText, expectedTempText);
		VerifyUtil.assertThat(tempElement, "Temperature is displayed on the weather Information",
				"Temperature is not displayed on the weather Information");
		VerifyUtil.assertThat(humidityEle, "Humidity is displayed on the weather Information",
				"Humidity is not displayed on the weather Information");
		VerifyUtil.assertThat(visibilityEle, "Visibility is displayed on the weather Information",
				"Visibility is not displayed on the weather Information");
	}

	public void verifyFunctionalityOfWeatherInYourCitySearchBox(String cityName) {
		WaitUtils.waitForTheElementToBeVisible(driver, weatherInYourCitySearchBox, "WeatherInYourCitySearchBox");
		weatherInYourCitySearchBox.sendKeys(cityName);
		weatherInYourCitySearchBox.sendKeys(Keys.ENTER);
		String currentUrl = BrowserUtils.getCurrentUrlOfBrowser(driver);
		VerifyUtil.checkTwoTextsContainsOrNot(currentUrl, cityName);
	}

	public void verifyWeatherDetailsAfterSearchedThroughWeatherInYourCitySearchBox(String cityName,
			String expectedTextOnNavigation, String expectedCityOnNavigation) throws InterruptedException {
		WaitUtils.waitForTheElementToBeVisible(driver, weatherInYourCitySearchBox, "WeatherInYourCitySearchBox");
		weatherInYourCitySearchBox.sendKeys(cityName);
		weatherInYourCitySearchBox.sendKeys(Keys.ENTER);
		WaitUtils.waifForPageToBeLoad(driver);
		// Verify Url contains the entered city name.
		String currentUrl = BrowserUtils.getCurrentUrlOfBrowser(driver);
		VerifyUtil.checkTwoTextsContainsOrNot(currentUrl, cityName);

		// verify if text is WeatherInYourCity Text present
		WaitUtils.waitForTheElementToBeVisible(driver, weatherInYourCityText, "WeatherInYourCityText");
		VerifyUtil.checkTwoTextsContainsOrNot(expectedTextOnNavigation, weatherInYourCityText.getText().trim());

		// verify if CityOnNavigation is same as that we have passed.
		WaitUtils.waitForTheElementToBeVisible(driver, cityOnNavigation, "expectedCityOnNavigation");
		String attributeValue = BrowserUtils.getAttributeValueOfTheWebElement(cityOnNavigation, "value");
		VerifyUtil.checkTwoTextsContainsOrNot(attributeValue, expectedCityOnNavigation);

		// Verify if Expected Weather details on navigation
		WaitUtils.waitForTheElementToBeVisible(driver, weatherInfoOfYourCity, "WeatherInfoOfYourCity");
		String[] weatherInfo = weatherInfoOfYourCity.getText().trim().split(",");
		VerifyUtil.checkTwoTextsContainsOrNot(weatherInfo[0].trim(), "temperature from");
		VerifyUtil.checkTwoTextsContainsOrNot(weatherInfo[1].trim(), "wind");

		// Verify if Geo coords are visible or not
		boolean result = WaitUtils.waitForTheElementToBeVisible(driver, geoCoords, "GeoCoords");
		VerifyUtil.assertThat(result, "Geo Confidantes are available", "eo Confidantes are not available");

	}

	public void verifyFunctionalityOfSearchBoxesAfterEnteringInvalidCityNames(String invalidCityName,
			String expectedMessageForHomePageSearchBox, String expectedMessageForWeatherInYoyrCitySearchBox)
			throws InterruptedException {
		WaitUtils.waitForTheElementToBeVisible(driver, homePageSearchBox, "HomePageSearchBox");
		homePageSearchBox.sendKeys(invalidCityName);
		WaitUtils.waitForTheElementToBeClickable(driver, homePageSearchButton, "HomePageSearchButton");
		WaitUtils.waitForTheFixedTime(3);
		homePageSearchButton.click();
		WaitUtils.waitForTheElementToBeVisible(driver, errorMessageForInvalidCityOnHomePage, "ErrorMessageOnHomePage");
		VerifyUtil.checkTwoTextsContainsOrNot(errorMessageForInvalidCityOnHomePage.getText().trim(),
				expectedMessageForHomePageSearchBox);
		WaitUtils.waitForTheElementToBeVisible(driver, weatherInYourCitySearchBox, "WeatherInYourCitySearchBox");
		weatherInYourCitySearchBox.sendKeys(invalidCityName);
		WaitUtils.waitForTheFixedTime(3);
		weatherInYourCitySearchBox.sendKeys(Keys.ENTER);
		WaitUtils.waitForTheElementToBeVisible(driver, errorMessageForInvalidCityOnWeatherInYourCity,
				"ErrorMessageOnWeatherInYourCity");
		VerifyUtil.checkTwoTextsContainsOrNot(errorMessageForInvalidCityOnWeatherInYourCity.getText().trim(),
				expectedMessageForWeatherInYoyrCitySearchBox);
	}

	public void verifyNavigateToMapFunctionality(String expectedUrlToBeConatins) throws InterruptedException {
		WaitUtils.waitForTheElementToBeClickable(driver, mapSection, "MAP Section");
		WindowUtil.scrollIntoView(driver, 0, 500);
		mapSection.click();
		WaitUtils.waifForPageToBeLoad(driver);
		WindowUtil.switchToChildWindow(driver);
		String currentUrl = driver.getCurrentUrl();
		VerifyUtil.checkTwoTextsContainsOrNot(currentUrl, expectedUrlToBeConatins);
	}

	public void clickOnDifferentLayersOfMapSectionAndVerify(String expectedLayer, String expectedText) {
		WaitUtils.waitForTheElementToBeClickable(driver, mapSection, "MAP Section");
		WindowUtil.scrollIntoView(driver, 0, 500);
		mapSection.click();
		WaitUtils.waifForPageToBeLoad(driver);
		WindowUtil.switchToChildWindow(driver);
		BrowserUtils.selectExpectedOptionFromTheListOfWebElement(driver, listOfMapLayers, expectedLayer);
		VerifyUtil.checkTwoTextsContainsOrNot(driver.getCurrentUrl().trim(), "layer=" + expectedText);
	}

}
