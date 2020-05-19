package stepDefinition;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageRepositories.KodoPageRepository_homePage;
import rootClass.Rootclass;
import utility.ActionsClass;

public class KodoStepDefinition extends Rootclass {

	KodoPageRepository_homePage homePage = new KodoPageRepository_homePage();
	ActionsClass act = new ActionsClass();

	@Given("^I launch the URL$")
	public void I_launch_url() throws Throwable {
		act.launchUrl();
	}

	@Then("^Checking search bar availablity$")
	public void check_search_bar_availablity() throws Throwable {
		act.isEnbleAndDisplay(homePage.searchTextbox);
		act.isEnbleAndDisplay(homePage.searchIcon);
	}

	@Then("^Checking Search bar input validations$")
	public void search_bar_input_validations() throws Throwable {

		String alpha = "Demo";
		String num = "123";
		String spl = "!@#$";
		String aphanumspl = alpha + num + spl;

		// Alphabets
		homePage.typeInSearchTextbox(alpha);
		Assert.assertEquals(alpha, homePage.searchTextbox.getAttribute("value"));
		homePage.searchTextbox.clear();

		// Numeric
		homePage.typeInSearchTextbox(num);
		Assert.assertEquals(num, homePage.searchTextbox.getAttribute("value"));
		homePage.searchTextbox.clear();

		// special characters
		homePage.typeInSearchTextbox(spl);
		Assert.assertEquals(spl, homePage.searchTextbox.getAttribute("value"));
		homePage.searchTextbox.clear();

		// alpha numeric & special characters
		homePage.typeInSearchTextbox(aphanumspl);
		Assert.assertEquals(aphanumspl, homePage.searchTextbox.getAttribute("value"));
		homePage.searchTextbox.clear();

	}

	@Then("^Checking Search bar functional behaviour using \"([^\"]*)\" and \"([^\"]*)\"$")
	public void search_bar_functional_behaviour(String validText1 ,String inValidText) throws Throwable {

		// Enter 2 character and check for suggestion drop down
		homePage.typeInSearchTextbox("pr");
		Assert.assertEquals(false, act.isEnbleAndDisplay(homePage.suggestionDropDown));
		homePage.searchTextbox.clear();

		// Enter 3 character and check for suggestion drop down
		homePage.typeInSearchTextbox("pri");
		Assert.assertEquals(true, act.isEnbleAndDisplay(homePage.suggestionDropDown));
		homePage.searchTextbox.clear();

		// Click on the search Icon without entering any text
		homePage.clickSearchIcon();
		Assert.assertEquals("Please enter a search keyword", homePage.warningMsgTexteleGetText().trim());

		// Enter some product name which is not there in the website and search
		
		homePage.typeInSearchTextbox(inValidText);
		homePage.clickSearchIcon();
		Assert.assertEquals("No results were found for your search \"" + inValidText + "\"",
				homePage.warningMsgTexteleGetText().trim());

		// Enter some valid product name
		
		homePage.typeInSearchTextbox(validText1);
		Thread.sleep(5000);

		// Click on search
		// Type partial name of a valid product and click on search
		// Now check the search bar for text box value
		// Type partial name of a valid product and check the no of suggestions
		// with the no of search results
		int sugCount = homePage.suggestionListCount();
		homePage.clickSearchIcon();
		Assert.assertEquals("\"PRINTED SUMMER DRESS\"", homePage.searchResultTextGetText());
		Assert.assertEquals("Search", homePage.searchTextbox.getAttribute("placeholder"));
		Assert.assertEquals(homePage.searchResultCounter(), sugCount);

		// Type a product name and check the product name is available in the
		// suggestions list
		
		String validText2= "Print";
		homePage.typeInSearchTextbox(validText2);
		Thread.sleep(5000);
		for (int i = 0; i < (homePage.suggestionListText().size()-1); i++) {
			Assert.assertEquals(homePage.suggestionListText().get(i).contains(validText2), true);
		}
		// Check the suggestion are prefixed with the category names
		
		for (int i = 0; i < (homePage.suggestionListText().size()-1); i++) {
			Assert.assertEquals(homePage.suggestionListText().get(i).contains(">"), true);
		}

	}

}
