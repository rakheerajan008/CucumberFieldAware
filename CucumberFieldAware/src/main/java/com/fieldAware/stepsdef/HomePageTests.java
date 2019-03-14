package com.fieldAware.stepsdef;

import java.util.concurrent.TimeUnit;

import cucumber.api.java.After;

import com.fieldAware.browser.Browser;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;

public class HomePageTests {
	HomePage homepage;
	public String[] expectedMenuItems;
	public String[] expectedSubMenuItem;
	 @Before
	    public void setUp() {
	    	Browser.init();
	    	Browser.instance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    }
	 @After
	    public void tearDown() {
	    	Browser.quit();
	    }
	 @Given("the user is on Home page")
	    public void the_user_is_on_Home_page() {
	    	homepage = HomePage.goTo();
	    }
	 
	   
	  
	    
	    
	    @When("he expects the following menu item: \"([^\"]*)\"")
	    public void he_expects_the_following_menu_item(String menuItem) {
	    	expectedMenuItems = menuItem.split(",");
	    }
	  
	  @Then("ensure the Menu Items are Displayed")
	    public void ensure_the_Menu_Items_are_Displayed() {
	    	HomePage.isNavigationMenuDisplayed();
	    }
	  
	  @Then("ensure the sub menus are Displayed: \"([^\"]*)\"")
	    public void ensure_the_subMenuItems_are_Displayed(String subMenus) {
	    	expectedSubMenuItem = subMenus.split(",");
	    	homepage.checkSubMenuDisplayed(expectedMenuItems);
	    }
	  
	  @And("the menu order is as specified")
	    public void the_menu_order_is_as_specified() {
	    	homepage.checkNavigationMenuitemsOrder(expectedMenuItems);
	    }
	  @And("the sub menus order is as specified")
	    public void the_sub_menus_order_is_as_specified() {
	    	homepage.checkSubMenuItemsOrder(expectedMenuItems, expectedSubMenuItem);
	    }
	  
	  
	}