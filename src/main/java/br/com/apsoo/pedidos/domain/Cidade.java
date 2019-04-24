package br.com.apsoo.pedidos.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity// para dizer que é uma classe elegivel para entidade no banco de dados
@Table(name = "TB_CIDADE")//para alterar o nome(no caso de estado para TB_ESTADO).
@SequenceGenerator(name = "seq_cidade")//cria sequence e dá um nome
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CI_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_cidade")
    private Long id;

    @Column(name = "CI_NOME")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "ES_ID")
    private Estado estado;

    public Cidade() {
    }

    public Cidade(Long id, String nome, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return id.equals(cidade.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
