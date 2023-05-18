package com.example.demo.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name="tbl_student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private long id;
	private String name;
	//private String address;
	private String Years;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List <Subject> subjects;
	
	
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Hobby> hobbies=new HashSet<>();


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getYears() {
		return Years;
	}


	public void setYears(String years) {
		Years = years;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public List<Subject> getSubjects() {
		return subjects;
	}


	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}


	public Set<Hobby> getHobbies() {
		return hobbies;
	}


	public void setHobbies(Set<Hobby> hobbies) {
		this.hobbies = hobbies;
	}



}
