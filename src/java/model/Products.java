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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mazsub
 */
public class Products {

    public Products() {
    }

    public List<Product> showProduct(String tensp) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://mssql43054-ps04375q.jelastic.skali.net:1433;databaseName=ASMSOF301";
            Connection con = DriverManager.getConnection(url, "sa", "GOBilp28941");
            String sql = "Select * from Products ";
            if (tensp.length() > 0) {
                sql += "where Name like '%" + tensp + "%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<Product> list = new ArrayList<Product>();
            while (rs.next()) {
                String code = rs.getString("Code");
                String name = rs.getString("Name");
                float price = rs.getFloat("Price");
                Product sp = new Product(code, name, price);
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(String masp) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://MAZSUB\\MAZSUB;databasename=ASMSOF301;username=sa;password=";
            Connection con = DriverManager.getConnection(url);
            String sql = "Delete from Products where Code = ?";
            PreparedStatement ptsm = con.prepareStatement(sql);
            ptsm.setString(1, masp);
            ptsm.executeUpdate();
            ptsm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert(String masp, String tensp, float gia) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://MAZSUB\\MAZSUB;databasename=ASMSOF301;username=sa;password=";
            Connection con = DriverManager.getConnection(url);
            String sql = "Insert into Products values (?, ?, ?)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, masp);
            pstm.setString(2, tensp);
            pstm.setFloat(3, gia);
            pstm.executeUpdate();
            pstm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(String masp, String tensp, float gia) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://MAZSUB\\MAZSUB;databasename=ASMSOF301;username=sa;password=";
            Connection con = DriverManager.getConnection(url);
            String sql = "Update Products set Name=?, Price=? where Code=?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, tensp);
            pstm.setFloat(2, gia);
            pstm.setString(3, masp);
            pstm.executeUpdate();
            pstm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
