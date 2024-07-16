package br.com.alura.literalura.literalura.principal;

import br.com.alura.literalura.literalura.repository.AutorRepository;
import br.com.alura.literalura.literalura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.awt.Menu;
import java.security.Principal;

import static java.awt.SystemColor.menu;

@SpringBootApplication
@EntityScan(basePackages = {"br.com.alura.literalura.model.livro", "br.com.alura.literalura.model.autor"})
@EnableJpaRepositories(basePackages = "br.com.alura.literalura.repository")
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private LivroRepository repositorioLivro;
	@Autowired
	private AutorRepository repositorioAutor;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Olá, seja bem vindo ao Projeto Literalura!\n");

		Object repository = null;
		Principal principal = new Principal(repository) {
            @Override
            public boolean equals() {
                return equals(null);
            }

            @Override
			public boolean equals(Object another) {
				return false;
			}

			@Override
			public String toString() {
				return "";
			}

			@Override
			public int hashCode() {
				return 0;
			}

			@Override
			public String getName() {
				return "";
			}
		}
		principal.getName(menu);
	}
}

