package com.aidnd.library.render;

import java.awt.Color;

/**
 * Canonical biome and POI colour constants shared by all Aethermere clients.
 * Use {@link #colorFor(String)} to look up the fill colour for a biome name
 * received from the API (case-insensitive).
 */
public final class BiomeColors {

    // ── Biome colours ──────────────────────────────────────────────────────
    public static final Color BG          = new Color(10,  10,  10);
    public static final Color PLAINS      = new Color(100, 140, 70);
    public static final Color FOREST_D    = new Color(34,  85,  34);
    public static final Color FOREST_E    = new Color(20,  100, 50);
    public static final Color FOREST_T    = new Color(10,  110, 60);
    public static final Color MOUNTAINS   = new Color(130, 120, 115);
    public static final Color HILLS       = new Color(140, 130, 90);
    public static final Color SWAMP       = new Color(60,  80,  50);
    public static final Color BADLANDS    = new Color(160, 100, 60);
    public static final Color LAKE        = new Color(40,  80,  160);
    public static final Color DESERT      = new Color(200, 170, 90);
    public static final Color TUNDRA      = new Color(180, 200, 210);
    public static final Color GLACIER     = new Color(210, 230, 240);
    public static final Color DEEP_OCEAN   = new Color(10,  30,  90);
    public static final Color MEDIUM_OCEAN = new Color(20,  60,  140);
    public static final Color SHALLOW      = new Color(50,  110, 190);
    public static final Color FROZEN_SEA  = new Color(160, 190, 215);
    public static final Color ICE_SHELF   = new Color(220, 235, 245);
    public static final Color CORAL_REEF  = new Color(80,  200, 200);
    public static final Color KELP_FOREST = new Color(30,  100, 90);
    public static final Color BEACH              = new Color(240, 220, 160);
    public static final Color GRASSY_SHORELINE   = new Color(100, 150,  80);
    public static final Color ROCKY_SHORE        = new Color(100, 90,  80);
    public static final Color GRASSLAND_HILLS    = PLAINS;
    public static final Color FOOTHILLS          = new Color(180, 160, 110);
    public static final Color FORESTED_FOOTHILLS = new Color(60,  100, 55);
    // legacy aliases kept for any cached data still using old names
    public static final Color SNOWY_MOUNTAINS    = new Color(188, 203, 218);
    public static final Color ROCKY_PEAKS        = new Color(62,  56,  50);
    public static final Color ALPINE_PEAKS       = new Color(185, 200, 215);
    public static final Color FROZEN_LAKE        = new Color(160, 200, 225);
    public static final Color MANGROVE_SWAMP     = new Color(30,  90,  60);
    public static final Color SAVANNAH           = new Color(190, 170, 80);
    public static final Color RAINY_HILLS        = new Color(70,  120, 80);
    public static final Color FROZEN_WASTES      = new Color(200, 215, 225);
    public static final Color SNOWY_HILLS        = new Color(180, 195, 210);
    public static final Color VOLCANIC_CALDERA   = new Color(160, 30,  10);
    public static final Color ASHLANDS           = new Color(110, 100, 90);
    // ── Normal foothills mid-moisture ──────────────────────────────────────
    public static final Color GRASSY_FOOTHILLS   = new Color(105, 130, 75);
    // ── Craggy (YOUNG tectonic) variants ───────────────────────────────────
    public static final Color CRAGGY_FORESTED_FOOTHILLS = new Color(50,  85,  45);
    public static final Color CRAGGY_GRASSY_FOOTHILLS   = new Color(80, 105,  55);
    public static final Color CRAGGY_FOOTHILLS          = new Color(125,  95,  60);
    public static final Color CRAGGY_RAINY_HILLS        = new Color(60,   95,  60);
    public static final Color CRAGGY_GRASSLAND_HILLS    = new Color(85,  110,  55);
    public static final Color CRAGGY_HILLS              = new Color(110,  90,  65);
    // ── Weathered (ANCIENT tectonic) variants ──────────────────────────────
    public static final Color WEATHERED_FORESTED_FOOTHILLS = new Color(70,  100,  60);
    public static final Color WEATHERED_GRASSY_FOOTHILLS   = new Color(100, 118,  72);
    public static final Color WEATHERED_FOOTHILLS          = new Color(148, 128,  92);
    public static final Color WEATHERED_RAINY_HILLS        = new Color(72,  108,  68);
    public static final Color WEATHERED_GRASSLAND_HILLS    = new Color(95,  115,  68);
    public static final Color WEATHERED_HILLS              = new Color(138, 118,  82);

    // ── POI colours ────────────────────────────────────────────────────────
    public static final Color TOWN    = new Color(230, 210, 160);
    public static final Color DUNGEON = new Color(180, 60,  60);
    public static final Color RUMOUR  = new Color(160, 100, 200);
    public static final Color PLAYER  = new Color(255, 220, 80);

