import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VentanaJuego extends JFrame {

    public VentanaJuego() {
        iniciarComponentes();
    }
    //menu y panel de juego

    public void iniciarComponentes() {
        this.setVisible(true);
        this.setTitle("Space Invaders");
        this.setSize(700, 700);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panelMenu();
    }

    public void panelMenu() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setSize(690, 700);
        panelPrincipal.setLocation(0, 0);
        panelPrincipal.setBackground(Color.BLACK);
        panelPrincipal.setLayout(null);
        this.add(panelPrincipal);

        JLabel etiquetaTitulo = new JLabel("SPACE INVADERS", JLabel.CENTER);
        etiquetaTitulo.setFont(new Font("Consolas", Font.BOLD, 30));
        etiquetaTitulo.setSize(400, 40);
        etiquetaTitulo.setLocation(150, 100);
        etiquetaTitulo.setForeground(Color.white);
        panelPrincipal.add(etiquetaTitulo);

        JButton btnIniciar_Juego = new JButton("Comenzar juego");
        btnIniciar_Juego.setFont(new Font("Consolas", Font.BOLD, 20));
        btnIniciar_Juego.setSize(200, 40);
        btnIniciar_Juego.setLocation(250, 160);
        btnIniciar_Juego.setOpaque(true);
        btnIniciar_Juego.setForeground(Color.white);
        btnIniciar_Juego.setBackground(Color.black);
        btnIniciar_Juego.setBorderPainted(false);
        btnIniciar_Juego.setFocusPainted(false);
        panelPrincipal.add(btnIniciar_Juego);

        JPanel juegoinicio = new JPanel();
        juegoinicio.setSize(700, 700);
        juegoinicio.setLocation(0, 0);
        juegoinicio.setBackground(Color.BLUE);
        juegoinicio.setLayout(null);
        this.add(juegoinicio);

        btnIniciar_Juego.addActionListener(e -> {
            remove(panelPrincipal);
            new JugadorThread(juegoinicio).start();
            juegoinicio.requestFocusInWindow();
            repaint();
            revalidate();
        });

        this.repaint();
        this.revalidate();
    }


    //thread hilo del jugador
    private static class JugadorThread extends Thread implements KeyListener {
        private final JPanel panel;
        private int x = 350;
        private int y = 630;
        private int velocidad = 50;
        private PlayerPanel paneldeljugador;

        public JugadorThread(JPanel panel) {
            this.panel = panel;
            this.panel.addKeyListener(this);
            this.panel.setFocusable(true);
            this.panel.requestFocusInWindow();

            paneldeljugador = new PlayerPanel();
            paneldeljugador.setBounds(x, y, 10, 10);
            panel.add(paneldeljugador);
        }

        @Override
        public void run() {
            while (true) {
                paneldeljugador.repaint();
                try {
                    Thread.sleep(16);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode())

            {
                case KeyEvent.VK_LEFT:
                    x -= velocidad;
                    if (x < 0) x = 0;
                    paneldeljugador.setLocation(x, y);
                    break;
                case KeyEvent.VK_RIGHT:
                    x += velocidad;
                    if (x + paneldeljugador.getWidth() > panel.getWidth()) {
                        x = panel.getWidth() - paneldeljugador.getWidth();
                    }
                    paneldeljugador.setLocation(x, y);
                    break;
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {}
    }

    private static class PlayerPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 10, 10);
        }
    }


}