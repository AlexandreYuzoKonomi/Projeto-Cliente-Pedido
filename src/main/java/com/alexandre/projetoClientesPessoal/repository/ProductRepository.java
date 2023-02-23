package com.alexandre.projetoClientesPessoal.repository;

import com.alexandre.projetoClientesPessoal.entidy.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(value = "SELECT p FROM Product p LEFT JOIN FETCH p.categoryList WHERE p.id =:id")
    Optional<Product> findByIdWithCategories(@Param("id") Long id);
}
