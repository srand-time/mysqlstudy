package main;
import frame.Choose_Frame;

import java.sql.*;
public class main_page {
    public static void main(String[] args) throws Exception {
        sql_va.DataBase_Driver();
        Choose_Frame.main();
        //if(sql_va.stop==1)
        	//sql_va.conn.close();
    }
}
