public class LoteProduto {
    String identificadorUnico;
    double quantidade;
    StatusLote status = StatusLote.EM_PRODUCAO;

    LoteProduto(String identificadorUnico, double quantidade) {
        this.identificadorUnico = identificadorUnico;
        this.quantidade = quantidade;
    }

    void liberar() {
        if (status == StatusLote.APROVADO) status = StatusLote.LIBERADO;
        else System.out.println("Lote precisa estar APROVADO para ser liberado");
    }

    void expedir() {
        if (status == StatusLote.LIBERADO) status = StatusLote.EXPEDIDO;
        else System.out.println("Lote precisa estar LIBERADO para ser expedido");
    }
}
