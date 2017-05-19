package steam.forms;

import framework.BaseElement;

import framework.Button;
import framework.services.CommonFunctions;
import framework.services.HttpUtils;
import org.openqa.selenium.By;


import java.util.Properties;


public class InstallPage extends BasePage {

    private static final String LOCATOR = "//div[@id='about_greeting_ctn']//*//a[@id='about_install_steam_link']";

    private static final String DOWNLOAD_FILEPATH_KEY = "downloadFilePath";

    Button btnDownload;
    public InstallPage() {

    }

    public boolean isFullDownload() {

        btnDownload = new Button(By.xpath((LOCATOR)));
        String href =  btnDownload.getAttribute("href");
        Properties properties = getProperties();
        String filePath = properties.getProperty(DOWNLOAD_FILEPATH_KEY);
        CommonFunctions commonFunctions = new CommonFunctions();
        HttpUtils utils = new HttpUtils();
        long size = utils.getSizeOfContent(href, filePath);
        return commonFunctions.isFullDownLoad(filePath, size);


    }
}
