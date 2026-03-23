package com.aidnd.library.world;

public enum Biome {
    // ── Landmass biomes (ordinals 0–9 — must not change) ────────────────────
    PLAINS, FOREST_DECIDUOUS, FOREST_EVERGREEN, FOREST_TROPICAL,
    HILLS, MOUNTAINS, DESERT, BADLANDS, SWAMP, LAKE,

    // ── Polar landmass biomes (ordinals 10–11) ───────────────────────────────
    TUNDRA,   // passable frozen plains
    GLACIER,  // impassable ice; polar equivalent of MOUNTAINS

    // ── Boundary biomes — always impassable (ordinals 12–15) ────────────────
    DEEP_OCEAN, SHALLOW_WATER,   // temperate / equatorial boundary ring
    FROZEN_OCEAN, ICE_SHELF,     // polar boundary ring

    // ── Coastal water variety (ordinals 16–17) ───────────────────────────────
    CORAL_REEF,   // warm shallow water — equatorial only
    KELP_FOREST,  // cold shallow water — temperate only

    // ── Shoreline biomes (ordinals 18–19) ────────────────────────────────────
    BEACH,        // passable; sandy strip at low-elevation coasts (elev < 0.40)
    ROCKY_SHORE,  // impassable; rocky/cliff coast at high-elevation coasts (elev ≥ 0.65)

    // ── Hill variety (ordinal 20) ─────────────────────────────────────────────
    GRASSLAND_HILLS,  // passable; moist hills — green fill + hills sprite

    // ── Foothill biomes (ordinals 21–22) ─────────────────────────────────────
    FOOTHILLS,          // passable; dry foothills (tan/khaki)
    FORESTED_FOOTHILLS, // passable; wet foothills (dark green)

    // ── Polar water biomes (ordinal 23) ──────────────────────────────────────
    FROZEN_LAKE,      // passable; polar substitute for LAKE and SWAMP

    // ── Equatorial biome variants (ordinal 27) ────────────────────────────────
    MANGROVE_SWAMP,   // passable; equatorial substitute for SWAMP

    // ── Warm grassland biomes (ordinal 28) ───────────────────────────────────
    SAVANNAH,         // passable; dry tropical grassland (mid elevation, low-mid moisture)

    // ── Mid-depth ocean (ordinal 29) ─────────────────────────────────────────
    MEDIUM_OCEAN,     // impassable; inner 60% of ocean zone

    // ── Mid-elevation shoreline (ordinal 30) ─────────────────────────────────
    GRASSY_SHORELINE, // passable; vegetated coast at mid-elevation (0.40–0.65)

    // ── Wet hill biome (ordinal 31) ───────────────────────────────────────────
    RAINY_HILLS,      // passable; wet elevated terrain (elev 0.65–0.80, moisture > 0.55)

    // ── Polar landmass expansions (ordinals 32–33) ───────────────────────────
    FROZEN_WASTES,    // passable; polar substitute for flat/dry land (PLAINS, SAVANNAH, DESERT)
    SNOWY_HILLS,      // passable; polar substitute for hilly terrain (FOOTHILLS, GRASSLAND_HILLS etc.)

    // ── Volcanic biomes (ordinals 34–35) ─────────────────────────────────────
    VOLCANIC_CALDERA, // impassable; active volcanic crater
    ASHLANDS,         // passable; danger zone of volcanic ash and debris

    // ── Normal foothills — mid-moisture variant (ordinal 36) ─────────────────
    GRASSY_FOOTHILLS, // passable; mid-moisture foothills (green-tan)

    // ── Craggy foothill/hill variants — YOUNG tectonic age (ordinals 37–42) ──
    CRAGGY_FORESTED_FOOTHILLS,  // passable; young jagged wet forested foothills
    CRAGGY_GRASSY_FOOTHILLS,    // passable; young jagged mid-moisture foothills
    CRAGGY_FOOTHILLS,           // passable; young jagged dry foothills
    CRAGGY_RAINY_HILLS,         // passable; young jagged wet hills
    CRAGGY_GRASSLAND_HILLS,     // passable; young jagged grassy hills
    CRAGGY_HILLS,               // passable; young jagged dry hills

