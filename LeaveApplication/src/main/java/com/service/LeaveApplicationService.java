package com.service;

import com.domain.LeaveApplication;
import com.repository.LeaveApplicationRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;

@Service
@Transactional
public class LeaveApplicationService {
    private LeaveApplicationRepo leaveApplicationRepo;
    public LeaveApplicationService(LeaveApplicationRepo leaveApplicationRepo)
    {
        this.leaveApplicationRepo=leaveApplicationRepo;
    }

    @Transactional
    public boolean insert(LeaveApplication leaveApplication) throws SQLException
    {
        leaveApplication.setId(leaveApplication.getId());
        leaveApplication.setFromDate(leaveApplication.getFromDate());
        leaveApplication.setToDate(leaveApplication.getToDate());
        leaveApplication.setReason(leaveApplication.getReason());
        return leaveApplicationRepo.create(leaveApplication);
    }
}
