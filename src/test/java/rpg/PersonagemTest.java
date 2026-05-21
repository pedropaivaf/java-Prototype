package rpg;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonagemTest {

    // Clone cria objeto independente

    @Test
    public void deveClonarGuerreiro() {
        Guerreiro original = new Guerreiro("Thor", 10, 200, 50);
        System.out.println("[PROTOTYPE] clonar() Guerreiro | original: " + original);
        Personagem clone = original.clonar();
        System.out.println("  -> clone: " + clone);
        assertNotSame(original, clone);
        assertEquals(original.getNome(), clone.getNome());
        assertEquals(original.getNivel(), clone.getNivel());
        assertEquals(original.getClasse(), clone.getClasse());
    }

    @Test
    public void deveClonarMago() {
        Mago original = new Mago("Gandalf", 15, 120, 300);
        System.out.println("[PROTOTYPE] clonar() Mago | original: " + original);
        Personagem clone = original.clonar();
        System.out.println("  -> clone: " + clone);
        assertNotSame(original, clone);
        assertEquals(original.getNome(), clone.getNome());
        assertEquals(((Mago) clone).getMana(), original.getMana());
    }

    @Test
    public void deveClonarArqueiro() {
        Arqueiro original = new Arqueiro("Legolas", 12, 150, 95);
        System.out.println("[PROTOTYPE] clonar() Arqueiro | original: " + original);
        Personagem clone = original.clonar();
        System.out.println("  -> clone: " + clone);
        assertNotSame(original, clone);
        assertEquals(original.getNome(), clone.getNome());
        assertEquals(((Arqueiro) clone).getPrecisao(), original.getPrecisao());
    }

    // Modificar clone nao afeta original

    @Test
    public void naoDeveAlterarOriginalAoModificarClone() {
        Guerreiro original = new Guerreiro("Kratos", 20, 500, 80);
        Guerreiro clone = (Guerreiro) original.clonar();
        System.out.println("[PROTOTYPE] modificar clone | original antes: " + original);
        clone.setNome("Clone-Kratos");
        clone.setNivel(1);
        System.out.println("  -> original apos modificacao do clone: " + original);
        System.out.println("  -> clone modificado: " + clone);
        assertEquals("Kratos", original.getNome());
        assertEquals(20, original.getNivel());
    }

    @Test
    public void naoDeveAlterarOriginalMagoAoModificarClone() {
        Mago original = new Mago("Merlin", 18, 100, 400);
        Mago clone = (Mago) original.clonar();
        System.out.println("[PROTOTYPE] modificar mana do clone | mana original: " + original.getMana());
        clone.setMana(0);
        System.out.println("  -> mana original apos: " + original.getMana() + " (esperado: 400)");
        assertEquals(400, original.getMana());
    }

    // Classe preservada apos clone

    @Test
    public void deveMantерClasseCorretaAposClonar() {
        Personagem g = new Guerreiro("A", 1, 100, 10);
        Personagem m = new Mago("B", 1, 80, 200);
        Personagem a = new Arqueiro("C", 1, 90, 70);
        System.out.println("[PROTOTYPE] classe preservada no clone");
        System.out.println("  -> " + g.clonar().getClasse() + " (esperado: Guerreiro)");
        System.out.println("  -> " + m.clonar().getClasse() + " (esperado: Mago)");
        System.out.println("  -> " + a.clonar().getClasse() + " (esperado: Arqueiro)");
        assertEquals("Guerreiro", g.clonar().getClasse());
        assertEquals("Mago", m.clonar().getClasse());
        assertEquals("Arqueiro", a.clonar().getClasse());
    }

    // Clonar multiplas vezes

    @Test
    public void deveClonarMultiplasVezesIndependentemente() {
        Arqueiro base = new Arqueiro("Robin", 5, 100, 80);
        Arqueiro clone1 = (Arqueiro) base.clonar();
        Arqueiro clone2 = (Arqueiro) base.clonar();
        System.out.println("[PROTOTYPE] 2 clones independentes | base: " + base);
        clone1.setNome("Robin-1");
        clone2.setNome("Robin-2");
        System.out.println("  -> clone1: " + clone1 + " | clone2: " + clone2);
        assertEquals("Robin", base.getNome());
        assertNotEquals(clone1.getNome(), clone2.getNome());
    }
}
