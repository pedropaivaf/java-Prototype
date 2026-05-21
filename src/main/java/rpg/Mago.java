package rpg;

public class Mago extends Personagem {
    private int mana;

    public Mago(String nome, int nivel, int pontoDeVida, int mana) {
        super(nome, nivel, pontoDeVida);
        this.mana = mana;
    }

    public int getMana() { return mana; }
    public void setMana(int mana) { this.mana = mana; }

    @Override
    public String getClasse() { return "Mago"; }

    @Override
    public Personagem clonar() {
        return new Mago(getNome(), getNivel(), getPontoDeVida(), mana);
    }
}
