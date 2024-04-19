package pages;

import com.mongodb.DBRef;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class TeknosaPage {

    public TeknosaPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAndroidDriver()),this);
    }

    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText']")
    public WebElement markaKutusu;

    @AndroidFindBy(xpath = "//*[@text='Sonuçları Göster']")
    public WebElement sonuclariGosterButonu;

    @AndroidFindBy(xpath = "//*[@bounds='[75,686][114,725]']")
    public WebElement kutucuk;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.TextView'])[9]")
    public WebElement birinciUrunFiyati;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.TextView'])[13]")
    public WebElement ikinciUrunFiyati;

    @AndroidFindBy(xpath = "//*[@bounds='[27,762][514,1276]']")
    public WebElement enUcuzSamsung;

    @AndroidFindBy(xpath = "//*[@text='Sepete Ekle']")
    public WebElement sepeteEkleButonu;

    @AndroidFindBy(xpath = "//*[@text='Sepetime Git']")
    public WebElement sepetimeGitButonu;

    @AndroidFindBy(xpath = "//*[@text='+']")
    public WebElement artiButonu;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.TextView'])[7]")
    public WebElement urunFiyati;



}
