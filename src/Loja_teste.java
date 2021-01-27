import static org.junit.Assert.*;

import org.junit.Test;
public class Loja_teste {

	@Test
	public void adicionaProdutoTeste() {
		Produto prod = new Produto("Caneta", 5, 2);
		assertNotNull(prod.getName());
		assertEquals("Caneta",prod.getName());
		assertEquals(5, prod.getQuant(), 0.001);
		assertEquals(2,prod.getPreco(),0.001);
		
		Loja loja = new Loja();
		loja.addProduto(prod);
		assertEquals(1, loja.Quantidade());
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void buscarProdutoInexistenteTeste() {
		Produto prod = new Produto("Caneca", 50, 25);
		
		Loja loja = new Loja();
		loja.addProduto(prod);
		
		loja.Busca("Caneta");
	}
	
	@Test
	public void remocaoProdutoTeste() {
		Produto prod = new Produto("Gato", 50, 25);
		
		Loja loja = new Loja();
		loja.addProduto(prod);
		
		assertTrue(loja.RemoveProduto("Gato"));
	}
	
	@Test
	public void encontrarProdutoEspecificoTeste() {
		Produto prod = new Produto("Água", 100, 3);
		
		Loja loja = new Loja();
		loja.addProduto(prod);
		
		assertTrue(loja.Busca("Água"));
	}
	
	@Test
	public void verficarListaProdutos() {
		Produto prod1 = new Produto("Gato", 50, 25);
		Produto prod2 = new Produto("Cachorro", 10, 10);
		
		Loja loja = new Loja();
		loja.addProduto(prod1);
		loja.addProduto(prod2);
		
		assertEquals(loja.Quantidade(), 2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void verificarProdutoNaoEncontrado() {
		
		Produto prod = new Produto("Gato", 50, 25);
	
		Loja loja = new Loja();
		loja.addProduto(prod);

		loja.Busca("cachorro");
	}
}
