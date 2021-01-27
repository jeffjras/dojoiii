import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
				
	public static boolean containsOnlyNumbers(String str) {        
        if (str == null || str.length() == 0)
            return false;
        
        for (int i = 1; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)))
                return false;
        }        
        return true;
    }
	
	public static void main(String[] args) {
		
		Loja loja = new Loja();
		int opcao;
		String confirm;
		Scanner in = new Scanner(System.in);
		String nomeProduto;
		
		System.out.println("Loja XPTO online \n\n");
		System.out.println("Logado como: Operdador Teste\n\n");
		while (true) {
			////Arrumamos o case de sa�da da loja
			System.out.println("Pressione:\n\t1 - Adicionar produtos\n\t2 - Excluir Produtos\n\t3 - Exibir produtos\n\t4 - Procurar produto\n\t5 - Atualizar produto\n\t6 - sair\nopcao: ");
			opcao = in.nextByte();
			switch (opcao) {
			case 1:
				String nome;
				int quantidade;
				float preco;
				
				in.nextLine();
				
				System.out.println("Nome do Produto a ser Adicionado: ");
				
				String[] separa = in.nextLine().replaceAll("[ ]+", " ").split(" ");
				
				String frase2 = "";
				String dados = "";
				for (String frase : separa) { 
					frase2 = frase.replaceAll(" ", ""); 
					if (!frase2.isEmpty()) {
						dados = dados + " " + frase2;
					}											
				}
								
				try {
					//dados.matches("^[0-9]*[.]{0,1}[0-9]*$"))					
					if (containsOnlyNumbers(dados)) {
						InputMismatchException erro = new InputMismatchException();
					    throw erro;
					} else {
						nome = dados;
					}												           
		        } catch (InputMismatchException e) {		        	
		            System.err.println("Nome inválido! \n");		        		           
		            break;
		        } catch (IllegalArgumentException e) {		        	
		            System.err.println("Parâmetro inválido! \n");          
		            break;
		        }
					
				System.out.println("Quantidade do produto:");				
				quantidade = 0;
				try {
					quantidade = in.nextInt();		            		            
		        }  				
				catch (InputMismatchException erro1) {		        	
		            System.err.println("(1) Não é permitido inserir letras na quantidade, informe apenas números inteiros\n(2) Não é possível inserir números decimais\n");
		            in.nextLine();
		            break;
		        }
				
				System.out.println("Preco unitario: ");				
				preco = 0;
				try {
					preco = in.nextFloat();		            		           
		        }  				
				catch (InputMismatchException erro1) {		        	
		            System.err.println("(1) Não é permitido inserir letras no preço\n(2) Foi digitado um caracter inválido (.#$%&*@ )\n");
		            in.nextLine();
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
					System.out.println("\n (y/n) Realmente deseja remover o produto: " + nomeProduto + " ?");
					confirm = in.next();
					if (confirm.trim().equals("y")) {
						if (loja.RemoveProduto(nomeProduto)) {
							System.out.println("Produto " + nomeProduto + " Removido! \n" );
						}
					} else {
						System.out.println("Operacao Cancelada\n");
					}
				} else {
					System.err.println("Produto: " + nomeProduto + " não encontrado! \n");
					in.nextLine();
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
					System.out.println("Produto " + nomeProduto + " encontrado!");
					loja.MostraProdutos(nomeProduto);
				} else {
					System.err.println("Produto " + nomeProduto + " não encontado!");
				}											
				break;
			////////Implementamos a fun��o de aletara��o de produto
			case 5:
				System.out.println("Qual o nome do produto a ser alterado: ");
				nomeProduto = in.next();
				if (loja.Busca(nomeProduto)) {
					String novo_nome;
					int nova_quantidade;
					float novo_preco;
					System.out.println("Produto " + nomeProduto + " encontrado!");					
					System.out.println("Insira o novo nome: ");
					novo_nome = in.next();
					System.out.println("Insira o nova quantidade: ");
					nova_quantidade = in.nextInt();
					System.out.println("Insira o novo pre�o: ");
					novo_preco = in.nextFloat();
					loja.atualizarProduto(nomeProduto, novo_nome, nova_quantidade, novo_preco );
					System.out.println("Produto atualizado com sucesso! ");
				} else {
					System.err.println("Produto " + nomeProduto + " não encontado!");
				}
				break;
			case 6:
				System.exit(0);
			}
		}
	}
}
