import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TarefaDAO dao = new TarefaDAO();

        int opcao = 0;

        while (opcao != 7) {

            System.out.println("\n===== GESTÃO DE TAREFAS =====");

            System.out.println("1 - Criar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Concluir tarefa");
            System.out.println("4 - Excluir tarefa");
            System.out.println("5 - Filtrar por categoria");
            System.out.println("6 - Filtrar por status");
            System.out.println("7 - Sair");

            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Categoria: ");
                    String categoria = scanner.nextLine();

                    dao.criarTarefa(titulo, categoria);

                    break;

                case 2:
                    dao.listarTarefas();
                    break;

                case 3:

                    System.out.print("ID da tarefa: ");
                    int id = scanner.nextInt();

                    dao.concluirTarefa(id);

                    break;

                case 4:

                    System.out.print("ID da tarefa: ");
                    int excluir = scanner.nextInt();

                    dao.excluirTarefa(excluir);

                    break;

                case 5:

                    System.out.print("Categoria: ");
                    String cat = scanner.nextLine();

                    dao.filtrarCategoria(cat);

                    break;

                case 6:

                    System.out.print("Status (Pendente ou Concluída): ");
                    String status = scanner.nextLine();

                    dao.filtrarStatus(status);

                    break;
            }
        }
    }
}