package br.com.apsoo.pedidos.resource;

import br.com.apsoo.pedidos.domain.Pedido;
import br.com.apsoo.pedidos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable("id") Integer id) {
        Pedido pedido = pedidoService.buscarPorId(id);

        return ResponseEntity.ok().body(pedido);
    }
}