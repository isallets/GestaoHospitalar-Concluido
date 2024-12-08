package gestaohospitalar;

public class Pessoa {
    private String nome;
    private String identidade;
    private String cpf;
    private String endereco;
    private String telefone;
    
    public Pessoa(String nome, String id, String cpf, String end, String tel){
        this.nome = nome;
        identidade = id;
        this.cpf = cpf;
        endereco = end;
        telefone = tel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public void imprimir(){
        System.out.println("Nome           : " + nome);
        System.out.println("Identidade     : " + identidade);
        System.out.println("C.P.F.         : " + cpf);
        System.out.println("Endereço       : " + endereco);
        System.out.println("Telefone       : " + telefone);
    }
}
