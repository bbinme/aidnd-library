# Aethermere Library — Setup Spec

## Overview

A shared Gradle library (`aethermere-library`) at `./aidnd/library`, group `com.aidnd`,
artifact `aethermere-library`, distributed via `publishToMavenLocal`. Used by `client` and
`admin-client`. **GMS does not depend on this library** — its internal `Biome`/`PointOfInterest`
enums remain in `com.aidnd.gms.world.model` (used extensively in generation logic; clients
communicate via String over REST already).

---

## Gradle project structure

```
library/
  build.gradle
  settings.gradle
  src/main/java/com/aidnd/library/
    world/
      Biome.java
      PointOfInterest.java
    api/dto/
      AuthResponse.java
      ClientRumour.java
      LoginRequest.java
      PlayerPositionDto.java
      TileResponse.java
      WorldResponse.java
      WorldSummaryResponse.java
    theme/
      AethermereTheme.java
    components/
      StyledTextField.java
      StyledPasswordField.java
    render/
      BiomeColors.java
  src/main/resources/
    fonts/README.md   (same placeholder, fonts remain git-ignored)
```

---

## build.gradle

```groovy
plugins {
    id 'java-library'
    id 'maven-publish'
}

group   = 'com.aidnd'
version = '0.1.0-SNAPSHOT'

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
    withSourcesJar()
}

repositories {
    mavenCentral()
}

dependencies {
    // Pure Java + AWT/Swing (from JDK) — no external deps
}

publishing {
    publications {
        mavenJava(MavenPublication) {
            artifactId = 'aethermere-library'
            from components.java
        }
    }
}
```

---

## Contents

### `world/Biome.java`
Copied from `com.aidnd.gms.world.model.Biome` — identical enum, new package
`com.aidnd.library.world`. Ordinals must not change. Includes all 20 biomes through
`ROCKY_SHORE` and the `isImpassable()` method.

### `world/PointOfInterest.java`
`NONE, TOWN, DUNGEON` — copied from GMS, new package.

### `api/dto/*.java`
All records moved to `com.aidnd.library.api.dto`. `TileResponse` and `WorldResponse`
reference `ClientRumour` and `PlayerPositionDto` within the same package.

`WorldSummaryResponse` uses the **superset** (admin version — 10 fields):
```java
public record WorldSummaryResponse(
    String id, String sessionId, int width, int height,
    int partyStartCol, int partyStartRow, String status,
    int latitudeBand, int longitudeSlot, boolean souEnabled) {}
```
The client currently only uses 7 fields; Jackson ignores the extras automatically.

### `theme/AethermereTheme.java`
Merged from both clients. Uses client version as base (has Javadoc comments).
Add the `DANGER_MEDIUM` constant the admin-client is missing:
```java
public static final Color DANGER_MEDIUM = new Color(0xA08C40);
```
Font loading unchanged — looks for `/fonts/Cinzel-Regular.ttf` and `/fonts/Raleway-Regular.ttf`
on the classpath; each client keeps its own font files in `src/main/resources/fonts/`.

### `components/StyledTextField.java` / `StyledPasswordField.java`
Use the **client versions** as canonical — they have more complete behaviour (focus glow,
no-arg constructor on StyledTextField, corner radius 2, maxHeight 42). Admin versions are
behind in features and will be updated to match.

Package: `com.aidnd.library.components`. Imports updated to `com.aidnd.library.theme.AethermereTheme`.

### `render/BiomeColors.java`
New utility class. Static method `colorFor(String biome)` returns `java.awt.Color`.
Consolidates the biome→color maps currently duplicated in `OverworldPanel` and `MapCanvas`.
Also exposes POI colour constants (`COL_TOWN`, `COL_DUNGEON`, `COL_RUMOUR`, `COL_PLAYER`).

```java
package com.aidnd.library.render;

import java.awt.Color;

public final class BiomeColors {
    public static Color colorFor(String biome) { ... }

    public static final Color TOWN    = new Color(230, 210, 160);
    public static final Color DUNGEON = new Color(180,  60,  60);
    public static final Color RUMOUR  = new Color(160, 100, 200);
    public static final Color PLAYER  = new Color(255, 220,  80);

    private BiomeColors() {}
}
```

---

## Migration plan (client + admin-client)

For each repo after the library is published:

1. Add `mavenLocal()` to `repositories` block in `build.gradle`
2. Add dependency: `implementation 'com.aidnd:aethermere-library:0.1.0-SNAPSHOT'`
3. Delete the local copies of the migrated files
4. Update all imports from `com.aidnd.client.*` / `com.aidnd.admin.*` to `com.aidnd.library.*`
5. Update `OverworldPanel.biomeColor()` and `MapCanvas.biomeColor()` to delegate to
   `BiomeColors.colorFor()` and remove the duplicated colour constants
6. Remove duplicated font-loading code now that `AethermereTheme` is in the library

Files deleted from **client**:
- `api/dto/AuthResponse.java`, `ClientRumour.java`, `LoginRequest.java`,
  `PlayerPositionDto.java`, `TileResponse.java`, `WorldResponse.java`, `WorldSummaryResponse.java`
- `theme/AethermereTheme.java`
- `components/StyledTextField.java`, `StyledPasswordField.java`

Files deleted from **admin-client**: same list.

---

## Not included (deferred)

- `RegisterRequest`, `SessionRequest/Response`, `CharacterRequest/Response`,
  `CreateWorldRequest`, `MoveRequest/Response`, `WorldDeltaResponse`, `PlayerTileDeltaDto`,
  `ResolvedRumourDto` — client-specific; no admin-client counterpart
- `GmsClient` / `GmsAdminClient` — parallel but different; not worth abstracting yet
- `StyledButton`, `BiomeCard`, `GlassPanel`, etc. — not yet duplicated in both repos
