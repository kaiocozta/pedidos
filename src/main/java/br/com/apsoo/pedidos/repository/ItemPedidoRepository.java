package br.com.apsoo.pedidos.repository;

import br.com.apsoo.pedidos.domain.Categoria;
import br.com.apsoo.pedidos.domain.ItemPedido;
import br.com.apsoo.pedidos.domain.ItemPedidoPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPK> {
}