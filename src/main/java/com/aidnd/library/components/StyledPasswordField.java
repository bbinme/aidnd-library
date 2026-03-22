package com.aidnd.library.components;

import com.aidnd.library.theme.AethermereTheme;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/** Dark-background password field matching the design spec. */
public class StyledPasswordField extends JPasswordField {

    private boolean focused = false;

    public StyledPasswordField() {
        setOpaque(false);
        setFont(AethermereTheme.body(13f));
        setForeground(AethermereTheme.TEXT_PRIMARY);
        setCaretColor(AethermereTheme.ACCENT_GOLD);
        setEchoChar('•');
        setBorder(new EmptyBorder(10, 14, 10, 14));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 42));

        addFocusListener(new FocusAdapter() {
            @Override public void focusGained(FocusEvent e) { focused = true;  repaint(); }
            @Override public void focusLost(FocusEvent e)   { focused = false; repaint(); }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();

        g2.setColor(AethermereTheme.BG_INPUT);
        g2.fillRoundRect(0, 0, w, h, 2, 2);

        Color border = focused ? AethermereTheme.BORDER_FOCUS : AethermereTheme.BORDER_DIM;
        g2.setColor(border);
        g2.setStroke(new BasicStroke(1f));
        g2.drawRoundRect(0, 0, w - 1, h - 1, 2, 2);

        if (focused) {
            g2.setColor(AethermereTheme.ACCENT_GOLD_GLOW);
            g2.setStroke(new BasicStroke(3f));
            g2.drawRoundRect(1, 1, w - 3, h - 3, 2, 2);
        }

        g2.dispose();
        super.paintComponent(g);
    }
}
