package br.com.alura.literalura.literalura.service;

import br.com.alura.literalura.literalura.model.livro.LivroDTO;
import br.com.alura.literalura.literalura.model.autor.AutorDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConversorDados {

    public LivroDTO converterDados(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        var node = mapper.readTree(json);
        var jsonLivro = node.get("results").get(0);

        return mapper.treeToValue(jsonLivro, LivroDTO.class);
    }
}
