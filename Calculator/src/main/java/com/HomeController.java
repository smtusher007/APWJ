package com;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@Controller
public class HomeController {

    private DataSource dataSource;

    public HomeController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @RequestMapping("/calculator-form")
    public String calculatorForm() {
        return "calculator";
    }

    @RequestMapping("/data")

    public void getData() throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user");
        while(resultSet.next()) {
            System.out.println(resultSet.getLong(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
        }
    }

    @RequestMapping("/data/create")

    public String createData(@ModelAttribute("number1") int number1, @ModelAttribute("number2") int number2, Model model) throws SQLException {
        Connection connection = dataSource.getConnection();

        String data=number1+"  "+number2;
        int result=number1+number2;
        PreparedStatement statement = connection.prepareStatement("insert into user (data, result) values (?, ?)");
        statement.setString(1, data);
        statement.setString(2, String.valueOf(result));
        statement.execute();

        model.addAttribute("result",result);
        return "calculator";
    }

    
}
