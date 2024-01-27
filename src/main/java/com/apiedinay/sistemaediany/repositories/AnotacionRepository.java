package com.apiedinay.sistemaediany.repositories;
import org.springframework.stereotype.Repository;
import com.apiedinay.sistemaediany.models.Anotacion;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AnotacionRepository extends JpaRepository<Anotacion,Long > {
    
}
