package br.com.apsoo.pedidos.resource;

import br.com.apsoo.pedidos.domain.Categoria;
import br.com.apsoo.pedidos.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/categorias")
@CrossOrigin(origins = "*")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable("id") Integer id) {

        Categoria categoria = categoriaService.buscarPorId(id);

        return ResponseEntity.ok().body(categoria);

    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> buscaTodasCategorias() {

        return ResponseEntity.ok().body(categoriaService.buscaTodasCategorias());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> salvar(@RequestBody Categoria novaCategoria) {
        novaCategoria = categoriaService.salvar(novaCategoria);
        URI uriNovaCategoria = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(novaCategoria.getId()).toUri();
        return ResponseEntity.ok().body(uriNovaCategoria);

    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Integer id) {
        categoriaService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Categoria categoria) {

        return ResponseEntity.ok().body(categoriaService.atualizar(categoria));
    }


}
