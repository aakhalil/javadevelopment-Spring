package com.cybertek.repository;

import com.cybertek.entity.Account;
import com.cybertek.enums.UserRole;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

//Write a derived query to list all accounts with a specific country or state
          List<Account> findAllByCountryOrState ( String country, String state);

//Write a derived query to list all accounts with age lower than or equal to a specific value
    List <Account> findAllByAgeLessThanEqual (Integer age);



//Write a derived query to list all accounts with a specific role
    List <Account> findAllByRole (UserRole  role);


//Write a derived query to list all accounts between a range of ages

    List<Account> findAllByAgeBetween ( Integer age1, Integer age2);


//Write a derived query to list all accounts where the beginning of the address contains the keyword

    List<Account>findAllByAddressStartingWith( String str);


//Write a derived query to sort the list of accounts with age

    List<Account> findByOrderByAgeDesc ();


// ------------------- JPQL QUERIES ------------------- //


//Write a JPQL query that returns all accounts
// naming the methods can be any thing

    @Query("select a from Account a")
    List<Account>fetchAllJPQL ();


//Write a JPQL query to list all admin accounts

    @Query("select a from Account a  where a.role='USER' ")
    List<Account>fetchAdminUsersJPQL();

//Write a JPQL query to sort all accounts with age
    @Query("select  a from Account  a order by a.age desc ")
    List<Account>orderWithAgeJPQL();


// ------------------- Native QUERIES ------------------- //


//Write a native query to read all accounts with an age lower than a specific value

    // here we need to use native sql so we need to use the tables names not the entity names
    @Query(value=" select  * from account_details where  age < ?1",nativeQuery = true)
    List<Account>retrieveAllByAgeLowerThan(Integer age);


//Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city

    @Query(value = "select * from account_details where name ILIKE concat('%', ?1, '%') OR country ILIKE concat ('%', ?1, '%') OR  address ILIKE concat ('%', ?1, '%')  OR state ILIKE concat ('%', ?1, '%') ",nativeQuery = true)
    List<Account>retrieveBySearchCriterias(String pattern);


//Write a native query to read all accounts with an age lower than a specific value
    @Query(value =" select  * from account_details where age >?1", nativeQuery = true)
    List<Account> retrieveLessThan(int age);



}
