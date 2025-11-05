package br.com.fiap.fintech.repository;


import br.com.fiap.fintech.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    @Query("SELECT SUM(r.valor) FROM Receita r WHERE r.usuario.id = :usuarioId " +
            "AND FUNCTION('TO_CHAR', r.dataReceita, 'YYYY-MM') = CONCAT(CAST(:ano as string), CONCAT('-', CAST(:mes as string)))")
    Optional<Double> somarReceitasPorMes(
            @Param("usuarioId") Long usuarioId,
            @Param("ano") int ano,
            @Param("mes") int mes
    );
}