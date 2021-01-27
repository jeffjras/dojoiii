import java.util.ArrayList;
import java.util.List;


public class Loja {
	protected List<Produto> produtos;

	public Loja() {
		this.produtos = new ArrayList<>();
	}
	
	
	public void addProduto (Produto produto) {
		this.produtos.add(produto);
	}
	
	public boolean RemoveProduto(String nomeProduto) {
		for(Produto p : this.produtos) {
			if (p.getName().equals(nomeProduto)) {
				this.produtos.remove(p);
				return true;
			}
		}
		return false;
	}
	
	public void MostraProdutos(String nome) {
		if (this.Quantidade() > 0) {
			for (Produto p : this.produtos) {
				if (p.getName().equals(nome)) {
					System.out.println(p);
				}
			}
		} else {
			System.out.println("Carrinho de Compras Vazio.\n");
		}
	}
	
	public int Quantidade() {
		return this.produtos.size();
	}
	
	public boolean Busca (String nomeProduto) {
		for(Produto p : this.produtos) {
			if (p.getName().equals(nomeProduto)) {
				return true;
			}
		}
		throw new IllegalArgumentException();
	}	
	
	//////Implementamos a função de atualizarProduto
	//////Recebe o nome do produto para ser alterado e pede os novos parametros para que seja alterado
	public boolean atualizarProduto(String nomeProduto, String novo_nome, int nova_quantidade, float novo_preco) {
		for(Produto p : this.produtos) {
			if (p.getName().equals(nomeProduto)) {
				p.setName(novo_nome);
				p.setQuant(nova_quantidade);
				p.setPreco(novo_preco);
				return true;
			}
		}
		return false;
	}
	
	public void ListaTudo () {
		for (Produto p : this.produtos) {			
			System.out.println(p);
		}
		System.out.println();
	}
	
}
