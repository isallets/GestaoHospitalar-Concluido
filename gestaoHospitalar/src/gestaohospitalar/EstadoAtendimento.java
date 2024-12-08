package gestaohospitalar;

public enum EstadoAtendimento {
    ENTRADA,
    TRATAMENTO_CLINICO_GERAL,
    PREPARACAO_PRE_CIRURGIA,
    CIRURGIA,
    POS_CIRURGIA,
    ALTA_CLINICA;
    
    public static boolean estadoExistente(String nome) {
        for (EstadoAtendimento estado : EstadoAtendimento.values()) {
            if (estado.name().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }
}
