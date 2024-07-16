package br.com.alura.literalura.literalura.repository;

import br.com.alura.literalura.literalura.model.livro.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> livrosCadastrados();
}

