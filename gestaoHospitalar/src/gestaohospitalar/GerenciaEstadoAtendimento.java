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
        
        public void excluirEstado(int posicao) {
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

    private Scanner scanner = new Scanner(System.in);
    
        
    public void atualizarEstadoPaciente(Medico medico, Paciente[] pacientes, EstadoAtendimento[] estados) {
        System.out.println("Digite o ID do paciente para alterar o estado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        for (Paciente paciente : pacientes) {
            if (paciente != null) { 
                System.out.println("Paciente encontrado: " + paciente.getNome());
                System.out.println("Estado atual: " + paciente.getEstadoAtendimento());

                System.out.println("Estados disponíveis: ");
                listarEstados();

                System.out.println("Escolha o novo estado pelo índice: ");
                int novoEstadoIndex = scanner.nextInt() - 1;  
                scanner.nextLine();  

                if (novoEstadoIndex >= 0 && novoEstadoIndex < estados.length && estados[novoEstadoIndex] != null) {
                    paciente.setEstadoAtendimento(estados[novoEstadoIndex]); 
                    System.out.println("Estado do paciente atualizado para: " + paciente.getEstadoAtendimento());
                } else {
                    System.out.println("Opção inválida.");
                }

                return;
            }
        }

        System.out.println("Paciente não encontrado.");
    }

}

    



