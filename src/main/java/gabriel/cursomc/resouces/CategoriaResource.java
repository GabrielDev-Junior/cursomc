package gabriel.cursomc.resouces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.model.processor.PhaseIndicator;
import gabriel.cursomc.domain.Categoria;
import gabriel.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> lista(){
		List<Categoria> list = service.listar();
		return ResponseEntity.ok().body(list);	
	}

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Categoria  obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}
