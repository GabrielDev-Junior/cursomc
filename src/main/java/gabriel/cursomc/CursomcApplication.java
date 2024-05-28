package gabriel.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import gabriel.cursomc.domain.Categoria;
import gabriel.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritorio");
		Categoria cat3 = new Categoria(null,"Lazer");
		
		categoriaRepository.saveAllAndFlush(Arrays.asList(cat1,cat2,cat3));
	}
	

}
