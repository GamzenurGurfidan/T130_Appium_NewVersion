package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "json:target/cucumber.json",},
        features = "src/test/resources/mobileTest",
        glue = "stepdefinitions",
        tags = "@teknosa",
        dryRun = true


        /*
        Eger dryRun true ise; Features da olusturmus oldugumuz steplerin stepdefinitions da olup olmadigini
        kontrol eder. Yani eger features daki stepleri tanimiyorsa eksik adimlari bize soyler
        eger eksik adim yoksa test passed olur ama bu gercek testin passed oldugu anlamina gelmez

        Eger dryRun false ise; artik feature daki adimlari stepdefinitions da eksiksiz oldugunu ve testlerimizin
        kosturulabilir oldugnu ifade eder
         */
)

public class runners {
}
