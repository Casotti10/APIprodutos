package br.com.fiap.fintech.repository;

// ... (imports)

import br.com.fiap.fintech.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    @Query("SELECT SUM(d.valor) FROM Despesa d WHERE d.usuario.id = :usuarioId " +
            "AND FUNCTION('TO_CHAR', d.dataDespesa, 'YYYY-MM') = CONCAT(CAST(:ano as string), CONCAT('-', CAST(:mes as string)))")
    Optional<Double> somarDespesasPorMes(
            @Param("usuarioId") Long usuarioId,
            @Param("ano") int ano,
            @Param("mes") int mes
    );
}