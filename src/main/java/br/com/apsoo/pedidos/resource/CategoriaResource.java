package br.com.apsoo.pedidos.resource;

import br.com.apsoo.pedidos.domain.Categoria;
import br.com.apsoo.pedidos.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable("id") Integer id) {

        Categoria categoria = categoriaService.buscarPorId(id);

        return ResponseEntity.ok().body(categoria);

    }

}
