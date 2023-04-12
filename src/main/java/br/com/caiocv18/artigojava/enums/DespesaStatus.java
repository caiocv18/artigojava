package br.com.caiocv18.artigojava.enums;

public enum DespesaStatus {
    PAGA(1),
    PENDENTE(2),
    AGENDADA(3),
    ATRASADA(4);
    private int codigo;

    DespesaStatus(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static DespesaStatus valorDoCodigo(int codigo){
        for (DespesaStatus valor : DespesaStatus.values()){
            if (valor.getCodigo() == codigo){
                return valor;
            }
        }
        throw new IllegalArgumentException("Código inválido para o status de uma Despesa");
    }

}
