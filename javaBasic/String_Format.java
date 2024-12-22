package javaBasic;

import static java.lang.String.format;

public class String_Format {

    public static  java.lang.String LOGIN_LINK= "//a[@class='ico-login']";

    public static  java.lang.String MY_ACCOUNT_LINK= "//a[@class= 'ico-account']";

    public static  java.lang.String LOGOUT_LINK= "//a[@class='ico-logout']";

    public static  java.lang.String DYNAMIC_POINT_LINK= "//a[@class='%s']";


    public static  java.lang.String DYNAMIC_PAGE_LINK= "//div[@class='%S]//a[text()='%S]']";


    public static void main(java.lang.String[] args) {
        // clickToHeaderLink(LOGIN_LINK);
        // clickToHeaderLink (MY_ACCOUNT_LINK);
        // clickToHeaderLink2(DYNAMIC_POINT_LINK, "ico-logout");
        // clickToFooterLink(DYNAMIC_PAGE_LINK, "footer-block customer-service", "Search" );

    }

    public static void clickToHeaderLink(java.lang.String locator){
        System.out.println("click to: " + locator);
    }

    // 1 THAM SO ĐỘNG
    public static void clickToHeaderLink2(java.lang.String dynamicLocator, java.lang.String pageName){
        // String locator = String.format(dynamicLocator, pageName);

    }
   // 2 tham số động
    public static void clickToFooterLink(java.lang.String dynamicLocator, java.lang.String areaName, java.lang.String pageName){
        // String locator = String.format(dynamicLocator,areaName, pageName);
    }

    // 1-n tham số động
    public static void clickToLink(java.lang.String dynamicLocator, java.lang.String... params){
        // String locator = String.format(dynamicLocator,(Object[]), params);
    }
}
