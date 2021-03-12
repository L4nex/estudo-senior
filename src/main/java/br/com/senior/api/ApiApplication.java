package br.com.senior.api;

import br.com.senior.api.entity.Categoria;
import br.com.senior.api.entity.Cidade;
import br.com.senior.api.entity.Estado;
import br.com.senior.api.entity.Produto;
import br.com.senior.api.repositories.CategoriaRepository;
import br.com.senior.api.repositories.CidadeRepository;
import br.com.senior.api.repositories.EstadoRepository;
import br.com.senior.api.repositories.ProdutoRepository;
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
		cidadeRepository.save(c3);;


//		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
//		cat2.getProdutos().addAll(Arrays.asList(p2));
//
//		p1.getCategorias().addAll(Arrays.asList(cat1));
//		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
//		p2.getCategorias().addAll(Arrays.asList(cat1));
//
//		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
//		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

	}
}
