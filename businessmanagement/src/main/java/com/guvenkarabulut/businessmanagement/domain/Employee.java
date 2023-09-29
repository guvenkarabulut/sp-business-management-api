package com.guvenkarabulut.businessmanagement.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table("employee")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;


    @Column("first_name")
    private String firstName;

    @Column("last_name")
    private String lastName;

    @Column("email")
    private String email;

    @Column("phone_number")
    private String phoneNumber;

    @Column("hire_date")
    private Instant hireDate;

    @Column("salary")
    private Long salary;

    @Column("commission_pct")
    private Long commissionPct;

    @Transient
    @JsonIgnoreProperties(value = { "tasks", "employee", "jobHistory" }, allowSetters = true)
    private Set<Job> jobs = new HashSet<>();

    @Transient
    @JsonIgnoreProperties(value = { "jobs", "manager", "department", "jobHistory" }, allowSetters = true)
    private Employee manager;

    @Transient
    @JsonIgnoreProperties(value = { "location", "employees", "jobHistory" }, allowSetters = true)
    private Department department;

    @Transient
    private JobHistory jobHistory;

    @Column("manager_id")
    private Long managerId;

    @Column("department_id")
    private Long departmentId;


    public Long getId() {
        return this.id;
    }

    public Employee id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public Employee firstName(String firstName) {
        this.setFirstName(firstName);
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Employee lastName(String lastName) {
        this.setLastName(lastName);
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public Employee email(String email) {
        this.setEmail(email);
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public Employee phoneNumber(String phoneNumber) {
        this.setPhoneNumber(phoneNumber);
        return this;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Instant getHireDate() {
        return this.hireDate;
    }

    public Employee hireDate(Instant hireDate) {
        this.setHireDate(hireDate);
        return this;
    }

    public void setHireDate(Instant hireDate) {
        this.hireDate = hireDate;
    }

    public Long getSalary() {
        return this.salary;
    }

    public Employee salary(Long salary) {
        this.setSalary(salary);
        return this;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Long getCommissionPct() {
        return this.commissionPct;
    }

    public Employee commissionPct(Long commissionPct) {
        this.setCommissionPct(commissionPct);
        return this;
    }

    public void setCommissionPct(Long commissionPct) {
        this.commissionPct = commissionPct;
    }

    public Set<Job> getJobs() {
        return this.jobs;
    }

    public void setJobs(Set<Job> jobs) {
        if (this.jobs != null) {
            this.jobs.forEach(i -> i.setEmployee(null));
        }
        if (jobs != null) {
            jobs.forEach(i -> i.setEmployee(this));
        }
        this.jobs = jobs;
    }

    public Employee jobs(Set<Job> jobs) {
        this.setJobs(jobs);
        return this;
    }

    public Employee addJob(Job job) {
        this.jobs.add(job);
        job.setEmployee(this);
        return this;
    }

    public Employee removeJob(Job job) {
        this.jobs.remove(job);
        job.setEmployee(null);
        return this;
    }

    public Employee getManager() {
        return this.manager;
    }

    public void setManager(Employee employee) {
        this.manager = employee;
        this.managerId = employee != null ? employee.getId() : null;
    }

    public Employee manager(Employee employee) {
        this.setManager(employee);
        return this;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
        this.departmentId = department != null ? department.getId() : null;
    }

    public Employee department(Department department) {
        this.setDepartment(department);
        return this;
    }

    public JobHistory getJobHistory() {
        return this.jobHistory;
    }

    public void setJobHistory(JobHistory jobHistory) {
        if (this.jobHistory != null) {
            this.jobHistory.setEmployee(null);
        }
        if (jobHistory != null) {
            jobHistory.setEmployee(this);
        }
        this.jobHistory = jobHistory;
    }

    public Employee jobHistory(JobHistory jobHistory) {
        this.setJobHistory(jobHistory);
        return this;
    }

    public Long getManagerId() {
        return this.managerId;
    }

    public void setManagerId(Long employee) {
        this.managerId = employee;
    }

    public Long getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(Long department) {
        this.departmentId = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee)) {
            return false;
        }
        return id != null && id.equals(((Employee) o).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Employee{" +
            "id=" + getId() +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", email='" + getEmail() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", hireDate='" + getHireDate() + "'" +
            ", salary=" + getSalary() +
            ", commissionPct=" + getCommissionPct() +
            "}";
    }
}
