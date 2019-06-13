/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.page.common;

import com.adjuster.hbadger.uitest.page.Element;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Represent a table.
 */
public class Table extends Element {

    private int rows;
    private int columns;

    @FindBy(how = How.XPATH, using = ".//cdk-header-cell")
    protected List<WebElement> headers;
    private final By sorter = By.xpath(".//*[contains(@class,'mat-sort-header-container')]/..");
    private final By filter = By.xpath(".//*[contains(@class,'fa-filter')]");

    public Table(WebDriverController wdController) {
        super(wdController, "//div[@class='data-table']");
        columns = headers.size();
        rows = wdController.findVisibleElements(column(0)).size();
    }

    public int getNumberOfColumns() {
        return columns;
    }

    public int getNumberOfRows() {
        return rows;
    }

    /**
     * Click on a cell in a specified row/column. Accepts column index and cell string content as input.
     */
    public void open(String column, String cell) {
        int index = wdController.getIndex(getColumnCellElements(column), cell);
        getColumnCellElements(column).get(index).click();
    }

    /**
     * Opens column filter dropdown.
     */
    public SearchableDropdown filter(String column) {
        int columnIdx = wdController.getIndex(headers, column);
        getFilter(columnIdx).click();
        return new SearchableDropdown(wdController);
    }

    /**
     * Sorts table on a column. Accepts column label as input. Subclass will implement method to return its object.
     */
    public Table sort(String column) {
        int columnIdx = wdController.getIndex(headers, column);
        getSorter(columnIdx).click();
        return this;
    }

    /**
     * Checks if column is sorted.
     */
    public boolean isSorted(String column) {
        return !getSortOrder(column).equalsIgnoreCase("unsorted");
    }

    /**
     * Checks if column has active filters.
     */
    public boolean isFilered(String column) {
        return headers.get(wdController.getIndex(headers, column)).getAttribute("class").contains("inactive");
    }

    public boolean columnContainsLabel(String columnLabel, String label) {
        return wdController.exists(getColumnCellElements(columnLabel), label);
    }

    /**
     * Returns sorting order for a column. Can be: 'ascending', 'descending' or 'unsorted'.
     */
    private String getSortOrder(String column) {
        int columnIdx = wdController.getIndex(headers, column);
        String ariaSorting = getSorter(columnIdx).getAttribute("aria-sort");
        return ariaSorting == null ? "unsorted" : ariaSorting;
    }

    /**
     * Represents a By locator for a cells of a given column. This needs to be dynamically modified by adding array index.
     * Returns a locator which is used in getCellsForAColumn(int columnIdx).
     */
    protected By column(int columnIdx) {
        return By.xpath("//cdk-cell[" + (columnIdx + 1) + "][contains(@class,'cdk-column-')][not(contains(@class,'expandedDetail'))]");
    }

    /**
     * Returns a header element based on index.
     */
    private WebElement getColumnHeader(int columnIdx) {
        return headers.get(columnIdx);
    }

    /**
     * Returns a sorter in a given header element.
     */
    private WebElement getSorter(int columnIdx) {
        return wdController.findNestedElements(getColumnHeader(columnIdx), sorter).get(0);
    }

    /**
     * Returns a filter in a given header element.
     */
    private WebElement getFilter(int columnIdx) {
        return wdController.findNestedElements(getColumnHeader(columnIdx), filter).get(0);
    }

    /**
     * Gets a list of cell elements for a given column.
     */
    protected List<WebElement> getColumnCellElements(String columnLabel) {
        int columnIdx = wdController.getIndex(headers, columnLabel);
        return wdController.findVisibleElements(column(columnIdx));

    }


}