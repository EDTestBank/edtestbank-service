package com.ossez.edtestbank.common;

/**
 * Constants for Insight SCO project
 *
 * @author YuCheng Hu
 */
public class SCOConstants {

    // Authentication
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_HEAD = "Bearer";

    // Temp folder
    public static final String TMP_FOLDER_PREFIX = "sco-data";
    public static final String PATH_DATA_EXCHANGE = "/home/insight/sco/dataExchange/";

    // DATA FOLDER
    public static final String IMPORT_DATA_FOLDER = "import-data";
    public static final String OUTPUT_DATA_FOLDER = "output-data";
    public static final String INPUT_DATA_FOLDER = "input-data";
    public static final String DATA_FOLDER_TEST = "data-test";

    // AZURE CONTAINER NAME COUNT MAP
    public static final String AZURE_CONTAINER_NAME_INPUT = "master";
    public static final String AZURE_CONTAINER_NAME_OUTPUT = "processed";


    // CSV FILE COUNT MAP
    public static final String COUNT_ROW = "count_row";
    public static final String COUNT_MATCH_SINGLE = "count_match_single";
    public static final String COUNT_MATCH_MULTI = "count_match_multi";
    public static final String COUNT_MATCH_NO = "count_match_no";


    // VALUE
    public static final String VALUE_YES = "YES";
    public static final String VALUE_NO = "NO";


    // HTTP STATUS RESPONSE VALUE
    public static final String HTTP_STATUS_VALUE_BAD_REQUEST_PARAMS= "Bad Request Params";
}
