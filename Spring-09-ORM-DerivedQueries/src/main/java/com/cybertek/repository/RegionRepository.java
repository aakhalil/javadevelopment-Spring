package com.cybertek.repository;

import com.cybertek.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region,Integer> {

    // display all regions in some country

    List<Region> findByCountry( String country);


    // display all regions in country without dupilcats


    List <Region> findDistinctByCountry(String country);

    // display all regions wuth country name include unites

    List <Region> findByCountryContaining (String country);

    List<Region>findByCountryContainingOrderByCountry (String country);


    // display 2 region in canada

    List <Region>findTop2ByCountry( String country);

}
