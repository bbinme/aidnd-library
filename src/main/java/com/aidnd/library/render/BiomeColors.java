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
    public static final Color OCEAN       = new Color(20,  50,  120);
    public static final Color SHALLOW     = new Color(50,  110, 190);
    public static final Color FROZEN_SEA  = new Color(160, 190, 215);
    public static final Color ICE_SHELF   = new Color(220, 235, 245);
    public static final Color CORAL_REEF  = new Color(80,  200, 200);
    public static final Color KELP_FOREST = new Color(30,  100, 90);
    public static final Color BEACH       = new Color(240, 220, 160);
    public static final Color ROCKY_SHORE = new Color(100, 90,  80);

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
        return switch (biome.toUpperCase()) {
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
            case "OCEAN"                          -> OCEAN;
            case "SHALLOW_WATER"                  -> SHALLOW;
            case "FROZEN_OCEAN"                   -> FROZEN_SEA;
            case "ICE_SHELF"                      -> ICE_SHELF;
            case "CORAL_REEF"                     -> CORAL_REEF;
            case "KELP_FOREST"                    -> KELP_FOREST;
            case "BEACH"                          -> BEACH;
            case "ROCKY_SHORE"                    -> ROCKY_SHORE;
            default                               -> BG;
        };
    }

    private BiomeColors() {}
}
