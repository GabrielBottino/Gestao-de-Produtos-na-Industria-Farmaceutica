import java.time.LocalDateTime;

public class RegistroEtapa {
    String descricao;
    LocalDateTime dataHora = LocalDateTime.now();
    Usuario executor; // * -- 1

    RegistroEtapa(String descricao, Usuario executor) {
        this.descricao = descricao;
        this.executor = executor;
    }
}
