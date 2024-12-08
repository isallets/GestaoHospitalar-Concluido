package gestaohospitalar;

import java.util.Scanner;

public class GestaoHospitalar {

    public static void main(String[] args) {
        Scanner e = new Scanner(System.in);

        Paciente pacientes[] = new Paciente[100];
        Medico medicos[] = new Medico[100];
        EstadoAtendimento estados[] = new EstadoAtendimento[10];       
        
        for (int i = 0; i < EstadoAtendimento.values().length; i++) {
            estados[i] = EstadoAtendimento.values()[i];
        }
        
        GerenciaMedicos gm = new GerenciaMedicos(medicos);
        GerenciaPacientes gp = new GerenciaPacientes(pacientes);
        GerenciaEstadoAtendimento gea = new GerenciaEstadoAtendimento(10);
        
        int op1, op2, op3, op4, pos;
        String novoEstado;
        
        do{
            System.out.println("--==[Gestão Hospitalar]==--");
            System.out.println("1 - Médicos");
            System.out.println("2 - Pacientes");
            System.out.println("3 - Login do Médico");
            System.out.println("4 - Estados de Atendimento");
            System.out.println("5 - Sair");
            System.out.println("Opção: ");
            op1 = e.nextInt();
            e.skip("\n");
            
            switch(op1){
                case 1:
                    do{
                        System.out.println("--==[Médicos]==--");
                        System.out.println("1 - Cadastrar");
                        System.out.println("2 - Alterar");
                        System.out.println("3 - Excluir");
                        System.out.println("4 - Consultar");
                        System.out.println("5 - Relatório");
                        System.out.println("6 - Voltar ao menu principal");
                        System.out.println("Opção: ");
                        op2 = e.nextInt();
                        e.skip("\n");

                        switch(op2){
                            case 1:
                                gm.cadastrar();
                                break;
                            case 2:
                                gm.alterar();
                                break;
                            case 3:
                                gm.excluir();
                                break;
                            case 4:
                                gm.consultar();
                                break;
                            case 5:
                                gm.relatorio();
                        }
                    }while(op2 != 6);
                    break;
                case 2:
                    do{
                        System.out.println("--==[Pacientes]==--");
                        System.out.println("1 - Cadastrar");
                        System.out.println("2 - Alterar");
                        System.out.println("3 - Excluir");
                        System.out.println("4 - Consultar");
                        System.out.println("5 - Relatório");
                        System.out.println("6 - Voltar ao menu principal");
                        System.out.println("Opção: ");
                        op2 = e.nextInt();
                        e.skip("\n");

                        switch(op2){
                            case 1:
                                gp.cadastrar();
                                break;
                                        
                            case 2:
                                gp.alterar();
                                break;
                            case 3:
                                gp.excluir();
                                break;
                            case 4:
                                gp.consultar();
                                break;
                            case 5:
                                gp.relatorio();
                        }
                    }while(op2 != 6);
                    break;
                case 3:
                    Medico medicoLogado= gm.loginMedico();
                    if(medicoLogado!=null){
                        do{
                            System.out.println("--==[Login do Médico]==--");
                            System.out.println("1 - Alterar estado do paciente");
                            System.out.println("2 - Voltar ao menu principal");
                            System.out.println("Opção: ");
                            op3 = e.nextInt();
                            e.skip("\n");

                            switch(op3){
                                case 1:
                                    gea.atualizarEstadoPaciente(medicoLogado, pacientes, estados);
                            }
                        }while(op3 != 2);
                    }
                    break;
                case 4:
                    do{
                        System.out.println("--==[Estados de Atendimento]==--");
                        System.out.println("1 - Cadastrar");
                        System.out.println("2 - Excluir");
                        System.out.println("3 - Relatório");
                        System.out.println("4 - Voltar ao menu principal");
                        System.out.println("Opção: ");
                        op4 = e.nextInt();
                        e.skip("\n");
                        switch(op4){
                            case 1:
                                System.out.print("Digite o nome do novo estado: ");
                                novoEstado = e.nextLine().toUpperCase();
                                gea.cadastrarEstado(novoEstado);
                                break;

                            case 2:
                                System.out.println("Digite uma posição para excluir do estado:");
                                pos = e.nextInt();
                                gea.excluirEstado(pos);
                                break;
                            case 3:
                                gea.listarEstados();
                        }
                        
                    }while(op4 != 4);
            }
        }while(op1 != 5);
    }
}
