package br.com.apsoo.pedidos.service;

import br.com.apsoo.pedidos.domain.Pedido;
import br.com.apsoo.pedidos.repository.PedidoRepository;
import br.com.apsoo.pedidos.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido buscarPorId(Integer id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido.orElseThrow(() -> new ObjectNotFoundException(
                "O objeto com o Id: " + id +
                        " da classe " + Pedido.class.getName() +
                        " não foi encontrado."));
    }
}