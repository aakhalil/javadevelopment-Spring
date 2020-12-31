package com.cybertek;

import com.cybertek.repository.EmployeeRepository;
import com.cybertek.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DerivedquiresApplication {

	@Autowired
	RegionRepository regionRepository;

	@Autowired
	EmployeeRepository employeeRepository;


	public static void main(String[] args) {
		SpringApplication.run(DerivedquiresApplication.class, args);
	}

	@PostConstruct
	public void testRegions(){
		System.out.println(  "---------------------Regions Starts------------------------");

		System.out.println( "findByCountrie: "+ regionRepository.findByCountry("Canada"));
//findByCountrie: [Region(region=Quebec, country=Canada), Region(region=Nova Scotia, country=Canada)]

		System.out.println( "findBydistinct: "+ regionRepository.findDistinctByCountry("Canada"));

		System.out.println( "findByContaining: "+ regionRepository.findByCountryContaining("United"));

		System.out.println( "findByContaining Order by : "+ regionRepository.findByCountryContainingOrderByCountry("United"));

		System.out.println( "top 2 : "+ regionRepository.findTop2ByCountry("Canada"));



		System.out.println(  "---------------------Employees Starts------------------------");

		System.out.println( "findByFirst name : "+ employeeRepository.findByEmail("amcnee1@google.es"));


	}



}
