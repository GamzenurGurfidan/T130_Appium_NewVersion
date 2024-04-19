package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static AndroidDriver appiumDriver;
    private static AppiumDriver appiumDriver2;
    private static IOSDriver iosDriver;

    static final String TELEFONADI = "Galaxy A54 5G";
    static final String ANDROIDVERSION = "10.0";
    static final String PLATFORM = "Android";
    static final String OTOMASYON_ISMI = "UiAutomator2";


    public static AndroidDriver getAndroidDriver() {
        URL appiumServerURL = null;
        try {
            appiumServerURL = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (appiumDriver == null) {

            UiAutomator2Options options = new UiAutomator2Options();

            options
                    .setAppPackage("com.tmob.teknosa")
                    .setAppActivity("com.tmob.teknosa.MainActivity")
                    // .setApp("C:\\Users\\Gamzenur\\IdeaProjects\\Appium_NewVersion\\Apps\\Teknosa – Alışveriş, Teknoloji_7.1.4_Apkpure.apk")
                    .setUdid("emulator-5556")
            // terminale "adb devices" yazarak cihazlarin kimlik nosuna ulaşiriz
            // kopyalayarak hangi cihaz uzerinde calismakl istiyorsak onun Udid'sini burada gireriz
                    .setSkipUnlock(true)
            // eger cihazın ekran kilidi kapalıysa ve acilsin istiyorsak
                    // .setLanguage("en")
            // uygulama dilini degistirmek icin
                    .setAutoGrantPermissions(true)
            // kullanici tarafindan verilmesi gereken izinleri kabul eder
                    .setNoReset(false)
            // uygulama ayarlari sifirlanacak mı sifirlanmayacak mı
                    // .setFullReset(false)
            // cihaz her seferinde fabrika ayarlarina geri döner // false tam tersi
                    // .withBrowserName("chrome")
                    // .setChromedriverExecutable("")

            ;


            if (ConfigReader.getProperty("platformName").equals("Android")) {

                assert appiumServerURL != null;
                appiumDriver = new AndroidDriver(appiumServerURL, options);
                appiumDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            } else {

                assert appiumServerURL != null;
                iosDriver = new IOSDriver(appiumServerURL, options);
                iosDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

                throw new UnsupportedOperationException("Dostum Ios kullanmaya calisiyorsun YAPMA!!");

            }

        }

        return appiumDriver;
    }


    public static void quitAppiumDriver() {
        if (appiumDriver != null) {
            appiumDriver.closeApp();
            appiumDriver = null;
        }
    }
}



