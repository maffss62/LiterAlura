package br.com.alura.literalura.literalura.repository;

import br.com.alura.literalura.literalura.model.autor.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> autoresCadastrados();

    List<Autor> autoresVivosNaqueleAno(int anoInformado);
}
