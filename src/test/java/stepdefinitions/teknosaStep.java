package stepdefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.TeknosaPage;
import utils.Driver;
import utils.ReusableMethods;

import java.io.IOException;

public class teknosaStep {

    AndroidDriver driver = Driver.getAndroidDriver();
    TeknosaPage teknosaPage = new TeknosaPage();


    @Given("Uygulama baslatilir")
    public void uygulama_baslatilir() {
        Driver.getAndroidDriver();

    }

    @Given("ilk ekran bolumunden {string} tiklanir")
    public void ılk_ekran_bolumunden_atlaya_tiklanir(String girisSecenegi) {
        ReusableMethods.scrollWithUiScrollableAndClick(girisSecenegi);

    }

    @Given("footer bolumunden {string} bolumune tiklanir")
    public void kategoriler_bolumune_tiklanir(String footerSecenek) {
        ReusableMethods.scrollWithUiScrollableAndClick(footerSecenek);

    }

    @Given("kategoriler bolumunden {string} bolumune tiklanir")
    public void kategoriler_bolumunden_telefon_bolumune_tiklanir(String kategoriTuru) {
        ReusableMethods.scrollWithUiScrollableAndClick(kategoriTuru);

    }

    @Given("telefon sayfasindan cihaz secimi {string} yapilir")
    public void telefon_sayfasindan_cihaz_secimi_yapilir(String cihazIsmi) {
        ReusableMethods.scrollWithUiScrollableAndClick(cihazIsmi);

    }

    @Given("cep telefonu sayfasinda {string} bolumune tiklanir")
    public void filtrele_bolumune_tiklanir(String cepTelefonuBolumu) {
        ReusableMethods.scrollWithUiScrollableAndClick(cepTelefonuBolumu);

    }

    @Given("filtrele sayfasindan herhangi bir {string} filtreleme yapilir")
    public void marka_bolumunden_marka_secimi_yapilir(String filtrelemeTuru) {
        ReusableMethods.scrollWithUiScrollableAndClick(filtrelemeTuru);

    }

    @Given("marka bolumunden bir cihaz {string} filtrelemesi yapilir")
    public void marka_bolumunden_bir_cihaz_filtrelemesi_yapilir(String cihazIsmi) {
        teknosaPage.markaKutusu.sendKeys(cihazIsmi);
        teknosaPage.kutucuk.click();
        teknosaPage.sonuclariGosterButonu.click();
    }

    @Given("siralama sayfasindan {string} siralamasi secilir")
    public void siralama_yapilirak_azalan_fiyat_secilir(String siralamaIsmi) {
        ReusableMethods.scrollWithUiScrollableAndClick(siralamaIsmi);

    }

    @Given("fiyatlarin azalan duzende oldugu test edilir")
    public void fiyatlarin_azalan_duzende_oldugu_test_edilir() {
        ReusableMethods.wait(3);
        ReusableMethods.ekranKaydirmaMethodu(530,2032,750,530,667);
        String birinciUrunFiyatiText = teknosaPage.birinciUrunFiyati.getText();
        String ikinciUrunFiyatiText = teknosaPage.ikinciUrunFiyati.getText();

        birinciUrunFiyatiText = birinciUrunFiyatiText.replaceAll("\\D","");
        ikinciUrunFiyatiText = ikinciUrunFiyatiText.replaceAll("\\D","");

        Assert.assertTrue(Integer.parseInt(birinciUrunFiyatiText) > Integer.parseInt(ikinciUrunFiyatiText));

    }

    @Given("en ucuz cihaz a tiklanir")
    public void en_ucuz_cihaz_a_tiklanir() {
        teknosaPage.enUcuzSamsung.click();

    }

    @Given("cihaz sepete eklenir")
    public void cihaz_sepete_eklenir() {
        teknosaPage.sepeteEkleButonu.click();

    }

    @Given("sepetime git bolumune tiklanir")
    public void sepetime_git_bolumune_tiklanir() {
        teknosaPage.sepetimeGitButonu.click();
        ReusableMethods.wait(2);
    }

    @Given("urunun sayisi arttirildiginda fiyatinin arttirildigi dogrulanir")
    public void urunun_sayisi_arttirildiginda_fiyatinin_arttirildigi_dogrulanir() {
        String urununIlkFiyati = teknosaPage.urunFiyati.getText();
        urununIlkFiyati = urununIlkFiyati.replaceAll("\\D","");
        urununIlkFiyati = urununIlkFiyati.substring(0,urununIlkFiyati.length()-2);
        teknosaPage.artiButonu.click();

        ReusableMethods.wait(4);

        String urununIkinciFiyati = teknosaPage.urunFiyati.getText();
        urununIkinciFiyati = urununIkinciFiyati.replaceAll("\\D","");
        urununIkinciFiyati = urununIkinciFiyati.substring(0,urununIkinciFiyati.length()-2);

        Assert.assertEquals(Integer.parseInt(urununIkinciFiyati),Integer.parseInt(urununIlkFiyati)*2);

    }

    @Given("kullanici cekmek istedigi elementin {string} screen shotini alir")
    public void kategori_bolumunun_screen_shoti_alinir(String elementXpath) throws IOException {
        ReusableMethods.screenShotElement(elementXpath);

    }

}
