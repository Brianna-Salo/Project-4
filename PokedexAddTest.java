import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;


public class PokedexAddTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Pokedex pdx;

    @Rule
    public Timeout globalTimeout = Timeout.millis(1000); // 1000 milliseconds for timeout


    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
        pdx = new Pokedex(5);
        pdx.addPokemon("whatever1");
        pdx.addPokemon("whatever2");
    }

    @After
    public void cleanUp() throws Exception {
        // reset the System.out to a new FileDescriptor, to print at console
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }

    @Test
    public void givenNotFullSizeDexWhenAddThenSuccess() throws Exception {
        boolean result = pdx.addPokemon("whatever3");
        result = result && pdx.addPokemon("whatever4");
        assertTrue(result);
    }

    @Test
    public void givenZeroSizeDexWhenAddThenFailNPromptMax() throws Exception {
        pdx = new Pokedex(0);
        boolean result = pdx.addPokemon("whatever");
        assertFalse(result);
        String content = outContent.toString().toLowerCase();
        assertTrue(content.contains("max"));
    }

    @Test
    public void givenFullDexWhenAddThenFailNPromptMax() throws Exception {
        pdx.addPokemon("whatever3");
        pdx.addPokemon("whatever4");
        pdx.addPokemon("whatever5");
        boolean result = pdx.addPokemon("whatever6");// The size is 5, 6 will overflow
        assertFalse(result);
        String content = outContent.toString().toLowerCase();
        assertTrue(content.contains("max"));
    }

    @Test
    public void givenExistingSpeciesIndexWhenAddThenFailNPromptDuplicate() throws Exception {
        boolean result = pdx.addPokemon("whatever1");
        assertFalse(result);
        String content = outContent.toString().toLowerCase();
        assertTrue(content.contains("duplicate"));
    }

}