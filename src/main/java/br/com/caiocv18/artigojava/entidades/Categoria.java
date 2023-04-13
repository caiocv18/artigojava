package br.com.caiocv18.artigojava.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_categoria")
public class Categoria implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    /*
      Serve para gerar o ID no momento de adicionar a entidade no banco de dados.
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    @OneToMany(mappedBy = "categoriaReceita")
    @JsonIgnore
    private List<Receita> receitas = new ArrayList<>();
    @OneToMany(mappedBy = "categoriaDespesa")
    @JsonIgnore
    private List<Despesa> despesas = new ArrayList<>();

    public Categoria() {
    }

    public Categoria(String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Receita> getReceitas() {
        return receitas;
    }

    public List<Despesa> getDespesas() {
        return despesas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return id.equals(categoria.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
