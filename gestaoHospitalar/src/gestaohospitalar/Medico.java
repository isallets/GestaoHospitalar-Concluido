package gestaohospitalar;

public class Medico extends Pessoa {
    private String crm;
    private String especialidade;
    private String ctps;
    
    public Medico(String nome, String id, String cpf, String end, String tel, String crm, String esp, String ctps){
        super(nome, id, cpf, end, tel);
        this.crm = crm;
        especialidade = esp;
        this.ctps = ctps;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }
    
    public void alterarEstadoPaciente(Paciente paciente, EstadoAtendimento novoEstado) {
        paciente.setEstadoAtendimento(novoEstado);
        System.out.println("Estado do paciente " + paciente.getNome() + " alterado para: " + novoEstado);
    }
        
    @Override
    public void imprimir(){
        super.imprimir();
        System.out.println("C.R.M.         : " + crm);
        System.out.println("Especialidade  : " + especialidade);
        System.out.println("C.T.P.S.       : " + ctps);
    }
}
