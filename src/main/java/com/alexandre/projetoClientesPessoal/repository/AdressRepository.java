package com.alexandre.projetoClientesPessoal.repository;

import com.alexandre.projetoClientesPessoal.entidy.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends JpaRepository<Address,Long> {
}
