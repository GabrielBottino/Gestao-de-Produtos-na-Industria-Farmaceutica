import java.util.ArrayList;
import java.util.List;

public class Produto {
    String codigo, nome;
    List<OrdemProducao> ordens = new ArrayList<>(); // 1 -- *

    Produto(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
}
