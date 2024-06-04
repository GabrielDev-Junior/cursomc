package gabriel.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gabriel.cursomc.domain.Cliente;
import gabriel.cursomc.repositories.ClienteRepository;

@Service // DECLARANDO A CLASSE SERVIÇO
public class ClienteService {
	
	@Autowired // AUTO INSTANCIAÇÃO
	private ClienteRepository repo;
	
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExceptionG(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		}
	

	public List<Cliente> listar() {	
		return repo.findAll();
	}

}
