package com.apiedinay.sistemaediany.repositories;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.apiedinay.sistemaediany.models.Empleado;



@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    // Puedes agregar consultas personalizadas aquí si es necesario
}

