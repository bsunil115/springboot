package com.example.postgre;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Autowired
	TestRepository repo;
	
	@GetMapping("/test/{id}")
	public Optional<?> getData(@PathVariable long id) {
		return  repo.findById(id);
	}
	
	@GetMapping("/test/")
	public List<Test> getAllData() {
		return  (List<Test>) repo.findAll();
	}
	
	
	@PostMapping("/create")
	public Test createData(@RequestBody Test test) {
		return repo.save(test);
	}
	
	@PutMapping("/update/")
	public Optional<Test> UpdateData(@RequestBody Test test) {
		return repo.findById(test.getId()).map(answer -> {
            answer.setName(test.getName());
            return repo.save(answer);
        });
        
	}
	
	@DeleteMapping("/delete/{id}")
	public void DeleteData(@PathVariable long id) {
		repo.deleteById(id);
        
	}
}
