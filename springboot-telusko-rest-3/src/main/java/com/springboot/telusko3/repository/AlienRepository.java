package com.springboot.telusko3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springboot.telusko3.model.Alien;



@RepositoryRestResource(collectionResourceRel = "aliens", path="aliens")
public interface AlienRepository extends JpaRepository<Alien, Integer>{

}
