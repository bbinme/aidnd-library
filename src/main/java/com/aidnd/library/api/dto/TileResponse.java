package com.aidnd.library.api.dto;

import java.util.List;

public record TileResponse(int col, int row, String shroudState,
                           String biome, String pointOfInterest,
                           Float elevation, Float moisture, Integer riverEdges,
                           String tileName, Integer townSizeTier,
                           List<ClientRumour> rumours,
                           String controllingFactionId, Boolean contested,
                           Integer stabilityScore, String foundingRace,
                           List<AllegianceEntry> allegiances) {}
