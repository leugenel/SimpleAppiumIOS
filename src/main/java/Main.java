import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class Main  {

  private IOSDriver driver;

  @Before
  public void setUp() throws MalformedURLException {
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
    desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
    desiredCapabilities.setCapability(MobileCapabilityType.APP,
            "/Users/eugenel/Library/Developer/Xcode/DerivedData/TryAppium1-afruatzrcvbnsyhigmdycmdealtw/Build/Products/Debug-iphonesimulator/TryAppium1.app");
    desiredCapabilities.setCapability("appiumVersion", "1.4.13");
    driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void testEugeneScenario() {

    // populate text fields with values
    MobileElement ediField = (MobileElement) driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]");
    ediField.sendKeys("Eugene");
    //Press the button
    MobileElement button = (MobileElement) driver.findElementByXPath("//UIAApplication[1]//UIAWindow[1]//UIAButton[1]");
    button.click();

    //Compare the text with the expected value
    MobileElement textField = (MobileElement) driver.findElementByXPath("//UIAApplication[1]//UIAWindow[1]//UIAStaticText[1]");
    TestCase.assertEquals(textField.getText(), "Hello Eugene We have the same name");

  }

  @Test
  public void testOtherScenario() {

    // populate text fields with values
    MobileElement ediField = (MobileElement) driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]");
    ediField.sendKeys("Dudu");
    //Press the button
    MobileElement button = (MobileElement) driver.findElementByXPath("//UIAApplication[1]//UIAWindow[1]//UIAButton[1]");
    button.click();

    //Compare the text with the expected value
    MobileElement textField = (MobileElement) driver.findElementByXPath("//UIAApplication[1]//UIAWindow[1]//UIAStaticText[1]");
    TestCase.assertEquals(textField.getText(),"Hello Dudu");

  }
}