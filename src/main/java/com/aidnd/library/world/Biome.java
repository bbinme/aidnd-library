package com.aidnd.library.world;

public enum Biome {
    // ── Landmass biomes (ordinals 0–9 — must not change) ────────────────────
    PLAINS, FOREST_DECIDUOUS, FOREST_EVERGREEN, FOREST_TROPICAL,
    HILLS, MOUNTAINS, DESERT, BADLANDS, SWAMP, LAKE,

    // ── Polar landmass biomes (ordinals 10–11) ───────────────────────────────
    TUNDRA,   // passable frozen plains
    GLACIER,  // impassable ice; polar equivalent of MOUNTAINS

    // ── Boundary biomes — always impassable (ordinals 12–15) ────────────────
    OCEAN, SHALLOW_WATER,        // temperate / equatorial boundary ring
    FROZEN_OCEAN, ICE_SHELF,     // polar boundary ring

    // ── Coastal water variety (ordinals 16–17) ───────────────────────────────
    CORAL_REEF,   // warm shallow water — equatorial only
    KELP_FOREST,  // cold shallow water — temperate only

    // ── Shoreline biomes (ordinals 18–19) ────────────────────────────────────
    BEACH,        // passable sandy strip at low-elevation coasts
    ROCKY_SHORE;  // impassable rocky/cliff coast at high-elevation coasts

    public boolean isImpassable() {
        return this == GLACIER
            || this == OCEAN
            || this == SHALLOW_WATER
            || this == FROZEN_OCEAN
            || this == ICE_SHELF
            || this == CORAL_REEF
            || this == KELP_FOREST
            || this == ROCKY_SHORE;
    }
}
