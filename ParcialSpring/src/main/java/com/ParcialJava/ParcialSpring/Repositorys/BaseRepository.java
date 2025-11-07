package com.ParcialJava.ParcialSpring.Repositorys;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<E, Long> extends JpaRepository<E, Long> {
    List<E> findByEliminadoFalse();

    List<E> findByEliminadoTrue();

    List<E> findByEliminadoFalseOrderByIdAsc();

    List<E> findByEliminadoTrueOrderByIdAsc();

    List<E> findAllByOrderByIdAsc();

    Optional<E> findByNombre(String nombre);

}
