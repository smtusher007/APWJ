package com.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="leave_application")
public class LeaveApplication {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id=1;

    @NotNull
    @Column(name="fromDate")
    private Date fromDate = new Date(2022,10,15);

    @NotNull
    @Column(name="toDate")
    private Date toDate = new Date(2022,10,18);

    @NotNull
    @Column(name="reason")
    private String reason="Vacation";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
