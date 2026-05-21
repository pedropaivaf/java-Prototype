package rpg;

public class Guerreiro extends Personagem {
    private int armadura;

    public Guerreiro(String nome, int nivel, int pontoDeVida, int armadura) {
        super(nome, nivel, pontoDeVida);
        this.armadura = armadura;
    }

    public int getArmadura() { return armadura; }
    public void setArmadura(int armadura) { this.armadura = armadura; }

    @Override
    public String getClasse() { return "Guerreiro"; }

    @Override
    public Personagem clonar() {
        return new Guerreiro(getNome(), getNivel(), getPontoDeVida(), armadura);
    }
}
