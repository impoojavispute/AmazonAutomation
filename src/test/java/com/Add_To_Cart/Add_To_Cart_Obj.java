package com.Add_To_Cart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.JavascriptExecutor;

public class Add_To_Cart_Obj

{

	WebDriver driver;

	By all = By.id("searchDropdownBox");

	By search = By.id("twotabsearchtextbox");

	By search_button = By.id("nav-search-submit-button");

	By addtocartbutton = By.id("add-to-cart-button");

	By cart = By.xpath("//*[@id=\"nav-cart\"]/child::div[1]");

	By book = By.id("sc-subtotal-label-activecart");

	Add_To_Cart_Obj(WebDriver d)

	{

		driver = d;

	}

	public void all_dropdown() throws InterruptedException

	{

		WebElement testdropdown = driver.findElement(all);

		Select dropdown = new Select(testdropdown);

		dropdown.selectByVisibleText("Books");

		Thread.sleep(3000);

	}

	public void search(String searchtext)

	{

		driver.findElement(search).sendKeys(searchtext);

	}

	public void searchbutton()

	{

		driver.findElement(search_button).click();

	}

	public void selectbook()

	{

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("scrollBy(0,350)");

		WebElement firstBook = driver.findElement(By.cssSelector("div.s-result-item:nth-child(1)"));

		firstBook.click();

	}

	public void addtocart()

	{

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("scrollBy(0,350)");

		driver.findElement(addtocartbutton).click();

	}

	public void checkcart()

	{

		driver.findElement(cart).click();

		int booklist = driver.findElements(By.xpath("//*[@id=\"a-autoid-0-announce\"]/span[2]")).size();

		if (booklist > 0)

		{

			System.out.println("Item Present");

		}

		else

		{

			System.out.println("Item not present");

		}

	}
	
	
	}
	

