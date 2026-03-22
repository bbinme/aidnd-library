package com.aidnd.library.theme;

import java.awt.*;
import java.io.InputStream;

public final class AethermereTheme {

    // ── Colors ─────────────────────────────────────────────────────────────
    public static final Color BG_DEEP          = new Color(0x0A0B0F);
    public static final Color BG_PANEL         = new Color(14, 16, 24, 224);    // 0.88 alpha
    public static final Color BG_PANEL_SOLID   = new Color(0x0E1018);
    public static final Color BG_INPUT         = new Color(20, 23, 35, 230);    // 0.90 alpha
    public static final Color BORDER_DIM       = new Color(80, 90, 130, 51);    // 0.20 alpha
    public static final Color BORDER_HOVER     = new Color(80, 90, 130, 89);    // 0.35 alpha
    public static final Color BORDER_FOCUS     = new Color(160, 140, 100, 127); // 0.50 alpha
    public static final Color ACCENT_GOLD      = new Color(0xC9A84C);
    public static final Color ACCENT_GOLD_DIM  = new Color(201, 168, 76, 76);   // 0.30 alpha
    public static final Color ACCENT_GOLD_GLOW = new Color(201, 168, 76, 30);   // 0.12 alpha
    public static final Color TEXT_PRIMARY     = new Color(0xD4D0C8);
    public static final Color TEXT_SECONDARY   = new Color(180, 176, 168, 127); // 0.50 alpha
    public static final Color TEXT_HEADING     = new Color(0xE8E2D4);
    public static final Color TEXT_PLACEHOLDER = new Color(140, 136, 128, 76);  // 0.30 alpha
    public static final Color DANGER           = new Color(0xA04040);
    public static final Color DANGER_MEDIUM    = new Color(0xA08C40);
    public static final Color SUCCESS          = new Color(0x4A8C5C);

    // ── Fonts ───────────────────────────────────────────────────────────────
    public static final Font FONT_DISPLAY;
    public static final Font FONT_BODY;

    static {
        FONT_DISPLAY = loadFont("/fonts/Cinzel-Regular.ttf", "Serif");
        FONT_BODY    = loadFont("/fonts/Raleway-Regular.ttf", "SansSerif");
    }

    private static Font loadFont(String resource, String fallbackFamily) {
        try (InputStream in = AethermereTheme.class.getResourceAsStream(resource)) {
            if (in != null) {
                Font font = Font.createFont(Font.TRUETYPE_FONT, in);
                GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
                return font;
            }
        } catch (Exception ignored) {}
        return new Font(fallbackFamily, Font.PLAIN, 13);
    }

    public static Font display(float size)     { return FONT_DISPLAY.deriveFont(Font.PLAIN, size); }
    public static Font displayBold(float size) { return FONT_DISPLAY.deriveFont(Font.BOLD, size); }
    public static Font body(float size)        { return FONT_BODY.deriveFont(Font.PLAIN, size); }
    public static Font bodyBold(float size)    { return FONT_BODY.deriveFont(Font.BOLD, size); }

    /** Alpha-blend a color: 0.0 = fully transparent, 1.0 = original */
    public static Color alpha(Color c, float a) {
        return new Color(c.getRed(), c.getGreen(), c.getBlue(), Math.round(a * 255));
    }

    private AethermereTheme() {}
}
