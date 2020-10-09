package com.example.demo.Repository;

import com.example.demo.Model.Employee;
import com.example.demo.Model.ICrud;
import com.example.demo.Model.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeRepository implements ICrud<Employee> {


    @Override
    public void create(Employee employee) {
        try{
            Connection connection = DBConnectionManager.getConnection();
            String SQL = "INSERT INTO employee VALUES(DEFAULT, ?)";

            PreparedStatement ps = DBConnectionManager.getConnection().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1,employee.getName());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList read() {
        return null;
    }

    @Override
    public void update(Employee o, int index) {

    }

    @Override
    public void delete(int index) {

    }
}
