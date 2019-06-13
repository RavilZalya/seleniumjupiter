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

import java.util.List;

public class SnackBarr extends Element {

	private WebDriverController wdController;
	private String statusPassIcon = "fa-check-circle";
	private String statusErrorIcon = "fa-window-close";
	
	public String userAlreadyExistsMessage = " User '%s' already exists ";

    @FindBy(xpath = "//div[contains(@class, 'snackbar')]//div[contains(@class, 'message')]/i")
    WebElement message;

    @FindBy(xpath = "//div[contains(@class, 'snackbar')]//i[contains(@class, 'fa-times')]")
    WebElement closeIcon;
    
    @FindAll({ @FindBy(xpath = "//div[contains(@class, 'snackbar')]//i") })
    List<WebElement> icons;

	public SnackBarr(WebDriverController wdController) {
		super(wdController, "//app-snack");
	}

	public String getMessage() {
    	return wdController.waitElementToBeInvisible(message) ? message.getText() : null;
    }
    
    public String getStatus() {
    	
    	if (wdController.waitElementToBeVisible(icons.get(0))) {
    		
    		if (icons.get(0).getAttribute("class").contains(statusErrorIcon))
    			return "error";
    		else if (icons.get(0).getAttribute("class").contains(statusPassIcon))
    			return "pass";
    		else
    			return null;
    	}
    	else
    		return null;
    }
    
}
