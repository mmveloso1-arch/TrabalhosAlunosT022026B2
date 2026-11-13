import java.util.ArrayList;
import java.util.Scanner;


class Livro {
    private int id;
    private String titulo;
    private String autor;

    public Livro(int id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}

public class Livraria {
    static ArrayList<Livro> listaDeLivros = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n========== SISTEMA DE GERENCIAMENTO ==========");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar todos");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Excluir");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    atualizar();
                    break;
                case 5:
                    excluir();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }
        } while (opcao != 0);
        
        scanner.close();
    }

    public static void cadastrar() {
        System.out.print("Digite o ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        
        for (Livro l : listaDeLivros) {
            if (l.getId() == id) {
                System.out.println("Erro: Ja existe um livro com este ID");
                return;
            }
        }

        System.out.print("Digite o título: ");
        String titulo = scanner.nextLine();
        
        System.out.print("Digite o autor: ");
        String autor = scanner.nextLine();

        Livro l = new Livro(id, titulo, autor);
        listaDeLivros.add(l);
        
        System.out.println("Livro cadastrado com sucesso!");
    }

    public static void listar() {
        if (listaDeLivros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            System.out.println("\n--- LISTA DE LIVROS ---");
            
            for (Livro l : listaDeLivros) {
                System.out.println("ID: " + l.getId() + " | Título: " + l.getTitulo() + " | Autor: " + l.getAutor());
            }
        }
    }

    public static void buscar() {
        if (listaDeLivros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        System.out.print("Digite o ID que deseja buscar: ");
        int id = scanner.nextInt();
        
        boolean encontrou = false;
        
        
        for (Livro l : listaDeLivros) {
            if (l.getId() == id) {
                System.out.println("Livro encontrado: ID: " + l.getId() + " | Título: " + l.getTitulo() + " | Autor: " + l.getAutor());
                encontrou = true;
                break; 
            }
        }

        if (!encontrou) {
            System.out.println("ID nao existe.");
        }
    }

    public static void atualizar() {
        if (listaDeLivros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        System.out.print("Digite o ID do livro que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        boolean encontrou = false;
        
        // Atualizando usando for-each
        for (Livro l : listaDeLivros) {
            if (l.getId() == id) {
                System.out.print("Digite o novo titulo: ");
                String novoTitulo = scanner.nextLine();
                
                System.out.print("Digite o novo autor: ");
                String novoAutor = scanner.nextLine();
                
                l.setTitulo(novoTitulo);
                l.setAutor(novoAutor);
                
                System.out.println("Livro atualizado com sucesso");
                encontrou = true;
                break;
            }
        }

        if (!encontrou) {
            System.out.println("ID nao existe.");
        }
    }

    public static void excluir() {
        if (listaDeLivros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        System.out.print("Digite o ID do livro que deseja excluir: ");
        int id = scanner.nextInt();

        Livro livroParaRemover = null;
        
        for (Livro l : listaDeLivros) {
            if (l.getId() == id) {
                livroParaRemover = l; 
                break;
            }
        }

        if (livroParaRemover != null) {
            listaDeLivros.remove(livroParaRemover);
            System.out.println("Livro excluido com sucesso");
        } else {
            System.out.println("ID nao existe.");
        }
    }
}