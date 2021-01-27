import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		
		Loja loja = new Loja();
		int opcao;
		String confirm;
		Scanner in = new Scanner(System.in);
		String nomeProduto;
		
		System.out.println("Loja XPTO online \n\n");
		System.out.println("Logado como: Operdador Teste\n\n");
		while (true) {
			////Arrumamos o case de saída da loja
			System.out.println("Pressione:\n\t 1 - Adicionar produtos\n\t2 - Excluir Produtos\n\t3 - Exibir produtos\n\t4 - Procurar produto\n\t5 - Atualizar produto\n\t6 - sair\nopcao: ");
			opcao = in.nextByte();
			switch (opcao) {
			case 1:
				String nome;
				int quantidade;
				float preco;
				in.nextLine();
				System.out.println("Nome do Produto a ser Adicionado: ");
				nome = in.next();
				System.out.println("Quantidade do produto:");
				quantidade = in.nextInt();
				System.out.println("Preco unitario: ");
				preco = in.nextFloat();
				String[] separa=in.nextLine() .replaceAll("[ ]+", " ") .split(" ");
				String frase2 ="";
				String dados= "";
				for (String frase:separa) {
					frase2=frase.replaceAll(" ", "");
					if(!frase2.isEmpty()) {
						dados=dados+" "+frase2;
					}
				}
				try {
					nome=dados;
				} catch (InputMismatchException e) {
					System.err.println("Nome Invalido");
					break;
				}
				Produto p = new Produto(nome, quantidade, preco);
				loja.addProduto(p);
				System.out.println("Produto Adicionado");
				break;
			case 2:
				System.out.println("Nome do Produto a ser Removido: ");
				nomeProduto = in.next();
				if (loja.Busca(nomeProduto)) {
					System.out.println("\n (y/n) Realmente deseja remover esse produto?" + nomeProduto);
					confirm = in.next();
					if (confirm.equals("y")) {
						if (loja.RemoveProduto(nomeProduto)) {
							System.out.println("Produto" + nomeProduto + "Removido" );
						}
					} else {
						System.out.println("Operacao Cancelada\n");
					}
				} else {
					System.out.println("Produto: " + nomeProduto + "nao encontrado");
				}
				break;

			case 3: 
				System.out.println("A loja XPTO tem os Seguintes Produtos:\n");
				loja.ListaTudo();
				break;
			case 4:
				System.out.println("Qual o nome do produto a ser buscado: ");
				nomeProduto = in.next();
				if (loja.Busca(nomeProduto)) {
					System.out.println("Produto" + nomeProduto + "encontrado");
					loja.MostraProdutos(nomeProduto);
				} else {
					System.out.println("Produto" + nomeProduto + "não encontado");
				}
				break;
			////////Implementamos a função de aletaração de produto
			case 5:
				System.out.println("Qual o nome do produto a ser alterado: ");
				nomeProduto = in.next();
				if (loja.Busca(nomeProduto)) {
					System.out.println("Produto" + nomeProduto + "encontrado");
					System.out.println("Insira o novo nome: ");
					String novo_nome;
					System.out.println("Insira o nova quantidade: ");
					int nova_quantidade;
					System.out.println("Insira o novo preço: ");
					float novo_preco;
					novo_nome = in.next();
					nova_quantidade = in.nextInt();
					novo_preco = in.nextFloat();
					loja.atualizarProduto(nomeProduto, novo_nome, nova_quantidade, novo_preco );
				} else {
					System.out.println("Produto" + nomeProduto + "não encontado");
				}
				break;
			case 6:
				System.exit(0);
			}
		}
	}
}
