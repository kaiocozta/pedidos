package br.com.apsoo.pedidos.resource;

import br.com.apsoo.pedidos.domain.Produto;
import br.com.apsoo.pedidos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/categorias/{idCategoria}/produtos")
@CrossOrigin(origins = "*")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable("id") Integer id) {

        return ResponseEntity.ok().body(produtoService.buscarPorId(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> buscarTodosProdutosDaCategoria(@PathVariable("idCategoria") Integer idCategoria) {

        return ResponseEntity.ok().body(produtoService.buscarTodosProdutosDaCategoria(idCategoria));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> salvar(@PathVariable("idCategoria") Integer idCategoria, @RequestBody Produto novoproduto) {

        return ResponseEntity.ok().body(produtoService.salvar(idCategoria, novoproduto));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Integer id) {
        produtoService.deletar(id);
        return ResponseEntity.ok().build();

    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Produto produto) {

        return ResponseEntity.ok().body(produtoService.atualizar(produto));

    }
}