package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class IPokedexTest {

    private IPokedex pokedex;

    @BeforeEach
    public void setup() {
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
        pokedex = new Pokedex(metadataProvider, pokemonFactory);
    }

    @Test
    public void testAddPokemon() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        int index = pokedex.addPokemon(pokemon);

        assertEquals(0, index);
    }

    @Test
    public void testSize() {
        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        Pokemon pokemon2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729  , 202, 5000, 4, 1);
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);
        int size = pokedex.size();

        assertEquals(2, size);
    }

    @Test
    public void testGetPokemonValidId() throws PokedexException {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        pokedex.addPokemon(pokemon);
        Pokemon result = pokedex.getPokemon(0);

        assertNotNull(result);
        assertEquals("Bulbizarre", result.getName());
    }

    @Test
    public void testGetPokemonInvalidId() {
        assertThrows(PokedexException.class, () -> pokedex.getPokemon(200), "Expected PokedexException for invalid ID");
    }


    @Test
    public void testGetPokemons() {
        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        Pokemon pokemon2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729  , 202, 5000, 4, 1);

        List<Pokemon> pokemons = Arrays.asList(
                pokemon1,
                pokemon2
        );
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);

        List<Pokemon> result = pokedex.getPokemons();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(pokemons, result);
    }

    @Test
    public void testGetPokemonsSorted() {
        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        Pokemon pokemon2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729  , 202, 5000, 4, 1);

        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);

        Comparator<Pokemon> comparator = PokemonComparators.NAME;
        List<Pokemon> result = pokedex.getPokemons(comparator);

        assertEquals("Aquali", result.get(0).getName());
        assertEquals("Bulbizarre", result.get(1).getName());
    }
}