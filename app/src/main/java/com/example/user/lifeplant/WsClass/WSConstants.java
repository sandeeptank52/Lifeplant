package com.example.user.lifeplant.WsClass;
import okhttp3.MediaType;


public class WSConstants {
        public final static String BASE_URL = "http://192.168.43.226/iant/";
   //   public final static String BASE_URL = "http://192.168.2.7/iant/";
   //   public final static String BASE_URL = "http://localhost/iant/";


    public final static int CONNECTION_TIMEOUT = 30;
    public final static int SUCCESS_1 = 1;
    public final static int SUCCESS_2 = 2;
    public final static int SUCCESS_100 = 100;


    public static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");
    /**
     * Methods Name
     */
    public final static String METHOD_LOGIN = "Login.php";
    public final static String METHOD_SIGNUP = "insert.php";

    public final static String METHOD_PRODUCTDETAIL = "get_product_details.php";
    public final static String METHOD_HOME = "getData.php";
    public final static String METHOD_CART = "cart.php";
    public final String DEVICE_TYPE = "ANDROID";
    public final String DEVICE_TYPE_ANDROID = "android";
    public final String PARAMS_RESPONSE = "response";
    public final String PARAMS_SUCCESS = "success";
    public final String PARAMS_NEXT_PAGE = "next_page";
    public final String PARAMS_RESULT = "result";
    public final String PARAMS_ID = "id";
    public final String PARAMS_QUESTION_MARK = "?";
    public final String PARAMS_AND = "&";
    public final String PARAMS_EQUAL = "=";
    public final String PARAMS_SPACE = "%20";
    /**
     * Settings Name
     */
    public final String PARAMS_SETTINGS = "settings";
    /**
     * Parameters Name
     */
    public final String PARAMS_COMPANY_NAME = "company_name";
    public final String PARAMS_EMAIL = "email";
    public final String PARAMS_PASSWORD = "password";
    public final String PARAMS_FNAME = "fname";
    public final String PARAMS_LNAME = "lname";
    public final String PARAMS_GENDER = "gender";
    public final String PARAMS_MOBNO = "mobileno";
    public final String PARAMS_BIRTHD = "birthdate";
    public final String PARAMS_USERID = "user_id";
    public final String PARAMS_QNTY = "qnty";
    public final String PARAMS_PROID = "pid";
    public enum Language {
        EN,
        NL,
    }

}
