package com.excel_test.excel_test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Item {
    // var
    @Id
    private Long id;
    @Column(name = "employeeType")
    private String employeeType;

    @Column(name = "isolationType")
    private String isolationType;

    @Column(name = "lolType")
    private String lolType;

    @Column(name = "name")
    private String name;

    // empty const
    public Item(Long id, String employeeType, String isolationType, String lolType) {
        this.id = id;
        this.employeeType = employeeType;
        this.isolationType = isolationType;
        this.lolType = lolType;
    }

    public Item() {

    }

    // getter setter
    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getIsolationType() {
        return isolationType;
    }

    public void setIsolationType(String isolationType) {
        this.isolationType = isolationType;
    }

    public String getLolType() {
        return lolType;
    }

    public void setLolType(String lolType) {
        this.lolType = lolType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
