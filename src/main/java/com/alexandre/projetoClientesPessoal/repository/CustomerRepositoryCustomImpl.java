package com.alexandre.projetoClientesPessoal.repository;

import com.alexandre.projetoClientesPessoal.entidy.Address;
import com.alexandre.projetoClientesPessoal.payload.AdressResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.jdbc.ReturningWork;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryCustomImpl implements CustomerRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<AdressResponse> findAddressList(Long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.doReturningWork(new ReturningWork<List<AdressResponse>>() {


            @Override
            public List<AdressResponse> execute(Connection connection) throws SQLException {

                final String sql = "SELECT c.endereco_id, en.id,en.cep,en.logradouro,en.numero,en.complemento,en.bairro " +
                        "FROM tab_cliente c " +
                        "JOIN tab_endereco en ON en.id=c.endereco_id WHERE c.id = ?";

                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    stmt.setLong(1, id);
                    try (ResultSet rs = stmt.executeQuery()) {

                        List<AdressResponse> addressList = new ArrayList<>();

                        while (rs.next()) {

                            AdressResponse address = AdressResponse.builder()
                                    .cep(rs.getString("cep"))
                                    .number(rs.getString("numero"))
                                    .district(rs.getString("bairro"))
                                    .adressLocation(rs.getString("logradouro"))
                                    .complementLocation(rs.getString("complemento"))
                                    .build();

                            addressList.add(address);

                        }
                        return addressList;
                    }
                }


            }
        });
    }

}
