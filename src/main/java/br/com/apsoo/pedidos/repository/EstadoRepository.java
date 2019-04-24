package br.com.apsoo.pedidos.repository;

import br.com.apsoo.pedidos.domain.Estado;
import br.com.apsoo.pedidos.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
