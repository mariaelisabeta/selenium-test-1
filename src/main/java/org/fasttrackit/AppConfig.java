package org.fasttrackit;
//declaram o variabila statica cptr ca is configurari care vrem sa fie valabile pentru orice schimbari din aplicatie; var stabila= aceeasi val pentru oricine oricand o apeleaza
// daca nu e satatica e de instanta
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.openqa.selenium.interactions.SourceType;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {

    private static Properties properties = new Properties();
 //bloc de cod |static|
    //in 1 rand citim datele din fisier
    static {
     InputStream inputStream = AppConfig.class.getClassLoader().getResourceAsStream("production.properties");
  //^ prin get.classLoader stabilesc de unde citesc fisierul
     try {
         properties.load(inputStream);
     } catch (IOException e) {
         e.printStackTrace();
         System.out.println("Could not read properties file.");
     }

     //error> unhandled exception>

    }


    private static String chromeDriverPath = properties.getProperty("chrome.driver.path");
    private static String siteUrl = properties.getProperty("site.url");


     //ca sa ave, acces la astea 2 private trebuie sa encapsulam. facem doar getteri ca sa le vada toata lumea, nu si setteri ca nu mi trebuie sa le modifice

    public static String getChromeDriverPath() {
        return chromeDriverPath;
    }

    public static String getSiteUrl() {
        return siteUrl;
    }
}
