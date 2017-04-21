/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Mazsub
 */
public class Customers {

    public Customers() {
    }

    public boolean checkLogin(String user, String pass) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://mssql43054-ps04375q.jelastic.skali.net:1433;databaseName=ASMSOF301";
            Connection con = DriverManager.getConnection(url, "sa", "GOBilp28941");
            String sql = "Select * from Customers where Username=? and Password=?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, user);
            pstm.setString(2, pass);
            ResultSet rs = pstm.executeQuery();
            boolean exist = false;
            exist = rs.next();
            rs.close();
            pstm.close();
            con.close();
            if (exist) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
