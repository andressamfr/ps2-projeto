package br.mackenzie.projeto1.repository;

import br.mackenzie.projeto1.entity.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {

    @Query(
            value = "SELECT * FROM jogo j WHERE j.nome_time_A = :nomeTime OR j.nome_time_B = :nomeTime",
            nativeQuery = true)
    List<Jogo> findByName(@Param("nomeTime") String nomeTime);
}