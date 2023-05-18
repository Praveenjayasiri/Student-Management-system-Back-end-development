package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@RestController

public class Studentcontroller {
	
	@Autowired
	private StudentRepository repo;
	
	
	//add student
	@PostMapping("/save")
	public Student addStudent(@RequestBody Student st) {
		
		return repo.save(st);
		
	}
	
	
	//add multiple student
	
	
	@PostMapping("/saveall")
	public List<Student> addMultipleStudent( @RequestBody List <Student> st){
		
		return repo.saveAll(st);
		
	}
	
	//find all student
	@GetMapping("/findall")
	public List<Student> findStudents()
	{
		return repo.findAll();
	}
	
	//find student using id
	@GetMapping("/findbyid/{id}")
	public Student findusingId(@PathVariable long id)
	{
		return repo.findById(id).orElseThrow(()->new RuntimeException ("Cannot find with give this id"));
	}
	
	//update student
	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student st)
	{
		Student oldSt= repo.findById(st.getId()).orElseThrow(()->new RuntimeException ("Cannot update student with give this id"));
		oldSt.setAddress(st.getAddress());
		oldSt.setName(st.getName());
		oldSt.setYears(st.getYears());
		
		return repo.save(oldSt);
	}
	
	//delete student
	@DeleteMapping("/delete/{id}")
	public String deleteusingId(@PathVariable long id)
	{
		repo.deleteById(id);
		return "Deleted Succsefully";
	}

}
