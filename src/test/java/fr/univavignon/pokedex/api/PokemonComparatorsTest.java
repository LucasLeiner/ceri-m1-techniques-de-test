package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PokemonComparatorsTest {

    private Pokemon bulbizare;
    private Pokemon aquali;

    @BeforeEach
    public void setup() {
        bulbizare = new Pokemon(1, "Bulbizare", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1);
    }

    @Test
    public void testCompareByName() {
        List<Pokemon> pokemons = Arrays.asList(aquali, bulbizare);
        pokemons.sort(PokemonComparators.NAME);

        assertEquals("Aquali", pokemons.get(0).getName());
        assertEquals("Bulbizare", pokemons.get(1).getName());
    }

    @Test
    public void testCompareByIndex() {
        List<Pokemon> pokemons = Arrays.asList(aquali, bulbizare);
        pokemons.sort(PokemonComparators.INDEX);

        assertEquals(1, pokemons.get(0).getIndex());
        assertEquals(133, pokemons.get(1).getIndex());
    }

    @Test
    public void testCompareByCp() {
        List<Pokemon> pokemons = Arrays.asList(bulbizare, aquali);
        pokemons.sort(PokemonComparators.CP);

        assertEquals(613, pokemons.get(0).getCp());
        assertEquals(2729, pokemons.get(1).getCp());
    }
}
