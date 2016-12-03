import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class PokedexCheckStatusTest {

    private Pokedex pdx;

    @Rule
    public Timeout globalTimeout = Timeout.millis(1000); // 1000 milliseconds for timeout


    @Before
    public void setUp() throws Exception {
        pdx = new Pokedex(5);
    }

    /*******************
     * Check Status
     *******************/
    @Test
    public void givenEmptyDexWhenCheckNonExistingStatusThenReturnNull() throws Exception {
        // attack, defense, speed
        int[] attr = pdx.checkStats("NotExisting");
        assertNull(attr);
    }

    @Test
    public void givenExistingDexWhenCheckNonExistingSpeciesThenReturnNull() throws Exception {
        // attack, defense, speed
        pdx.addPokemon("whatever1");
        int[] attr = pdx.checkStats("NotExisting");
        assertNull(attr);
    }

    @Test
    public void givenExistingDexWhenCheckExistingSpeciesThenReturnStatusInCorrectOrder() throws Exception {
        // attack, defense, speed
        // attack = (Length of species * 4) + 2
        // defense = (Length of species * 2) + 7
        // speed = (Length of species * 3) +  5
        pdx.addPokemon("whatever1");
        pdx.addPokemon("whatever2");
        pdx.addPokemon("four");
        int[] attr = pdx.checkStats("four");
        int[] expected = {18, 15, 17};
        assertArrayEquals(expected, attr);
    }

}
