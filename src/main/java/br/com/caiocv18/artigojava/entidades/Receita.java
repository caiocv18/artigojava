package br.com.caiocv18.artigojava.entidades;

import br.com.caiocv18.artigojava.enums.ReceitaStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_receita")
public class Receita implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    /*
     * Serve para gerar o ID no momento de adicionar a entidade no banco de dados.
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private Double valor;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT-3")
    private Instant data;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private Usuario usuario;

    private Integer status;

    public Receita() {
    }

    public Receita(String titulo, Double valor, Instant data, ReceitaStatus status, Usuario usuario) {
        super();
        this.titulo = titulo;
        this.valor = valor;
        this.data = data;
        setStatus(status);
        this.usuario = usuario;
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public ReceitaStatus getStatus() {
        return ReceitaStatus.valorDoCodigo(status);
    }

    public void setStatus(ReceitaStatus status) {
        if(status != null){
            this.status = status.getCodigo();
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receita receita = (Receita) o;
        return id.equals(receita.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