    /**
     * Returns the fill colour for the given biome string (as returned by the API).
     * Falls back to {@link #BG} for unknown biomes.
     */
    public static Color colorFor(String biome) {
        if (biome == null) return BG;
        String upper = biome.toUpperCase();
        if (isMountainBiomeName(upper)) return mountainColor(upper);
        return switch (upper) {
            case "PLAINS", "GRASSLAND"            -> PLAINS;
            case "FOREST_DECIDUOUS", "DECIDUOUS"  -> FOREST_D;
            case "FOREST_EVERGREEN", "EVERGREEN"  -> FOREST_E;
            case "FOREST_TROPICAL",  "TROPICAL"   -> FOREST_T;
            case "MOUNTAINS", "MOUNTAIN"          -> MOUNTAINS;
            case "HILLS", "HILL"                  -> HILLS;
            case "SWAMP", "WETLAND"               -> SWAMP;
            case "BADLANDS", "DESERT_SCRUB"       -> BADLANDS;
            case "LAKE"                           -> LAKE;
            case "DESERT"                         -> DESERT;
            case "TUNDRA", "ARCTIC", "SNOW"       -> TUNDRA;
            case "GLACIER"                        -> GLACIER;
            case "DEEP_OCEAN"                     -> DEEP_OCEAN;
            case "MEDIUM_OCEAN"                   -> MEDIUM_OCEAN;
            case "SHALLOW_WATER"                  -> SHALLOW;
            case "FROZEN_OCEAN"                   -> FROZEN_SEA;
            case "ICE_SHELF"                      -> ICE_SHELF;
            case "CORAL_REEF"                     -> CORAL_REEF;
            case "KELP_FOREST"                    -> KELP_FOREST;
            case "BEACH"                          -> BEACH;
            case "GRASSY_SHORELINE"               -> GRASSY_SHORELINE;
            case "ROCKY_SHORE"                    -> ROCKY_SHORE;
            case "GRASSLAND_HILLS"                -> GRASSLAND_HILLS;
            case "FOOTHILLS"                      -> FOOTHILLS;
            case "FORESTED_FOOTHILLS"             -> FORESTED_FOOTHILLS;
            case "SNOWY_MOUNTAINS"                -> SNOWY_MOUNTAINS;  // legacy
            case "ALPINE_PEAKS"                   -> ALPINE_PEAKS;     // legacy
            case "ROCKY_PEAKS"                    -> ROCKY_PEAKS;      // legacy
            case "FROZEN_LAKE"                    -> FROZEN_LAKE;
            case "MANGROVE_SWAMP"                 -> MANGROVE_SWAMP;
            case "SAVANNAH"                       -> SAVANNAH;
            case "RAINY_HILLS"                    -> RAINY_HILLS;
            case "FROZEN_WASTES"                  -> FROZEN_WASTES;
            case "SNOWY_HILLS"                    -> SNOWY_HILLS;
            case "VOLCANIC_CALDERA"               -> VOLCANIC_CALDERA;
            case "ASHLANDS"                       -> ASHLANDS;
            case "GRASSY_FOOTHILLS"               -> GRASSY_FOOTHILLS;
            case "CRAGGY_FORESTED_FOOTHILLS"      -> CRAGGY_FORESTED_FOOTHILLS;
            case "CRAGGY_GRASSY_FOOTHILLS"        -> CRAGGY_GRASSY_FOOTHILLS;
            case "CRAGGY_FOOTHILLS"               -> CRAGGY_FOOTHILLS;
            case "CRAGGY_RAINY_HILLS"             -> CRAGGY_RAINY_HILLS;
            case "CRAGGY_GRASSLAND_HILLS"         -> CRAGGY_GRASSLAND_HILLS;
            case "CRAGGY_HILLS"                   -> CRAGGY_HILLS;
            case "WEATHERED_FORESTED_FOOTHILLS"   -> WEATHERED_FORESTED_FOOTHILLS;
            case "WEATHERED_GRASSY_FOOTHILLS"     -> WEATHERED_GRASSY_FOOTHILLS;
            case "WEATHERED_FOOTHILLS"            -> WEATHERED_FOOTHILLS;
            case "WEATHERED_RAINY_HILLS"          -> WEATHERED_RAINY_HILLS;
            case "WEATHERED_GRASSLAND_HILLS"      -> WEATHERED_GRASSLAND_HILLS;
            case "WEATHERED_HILLS"                -> WEATHERED_HILLS;
            default                               -> BG;
        };
    }

    // ── Mountain colour computation ────────────────────────────────────────

    /** True for all new 45-biome mountain names (contains "_MOUNTAINS" or "MAJOR_PEAKS"). */
    static boolean isMountainBiomeName(String upper) {
        return upper.contains("_MOUNTAINS") || upper.contains("MAJOR_PEAKS");
    }

    /**
     * Computes a fill colour for a mountain biome name by parsing its moisture,
     * size, and tectonic-age components.
     */
    static Color mountainColor(String upper) {
        boolean snowy    = upper.contains("SNOWY");
        boolean rocky    = upper.contains("ROCKY");
        boolean craggy   = upper.contains("CRAGGY")   && !snowy; // SNOWY_CRAGGY → snowy wins
        boolean weathered = upper.contains("WEATHERED") && !snowy;

        // Base RGB by moisture variant
        int r, g, b;
        if (snowy)       { r = 192; g = 207; b = 222; }
        else if (rocky)  { r =  62; g =  56; b =  50; }
        else             { r =  95; g =  85; b =  78; }

        // Darken with elevation/size (snowy darkens half as much — still light)
        int darken = upper.contains("MAJOR_PEAKS") ? 22
                   : upper.contains("MAJOR_")      ? 14
                   : upper.contains("LARGE_")      ? 8
                   : upper.contains("MIDSIZE_")    ? 3
                   : 0;
        if (snowy) darken /= 2;

        // Tectonic age tint
        if (craggy)    r += 5;          // young/craggy: slightly warmer
        if (weathered) { r -= 3; g -= 3; b -= 3; } // ancient: slightly muted

        return new Color(
            Math.max(0, Math.min(255, r - darken)),
            Math.max(0, Math.min(255, g - darken)),
            Math.max(0, Math.min(255, b - darken))
        );
    }

    private BiomeColors() {}
}
