package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IPokemonFactoryTest {

    private PokemonFactory pokemonFactory;
    private IPokemonMetadataProvider metadataProvider;

    @BeforeEach
    public void setup() {
        metadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory(metadataProvider);
    }

    @Test
    public void testCreatePokemonBulbizarre() throws PokedexException {
        PokemonMetadata bulbizarreMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);

        Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);

        assertNotNull(pokemon);
        assertEquals(0, pokemon.getIndex());
        assertEquals("Bulbizarre", pokemon.getName());
        assertEquals(613, pokemon.getCp());
        assertEquals(64, pokemon.getHp());
        assertEquals(4000, pokemon.getDust());
        assertEquals(4, pokemon.getCandy());

        assertNotNull(pokemon.getIv());
        assertTrue(pokemon.getIv() >= 0 && pokemon.getIv() <= 1);

        assertEquals(pokemon.getAttack(), bulbizarreMetadata.getAttack() + (int) Math.round(pokemon.getIv() * 15));
        assertEquals(pokemon.getAttack(), bulbizarreMetadata.getAttack() + (int) Math.round(pokemon.getIv() * 15));
        assertEquals(pokemon.getAttack(), bulbizarreMetadata.getAttack() + (int) Math.round(pokemon.getIv() * 15));
    }

    @Test
    public void testCreatePokemonAquali() throws PokedexException {
        PokemonMetadata aqualiMetadata = new PokemonMetadata(0, "Aquali", 186, 168, 260);

        Pokemon pokemon = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);

        assertNotNull(pokemon);
        assertEquals(133, pokemon.getIndex());
        assertEquals("Aquali", pokemon.getName());
        assertEquals(2729, pokemon.getCp());
        assertEquals(202, pokemon.getHp());
        assertEquals(5000, pokemon.getDust());
        assertEquals(4, pokemon.getCandy());

        assertNotNull(pokemon.getIv());
        assertTrue(pokemon.getIv() >= 0 && pokemon.getIv() <= 1);

        assertEquals(pokemon.getAttack(), aqualiMetadata.getAttack() + (int) Math.round(pokemon.getIv() * 15));
        assertEquals(pokemon.getDefense(), aqualiMetadata.getDefense() + (int) Math.round(pokemon.getIv() * 15));
        assertEquals(pokemon.getStamina(), aqualiMetadata.getStamina() + (int) Math.round(pokemon.getIv() * 15));
    }


    @Test
    public void testCreatePokemonInvalidMetadata() throws PokedexException {

        assertThrows(RuntimeException.class, () -> pokemonFactory.createPokemon(999, 1000, 100, 1000, 1));
    }
}