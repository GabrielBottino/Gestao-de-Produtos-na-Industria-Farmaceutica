import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Usuario operador = new Usuario("Ana", "ana");

        Produto produto = new Produto("P1", "Dipirona 500 mg");
        OrdemProducao op = new OrdemProducao(1, produto, 1000, LocalDate.now().plusDays(5));

        EtapaFabricacao mistura = new EtapaFabricacao("Mistura", true, "15 min, 30 rpm");
        op.etapas.add(mistura);

        op.programar();
        op.iniciar();

        mistura.registros.add(new RegistroEtapa("Mistura concluída", operador));
        mistura.concluir();

        LoteProduto lote = new LoteProduto("L001", 980);
        op.lotes.add(lote);

        lote.status = StatusLote.APROVADO; // aprovação feita pelo setor de Qualidade
        lote.liberar();
        lote.expedir();

        op.encerrar();

        System.out.println("Ordem " + op.numero + ": " + op.status);
        System.out.println("Rendimento: " + op.rendimento + "% | Perdas: " + op.perdas);
        System.out.println("Lote " + lote.identificadorUnico + ": " + lote.status);
    }
}
