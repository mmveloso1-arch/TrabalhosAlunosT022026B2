import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;

class Produto {
    private int id;
    private String nome;
    private double preco;

    public Produto(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome + " | Preço: " + String.format(Locale.US, "%.2f", preco);
    }
}

public class CadastroProdutos { 
    private static ArrayList<Produto> produtos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        scanner.useLocale(Locale.US); 
        
        int opcao = -1;

        do {
            exibirMenu();
            
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcao) {
                    case 1: cadastrar(); break;
                    case 2: listar(); break;
                    case 3: buscar(); break;
                    case 4: atualizar(); break;
                    case 5: excluir(); break;
                    case 0:
                        System.out.println("Encerrando o programa...");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } else {
                System.out.println("Opção inválida! Digite um número correspondente ao menu.");
                scanner.nextLine(); 
            }
        } while (opcao != 0);
        
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n========== SISTEMA DE GERENCIAMENTO ==========");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar todos");
        System.out.println("3 - Buscar por ID");
        System.out.println("4 - Atualizar");
        System.out.println("5 - Excluir");
        System.out.println("0 - Sair");
        System.out.print("\nEscolha uma opção: ");
    }

    private static void cadastrar() {
        System.out.print("Digite o ID do produto: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        if (encontrarProdutoPorId(id) != null) {
            System.out.println("Erro: Já existe um produto cadastrado com este ID!");
            return;
        }

        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o preço do produto (ex: 15.50): ");
        double preco = scanner.nextDouble();
        scanner.nextLine();
        
        Produto novoProduto = new Produto(id, nome, preco);
        produtos.add(novoProduto);
        
        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void listar() {
        if (produtos.isEmpty()) {
            System.out.println("Não há registros cadastrados no momento.");
        } else {
            System.out.println("\n--- Lista de Produtos ---");
            for (Produto p : produtos) {
                System.out.println(p.toString());
            }
        }
    }

    private static void buscar() {
        if (produtos.isEmpty()) {
            System.out.println("Não há registros cadastrados para buscar.");
            return;
        }

        System.out.print("Digite o ID do produto que deseja buscar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Produto produtoEncontrado = encontrarProdutoPorId(id);

        if (produtoEncontrado != null) {
            System.out.println("Registro encontrado:");
            System.out.println(produtoEncontrado.toString());
        } else {
            System.out.println("Nenhum produto encontrado com o ID informado.");
        }
    }

    private static void atualizar() {
        if (produtos.isEmpty()) {
            System.out.println("Não há registros cadastrados para atualizar.");
            return;
        }

        System.out.print("Digite o ID do produto que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Produto produtoEncontrado = encontrarProdutoPorId(id);

        if (produtoEncontrado != null) {
            System.out.print("Digite o novo nome (atual: " + produtoEncontrado.getNome() + "): ");
            String novoNome = scanner.nextLine();
            
            System.out.print("Digite o novo preço (atual: " + produtoEncontrado.getPreco() + "): ");
            double novoPreco = scanner.nextDouble();
            scanner.nextLine();

            produtoEncontrado.setNome(novoNome);
            produtoEncontrado.setPreco(novoPreco);
            
            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Nenhum produto encontrado com o ID informado.");
        }
    }

    private static void excluir() {
        if (produtos.isEmpty()) {
            System.out.println("Não há registros cadastrados para excluir.");
            return;
        }

        System.out.print("Digite o ID do produto que deseja excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Produto produtoEncontrado = encontrarProdutoPorId(id);

        if (produtoEncontrado != null) {
            produtos.remove(produtoEncontrado);
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Nenhum produto encontrado com o ID informado.");
        }
    }

    private static Produto encontrarProdutoPorId(int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}