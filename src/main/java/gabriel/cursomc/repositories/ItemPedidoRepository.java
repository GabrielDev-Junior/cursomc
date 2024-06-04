package gabriel.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gabriel.cursomc.domain.ItemPedido;
import gabriel.cursomc.domain.ItemPedidoPK;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPK> {
}
