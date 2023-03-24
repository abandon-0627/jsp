package com.ZhaoShiyang.week4.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCDemoServlet extends HttpServlet {


    Connection con = null;
    @Override
    public void init() throws ServletException{
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/userdbtext?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "123123";

        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
            System.out.println("--> " + con);
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("I am in doGet()");
        String sql = "SELECT * FROM usertable";
        try{
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()){

            }
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("I am in doPost()");
    }

    @Override
    public void destroy(){
        super.destroy();
        try{
            con.close();
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }
}
