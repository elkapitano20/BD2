package database_objects;

import java.util.Date;

/**
 * Created by Pelmen on 22.01.2017.
 */
public class Worker {

    private int workerId;//PK
    private int departmentId;//FK do odzialu
    private int warehousePositionId;//FK do pozycji magazynowej

    private String name;
    private String surname;
    private int phoneNumber;
    private String email;
    private Date employmentDate;//data zatrudnienia
    private Date exemptionDate;//data zwolnienia
    private int pesel;
    private int salary;
    private String homeAdress;

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setWarehousePositionId(int warehousePositionId) {
        this.warehousePositionId = warehousePositionId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public void setExemptionDate(Date exemptionDate) {
        this.exemptionDate = exemptionDate;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setHomeAdress(String homeAdress) {
        this.homeAdress = homeAdress;
    }

    public int getWorkerId() {
        return this.workerId;
    }

    public int getDepartmentId() {
        return this.departmentId;
    }

    public int getWarehousePositionId() {
        return this.warehousePositionId;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public int getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public Date getEmploymentDate() {
        return this.employmentDate;
    }

    public Date getExemptionDate(){
        return this.exemptionDate;
    }

    public int getPesel() {
        return this.pesel;
    }

    public int getSalary() {
        return this.salary;
    }

    public String getHomeAdress() {
        return this.homeAdress;
    }
}
