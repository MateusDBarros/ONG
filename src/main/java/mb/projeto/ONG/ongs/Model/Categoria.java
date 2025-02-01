package mb.projeto.ONG.ongs.Model;

public enum Categoria {
    EDUCACAO ("Educação"),
    SAUDE ("Saúde"),
    AMBIENTE ("Meio Ambiente"),
    DIREITOS ("Direitos dos Animais"),
    PROTECAO ("Proteção das Minorias");

    private final String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