    // ── Weathered foothill/hill variants — ANCIENT tectonic age (ordinals 43–48) ─
    WEATHERED_FORESTED_FOOTHILLS,  // passable; ancient eroded wet forested foothills
    WEATHERED_GRASSY_FOOTHILLS,    // passable; ancient eroded mid-moisture foothills
    WEATHERED_FOOTHILLS,           // passable; ancient eroded dry foothills
    WEATHERED_RAINY_HILLS,         // passable; ancient eroded wet hills
    WEATHERED_GRASSLAND_HILLS,     // passable; ancient eroded grassy hills
    WEATHERED_HILLS,               // passable; ancient eroded dry hills

    // ── Small Mountains  elev 0.78–0.90  (ordinals 49–57) ────────────────────
    SMALL_MOUNTAINS,                SNOWY_SMALL_MOUNTAINS,                ROCKY_SMALL_MOUNTAINS,
    CRAGGY_SMALL_MOUNTAINS,         SNOWY_CRAGGY_SMALL_MOUNTAINS,         ROCKY_CRAGGY_SMALL_MOUNTAINS,
    WEATHERED_SMALL_MOUNTAINS,      SNOWY_WEATHERED_SMALL_MOUNTAINS,      ROCKY_WEATHERED_SMALL_MOUNTAINS,

    // ── Midsize Mountains  elev 0.90–1.05  (ordinals 58–66) ──────────────────
    MIDSIZE_MOUNTAINS,              SNOWY_MIDSIZE_MOUNTAINS,              ROCKY_MIDSIZE_MOUNTAINS,
    CRAGGY_MIDSIZE_MOUNTAINS,       SNOWY_CRAGGY_MIDSIZE_MOUNTAINS,       ROCKY_CRAGGY_MIDSIZE_MOUNTAINS,
    WEATHERED_MIDSIZE_MOUNTAINS,    SNOWY_WEATHERED_MIDSIZE_MOUNTAINS,    ROCKY_WEATHERED_MIDSIZE_MOUNTAINS,

    // ── Large Mountains  elev 1.05–1.20  (ordinals 67–75) ────────────────────
    LARGE_MOUNTAINS,                SNOWY_LARGE_MOUNTAINS,                ROCKY_LARGE_MOUNTAINS,
    CRAGGY_LARGE_MOUNTAINS,         SNOWY_CRAGGY_LARGE_MOUNTAINS,         ROCKY_CRAGGY_LARGE_MOUNTAINS,
    WEATHERED_LARGE_MOUNTAINS,      SNOWY_WEATHERED_LARGE_MOUNTAINS,      ROCKY_WEATHERED_LARGE_MOUNTAINS,

    // ── Major Mountains  elev 1.20–1.40  (ordinals 76–84) ────────────────────
    MAJOR_MOUNTAINS,                SNOWY_MAJOR_MOUNTAINS,                ROCKY_MAJOR_MOUNTAINS,
    CRAGGY_MAJOR_MOUNTAINS,         SNOWY_CRAGGY_MAJOR_MOUNTAINS,         ROCKY_CRAGGY_MAJOR_MOUNTAINS,
    WEATHERED_MAJOR_MOUNTAINS,      SNOWY_WEATHERED_MAJOR_MOUNTAINS,      ROCKY_WEATHERED_MAJOR_MOUNTAINS,

    // ── Major Peaks  elev 1.40+  (ordinals 85–93) ────────────────────────────
    MAJOR_PEAKS,                    SNOWY_MAJOR_PEAKS,                    ROCKY_MAJOR_PEAKS,
    CRAGGY_MAJOR_PEAKS,             SNOWY_CRAGGY_MAJOR_PEAKS,             ROCKY_CRAGGY_MAJOR_PEAKS,
    WEATHERED_MAJOR_PEAKS,          SNOWY_WEATHERED_MAJOR_PEAKS,          ROCKY_WEATHERED_MAJOR_PEAKS;

    public boolean isImpassable() {
        return this == GLACIER
            || this == DEEP_OCEAN
            || this == MEDIUM_OCEAN
            || this == SHALLOW_WATER
            || this == FROZEN_OCEAN
            || this == ICE_SHELF
            || this == CORAL_REEF
            || this == KELP_FOREST
            || this == ROCKY_SHORE
            || this == VOLCANIC_CALDERA;
    }

    /** True for all 45 mountain biomes (5 sizes × 3 ages × 3 moisture variants). */
    public boolean isMountainBiome() {
        int o = ordinal();
        return o >= 49 && o <= 93;
    }
}
