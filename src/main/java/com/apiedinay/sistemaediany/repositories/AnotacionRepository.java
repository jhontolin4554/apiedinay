package com.apiedinay.sistemaediany.repositories;
import org.springframework.stereotype.Repository;
import com.apiedinay.sistemaediany.models.Anote;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AnotacionRepository extends JpaRepository<Anote,Long > {
    List<Anote> findByIdEmpleado(Long idEmpleado);
}
