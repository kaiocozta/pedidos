package br.com.apsoo.pedidos.repository;

import br.com.apsoo.pedidos.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}