package com.repository;

import com.domain.Employee;
import com.domain.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
@Repository
public class EmployeeRepo {
    private SessionFactory sessionFactory;
    public EmployeeRepo(SessionFactory sessionFactory)
    {
        this.sessionFactory=sessionFactory;
    }
    public boolean create(Employee employee) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.save(employee);
        return true;
    }
}
