package com.repository;
import com.domain.LeaveApplication;
import com.domain.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Repository
public class LeaveApplicationRepo {
    private SessionFactory sessionFactory;
    public LeaveApplicationRepo(SessionFactory sessionFactory)
    {
        this.sessionFactory=sessionFactory;
    }
    public boolean create(LeaveApplication leaveApplication) throws SQLException{
        Session session= sessionFactory.getCurrentSession();
        session.save(leaveApplication);
        return true;
    }

}
