package com.niit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;

@Entity
@Table(name="job_s180250")
public class Job {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
	@Column(nullable=false)
private String jobTitle;
private String jobDescription;
@Column(nullable=false)
private String skillsRequired;
private String location;
private String yrsOfExp;
private String companyname;
private String salary;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getJobTitle() {
	return jobTitle;
}
public void setJobTitle(String jobTitle) {
	this.jobTitle = jobTitle;
}
public String getJobDescription() {
	return jobDescription;
}
public void setJobDescription(String jobDescription) {
	this.jobDescription = jobDescription;
}
public String getSkillsRequired() {
	return skillsRequired;
}
public void setSkillsRequired(String skillsRequired) {
	this.skillsRequired = skillsRequired;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getYrsOfExp() {
	return yrsOfExp;
}
public void setYrsOfExp(String yrsOfExp) {
	this.yrsOfExp = yrsOfExp;
}
public String getCompanyname() {
	return companyname;
}
public void setCompanyname(String companyname) {
	this.companyname = companyname;
}
public String getSalary() {
	return salary;
}
public void setSalary(String salary) {
	this.salary = salary;
}
}
