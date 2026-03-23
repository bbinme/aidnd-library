package com.aidnd.library.api.dto;

import java.util.List;

public record WorldResponse(String id, String sessionId, int width, int height,
                            int partyStartCol, int partyStartRow, int turnNumber,
                            List<PlayerPositionDto> players, List<TileResponse> tiles,
                            List<FactionSummary> factions) {}
