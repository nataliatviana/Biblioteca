// Natália Toscano Viana
// Júlia Henriques de Andrade

package Facisa;
import java.util.Scanner;


public class Biblioteca {
	static Scanner sc = new Scanner(System.in);
	static String[] livros = new String[20];
	static String[] autores = new String[20];
	static String livro;
	static String autor;
	
	static int qntLivros = 0;
	
	public static void main(String[] args) {
		
		int opcao = 0;

		while (opcao != 5) {
			System.out.println("========== M E N U - P R I N C I P A L ==========");
			System.out.println("[1]ADICIONAR NOVO LIVRO \n "
							 + "[2]PESQUISAR POR TÍTULO \n "
							 + "[3]EXCLUIR POR TÍTULO \n "
							 + "[4]LISTAR LIVROS \n "
							 + "[5]SAIR"
							 );
			
			System.out.println("Digite sua opção:");
			opcao = sc.nextInt();
			sc.nextLine();

			switch (opcao) {
				case 1: 
					
					System.out.println("Qual livro você deseja adicionar:");
					livro = sc.nextLine().trim();
					
					System.out.println("Qual o autor do livro?");
					autor = sc.nextLine().trim();
					
					if(!(livro.isEmpty() || autor.isEmpty())) {
						
						livro = livro.toUpperCase();
						autor = autor.toUpperCase();
						
						addLivros(livro, autor);
						
						System.out.println("LIVRO ADICIONADO COM SUCESSO!!!");
						
					} else {
						System.out.println("ENTRADA INVÁLIDA!");	
					}
					
					break;
				
				case 2: 
					
					System.out.println("Qual livro deseja pesquisar:");
					livro = sc.nextLine().trim();
					livro = livro.toUpperCase();
					
					if(!(livro.isEmpty())) {
					
						pesquisarLivros(livro);
					}else {
						System.out.println("ENTRADA INVÁLIDA!");	
					}
					
					break;
				
				case 3: 
					
					System.out.println("Qual livro deseja excluir:");
					livro = sc.nextLine().trim();
					livro = livro.toUpperCase();
					
					if(!(livro.isEmpty())) {
						
						excluirLivros(livro);
					}else {
						System.out.println("ENTRADA INVÁLIDA!");	
					}
					
					break;
				
				case 4: 
					
					if (qntLivros == 0) {
						System.out.println("NÃO HÁ LIVROS CADASTRADOS!");
					}else {
						listarLivros();

					}

					break;
				
				case 5: 
	
					break;
				
				
				default:
					System.out.println("OPÇÃO INVÁLIDA, TENTE NOVAMENTE");
			}
			
			
		}
		System.out.println("FIM DO PROGRAMA!");
	}

	// MÉTODOS:
	

	public static void addLivros(String livro, String autor) {
				
				livros[qntLivros] = livro;
				autores[qntLivros] = autor;
				
				qntLivros += 1;
				
		}
	

	public static void pesquisarLivros(String livro) {
	
		boolean encontrou = false;
		
		for (int i = 0; i < qntLivros; i++) {
			if (livros[i].equals(livro)) {
				
				System.out.println("LIVRO PESQUISADO: " + livros[i]);
				System.out.println("AUTOR DO LIVRO PESQUISADO: " + autores[i]);

				encontrou = true;
				
				break;
			}
		}
		
		if (!encontrou) {
			System.out.println("LIVRO NÃO ENCONTRADO!");
		}

	}

	public static void excluirLivros(String livro) {
		
		boolean encontrou = false;
			
		for (int i = 0; i < qntLivros; i++) {
			if (livros[i].equals(livro)) {
				
				livros[i] = livros[qntLivros-1];
				autores[i] = autores[qntLivros-1];
				
				livros[qntLivros-1] = null;
				autores[qntLivros-1] = null;
				
				qntLivros--;
				
				encontrou = true;

				System.out.println("LIVRO EXCLUÍDO COM SUCESSO!");
			}

		}

		if(!encontrou) {
				System.out.println("LIVRO NÃO ENCONTRADO!");
			}
		}

	public static void listarLivros() {
		
		for (int i = 0; i < qntLivros; i++) {
			System.out.println("Nome do livro: "  + livros[i] + ", Autor do livro: " + autores[i]);
		}
	}
}

