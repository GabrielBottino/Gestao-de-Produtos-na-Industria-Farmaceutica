import java.util.ArrayList;
import java.util.List;

public class EtapaFabricacao {
    String nome, parametros;
    boolean obrigatoria, concluida;
    List<RegistroEtapa> registros = new ArrayList<>(); // composição 1 -- *

    EtapaFabricacao(String nome, boolean obrigatoria, String parametros) {
        this.nome = nome;
        this.obrigatoria = obrigatoria;
        this.parametros = parametros;
    }

    void concluir() {
        if (registros.isEmpty()) System.out.println("Etapa " + nome + " sem registro de execução");
        else concluida = true;
    }
}
