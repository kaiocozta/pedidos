package br.com.apsoo.pedidos.repository;

import br.com.apsoo.pedidos.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    @Query
    Categoria findByNome(String nome);
}
