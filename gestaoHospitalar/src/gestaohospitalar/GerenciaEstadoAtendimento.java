package gestaohospitalar;

import java.util.Scanner;

public class GerenciaEstadoAtendimento {
    private String[] estados;
    private int indiceAtual;

    public GerenciaEstadoAtendimento(int tamanhoMaximo) {
        this.estados = new String[tamanhoMaximo];
        this.indiceAtual = 0;

        for (EstadoAtendimento estado : EstadoAtendimento.values()) {
            if (indiceAtual < estados.length) {
                estados[indiceAtual++] = estado.name(); 
            }
        }
    }
    
        public void cadastrarEstado(String nome) {
        if (EstadoAtendimento.estadoExistente(nome)) {
            System.out.println("Estado já existe no enum. Não foi possível cadastrar.");
        } else if (estadoExistente(nome)) {
            System.out.println("Estado já existe no cadastro. Não foi possível cadastrar.");
        } else if (indiceAtual < estados.length) {
            estados[indiceAtual++] = nome;
            System.out.println("Novo estado cadastrado com sucesso: " + nome);
        } else {
            System.out.println("Não há mais espaço para novos estados.");
        }
    }
    
        private boolean estadoExistente(String nome) {
        for (int i = 0; i < indiceAtual; i++) {
            if (estados[i].equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }
        
        public void excluirEstadoPelaPosicao(int posicao) {
        if (posicao < 0 || posicao >= indiceAtual) {
            System.out.println("Posição inválida.");
            return;
        }

        if (EstadoAtendimento.estadoExistente(estados[posicao])) {
            System.out.println("Você não pode excluir um ESTADO PADRÃO do enum.");
            return;
        }

        for (int i = posicao; i < indiceAtual - 1; i++) {
            estados[i] = estados[i + 1]; 
        }
        estados[indiceAtual - 1] = null;
        indiceAtual--;

        System.out.println("Estado na posição " + posicao + " excluído com sucesso.");
    }
        
        public void listarEstados() {
        System.out.println("--==[Estados Cadastrados]==--");

        for (int i = 0; i < indiceAtual; i++) {
            System.out.println(estados[i]);
        }
    }    
    
    //-------------------------------
    private Scanner scanner = new Scanner(System.in);
    
        
    public void alterarEstadoPaciente(Medico medico, Paciente[] pacientes, String[] estados) {
    System.out.println("Digite o ID do paciente para alterar o estado: ");
    int id = scanner.nextInt();
    scanner.nextLine(); // Limpa o buffer

    // Busca o paciente pelo ID
    for (Paciente paciente : pacientes) {
        if (paciente != null) { // Verifica se o paciente existe e tem o ID correto
            System.out.println("Paciente encontrado: " + paciente.getNome());
            System.out.println("Estado atual: " + paciente.getEstadoAtendimento());

            // Exibe os estados disponíveis no array
            System.out.println("Estados disponíveis: ");
            for (int i = 0; i < estados.length; i++) {
                if (estados[i] != null) {
                    System.out.println((i + 1) + " - " + estados[i]); // Mostra o índice e o estado
                }
            }

            // Solicita ao médico a escolha do novo estado
            System.out.println("Escolha o novo estado: ");
            int novoEstadoIndex = scanner.nextInt() - 1;  // Subtrai 1 para ajustar o índice (começando de 0)
            scanner.nextLine();  // Limpa o buffer

            // Valida a escolha do novo estado
            if (novoEstadoIndex >= 0 && novoEstadoIndex < estados.length && estados[novoEstadoIndex] != null) {
                // Atualiza o estado do paciente
                paciente.setEstadoAtendimento(EstadoAtendimento.values()[novoEstadoIndex]);
                System.out.println("Estado do paciente atualizado para: " + paciente.getEstadoAtendimento());
            } else {
                System.out.println("Opção inválida.");
            }

            return;
        }
    }

    System.out.println("Paciente não encontrado.");
}

        
        
        
        
        
    /*
    private Scanner scanner = new Scanner(System.in);
 
    public void alterarEstadoPaciente(Medico medico, Paciente[] pacientes) {
        System.out.println("Digite o ID do paciente para alterar o estado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        for (Paciente paciente : pacientes) {
            if (paciente != null) {
                System.out.println("Paciente encontrado: " + paciente.getNome());
                System.out.println("Estado atual: " + paciente.getEstadoAtendimento());

                System.out.println("Estados disponíveis: ");
                for (EstadoAtendimento estado : EstadoAtendimento.values()) {
                    System.out.println(estado.ordinal() + 1 + " - " + estado);
                }

                System.out.println("Escolha o novo estado: ");
                int novoEstadoIndex = scanner.nextInt() - 1;
                scanner.nextLine();

                if (novoEstadoIndex >= 0 && novoEstadoIndex < EstadoAtendimento.values().length) {
                    paciente.setEstadoAtendimento(EstadoAtendimento.values()[novoEstadoIndex]);
                    System.out.println("Estado do paciente atualizado para: " + paciente.getEstadoAtendimento());
                } else {
                    System.out.println("Opção inválida.");
                }

                return;
            }
        }

        System.out.println("Paciente não encontrado.");
    }
*/
}

    



