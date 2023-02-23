package com.alexandre.projetoClientesPessoal.repository;


import com.alexandre.projetoClientesPessoal.entidy.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

}
