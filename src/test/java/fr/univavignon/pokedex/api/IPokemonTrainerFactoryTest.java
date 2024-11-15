package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory pokemonTrainerFactory;
    private IPokedexFactory pokedexFactory;

    @BeforeEach
    public void setUp() {
        pokemonTrainerFactory = new PokemonTrainerFactory();
        pokedexFactory = new PokedexFactory();
    }

    @Test
    public void testCreateTrainer() {
        PokemonTrainer createdTrainer = pokemonTrainerFactory.createTrainer("Lucas", Team.MYSTIC, pokedexFactory);

        assertNotNull(createdTrainer);
        assertEquals("Lucas", createdTrainer.getName());
        assertEquals(Team.MYSTIC, createdTrainer.getTeam());
        assertNotNull(createdTrainer.getPokedex()); // Vérification que le Pokedex a bien été créé
    }
}