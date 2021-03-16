package br.com.senior.api;

import br.com.senior.api.entity.*;
import br.com.senior.api.entity.enums.TipoCliente;
import br.com.senior.api.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {


		Categoria cat1 = new Categoria();
		cat1.setNome("Informática");

		Categoria cat2 = new Categoria();
		cat2.setNome("Escritório");

		Categoria categoriaSalva1 = categoriaRepository.save(cat1);
		Categoria categoriaSalva2 = categoriaRepository.save(cat2);



		Produto p1 = new Produto();
		p1.setNome("Computador");
		p1.setPreco(new BigDecimal(2000));
		p1.setCategoria(categoriaSalva1);

		Produto p2 = new Produto();
		p2.setNome("Impressora");
		p2.setPreco(new BigDecimal(800));
		p2.setCategoria(categoriaSalva1);

		Produto p3 = new Produto();
		p3.setNome("Mouse");
		p3.setPreco(new BigDecimal(2400));
		p3.setCategoria(categoriaSalva2);

		produtoRepository.save(p1);
		produtoRepository.save(p2);
		produtoRepository.save(p3);

		Estado est1 = new Estado();
		est1.setNome("Minas Gerais");

		Estado est2 = new Estado();
		est2.setNome("São Paulo");

		Estado estadoSalvo1 = estadoRepository.save(est1);
		Estado estadoSalvo2 = estadoRepository.save(est2);

		Cidade c1 = new Cidade();
		c1.setNome("Uberlândia");
		c1.setEstado(estadoSalvo1);

		Cidade c2 = new Cidade();
		c2.setNome("São Paulo");
		c2.setEstado(estadoSalvo2);

		Cidade c3 = new Cidade();
		c3.setNome("Campinas");
		c3.setEstado(estadoSalvo2);

		cidadeRepository.save(c1);
		cidadeRepository.save(c2);
		cidadeRepository.save(c3);

		Cliente cli1 = new Cliente();
		cli1.setNome("Maria Silva");
		cli1.setEmail("maria@gmail.com");
		cli1.setCpfOuCnpj("36378912377");
		cli1.setTipo(TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		Cliente clienteSalvo = clienteRepository.save(cli1);

		Endereco e1 = new Endereco();
		e1.setLogradouro("Rua Flores");
		e1.setNumero("300");
		e1.setComplemento("Apto 303");
		e1.setBairro("Jardim");
		e1.setCep("38220837");
		e1.setCliente(clienteSalvo);
		e1.setCidade(c1);

		Endereco e2 = new Endereco();
		e2.setLogradouro("Avenida Matos");
		e2.setNumero("105");
		e2.setComplemento("Sala 800");
		e2.setBairro("Centro");
		e2.setCep("38777012");
		e2.setCliente(clienteSalvo);
		e2.setCidade(c2);

		clienteSalvo.getEnderecos().addAll(Arrays.asList(e1, e2));
		clienteRepository.save(clienteSalvo);
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
	}
}
