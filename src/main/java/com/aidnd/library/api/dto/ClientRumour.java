package com.aidnd.library.api.dto;

public record ClientRumour(String claimedType, String description, String sourceType,
                           String actualTruth, String discoveredTruth) {}
