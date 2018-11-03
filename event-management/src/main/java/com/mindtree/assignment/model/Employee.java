package com.mindtree.assignment.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "employees")
public class Employee {

   @Id
   @Column(name = "mid")
   private String mid;

   @Column(name = "name")
   @Size(max = 100, min = 2, message = "{employee.name.invalid}")
   @NotEmpty(message="Please Enter your name")
   private String name;

   @Column(name = "join_date")
   private Date joinDate;

   @Column(name = "email_id", unique = true)
   @Email(message = "{employee.email.invalid}")
   @NotEmpty(message="Please Enter your email")
   private String emailId;
   
   @ManyToMany(cascade = { CascadeType.ALL })
   @JoinTable(
     name = "employees_events", 
     joinColumns = { @JoinColumn(name = "mid") }, 
     inverseJoinColumns = { @JoinColumn(name = "event_id") }
   )
   Set<Event> events = new HashSet<Event>();
  

   public Set<Event> getEvents() {
	return events;
   }

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	public Employee() {
      super();
   }

   public Employee(String mid, String name) {
       this.name = name;
       this.mid = mid;
   }
   
   public Employee(String mid, String name, Set<Event> event) {
       this.mid = mid;
       this.name = name;
       this.events = event;
   }

	public String getMid() {
		return mid;
	}
	
	public void setMid(String mid) {
		this.mid = mid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public Date getJoinDate() {
		return joinDate;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Employee))
            return false;

        Employee employee = (Employee) o;
        if (mid != employee.mid)
            return false;
        if (!name.equals(employee.name))
            return false;
        if (!emailId.equals(employee.emailId))
            return false;
       return true;
    }

    @Override
    public int hashCode() {
        int result = 20;
        result = 31 * result + mid.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + emailId.hashCode();
        return result;
    }
}