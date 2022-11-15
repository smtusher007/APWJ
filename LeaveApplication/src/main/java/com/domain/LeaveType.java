package com.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="leave_application")
public class LeaveType {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id=1;

    @NotNull
    @Column(name="category")
    private  String category="Vacation";

    @NotNull
    @Column(name="Total_Days")
    private int Total_Days=1;

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

    public int getTotal_Days() {
        return Total_Days;
    }

    public void setTotal_Days(int total_Days) {
        Total_Days = total_Days;
    }
}
