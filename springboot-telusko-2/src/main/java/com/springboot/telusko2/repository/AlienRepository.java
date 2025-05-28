package com.springboot.telusko2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springboot.telusko2.model.Alien;



//public interface AlienRepository extends CrudRepository<Alien, Integer>{
	public interface AlienRepository extends JpaRepository<Alien, Integer>{
	
	List<Alien> findByTech(String tech);
	List<Alien> findByAidGreaterThan(int aid);
	
	@Query("from Alien where tech=?1 order by name")
	List<Alien> findByTechSorted(String tech);

}
