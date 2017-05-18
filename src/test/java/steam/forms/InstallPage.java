package steam.forms;

import framework.BrowserFactory;
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
public class InstallPage extends BasePage{
    WebDriver driver;
    String setupFileLocator = "//span[text()='Установить Steam']";
   /* File f = new File("имя_файла");
    long len = f.length();*/

    public InstallPage() {
        this.driver = getDriver();
    }
    public void clickOnSetUpFile(){
       // BrowserFactory.waitElementsExplicide(setupFileLocator);
     //  driver.findElement(setupFileLocator).click();
       try {
            URL url = new URL("https://steamcdn-a.akamaihd.net/client/installer/SteamSetup.exe");

            String loginAndPassword = "login" + ":" + "password";

            String encoding = Base64.getEncoder().encodeToString(
                    loginAndPassword.getBytes());

            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoding);

            InputStream content = (InputStream) connection.getInputStream();
            File file = new File("src/test/resources/steam.exe");
            OutputStream out = new FileOutputStream(file);
            IOUtils.copy(content, out);
            content.close();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
