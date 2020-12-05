package com.ossez.edtestbank.common.search;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Order;

public class PagedCriteria {
    private String sortColumn = "";
    private SortDirection direction = SortDirection.ASCENDING;
    private int pageNumber = 0;
    private int pageSize = 20;

    /**
     * Creates a new paged criteria instance.
     */
    public PagedCriteria() {

    }

    /**
     * Constructor for a paged criteria instance.
     *
     * @param pageNumber
     * @param pageSize
     */
    public PagedCriteria(int pageNumber, int pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    /**
     * Constructor a new paged criteria instance with additional parameters.
     *
     * @param pageNumber
     * @param pageSize
     * @param sortColumn
     * @param sortDirection
     */
    public PagedCriteria(int pageNumber, int pageSize, String sortColumn, SortDirection sortDirection) {
        this(pageNumber, pageSize);

        this.sortColumn = sortColumn;
        this.direction = sortDirection;
    }

    /**
     * @return the orderColumn
     */
    public String getSortColumn() {
        return sortColumn;
    }

    /**
     * @param orderColumn
     */
    public void setSortColumn(String orderColumn) {
        this.sortColumn = orderColumn;
    }

    /**
     * @return the direction
     */
    public SortDirection getSortDirection() {
        return direction;
    }

    /**
     * @param direction
     */
    public void setSortDirection(SortDirection direction) {
        this.direction = direction;
    }

    /**
     * @return the pageNumber
     */
    public int getPageNumber() {
        return pageNumber;
    }

    /**
     * @param pageNumber
     */
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * @return the pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * Gets the hibernate order clause for the current sort criteria.
     *
     * @return values in order
     */
    public Order getSortCriteria() {
        if (this.direction == SortDirection.ASCENDING)
            return Order.asc(this.sortColumn);
        else
            return Order.desc(this.sortColumn);
    }

    /**
     * Determines whether or not the criteria has sort criteria specified.
     *
     * @return non null value for column with the ability for sort
     */
    public boolean hasSort() {
        return StringUtils.isNotEmpty(this.sortColumn);
    }
}
