package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PokemonComparatorsTest {

    private Pokemon bulbasaur;
    private Pokemon vaporeon;
    private Pokemon charmander;

    @BeforeEach
    public void setup() {
        bulbasaur = new Pokemon(1, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        vaporeon = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1);
        charmander = new Pokemon(4, "Salamèche", 128, 108, 78, 700, 76, 4000, 2, 0.6);
    }

    @Test
    public void testCompareByName() {
        List<Pokemon> pokemons = Arrays.asList(charmander, vaporeon, bulbasaur);
        pokemons.sort(PokemonComparators.NAME);

        assertEquals("Aquali", pokemons.get(0).getName());
        assertEquals("Bulbizarre", pokemons.get(1).getName());
        assertEquals("Salamèche", pokemons.get(2).getName());
    }

    @Test
    public void testCompareByIndex() {
        List<Pokemon> pokemons = Arrays.asList(vaporeon, charmander, bulbasaur);
        pokemons.sort(PokemonComparators.INDEX);

        assertEquals(1, pokemons.get(0).getIndex());
        assertEquals(4, pokemons.get(1).getIndex());
        assertEquals(133, pokemons.get(2).getIndex());
    }

    @Test
    public void testCompareByCp() {
        List<Pokemon> pokemons = Arrays.asList(bulbasaur, charmander, vaporeon);
        pokemons.sort(PokemonComparators.CP);

        assertEquals(613, pokemons.get(0).getCp());
        assertEquals(700, pokemons.get(1).getCp());
        assertEquals(2729, pokemons.get(2).getCp());
    }
}
