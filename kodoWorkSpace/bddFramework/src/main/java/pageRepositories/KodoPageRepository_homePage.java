package pageRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rootClass.Rootclass;

public class KodoPageRepository_homePage extends Rootclass {
	
	
	public KodoPageRepository_homePage(WebDriver driver) {
    this.driver = driver;
// This initElements method will create all WebElements
    PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'REGISTER')]")
	public WebElement regiterButton;
	
	public WebElement resgi(){
		return regiterButton;
	}
	
	public void clickRegiterButton(){
		regiterButton.click();
}
	

}
