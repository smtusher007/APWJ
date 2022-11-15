package com.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="leave_application")
public class LeaveType {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name="category")
    private  String category;

    @NotNull
    @Column(name="Total_Days")
    private String Total_Days;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTotal_Days() {
        return Total_Days;
    }

    public void setTotal_Days(String total_Days) {
        Total_Days = total_Days;
    }
}
