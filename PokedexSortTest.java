import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class PokedexSortTest {

    private Pokedex pdx;

    @Rule
    public Timeout globalTimeout = Timeout.millis(1000); // 1000 milliseconds for timeout


    @Before
    public void setUp() throws Exception {
        pdx = new Pokedex(6);
    }

    @Test
    public void givenEmptyDexWhenSortThenReturnNullMembers() throws Exception {
        pdx.sortPokemon();
        String[] speciesList = pdx.listPokemon();
        assertNull(speciesList);
    }

    @Test
    public void givenOneElementDexWhenSortThenReturnMembersWithCorrectOrder() throws Exception {
        pdx.addPokemon("OnlyElement");
        pdx.sortPokemon();
        String[] speciesList = pdx.listPokemon();
        String[] expectedList = {"OnlyElement"};
        assertArrayEquals(expectedList, speciesList);
    }

    @Test
    public void givenHalfFilledDexWhenSortThenReturnMembersWithCorrectOrder() throws Exception {
        pdx.addPokemon("whatever");
        pdx.addPokemon("XYz");
        pdx.addPokemon("ThisSequence");
        pdx.sortPokemon();
        String[] speciesList = pdx.listPokemon();
        String[] expectedList = {"ThisSequence", "whatever", "XYz"};
        assertArrayEquals(expectedList, speciesList);
    }

    @Test
    public void givenFilledDexWhenSortReturnMembersWithCorrectOrder() throws Exception {
        pdx.addPokemon("whatever1");
        pdx.addPokemon("whatever2");
        pdx.addPokemon("zAfterWhatever");
        pdx.addPokemon("aheadWhatever2");
        pdx.addPokemon("aheadWhatever1");
        pdx.addPokemon("Cheese");
        pdx.sortPokemon();
        String[] speciesList = pdx.listPokemon();
        String[] expectedList = {"aheadWhatever1", "aheadWhatever2", "Cheese", "whatever1", "whatever2", "zAfterWhatever"};
        assertArrayEquals(expectedList, speciesList);
    }
}
