package com.service;


import com.domain.LeaveType;
import com.repository.LeaveTypeRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;

@Service
@Transactional
public class LeaveTypeService {
    private LeaveTypeRepo leaveTypeRepo;
    public  LeaveTypeService(LeaveTypeRepo leaveTypeRepo){this.leaveTypeRepo=leaveTypeRepo;}

    @Transactional
    public boolean insert(LeaveType leaveType) throws SQLException{
        leaveType.setId(leaveType.getId());
        leaveType.setCategory(leaveType.getCategory());
        leaveType.setTotal_Days(leaveType.getTotal_Days());
        return leaveTypeRepo.create(leaveType);
    }
}
