package pageObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.fieldAware.browser.Browser;

public class HomePage {
	
	public static HomePage goTo()
	{
		Browser.instance.get("http://www.fieldaware.com/");
		Assert.assertTrue(isAt());
		return new HomePage();
	}
	public static boolean isAt() {
		return Browser.instance.getTitle().equalsIgnoreCase("Field Service Management Software by FieldAware");
	}

	public static boolean isNavigationMenuDisplayed() {
		if (Browser.instance.findElement(By.xpath("//*[@id=\"navbar-collapse-1\"]/ul")).isDisplayed())
			return true;
		else
			return false;

	}

	public void checkNavigationMenuitemsOrder(String[] expectedMenuItems) {
		List<WebElement> navigationMenu =
				Browser.instance.findElements(By.xpath("//ul[@class='nav navbar-nav pull-right-sm nav-list']/li/a"));
				List<String> el = new ArrayList<String>();

				for (Iterator<WebElement> i = navigationMenu.iterator(); i.hasNext();) {
					WebElement e = i.next();

					el.add(e.getAttribute("title"));
				}
				String[] eOnpage = el.toArray(new String[el.size()]);

				for (int i = 0; i < eOnpage.length; i++) {
					Assert.assertTrue(eOnpage[i].equals(expectedMenuItems[i].trim()));
				}
			}
	public void checkSubMenuDisplayed(String[] menu) {

		for (int i = 0; i < menu.length; i++) {
			if (menu[i].trim().equals("Why FieldAware") || menu[i].trim().equals("Get a Demo")) {
				continue;
			}
			ClickMenu(menu[i].trim());
			Assert.assertTrue(isSubMenuDisplayed(menu[i].trim()));

		}
		
	}
	public void ClickMenu(String menu) {
		 
		Browser.instance.findElement(By.xpath("//a[@title='" + menu + "']")).click();
	}
	private boolean isSubMenuDisplayed(String menuItem) {

		return Browser.instance.findElement(By.xpath("//a[@title='" + menuItem + "']//../ul[@class='dropdown-menu']"))
				.isDisplayed();
	}
	private String[] getSubMenuItems(String menu) {
		ClickMenu(menu);

		List<WebElement> subMenus = Browser.instance
				.findElements(By.xpath("//a[@title='" + menu + "']//../ul//li[contains(@class, 'navigation-item white-link')]//a"));

		List<String> el = new ArrayList<String>();

		for (Iterator<WebElement> i = subMenus.iterator(); i.hasNext();) {
			WebElement e = i.next();

			el.add(e.getAttribute("title"));
		}
		String[] subMenuTitles = el.toArray(new String[el.size()]);

		return subMenuTitles;
	}
	public void checkSubMenuItemsOrder(String[] expectedMenuItem, String[] expectedSubMenuItems) {
 
			for (int i = 0; i < expectedMenuItem.length; i++) {
				String[] actual = getSubMenuItems(expectedMenuItem[i].trim());

				for (int j = 0; j < expectedSubMenuItems.length; j++) {
					Assert.assertTrue(expectedSubMenuItems[j].trim().equals(actual[j].trim()));
				}

			}
			 
		}
	
	}
	
	

