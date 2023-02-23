package com.alexandre.projetoClientesPessoal.repository;

import com.alexandre.projetoClientesPessoal.entidy.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>,CustomerRepositoryCustom {

//    @Query(value ="SELECT c FROM Customer c LEFT JOIN FECTH c.adress WHERE c.id = :id")
//    Optional<Customer> findByIdWhitAdrees(@Param("id") Long id);

    @Query(value = "SELECT c FROM Customer c WHERE " +
            " c.name LIKE CONCAT('%',:query,'%') " +
            "Or c.email LIKE CONCAT('%',:query,'%') " +
            "Or c.document LIKE CONCAT('%',:query,'%')")
    List<Customer> searchCustomer(String query);

//    @Query("SELECT c FROM Customer c LEFT JOIN FETCH c.address WHERE c.id= :id")
//    List<Customer> findByIdWithAdress(Long id);
}
