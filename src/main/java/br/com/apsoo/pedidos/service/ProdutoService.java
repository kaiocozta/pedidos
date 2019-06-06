package br.com.apsoo.pedidos.service;

import br.com.apsoo.pedidos.domain.Categoria;
import br.com.apsoo.pedidos.domain.Produto;
import br.com.apsoo.pedidos.repository.ProdutoRepository;
import br.com.apsoo.pedidos.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaService categoriaService;

    public Produto buscarPorId(Integer id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElseThrow(() -> new ObjectNotFoundException(
                "O objeto com o Id: " + id +
                        " da classe " + Produto.class.getName() +
                        " não foi encontrado."));
    }

    public Produto salvar(Integer idCategoria, Produto produto) {

        Categoria categoria = categoriaService.buscarPorId(idCategoria);

        produto.getCategorias().add(categoria);

        return produtoRepository.save(produto);
    }

    public void deletar(Integer id) {

        buscarPorId(id);

        produtoRepository.deleteById(id);
    }

    public Produto atualizar(Produto produto) {

        Produto produtoExistente = buscarPorId(produto.getId());

        produtoExistente.setNome(produto.getNome());
        produtoExistente.setPreco(produto.getPreco());


        return produtoRepository.save(produtoExistente);
    }

    public List<Produto> buscarTodosProdutosDaCategoria(Integer idCategoria) {

        Categoria categoria = categoriaService.buscarPorId(idCategoria);

        return categoria.getProdutos();
    }
}