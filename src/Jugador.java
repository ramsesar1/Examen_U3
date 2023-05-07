/*

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Jugador extends JPanel implements KeyListener {
    private int x = 350;
    private int y = 630;
    private int velocidad = 15;

    public Jugador() {
        this.setPreferredSize(new Dimension(700, 700));
        this.setFocusable(true);
        this.requestFocusInWindow();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                createWhiteSquare();
                addKeyListener(Jugador.this);
            }
        });
        thread.start();
    }

    private void createWhiteSquare() {
        SwingUtilities.invokeLater(() -> {
            Graphics g = getGraphics();
            if (g != null) {
                g.setColor(Color.WHITE); // set color to blue
                g.fillRect(x, y, 10, 10); // draw the white square
            }
        });
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT :
                if (x > 0) {
                    x -= velocidad;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (x < 690) {
                    x += velocidad;
                }
                break;
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
    }
}
*/