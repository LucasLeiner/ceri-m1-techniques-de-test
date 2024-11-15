package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    @BeforeEach
    public void setUp() {
        pokedexFactory = new PokedexFactory();
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokedex() {
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        assertNotNull(pokedex);
        assertInstanceOf(Pokedex.class, pokedex);
    }
}