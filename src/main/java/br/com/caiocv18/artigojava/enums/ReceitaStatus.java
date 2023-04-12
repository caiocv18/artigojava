package br.com.caiocv18.artigojava.enums;

public enum ReceitaStatus {
    RECEBIDA(1),
    PENDENTE(2),
    AGENDADA(3),
    ATRASADA(4);
    private int codigo;

    ReceitaStatus(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static ReceitaStatus valorDoCodigo(int codigo){
        for (ReceitaStatus valor : ReceitaStatus.values()){
            if (valor.getCodigo() == codigo){
                return valor;
            }
        }
        throw new IllegalArgumentException("Código inválido para o status de uma Receita");
    }

}
