package com.ossez.edtestbank.common.search.criteria;

import com.ossez.edtestbank.common.search.PagedCriteria;

import java.util.Date;

/**
 * Model for report that uses paged criteria
 */
public class Report extends PagedCriteria {

    private String customerName = "";
    private String customerEmail = "";
    private boolean closedLeads = false;
    private boolean closedSoldLeads = false;

    private String leadSources = null;

    private boolean additionalRequests = false;
    private boolean updateRequired = false;
    private Date startDate = null;
    private Date endDate = null;

    private String leadNameType = null;


    // --- Latest Activity ---
    private Date latestStartDate = null;
    private Date latestEndDate = null;

    // --- Re-Assign Date Range --
    private Date reassignedStartDate = null;
    private Date reassignedendDate = null;

    private String searchText = "";


}
