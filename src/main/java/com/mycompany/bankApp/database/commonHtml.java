/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankApp.database;

/**
 *
 * @author darag
 */
public class commonHtml {
        // basic HTML page stuff
    public static String htmlstart = "<!DOCTYPE html>\n" +
"<html lang='en'>\n" +
"    <head>\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
"        <title>DASC Bank Ltd.</title>\n" +
"        <link rel=\"stylesheet\" href=\"http://localhost:8080/basicstyle.css\" />\n" +
"    </head>\n" +
"\n" +
"    <body>";
    public static String htmlend = "    </body>\n" +
"</html>";
    
    public static String menu = "<!DOCTYPE html>\n" +
"<html lang='en'>\n" +
"    <head>\n" +
"        <meta http-equiv='Content-Type' content='text/html; charset=utf-8' />\n" +
"        <title>DASC Bank Ltd.</title>\n" +
"        <link rel='stylesheet' href='http://localhost:8080/basicstyle.css' />\n" +
"    </head>\n" +
"\n" +
"    <body>\n" +
"<div id='cssmenu'>\n" +
"<ul>\n" +
"    <li><a href='index.html'>DASC Bank</a></li>\n" +
"    <li>\n" +
"        <a href='#'>Customers</a>\n" +
"        <ul>\n" +
"            <li><a href='http://localhost:8080/addcustomer.html'>Add new customer</a></li>\n" +
"            <li><a href='http://localhost:8080/webapi-V10/customers/'>View customers</a></li>\n" +
"            <li><a href='http://localhost:8080/viewcustomerbyid.html'>View customer by ID</a></li>\n" +
"            <li><a href='http://localhost:8080/deletecustomer.html'>Delete Customer by ID</a></li>\n" +
"        </ul>\n" +
"    </li>\n" +
"    <li>\n" +
"        <a href='#'>Accounts</a>\n" +
"        <ul>\n" +
"            <li><a href='http://localhost:8080/addaccount.html'>Add a new account</a></li>\n" +
"            <li><a href='http://localhost:8080/webapi-V10/accounts/'>View accounts</a></li>\n" +
"            <li><a href='http://localhost:8080/viewaccountbyid.html'>View account by ID</a></li>\n" +
"            <li><a href='http://localhost:8080/deleteaccount.html'>Delete Account by ID</a></li>\n" +
"        </ul>\n" +
"    </li>\n" +
"    <li>\n" +
"        <a href='#'>Balances</a>\n" +
"        <ul>\n" +
"            <li><a href='http://localhost:8080/displaybalance.html'>Balance by Acc Id</a></li>\n" +
"        </ul>\n" +
"    </li>\n" +
"    <li>\n" +
"        <a href='#'>Misc</a>\n" +
"        <ul>\n" +
"            <li><a href='searchcustomer.html'>Search customer form</a></li>\n" +
"            <li><a href='searchcustomerget.html'>Search customer form GET</a></li>\n" +
"            <li><a href='http://localhost:8080/transactionform.html'>Transaction form</a></li>\n" +
"        </ul>\n" +
"    </li>\n" +
"</ul>\n" +
"</div>\n" +
"\n" +
"<script src='http://localhost:8080/js/jquery-1.8.3.min.js'></script>\n" +
"<script src='http://localhost:8080/js/menumaker.js'></script>\n" +
"<script type='text/javascript'>\n" +
"$('#cssmenu').menumaker({\n" +
"    title: 'Menu',\n" +
"    format: 'multitoggle'\n" +
"});\n" +
"</script>\n" +
"\n" +
"<hr />";
            
}
