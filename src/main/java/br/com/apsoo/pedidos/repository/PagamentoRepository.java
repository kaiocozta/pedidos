package br.com.apsoo.pedidos.repository;

import br.com.apsoo.pedidos.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
}