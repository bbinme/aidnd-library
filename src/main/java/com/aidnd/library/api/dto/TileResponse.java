package com.aidnd.library.api.dto;

import java.util.List;

public record TileResponse(int col, int row, String shroudState,
                           String biome, String pointOfInterest,
                           Float elevation, Integer riverEdges,
                           List<ClientRumour> rumours) {}
