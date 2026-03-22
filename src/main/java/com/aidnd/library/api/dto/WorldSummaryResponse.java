package com.aidnd.library.api.dto;

public record WorldSummaryResponse(String id, String sessionId, int width, int height,
                                   int partyStartCol, int partyStartRow, String status,
                                   int latitudeBand, int longitudeSlot, boolean souEnabled) {}
