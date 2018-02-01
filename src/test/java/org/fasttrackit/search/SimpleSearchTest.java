//I.new project bla bla 2. click 1st folder new file .gitignore .idea *.iml
//3. cand faci un proiect nou trebuie sa google:selenium java maven + copy la dependency + paste in .pomxml
// + updatarea ultimei versiuni de junit [modificarea in ceea ce e scris deja cu ce gasesti pe ggle.
//II. java org.fasttractit new class
//fiecare test va fi o metoda publica

//va fi void ca testul nu va returna nimic, ci doar va face niste actiuni si atat
// "\" tine loc de ghilimele intre ghilimele. escape character
//in pagina click dreapta - inspect. a- ancore e tagul pentru linkuri
//un tag, atribute- keye+valoare


package org.fasttrackit.search;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SourceType;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleSearchTest {

    //transformam metoda intr un test: deasupra metodei punem o adnotare adica @
    @Test
    public void simpleSearchWithOneKeyWord(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\drivers\\chromedriver.exe"); // copy paste erorii pe care am primit o si pasii de pe primul link
        WebDriver driver = new ChromeDriver();
        //deschiderea unei pagini web
        driver.get("https://fasttrackit.org/selenium-test/");
        String keyword = "vase";
        driver.findElement(By.id("search")).sendKeys(keyword  + Keys.ENTER);
        System.out.println("pressed enter in search field");

        List<WebElement> productNames = driver.findElements(By.cssSelector(".product-name a"));
        System.out.println("stored " + productNames.size() + " product names from search results.");


        for(WebElement productname: productNames) {
                        assertThat("some of the product names do not contain the searchedkeyword",
                                productname.getText(), containsString (keyword.toUpperCase()));

        }











        //by. classname- una dintre clase. nu o sa poti si button si search button, ci doar una[din inspect din site]
        //by. linktext - inspect pe add to wishlist- si copiez doar Add to Wishlist, adica textul, nu linkul
        //by. partiallinktext putem da o portiune din acel text: add to wish- iddentifica corect
        //by. name - input, button, orice
        //preferam id, name, classname, linktext. trb sa cautam atributul care e cel mai putin probabil sa fie schimbat in viitor
}
    @Test
    public void specialPriceDisplayAfterSimpleSearch() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\drivers\\chromedriver.exe"); // copy paste erorii pe care am primit o si pasii de pe primul link
        WebDriver driver = new ChromeDriver();
        //deschiderea unei pagini web
        driver.get("https://fasttrackit.org/selenium-test/");
        driver.findElement(By.id("search")).sendKeys("vase" + Keys.ENTER);

        String oldPrice = driver.findElement(By.xpath("//p[@class='old-price']//span[@class='price']")).getText();
        String specialPrice = driver.findElement(By.xpath("//p[@class='special-price']//span[@class='price']")).getText();









        ////div[@class='product-info' and ./descendant::*[@class='product-name' and ./a[text()='Modern Murray Ceramic Vase']]]//p[@class='old-price']//span[@class='price']
       //p[@class='old-price' and ./ancestor::*[.//*[text()='Modern Murray Ceramic Vase']]]//span[@class='price']
    //1.2//same thing
    }
   // if (old>special)
    //daca old?special sa pice testul
       // driver.findElement(By.xpath("//div[@class='product-info' and ./descendant::*[text()='Herald Glass Vase']]//button[contains(@class, 'btn-cart')]")).click();

}

