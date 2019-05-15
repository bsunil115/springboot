package com.example.postgre;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, Long>{
	@Query("SELECT u FROM Test u WHERE u.id = 5")
	List<Test> findUser(@Param("name") String lastName);


}
