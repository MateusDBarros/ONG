package mb.projeto.ONG.ongs.Model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Categoria {
    SAUDE("Saúde"),
    PROTECAO("Proteção"),
    AMBIENTE("Ambiente"),
    DIREITOS("Direitos"),
    EDUCACAO("Saúde e Educação"); // Defina o valor que deseja aceitar

    private final String label;

    Categoria(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }

    @JsonCreator
    public static Categoria fromString(String value) {
        for (Categoria categoria : Categoria.values()) {
            // Compara tanto o nome do enum quanto o label, ignorando diferenças de maiúsculas/minúsculas
            if (categoria.name().equalsIgnoreCase(value) || categoria.label.equalsIgnoreCase(value)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Valor inválido para Categoria: " + value);
    }
}
