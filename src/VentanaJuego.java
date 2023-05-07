import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class VentanaJuego extends JFrame {

    public VentanaJuego() {
        iniciarComponentes();
    }

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
            JugadorThread jugadorThread = new JugadorThread(juegoinicio);
            jugadorThread.start();
            DisparoThread bulletThread = new DisparoThread(jugadorThread, juegoinicio);
            bulletThread.start();
            aliensEnemigos enemigosThread = new aliensEnemigos(juegoinicio);
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
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    x -= velocidad;
                    if (x < 0) x = 0;
                    paneldeljugador.setLocation(x, y);
                    break;
                case KeyEvent.VK_RIGHT:
                    x += velocidad;
                    if (x > 690) x = 690;
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
        public void paint(Graphics g) {
            super.paint(g);
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 10, 10);
        }
    }

    //hilo thread disparo

    private static class DisparoThread extends Thread {
        private final JugadorThread jugadorThread;
        private final JPanel panel;
        private final List<paneldebalas> balas = new ArrayList<>();

        public DisparoThread(JugadorThread jugadorThread, JPanel panel) {
            this.jugadorThread = jugadorThread;
            this.panel = panel;
        }


        private class paneldebalas extends JPanel {
            private int x;
            private int y;
            private int velocidad = 20;

            public paneldebalas(int x, int y) {
                this.x = x;
                this.y = y;
                setBounds(x, y, 2, 10);
            }

            public void mover() {
                y -= velocidad;
                if (y < 0) {
                    balas.remove(this);
                    panel.remove(this);
                } else {
                    setBounds(x, y, 2, 10);
                }
            }

            @Override
            public void paint(Graphics g) {
                super.paint(g);
                g.setColor(Color.YELLOW);
                g.fillRect(0, 0, 2, 10);
            }
        }

        @Override
        public void run() {
            while (true) {
                int x = jugadorThread.x + 5;
                int y = jugadorThread.y;
                paneldebalas panelbala = new paneldebalas(x, y);
                balas.add(panelbala);
                panel.add(panelbala);
                panel.repaint();

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (paneldebalas bullet : balas) {
                    bullet.mover();
                }
                panel.repaint();
            }
        }
    }
    
    private static class aliensEnemigos implements Observer {
    	private Enemigos aliens;
    	private Navecita nave;
    	private JPanel panel;
    	private panel_enemigos iniPanel;
    	
        public aliensEnemigos(JPanel panel) {
        	this.panel=panel;
        	aliens = new Enemigos();
        	iniPanel = new panel_enemigos();
        	panel.add(iniPanel);
        	
        	Thread hiloEnemigos = new Thread(aliens);
        	hiloEnemigos.start();
        }

        private class panel_enemigos extends JPanel {

            public panel_enemigos() {
            	setBounds(0,0,700,700);
            	this.setBackground(Color.black);
            }

            @Override
            public void paint(Graphics g) {
                super.paint(g);
                //PINTAR ENEMIGOS
                Navecita[] nave = aliens.getEnemigos();
                g.setColor(Color.pink);
                for(int i=0;i<55;i++) {
                	g.fillRect(nave[i].getPosi_x(), nave[i].getPosi_y(), 25, 25);
                }
                //
            }
        }

		@Override
		public void update(Observable o, Object arg) {
			aliens = (Enemigos) arg;
		}
    }
    
}
