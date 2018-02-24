package com.example;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ExampleSteps {

    public WebDriver driver;


    @Given("^I want to open QAERP$")
    public void i_want_to_open_QAERP() throws Throwable {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Documents\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://qaerp.franciscanecare.net/Secure/");
        driver.manage().window().maximize();


    }

    @When("^the username is \"([^\"]*)\"$")
    public void the_username_is(String arg1) throws Throwable {
        driver.findElement(By.id("txtUserName")).sendKeys(arg1);
    }

    @When("^password is \"([^\"]*)\"$")
    public void password_is(String arg1) throws Throwable {
        driver.findElement(By.id("txtPassword")).sendKeys("Admin#franciscan");
    }

    @Then("^user should get entry to ERP$")
    public void user_should_get_entry_to_ERP() throws Throwable {
        //driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
        Thread.sleep(4000);
        driver.findElement(By.id("btnLogin")).sendKeys("vbKeyLButton 1");

    }

    @Then("^Click on Stock ERP$")
    public void click_on_Stock_ERP() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"form1\"]/div[4]/div/div/div/div/div[3]/a/img")).click();

        //Open Global Masters-> Define Item Category
    }

    @Given("^Open Define Category$")
    public void open_Define_Category() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"form2\"]/div[4]/div/ul/li[1]/a")).click();

        driver.findElement(By.xpath("//*[@id=\"form2\"]/div[4]/div/ul/li[1]/ul/li[2]/a")).click();

    }

    @When("^Text field is selected as category name$")
    public void text_field_is_selected_as_category_name() throws Throwable {

        //Switch Frame
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"Define Item Category \"]")));

        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtItemCatg_TextBox\"]")).sendKeys("MAIN STOCK");

    }

    @When("^Description is Selected$")
    public void description_is_Selected() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtDescriptiion_TextBox\"]")).sendKeys("Testing");
    }


    @Then("^Click Save$")
    public void click_Save() throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_BtnControls1_btnSave\"]")).click();
        driver.switchTo().defaultContent();
        String actual_msg = driver.findElement(By.id("defaultSpeechbubbleHeader")).getText();
        System.out.println(actual_msg);

        //Assert.assertEquals("actual_msg");
        Assert.assertEquals("MAIN STOCK already exist", actual_msg);

        //switch of default frame
        driver.switchTo().defaultContent();
        driver.close();
    }

    @Given("^item subcategory page is open$")
    public void item_subcategory_page_is_open() throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"form2\"]/div[4]/div/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"form2\"]/div[4]/div/ul/li[1]/ul/li[3]/a")).click();
        //Switch Frame
        driver.switchTo().frame(driver.findElement((By.xpath("//*[@id=\"Define Items Sub Category\"]"))));
    }

    @When("^category is selected$")
    public void category_is_selected() throws Throwable {
        new Select(driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlItemCatName\"]"))).selectByIndex(3);

    }

    @Then("^enter subcategory$")
    public void enter_subcategory() throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtItemSubCat_TextBox\"]")).sendKeys("TEST1");
    }

    @Then("^click save$")
    public void click_save() throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_BtnControls1_btnSave\"]")).click();
        Thread.sleep(3000);

        driver.close();
    }


    @Given("^define item page is open$")
    public void define_item_page_is_open() throws Throwable {
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[@id=\"form2\"]/div[4]/div/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"form2\"]/div[4]/div/ul/li[1]/ul/li[5]/a")).click();

        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"Define Item\"]")));

        //Select Item Category

       // new Select(driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlItemCategory\"]"))).selectByIndex(4);
      //  Thread.sleep(2000);
    }

    @Then("^select item category$")
    public void select_item_category() throws Throwable {

        new Select(driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlItemCategory\"]"))).selectByIndex(8);


    }

     @Then("^select item subcategory$")
    public void select_item_subcategory() throws Throwable {

         Thread.sleep(500);
        Select d= new Select(driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlItemSubCat\"]")));
        d.selectByIndex(1);

        System.out.println("The selected value is :" + d.getFirstSelectedOption().getText());


    }

    @Then("^Enter Item Name$")
    public void enter_Item_Name() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtItemName_TextBox\"]")).sendKeys("Auto Test");

    }

    @Then("^Enter Item code$")
    public void enter_Item_code() throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtItemCode_TextBox\"]")).sendKeys("AI-01");

    }

    @Then("^Select Unit$")
    public void select_Unit() throws Throwable {
        new Select(driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlUnit\"]"))).selectByIndex(6);

    }

    @Then("^Enter Max Qty$")
    public void enter_Max_Qty() throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtMinQty_TextBox\"]")).sendKeys("10");

    }

    @Then("^Enter Min Qty$")
    public void enter_Min_Qty() throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtMaxQty_TextBox\"]")).sendKeys("100");

    }

    @Then("^Select Item Type$")
    public void select_Item_Type() throws Throwable {

        new Select(driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlItemType\"]"))).selectByIndex(1);


        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_BtnControls1_btnSave\"]")).click();
        Thread.sleep(3000);

        driver.close();
    }

    @Given("^Define unit page is open$")
    public void define_unit_page_is_open() throws Throwable {

        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[@id=\"form2\"]/div[4]/div/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"form2\"]/div[4]/div/ul/li[1]/ul/li[4]/a")).click();
    }

    @Then("^Enter Unit Name$")
    public void enter_Unit_Name() throws Throwable {

        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"Define Unit\"]")));

        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtUnitName_TextBox\"]")).sendKeys("Numbers");

    }

    @Then("^Enter Description$")
    public void enter_Description() throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtShortName_TextBox\"]")).sendKeys("Noss");


        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_BtnControls1_btnSave\"]")).click();
        Thread.sleep(3000);

        driver.close();
    }

    @Given("^Define Brand Form is Open$")
    public void define_Brand_Form_is_Open() throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"form2\"]/div[4]/div/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"form2\"]/div[4]/div/ul/li[1]/ul/li[6]/a")).click();

        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"Define Brand Name\"]")));

    }

    @Then("^Enter the Brand Name$")
    public void enter_the_Brand_Name() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtBrandName_TextBox\"]")).sendKeys("Hitachi");
        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_BtnControls1_btnSave\"]")).click();
        Thread.sleep(3000);

        driver.close();

    }

    //To Test Stock Module

    @Given("^Asset Opening Entry Form is Open$")
    public void asset_Opening_Entry_Form_is_Open() throws Throwable {
        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//*[@id=\"form2\"]/div[4]/div/ul/li[3]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"form2\"]/div[4]/div/ul/li[3]/ul/li[1]/a")).click();
    }

    @Then("^Select Date$")
    public void select_Date() throws Throwable {

        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"Asset Opening Entry\"]")));
        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtOpeningDate_TextBox\"]")).click();
        Thread.sleep(1000);
        new Select(driver.findElement(By.xpath("//*[@id=\"datepick-div\"]/div[3]/div/select[2]")));
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"datepick-div\"]/div[3]/div/select[2]/option[4]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"datepick-div\"]/div[3]/div/select[1]/option[4]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"datepick-div\"]/div[3]/table/tbody/tr[1]/td[7]/a")).click();
        Thread.sleep(3000);


    }

    @Then("^Select Asset Account$")
    public void select_Asset_Account() throws Throwable {
        new Select(driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlAccount\"]"))).selectByIndex(6);

    }

    @Then("^Select Item$")
    public void select_Item() throws Throwable {
        new Select(driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_rptOpening_ddlItemName_0\"]"))).selectByIndex(2);

    }

    @Then("^Select Brand$")
    public void select_Brand() throws Throwable {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_rptOpening_ddlBrandName_0\"]")).click();
        new Select(driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_rptOpening_ddlBrandName_0\"]"))).selectByIndex(2);


    }

    @Then("^Enter Quantity$")
    public void enter_Quantity() throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_rptOpening_txtQty_0_TextBox_0\"]")).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_rptOpening_txtQty_0_TextBox_0\"]")).sendKeys("10");

    }

    @Then("^Enter Rate$")
    public void enter_Rate() throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_rptOpening_txtRate_0_TextBox_0\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_rptOpening_txtRate_0_TextBox_0\"]")).sendKeys("100");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_BtnControls1_btnSave\"]")).click();
        Thread.sleep(3000);

        driver.close();

    }

    //To Test Opening Quantity Form

    @Given("^Opening Qty Form is Open$")
    public void opening_Qty_Form_is_Open() throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"form2\"]/div[4]/div/ul/li[3]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"form2\"]/div[4]/div/ul/li[3]/ul/li[2]/a")).click();
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"Opening Qty\"]")));


    }

    @Then("^Select Opening Date$")
    public void select_Opening_Date() throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtOpeningDate_TextBox\"]")).click();
        Thread.sleep(1000);
        new Select(driver.findElement(By.xpath("//*[@id=\"datepick-div\"]/div[3]/div/select[2]")));

        driver.findElement(By.xpath("//*[@id=\"datepick-div\"]/div[3]/div/select[2]/option[4]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"datepick-div\"]/div[3]/div/select[1]/option[4]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"datepick-div\"]/div[3]/table/tbody/tr[1]/td[7]/a")).click();
        Thread.sleep(1000);


    }

    @Then("^Select Item Name$")
    public void select_Item_Name() throws Throwable {

        new Select(driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_rptOpening_ddlItemName_0\"]"))).selectByIndex(5);


    }

    @Then("^Select Item Brand$")
    public void select_Item_Brand() throws Throwable {
        Thread.sleep(3000);
        new Select(driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_rptOpening_ddlBrandName_0\"]"))).selectByIndex(2);

    }

    @Then("^Enter Qty$")
    public void enter_Qty() throws Throwable {
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_rptOpening_txtQty_0_TextBox_0\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_rptOpening_txtQty_0_TextBox_0\"]")).sendKeys("10");

    }

    @Then("^Enter opening Rate$")
    public void enter_opening_Rate() throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_rptOpening_txtRate_0_TextBox_0\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_rptOpening_txtRate_0_TextBox_0\"]")).sendKeys("200");
        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_BtnControls1_btnSave\"]")).click();
        Thread.sleep(3000);

        driver.close();

    }

    // Purchase order form
    @Given("^Purchase Order Form is Open$")
    public void purchase_Order_Form_is_Open() throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"form2\"]/div[4]/div/ul/li[3]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"form2\"]/div[4]/div/ul/li[3]/ul/li[4]/a")).click();
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"Purchase Order\"]")));


    }

    @Then("^Select Vendor$")
    public void select_Vendor() throws Throwable {

        new Select(driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlVendor\"]"))).selectByIndex(4);
        Thread.sleep(2000);

    }

    @Then("^Item Name and Brand$")
    public void itemNameAndBrand() throws Throwable {


        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_rptOrder_ddlItemName_0\"]")).click();

        new Select(driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_rptOrder_ddlItemName_0\"]"))).selectByIndex(2);

        Thread.sleep(4000);

        new Select(driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_rptOrder_ddlBrandName_0\"]"))).selectByIndex(2);
        Thread.sleep(2000);
    }

    @Then("^Enter Item Quantity$")
    public void enterItemQuantity() throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_rptOrder_txtQty_0_TextBox_0\"]")).clear();
        Thread.sleep(2000);


        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_rptOrder_txtQty_0_TextBox_0\"]")).sendKeys("10");

        Thread.sleep(1000);
    }

    @And("^Enter Item Rate$")
    public void enterItemRate() throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_rptOrder_txtRate_0_TextBox_0\"]")).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_rptOrder_txtRate_0_TextBox_0\"]")).sendKeys("200");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_BtnControls1_btnSave\"]")).click();

        Thread.sleep(2000);

        driver.close();
    }

    //Stock In Entry Form
    @Given("^The Stock In Entry Form Is Open$")
    public void theStockInEntryFormIsOpen() throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"form2\"]/div[4]/div/ul/li[3]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"form2\"]/div[4]/div/ul/li[3]/ul/li[6]/a")).click();
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"Stock In Entry\"]")));
        Thread.sleep(200);
        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_UpAll\"]")).click();
        Thread.sleep(300);

    }

    @Then("^Select the Receipt Date$")
    public void selectTheReceiptDate() throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlVoucherDate_TextBox\"]")).clear();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlVoucherDate_TextBox\"]")).sendKeys("23-Feb-2018");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_UpAll\"]")).click();
        Thread.sleep(500);



        /*WebElement dateWidget = driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlVoucherDate_TextBox\"]"));
        List<WebElement> columns = dateWidget.findElements(By.xpath("//*[@id=\"datepick-div\"]/div[3]/table/tbody/tr[4]/td[5]"));

        for (WebElement cell : columns) {
            //Select 13th Date
            if (cell.getText().equals("13")) {
                cell.findElement(By.linkText("13")).click();
                break;


            }
            System.out.println("The value printed is :" + cell.getText());
        }*/
    }

    @And("^Select the Vendor from list$")
    public void selectTheVendorFromList() throws Throwable {

        new Select(driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlVendor\"]"))).selectByIndex(10);

        Thread.sleep(500);
    }

    @And("^Select Item from the list$")
    public void selectItemFromTheList() throws Throwable {

        new Select(driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_rptStockInEntry_ddlItemName_0\"]"))).selectByIndex(10);
        Thread.sleep(500);


    }

    @And("^Select the Item Brand$")
    public void selectTheItemBrand() throws Throwable {

        new Select(driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_rptStockInEntry_ddlBrand_0\"]"))).selectByIndex(1);

    }

    @Then("^Enter the Item In Quantity$")
    public void enterTheItemInQuantity() throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_rptStockInEntry_txtInQty_0_TextBox_0\"]")).clear();
        Thread.sleep(200);
        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_rptStockInEntry_txtInQty_0_TextBox_0\"]")).sendKeys("10");
        Thread.sleep(200);
        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_rptStockInEntry_lblRate_0_TextBox_0\"]")).clear();
        Thread.sleep(200);
        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_rptStockInEntry_lblRate_0_TextBox_0\"]")).sendKeys("100");
    }

    @And("^Enter the Item rate$")
    public void enterTheItemRate() throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_rptStockInEntry_lblRate_0_TextBox_0\"]")).clear();
        Thread.sleep(200);
        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_rptStockInEntry_lblRate_0_TextBox_0\"]")).sendKeys("100");
        Thread.sleep(500);
        driver.close();
    }

    // With Stock In
    @Then("^Select the With Stock In Option$")
    public void selectTheWithStockInOption() throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_UpAll\"]/div[2]/div/div[2]/span[1]/label")).click();
        Thread.sleep(500);
    }

    @And("^Select Purchase Order Number$")
    public void selectPurchaseOrderNumber() throws Throwable {

        Select D = new Select(driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlPurchaseOrderNo\"]")));
        D.selectByIndex(1);
        System.out.println("Selected value under Purchase order no. is " +D.getFirstSelectedOption().getText() );
    }

    @Then("^Enter the Stock In Item Qty$")
    public void enterTheStockInItemQty() throws Throwable {
        WebElement Q = driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_rptStockInEntry_txtItemOrderQty_0\"]"));
        String p= Q.getAttribute("value");
        System.out.println("The valueis" + p);

        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_rptStockInEntry_txtInQty_0_TextBox_0\"]")).clear();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_rptStockInEntry_txtInQty_0_TextBox_0\"]")).sendKeys(Q.getAttribute("value"));

    }

    @And("^Enter the Stock In Item rate$")
    public void enterTheStockInItemRate() throws Throwable {

    }
}











