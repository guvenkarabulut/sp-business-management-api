package com.guvenkarabulut.businessmanagement.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("job")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;

    @Column("job_title")
    private String jobTitle;

    @Column("min_salary")
    private Long minSalary;

    @Column("max_salary")
    private Long maxSalary;

    @Transient
    @JsonIgnoreProperties(value = { "jobs" }, allowSetters = true)
    private Set<Task> tasks = new HashSet<>();

    @Transient
    @JsonIgnoreProperties(value = { "jobs", "manager", "department", "jobHistory" }, allowSetters = true)
    private Employee employee;

    @Transient
    private JobHistory jobHistory;

    @Column("employee_id")
    private Long employeeId;


    public Long getId() {
        return this.id;
    }

    public Job id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return this.jobTitle;
    }

    public Job jobTitle(String jobTitle) {
        this.setJobTitle(jobTitle);
        return this;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Long getMinSalary() {
        return this.minSalary;
    }

    public Job minSalary(Long minSalary) {
        this.setMinSalary(minSalary);
        return this;
    }

    public void setMinSalary(Long minSalary) {
        this.minSalary = minSalary;
    }

    public Long getMaxSalary() {
        return this.maxSalary;
    }

    public Job maxSalary(Long maxSalary) {
        this.setMaxSalary(maxSalary);
        return this;
    }

    public void setMaxSalary(Long maxSalary) {
        this.maxSalary = maxSalary;
    }

    public Set<Task> getTasks() {
        return this.tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public Job tasks(Set<Task> tasks) {
        this.setTasks(tasks);
        return this;
    }

    public Job addTask(Task task) {
        this.tasks.add(task);
        task.getJobs().add(this);
        return this;
    }

    public Job removeTask(Task task) {
        this.tasks.remove(task);
        task.getJobs().remove(this);
        return this;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
        this.employeeId = employee != null ? employee.getId() : null;
    }

    public Job employee(Employee employee) {
        this.setEmployee(employee);
        return this;
    }

    public JobHistory getJobHistory() {
        return this.jobHistory;
    }

    public void setJobHistory(JobHistory jobHistory) {
        if (this.jobHistory != null) {
            this.jobHistory.setJob(null);
        }
        if (jobHistory != null) {
            jobHistory.setJob(this);
        }
        this.jobHistory = jobHistory;
    }

    public Job jobHistory(JobHistory jobHistory) {
        this.setJobHistory(jobHistory);
        return this;
    }

    public Long getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(Long employee) {
        this.employeeId = employee;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Job)) {
            return false;
        }
        return id != null && id.equals(((Job) o).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Job{" +
            "id=" + getId() +
            ", jobTitle='" + getJobTitle() + "'" +
            ", minSalary=" + getMinSalary() +
            ", maxSalary=" + getMaxSalary() +
            "}";
    }
}
