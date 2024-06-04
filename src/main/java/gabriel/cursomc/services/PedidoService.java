package gabriel.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gabriel.cursomc.domain.Pedido;
import gabriel.cursomc.repositories.PedidoRepository;

@Service // DECLARANDO A CLASSE SERVIÇO
public class PedidoService {
	
	@Autowired // AUTO INSTANCIAÇÃO
	private PedidoRepository repo;
	
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExceptionG(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
		}
	

	public List<Pedido> listar() {	
		return repo.findAll();
	}

}
