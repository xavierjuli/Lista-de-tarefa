import java.util.Scanner;
import database.TarefaService;

public class MenuTerminal {
    //somente mostra o menu em loop para o terminal

    public void menu(){
        Scanner scanner = new Scanner(System.in);
        TarefaService tarefaService= new TarefaService();

        int opcao;
        do {
            System.out.println("\n=== Lista de Tarefas ===");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Listar todas as tarefas");
            System.out.println("3. Listar tarefas concluídas");
            System.out.println("4. Listar tarefas pendentes");
            System.out.println("5. Marcar como concluída uma tarefa");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        System.out.print("Digite a descrição da tarefa: ");
                        String descricao = scanner.nextLine();
                        if (tarefaService.criarTarefa(descricao)) {
                            System.out.println("Tarefa adicionada com sucesso!");
                        } else {
                            System.out.println("Falha ao adicionar tarefa");
                        }
                        break;
                    case 2:
                        System.out.println("Todas as Tarefas:");
                        tarefaService.listarTodas().forEach(tarefa ->{
                            System.out.println(tarefa.getId() + ": " + tarefa.getTexto() + (tarefa.isConcluida() ? " [Concluída]" : " [Pendente]"));
                        });
                        break;
                    case 3:
                        System.out.println("Tarefas Concluídas");
                        tarefaService.listarConcluidas().forEach(tarefa -> {
                            System.out.println(tarefa.getId() + ": " + tarefa.getTexto() +
                                    " - " + tarefa.getDataAlteracao());
                        });
                        break;
                    case 4:
                        System.out.println("Tarefas Pendentes");
                        tarefaService.listarPendentes().forEach(tarefa -> {
                            System.out.println(tarefa.getId() + ": " + tarefa.getTexto() +
                                    " - " + tarefa.getDataAlteracao());
                        });
                        break;
                    case 5:
                        System.out.print("Digite o ID da tarefa a ser marcada como concluída: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        if (tarefaService.atualizarStatus(id, true)) {
                            System.out.println("Tarefa marcada como concluída!");
                        } else {
                            System.out.println("Falha ao marcar tarefa como concluída");
                        }
                        break;
                    case 6:
                        System.out.println("Saindo...");
                        break;
                    default:System.out.println("Opção inválida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Erro!" + e.getMessage());
                opcao = -1;
            }
        } while (opcao != 6);

        scanner.close();
    }
}
