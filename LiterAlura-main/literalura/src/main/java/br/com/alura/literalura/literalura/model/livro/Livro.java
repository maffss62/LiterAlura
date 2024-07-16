package br.com.alura.literalura.literalura.model.livro;

import br.com.alura.literalura.literalura.model.autor.Autor;
import br.com.alura.literalura.literalura.model.autor.AutorDTO;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;
    @ManyToMany(mappedBy = "livros", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Autor> autor;
    private List<String> idioma;
    private int numeroDownloads;

    public Livro(LivroDTO livro, List<AutorDTO> autores){
        this.nome = livro.nome();
        this.numeroDownloads = livro.numeroDownloads();
        setIdioma(livro.idioma());
        this.autor = autores.stream()
                .map(Autor::new).toList();
    }

    public Livro(){
    }

    public List<String> getIdioma() {
        return idioma;
    }

    public void setIdioma(List<String> idioma) {
        this.idioma = idioma;
    }

    public Long getId() {
        return id;
    }


    public String getAutor() {
        String autores = autor.stream().
                map(Autor::getNome).
                collect(Collectors.joining(", "));
        return autores;
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

    public int getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setNumeroDownloads(int numeroDownloads) {
        this.numeroDownloads = numeroDownloads;
    }

    public void setAutor(List<Autor> autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        String retorno = "\n----------- LIVRO -----------\n" +
                "\nNome: " + this.getNome() +
                "\nAutor(es): " + this.getAutor() +
                "\nIdioma(s) " + this.getIdioma() +
                "\nNúmero de Downloads: " + this.getNumeroDownloads();
        return retorno;
    }


}