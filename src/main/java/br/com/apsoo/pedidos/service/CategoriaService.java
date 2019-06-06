package br.com.apsoo.pedidos.service;

import br.com.apsoo.pedidos.domain.Categoria;
import br.com.apsoo.pedidos.repository.CategoriaRepository;
import br.com.apsoo.pedidos.service.exception.CategoriaPossuiVinculoException;
import br.com.apsoo.pedidos.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;


@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscarPorId(Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.orElseThrow(() -> new ObjectNotFoundException(
                "O objeto com o Id: " + id +
                        " da classe " + Categoria.class.getName() +
                        " não foi encontrado."));
    }

    public List<Categoria> buscaTodasCategorias() {
        List<Categoria> categoria = categoriaRepository.findAll();

        return categoria;
    }


    public Categoria salvar(Categoria novaCategoria) {
        return categoriaRepository.save(novaCategoria);
    }

    public void deletar(Integer id) {
        if (!CollectionUtils.isEmpty(buscarPorId(id).getProdutos())) {
            throw new CategoriaPossuiVinculoException("A categoria " + buscarPorId(id).getNome() + " não pode ser excluida, pois possui produtos cadastrados!");
        } else {
            categoriaRepository.delete(buscarPorId(id));
        }
    }

    public Categoria atualizar(Categoria categoria) {

        Categoria categoriaExistente = buscarPorId(categoria.getId());
        categoriaExistente.setNome(categoria.getNome());
        return categoriaRepository.save(categoria);
    }

}