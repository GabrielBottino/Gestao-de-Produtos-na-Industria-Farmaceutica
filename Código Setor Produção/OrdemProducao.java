import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrdemProducao {
    int numero, prioridade;
    double quantidadePlanejada, perdas, rendimento;
    LocalDate prazo;
    StatusOrdem status;
    Produto produto;
    List<EtapaFabricacao> etapas = new ArrayList<>(); // composição 1 -- *
    List<LoteProduto> lotes = new ArrayList<>();      // 1 -- *

    OrdemProducao(int numero, Produto produto, double quantidadePlanejada, LocalDate prazo) {
        this.numero = numero;
        this.produto = produto;
        this.quantidadePlanejada = quantidadePlanejada;
        this.prazo = prazo;
        produto.ordens.add(this);
    }

    void programar() {
        status = StatusOrdem.PROGRAMADA;
    }

    void iniciar() {
        if (status == StatusOrdem.PROGRAMADA) status = StatusOrdem.EM_EXECUCAO;
        else System.out.println("A ordem precisa estar PROGRAMADA para iniciar");
    }

    void encerrar() {
        for (EtapaFabricacao e : etapas) {
            if (e.obrigatoria && !e.concluida) {
                System.out.println("Etapa obrigatória pendente: " + e.nome);
                return;
            }
        }
        double produzido = 0;
        for (LoteProduto l : lotes) produzido += l.quantidade;
        perdas = quantidadePlanejada - produzido;
        rendimento = produzido / quantidadePlanejada * 100;
        status = StatusOrdem.ENCERRADA;
    }
}
