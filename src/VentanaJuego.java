import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Observable;
import java.util.Observer;


public class VentanaJuego extends JFrame {

    public int score=0,hiScore=0;

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

        Tutorial();
    }

    public void Tutorial(){
        JPanel panelTuto = new JPanel();
        panelTuto.setSize(700, 700);
        panelTuto.setLocation(0, 0);
        panelTuto.setBackground(Color.black);
        panelTuto.setLayout(null);
        this.add(panelTuto);

        try{
            BufferedImage flechaI = ImageIO.read(new File("src//Recursos//flechaI.png"));
            BufferedImage flechaD = ImageIO.read(new File("src//Recursos//flechaD.png"));
            BufferedImage espacio = ImageIO.read(new File("src//Recursos//espacio.png"));
        }catch(IOException ex){
            ex.printStackTrace();
        }

        try{
            File file = new File("src//Recursos//flechaI.png");
            BufferedImage image = ImageIO.read(file);
            JLabel label = new JLabel(new ImageIcon(image));
            label.setBounds(440,340,100,100);
        }catch(IOException a){
            a.printStackTrace();
        }

        JLabel etiquetaTitulo = new JLabel("TUTORIAL", JLabel.CENTER);
        etiquetaTitulo.setFont(new Font("Consolas", Font.BOLD, 30));
        etiquetaTitulo.setSize(400, 40);
        etiquetaTitulo.setLocation(150, 100);
        etiquetaTitulo.setForeground(Color.white);
        panelTuto.add(etiquetaTitulo);

        JLabel subtituloUno = new JLabel("Sistema de puntos:", JLabel.CENTER);
        subtituloUno.setFont(new Font("Consolas", Font.BOLD, 20));
        subtituloUno.setSize(400, 40);
        subtituloUno.setLocation(0, 200);
        subtituloUno.setForeground(Color.white);
        panelTuto.add(subtituloUno);

        JLabel subtituloDos = new JLabel("Controles:", JLabel.CENTER);
        subtituloDos.setFont(new Font("Consolas", Font.BOLD, 20));
        subtituloDos.setSize(400, 40);
        subtituloDos.setLocation(300, 200);
        subtituloDos.setForeground(Color.white);
        panelTuto.add(subtituloDos);

        JLabel puntosEnemigos1 = new JLabel("  = ? MYSTERY");
        puntosEnemigos1.setFont(new Font("Consolas", Font.BOLD, 18));
        puntosEnemigos1.setSize(200, 40);
        puntosEnemigos1.setLocation(160, 300);
        puntosEnemigos1.setForeground(Color.white);
        panelTuto.add(puntosEnemigos1);

        JLabel puntosEnemigos2 = new JLabel("  = 30 POINTS");
        puntosEnemigos2.setFont(new Font("Consolas", Font.BOLD, 18));
        puntosEnemigos2.setSize(200, 40);
        puntosEnemigos2.setLocation(160, 350);
        puntosEnemigos2.setForeground(Color.white);
        panelTuto.add(puntosEnemigos2);

        JLabel puntosEnemigos3 = new JLabel("  = 20 POINTS");
        puntosEnemigos3.setFont(new Font("Consolas", Font.BOLD, 18));
        puntosEnemigos3.setSize(200, 40);
        puntosEnemigos3.setLocation(160, 400);
        puntosEnemigos3.setForeground(Color.white);
        panelTuto.add(puntosEnemigos3);

        JLabel puntosEnemigos4 = new JLabel("  = 10 POINTS");
        puntosEnemigos4.setFont(new Font("Consolas", Font.BOLD, 18));
        puntosEnemigos4.setSize(200, 40);
        puntosEnemigos4.setLocation(160, 450);
        puntosEnemigos4.setForeground(Color.white);
        panelTuto.add(puntosEnemigos4);

        JLabel controles1 = new JLabel(" Movimieno:");
        controles1.setFont(new Font("Consolas", Font.BOLD, 18));
        controles1.setSize(200, 40);
        controles1.setLocation(440, 300);
        controles1.setForeground(Color.white);
        panelTuto.add(controles1);

        JLabel controles2 = new JLabel(" Disparo:");
        controles2.setFont(new Font("Consolas", Font.BOLD, 18));
        controles2.setSize(200, 40);
        controles2.setLocation(440, 410);
        controles2.setForeground(Color.white);
        panelTuto.add(controles2);

        JButton btnConitnuar = new JButton("Continuar");
        btnConitnuar.setFont(new Font("Consolas", Font.BOLD, 20));
        btnConitnuar.setSize(200, 40);
        btnConitnuar.setLocation(250, 550);
        btnConitnuar.setOpaque(true);
        btnConitnuar.setForeground(Color.white);
        btnConitnuar.setBackground(Color.black);
        btnConitnuar.setBorderPainted(false);
        btnConitnuar.setFocusPainted(false);
        panelTuto.add(btnConitnuar);

        btnConitnuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(panelTuto);
                panelMenu();
                repaint();
            }

        });
        repaint();
        revalidate();
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

        JLabel etiquetaHS = new JLabel("SCORES", JLabel.CENTER);
        etiquetaHS.setFont(new Font("Consolas", Font.BOLD, 30));
        etiquetaHS.setSize(400, 40);
        etiquetaHS.setLocation(150, 300);
        etiquetaHS.setForeground(Color.white);
        panelPrincipal.add(etiquetaHS);

        JLabel hScore = new JLabel("BEST SCORE.........."+hiScore, JLabel.CENTER);
        hScore.setFont(new Font("Consolas", Font.BOLD, 20));
        hScore.setSize(400, 40);
        hScore.setLocation(150, 370);
        hScore.setForeground(Color.white);
        panelPrincipal.add(hScore);

        JLabel lScore = new JLabel("LAST SCORE.........."+score, JLabel.CENTER);
        lScore.setFont(new Font("Consolas", Font.BOLD, 20));
        lScore.setSize(400, 40);
        lScore.setLocation(150, 450);
        lScore.setForeground(Color.white);
        panelPrincipal.add(lScore);

        btnIniciar_Juego.addActionListener(e -> {
            remove(panelPrincipal);
            JugadorThread jugadorThread = new JugadorThread(juegoinicio);
            jugadorThread.start();
            DisparoThread bulletThread = new DisparoThread(jugadorThread, juegoinicio);
            bulletThread.start();
            EscudoThread shieldThread = new EscudoThread(juegoinicio);
            new Thread(shieldThread).start();
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
        private paneldejugador paneldeljugador;
        private boolean isFiring = false;

        public JugadorThread(JPanel panel) {
            this.panel = panel;
            this.panel.addKeyListener(this);
            this.panel.setFocusable(true);
            this.panel.requestFocusInWindow();

            paneldeljugador = new paneldejugador();
            paneldeljugador.setBounds(x, y, 10, 10);
            panel.add(paneldeljugador);
        }

        public static Font cargarFuente(String ruta){
            Font fuente = null;
            InputStream entradaBytes = ClassLoader.class.getResourceAsStream(ruta);
            try{
                fuente = Font.createFont(Font.TRUETYPE_FONT,entradaBytes);
            } catch(FontFormatException e){
                e.printStackTrace();
            } catch(IOException e){
                e.printStackTrace();
            }
            fuente = fuente.deriveFont(12f);
            return fuente;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    x -= velocidad;
                    if (x < 0) x = 0;
                    paneldeljugador.setLocation(x, y);
                    panel.repaint();
                    break;
                case KeyEvent.VK_RIGHT:
                    x += velocidad;
                    if (x > 690) x = 690;
                    paneldeljugador.setLocation(x, y);
                    panel.repaint();
                    break;
                case KeyEvent.VK_SPACE:
                    isFiring = true;
                    break;
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_SPACE:
                    System.out.println("baladisparada");
                    isFiring = false;
                    break;
            }
        }

        public boolean isFiring() {
            return isFiring;
        }
        public void run() {
            while (true) {
                paneldeljugador.setLocation(x, y);
                panel.repaint();

                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }



    }

    private static class paneldejugador extends JPanel {
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
        private paneldebalas bala;
        private boolean isFiring = false;

        public DisparoThread(JugadorThread jugadorThread, JPanel panel) {
            this.jugadorThread = jugadorThread;
            this.panel = panel;
        }

        public boolean isFiring() {
            return isFiring;
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
                    remove();
                } else {
                    setBounds(x, y, 2, 10);
                }
            }

            public void remove() {
                panel.remove(this);
                isFiring = false;
                bala = null;
                panel.repaint();
            }

            @Override
            public void paint(Graphics g) {
                super.paint(g);
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, 2, 10);
            }
        }


        @Override
        public void run() {
            while (true) {
                if (jugadorThread.isFiring() && !isFiring) {
                    bala = new paneldebalas(jugadorThread.paneldeljugador.getX() + 4, jugadorThread.paneldeljugador.getY() - 10);
                    panel.add(bala);
                    isFiring = true;
                }

                if (isFiring) {
                    bala.mover();
                }

                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //thread de escudos
    private static class EscudoThread implements Runnable {
        private final JPanel panel;
        private Escudo[][] Escudos;
        private int shieldGap = 80;
        private int shieldTop = 530;

        public EscudoThread(JPanel panel) {
            this.panel = panel;
            Escudos = new Escudo[4][];
            for (int i = 0; i < 1; i++) {
                Escudos[i] = new Escudo[4];
                for (int j = 0; j < 4; j++) {
                    int x = (j + 1) * shieldGap + j * 80;
                    int y = shieldTop - (i + 1) * shieldGap - i * 80;
                    Escudos[i][j] = new Escudo(x, y);
                    panel.add(Escudos[i][j]);
                }
            }
        }

        @Override
        public void run() {
        }

        private static class Escudo extends JPanel {
            public Escudo(int x, int y) {
                setBounds(x, y, 80, 80);
                setBackground(Color.GREEN);
            }
        }
    }









    //thread hilo aliens
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