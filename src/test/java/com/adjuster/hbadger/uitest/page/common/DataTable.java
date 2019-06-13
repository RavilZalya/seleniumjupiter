/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.page.common;

import com.adjuster.hbadger.uitest.page.Element;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DataTable extends Element {
	
	private WebDriverController wdController;

	@FindBy(xpath = "//input[contains(@class, 'icon search')]")
	public WebElement searchBar;

	@FindAll({ @FindBy(xpath = "//*[@class='data-table']//*[@class='type-name']") })
	public List<WebElement> searchResults;

	@FindBy(xpath = "//*[contains(@class, 'results')]")
	public WebElement resultsBody;

	@FindBy(xpath = "//*[contains(@class, 'add-new')]")
	public WebElement addNewButton;

	@FindBy(xpath = "//*[contains(@class, 'aj-toggle')]")
	public WebElement showDisabledToggle;

	@FindBy(xpath = "//*[contains(@class, 'show-deactivated')]")
	public WebElement showDisabledLabel;

	@FindAll({ @FindBy(xpath = "//button[contains(@class, 'sort-header-button')]") })
	public List<WebElement> sortHeaders;

	@FindAll({ @FindBy(xpath = "//cdk-header-cell[contains(@class, 'cdk-heading-title')]") })
	public List<WebElement> nonSortHeaders;

	@FindAll({ @FindBy(xpath = "//*[contains(@class, 'cdk-cell')]") })
	public List<WebElement> cells;

	@FindAll({ @FindBy(xpath = "//*[contains(@class, 'data-table')]//a") })
	public List<WebElement> anchors;


	public DataTable(WebDriverController wdController) {  //Given there is searchbar, addnew button etc. not sure what this element is. not the same as Table element
		super(wdController, "//div[@class='content']");			  // for now will set container xpath to the root html so it alaways gets found
	}
}
