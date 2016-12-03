import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

/**
 * Created by chris on 11/7/16.
 */
public class PokemonClassTest {

    Pokemon pokemon;

    @Rule
    public Timeout globalTimeout = Timeout.millis(1000); // 1000 milliseconds for timeout


    @Before
    public void setUp() throws Exception {
        // attack, defense, speed, length is: 11
        // attack = (Length of species * 4) + 2 = 46
        // defense = (Length of species * 2) + 7 = 29
        // speed = (Length of species * 3) +  5 = 38
        pokemon = new Pokemon("TestSpecies");
    }

    @Test
    public void getSpecies() throws Exception {
        assertEquals("TestSpecies", pokemon.getSpecies());
    }

    @Test
    public void getAttack() throws Exception {
        assertEquals(46, pokemon.getAttack());
    }

    @Test
    public void getDefense() throws Exception {
        assertEquals(29, pokemon.getDefense());
    }

    @Test
    public void getSpeed() throws Exception {
        assertEquals(38, pokemon.getSpeed());
    }

    @Test
    public void setSpecies() throws Exception {
        pokemon.setSpecies("NewSpecies");
        assertEquals("NewSpecies", pokemon.getSpecies());
    }

    @Test
    public void setAttack() throws Exception {
        pokemon.setAttack(1234);
        assertEquals(1234, pokemon.getAttack());
    }

    @Test
    public void setDefense() throws Exception {
        pokemon.setDefense(4567);
        assertEquals(4567, pokemon.getDefense());
    }

    @Test
    public void setSpeed() throws Exception {
        pokemon.setSpeed(6789);
        assertEquals(6789, pokemon.getSpeed());
    }

    @Test
    public void grow() throws Exception {
        pokemon.grow(21);
        assertEquals(46 + 21, pokemon.getAttack());
    }

    @Test
    public void harden() throws Exception {
        pokemon.harden(32);
        assertEquals(29 + 32, pokemon.getDefense());
    }

    @Test
    public void haste() throws Exception {
        pokemon.haste(78);
        assertEquals(38 + 78, pokemon.getSpeed());
    }

}
