package com.cognizant.orm_learn.repository;

import com.cognizant.orm_learn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    Country findByName(String name);
    @Query("SELECT c FROM Country c WHERE c.name = :name")
    Country findCountryByName(@Param("name") String name);
    @Query(value = "SELECT * FROM country WHERE co_name = :name", nativeQuery = true)
    Country findCountryNative(@Param("name") String name);

}