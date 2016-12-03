import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;


public class PokedexListTest {

    private Pokedex pdx;

    @Rule
    public Timeout globalTimeout = Timeout.millis(1000); // 1000 milliseconds for timeout


    @Before
    public void setUp() throws Exception {
        pdx = new Pokedex(5);
    }

    /******************
     * Listing Staff
     ******************/
    @Test
    public void givenEmptyDexWhenListThenReturnNull() throws Exception {
        // empty list
        String[] speciesList = pdx.listPokemon();
        assertNull(speciesList);
    }

    @Test
    public void givenNonEmptyDexWhenListThenReturnAllMembersWithoutNull() throws Exception {
        pdx.addPokemon("whatever1");
        pdx.addPokemon("whatever2");
        pdx.addPokemon("whatever7");
        pdx.addPokemon("whatever8");
        String[] speciesList = pdx.listPokemon();
        String[] expectedList = {"whatever1", "whatever2", "whatever7", "whatever8"};
        assertArrayEquals(expectedList, speciesList);
    }

}
