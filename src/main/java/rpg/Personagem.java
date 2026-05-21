package rpg;

public abstract class Personagem {
    private String nome;
    private int nivel;
    private int pontoDeVida;

    public Personagem(String nome, int nivel, int pontoDeVida) {
        this.nome = nome;
        this.nivel = nivel;
        this.pontoDeVida = pontoDeVida;
    }

    public abstract String getClasse();
    public abstract Personagem clonar();

    public String getNome() { return nome; }
    public int getNivel() { return nivel; }
    public int getPontoDeVida() { return pontoDeVida; }

    public void setNome(String nome) { this.nome = nome; }
    public void setNivel(int nivel) { this.nivel = nivel; }
    public void setPontoDeVida(int pontoDeVida) { this.pontoDeVida = pontoDeVida; }

    @Override
    public String toString() {
        return getClasse() + "{nome='" + nome + "', nivel=" + nivel + ", pv=" + pontoDeVida + "}";
    }
}
