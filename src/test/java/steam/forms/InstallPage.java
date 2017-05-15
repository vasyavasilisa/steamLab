package steam.forms;

import org.apache.commons.io.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

/**
 * Created by v.demyanova on 5/15/17.
 */
public class InstallPage {
    WebDriver driver;
    By setupFileLocator = By.xpath("//span[text()='Установить Steam']");

    public InstallPage(WebDriver webDriver) {
        this.driver = webDriver;
    }
    public void clickOnSetUpFile(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(setupFileLocator));
     //  driver.findElement(setupFileLocator).click();
       try {
            URL url = new URL("https://steamcdn-a.akamaihd.net/client/installer/steam.deb");

            String loginAndPassword = "login" + ":" + "password";

            String encoding = Base64.getEncoder().encodeToString(
                    loginAndPassword.getBytes());

            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoding);

            InputStream content = (InputStream) connection.getInputStream();
            File file = new File("src/test/resources/steam.deb");
            OutputStream out = new FileOutputStream(file);
            IOUtils.copy(content, out);
            content.close();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
