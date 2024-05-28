package gabriel.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gabriel.cursomc.domain.Categoria;
import gabriel.cursomc.repositories.CategoriaRepository;

@Service // DECLARANDO A CLASSE SERVIÇO
public class CategoriaService {
	
	@Autowired // AUTO INSTANCIAÇÃO
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<Categoria> listar() {
		return repo.findAll();
	}

}
