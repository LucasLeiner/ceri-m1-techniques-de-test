package fr.univavignon.pokedex.api;

import java.util.Random;

public class PokemonFactory implements IPokemonFactory {

    private final IPokemonMetadataProvider metadataProvider;
    private final Random random;

    /**
     * Constructor for PokemonFactory.
     *
     * @param metadataProvider The provider for Pokemon metadata.
     */
    public PokemonFactory(IPokemonMetadataProvider metadataProvider) {
        this.metadataProvider = metadataProvider;
        this.random = new Random();
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        try {
            PokemonMetadata metadata = metadataProvider.getPokemonMetadata(index);

            double iv = random.nextDouble();

            int attack = metadata.getAttack() + (int) Math.round(iv * 15);
            int defense = metadata.getDefense() + (int) Math.round(iv * 15);
            int stamina = metadata.getStamina() + (int) Math.round(iv * 15);

            return new Pokemon(index, metadata.getName(), attack, defense, stamina, cp, hp, dust, candy, iv);

        } catch (PokedexException e) {
            throw new RuntimeException("Error retrieving Pokémon metadata.", e);
        }
    }
}

