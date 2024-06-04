package gabriel.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import gabriel.cursomc.domain.Categoria;
import gabriel.cursomc.domain.Cidade;
import gabriel.cursomc.domain.Cliente;
import gabriel.cursomc.domain.Endereco;
import gabriel.cursomc.domain.Estado;
import gabriel.cursomc.domain.ItemPedido;
import gabriel.cursomc.domain.Pagamento;
import gabriel.cursomc.domain.PagamentoComBoleto;
import gabriel.cursomc.domain.PagamentoComCartao;
import gabriel.cursomc.domain.Pedido;
import gabriel.cursomc.domain.Produto;
import gabriel.cursomc.domain.enuns.EstadoPagamento;
import gabriel.cursomc.domain.enuns.TipoCliente;
import gabriel.cursomc.repositories.CategoriaRepository;
import gabriel.cursomc.repositories.CidadeRepository;
import gabriel.cursomc.repositories.ClienteRepository;
import gabriel.cursomc.repositories.EnderecoRepository;
import gabriel.cursomc.repositories.EstadoRepository;
import gabriel.cursomc.repositories.ItemPedidoRepository;
import gabriel.cursomc.repositories.PagamentoRepository;
import gabriel.cursomc.repositories.PedidoRepository;
import gabriel.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepositoy;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepositoy;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoReposory;
	

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritorio");
		Categoria cat3 = new Categoria(null,"Casa");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);
		
		Produto p4 = new Produto(null,"Toalha",20.00);
		Produto p5 = new Produto(null,"Sabonete",30.00);
		Produto p6 = new Produto(null,"Mesa",1500.00);
		
		//add VARIOS PRODUTOS NAS SUAS CATEGORIAS CORRESPENDENTES  
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		cat3.getProdutos().addAll(Arrays.asList(p4,p5,p6));
		
		//add CATEGORIA NO SEU PRODUTO CORRESPENDENTES
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p4.getCategorias().addAll(Arrays.asList(cat3));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));

		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6));
		
		//ESTANCIANDO ESTADO E CIDADE
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null,"Uberlândia",est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepositoy.saveAll(Arrays.asList(c1,c2,c3));
		
		//CRIANDO E ADD CLIENTE COM TELEFONES E ENDEREÇOS
		
		Cliente cli1 = new Cliente(null,"Maria Silva","maria@hotmail.com","99988877766",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("3333-4444","4444-3333"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apt 303", "Jardim", "88042156", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105","Sala 800", "Centro","88060423",cli1,c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));		
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		// CRIANDO PEDIDO E FORMA DE PAGAMENTO
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/10/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO,ped1,6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE,ped2,sdf.parse("20/10/2017 00:00"),null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepositoy.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1,p1,0.00,1,2000.00); 
		ItemPedido ip2 = new ItemPedido(ped1,p3,0.00,2,80.00);
		ItemPedido ip3 = new ItemPedido(ped2,p2, 100.00, 1,800.00);
		ItemPedido ip4 = new ItemPedido(ped1,p4,10.00,1, 1500.00);
		ItemPedido ip5 = new ItemPedido(ped2,p5,15.00,1, 200.00);
		ItemPedido ip6 = new ItemPedido(ped1,p6,12.00,1, 3500.00);
		
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2,ip4,ip6));
		ped2.getItens().addAll(Arrays.asList(ip3,ip5));
		
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p1.getItens().addAll(Arrays.asList(ip2));
		p1.getItens().addAll(Arrays.asList(ip4));
		p1.getItens().addAll(Arrays.asList(ip6));
		p2.getItens().addAll(Arrays.asList(ip3));
		p2.getItens().addAll(Arrays.asList(ip5));
		
		itemPedidoReposory.saveAll(Arrays.asList(ip1,ip2,ip3,ip4,ip5,ip6));
		
		
	}
	

}
