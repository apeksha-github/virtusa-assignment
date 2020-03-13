// added dummy comment
package need;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario2IE {
public static void main(String[] args) throws Exception {

System.setProperty("webdriver.ie.driver",
"C:\\Program Files\\drivers\\IEDriverServer.exe");
Thread.sleep(4000);
WebDriver driver = new InternetExplorerDriver();

// 1. Navigate

driver.get("https://www.phptravels.net/admin");

driver.manage().window().maximize();

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

driver.findElement(By.xpath("//input[@type='text']")).sendKeys(
"admin@phptravels.com");

driver.findElement(By.xpath("//input[@type='password']")).sendKeys(
"demoadmin");

driver.findElement(By.xpath("//span[contains(text(),'Login')]"))
.click();

// 2. In LHS Admin Console, click on Tours -> Reviews
Thread.sleep(5000);
driver.findElement(By.xpath("//*[@href='#Tours']")).click();

driver.findElement(
By.xpath("//a[@href='https://www.phptravels.net/admin/tours/reviews']"))
.click();

// List<WebElement> checkboxes = driver.findElements(By
// .xpath("//input[@class='checkboxcls']"));
// Thread.sleep(5000);
// System.out.println(checkboxes.get(1).isEnabled());
// if (checkboxes.get(1).isEnabled()) {
// checkboxes.get(1).click();
// }
Thread.sleep(5000);

WebElement reviewtable = driver
.findElement(By
.xpath("//table[@class='xcrud-list table table-striped table-hover']"));

WebElement overallOld = reviewtable
.findElement(By
.xpath("//table[@class='xcrud-list table table-striped table-hover']/tbody/tr[1]/td[7]"));

String overallOldstr = overallOld.getText();

System.out.println(overallOldstr);

// 3. Edit any of the tour (by clicking on Yellow square box) and Click
// on Overview tab

WebDriverWait wait = new WebDriverWait(driver, 10);
WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By
.xpath("//i[@class='fa fa-edit'][1]")));
el.click();
;

driver.findElement(
By.xpath("//input[@name='cHRfcmV2aWV3cy5yZXZpZXdfbmFtZQ--']"))
.clear();

driver.findElement(
By.xpath("//input[@name='cHRfcmV2aWV3cy5yZXZpZXdfbmFtZQ--']"))
.sendKeys("Modified John");

driver.findElement(
By.xpath("//textarea[@name='cHRfcmV2aWV3cy5yZXZpZXdfY29tbWVudA--']"))
.clear();

driver.findElement(
By.xpath("//textarea[@name='cHRfcmV2aWV3cy5yZXZpZXdfY29tbWVudA--']"))
.sendKeys("Modified comments");

WebElement status = driver.findElement(By
.xpath("//select[@name='cHRfcmV2aWV3cy5yZXZpZXdfc3RhdHVz']"));

Select currentstatus = new Select(status);

if (currentstatus.equals("Yes")) {

currentstatus.selectByVisibleText("No");

}

else {

currentstatus.selectByVisibleText("Yes");

}

// 4. Change the ratings of each field.

driver.findElement(By.xpath("//a[contains(text(),'Overall')]")).click();

// Review Clean*

WebElement reviewclean = driver.findElement(By
.xpath("//select[@name='cHRfcmV2aWV3cy5yZXZpZXdfY2xlYW4-']"));

Select reviewcleanrating = new Select(reviewclean);

reviewcleanrating.selectByVisibleText("4");

Thread.sleep(2000);

// Review Comfort*

WebElement reviewcomfort = driver
.findElement(By
.xpath("//select[@name='cHRfcmV2aWV3cy5yZXZpZXdfY29tZm9ydA--']"));

Select reviewcomfortrating = new Select(reviewcomfort);

reviewcomfortrating.selectByVisibleText("2");

Thread.sleep(2000);

// Review Location*

WebElement reviewlocation = driver
.findElement(By
.xpath("//select[@name='cHRfcmV2aWV3cy5yZXZpZXdfbG9jYXRpb24-']"));

Select reviewlocationrating = new Select(reviewlocation);

reviewlocationrating.selectByVisibleText("4");

Thread.sleep(2000);

// Review Facilities*

WebElement reviewfacilities = driver
.findElement(By
.xpath("//select[@name='cHRfcmV2aWV3cy5yZXZpZXdfZmFjaWxpdGllcw--']"));

Select reviewfacilitiesrating = new Select(reviewfacilities);

reviewfacilitiesrating.selectByVisibleText("4");

Thread.sleep(2000);

// Review Staff*

WebElement reviewstaff = driver.findElement(By
.xpath("//select[@name='cHRfcmV2aWV3cy5yZXZpZXdfc3RhZmY-']"));

Select reviewstaffrating = new Select(reviewstaff);

reviewstaffrating.selectByVisibleText("5");

Thread.sleep(2000);

driver.findElement(By.xpath("//a[contains(text(),'Save & Return')]"))
.click();

Thread.sleep(5000);

WebElement reviewtable1 = driver
.findElement(By
.xpath("//table[@class='xcrud-list table table-striped table-hover']"));

WebElement overallNew = reviewtable1
.findElement(By
.xpath("//table[@class='xcrud-list table table-striped table-hover']/tbody/tr[1]/td[7]"));

String overallNewstr = overallNew.getText();

System.out.println(overallNewstr);

// 5. Verify if the rating is changed as overall as compared to the
// previous rating of that tour.

if (overallOldstr.equals(overallNewstr)) {

System.out.println("Ratings unchanged");

}

else {

System.out.println("Ratings changed");
}
driver.findElement(By.xpath("//*[@id='logout']/a")).click();
}

}
