package rpg;

public class Arqueiro extends Personagem {
    private int precisao;

    public Arqueiro(String nome, int nivel, int pontoDeVida, int precisao) {
        super(nome, nivel, pontoDeVida);
        this.precisao = precisao;
    }

    public int getPrecisao() { return precisao; }
    public void setPrecisao(int precisao) { this.precisao = precisao; }

    @Override
    public String getClasse() { return "Arqueiro"; }

    @Override
    public Personagem clonar() {
        return new Arqueiro(getNome(), getNivel(), getPontoDeVida(), precisao);
    }
}
