import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.InputStream;


public class VentanaJuego extends JFrame {

    public int score = 0, hiScore = 0;
    private Sonido disparo_1;//VARIABLE GLOBAL PARA REPRODUCIR EL AUDIO
    private Sonido disparo_2;
    private Sonido disparo_3;
    private Sonido destruccion_1;
    private Sonido destruccion_2;
    private Sonido destruccion_3;
    //public static Font fuentepixel = cargarFuente("src//Recursos//fuente.ttf");

    private static int filas = 5;
    private static int columnas = 11;
    private static JPanel[][] aliens = new JPanel[filas][columnas];

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

    public void Tutorial() {
        JPanel panelTuto = new JPanel();
        panelTuto.setSize(700, 700);
        panelTuto.setLocation(0, 0);
        panelTuto.setBackground(Color.black);
        panelTuto.setLayout(null);
        this.add(panelTuto);
        
        cargarSonido();//LLAMAR AL METODO QUE CARGA EL AUDIO
        
        ImageIcon flechaI = new ImageIcon("src//Recursos//flechaI.png");
        JLabel flechai = new JLabel();
        flechai.setBounds(430, 335, 60, 60);
        flechai.setIcon(new ImageIcon(flechaI.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
        panelTuto.add(flechai);

        ImageIcon flechaD = new ImageIcon("src//Recursos//flechaD.png");
        JLabel flechad = new JLabel();
        flechad.setBounds(515, 335, 60, 60);
        flechad.setIcon(new ImageIcon(flechaD.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
        panelTuto.add(flechad);

        ImageIcon espacio = new ImageIcon("src//Recursos//espacio.png");
        JLabel espace = new JLabel();
        espace.setBounds(400, 420, 200, 100);
        espace.setIcon(new ImageIcon(espacio.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH)));
        panelTuto.add(espace);

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
        controles1.setLocation(440, 290);
        controles1.setForeground(Color.white);
        panelTuto.add(controles1);

        JLabel controles2 = new JLabel(" Disparo:");
        controles2.setFont(new Font("Consolas", Font.BOLD, 18));
        controles2.setSize(200, 40);
        controles2.setLocation(450, 410);
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
                disparo_3.play();//PRUEBA DE AUDIO
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

        JLabel hScore = new JLabel("BEST SCORE.........." + hiScore, JLabel.CENTER);
        hScore.setFont(new Font("Consolas", Font.BOLD, 20));
        hScore.setSize(400, 40);
        hScore.setLocation(150, 370);
        hScore.setForeground(Color.white);
        panelPrincipal.add(hScore);

        JLabel lScore = new JLabel("LAST SCORE.........." + score, JLabel.CENTER);
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
            AlienThread alienThread = new AlienThread(juegoinicio);
            alienThread.start();
            juegoinicio.requestFocusInWindow();
            repaint();
            revalidate();
        });

        this.repaint();
        this.revalidate();
    }

    public static Font cargarFuente(String ruta) {
        Font fuente = null;
        InputStream entradaBytes = ClassLoader.class.getResourceAsStream(ruta);
        try {
            fuente = Font.createFont(Font.TRUETYPE_FONT, entradaBytes);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fuente = fuente.deriveFont(12f);
        return fuente;
    }
    
    public void cargarSonido() {//FUNCION PARA CARGAR AUDIO
    	try {
    		disparo_1 = new Sonido("src/SonidosJuego/Audio_disparoLaser1.wav");
    		disparo_2 = new Sonido("src/SonidosJuego/Audio_disparoLaser2.wav");
    		disparo_3 = new Sonido("src/SonidosJuego/Audio_disparoLaser3.wav");
    		destruccion_1 = new Sonido("src/SonidosJuego/Audio_Destruccion1.wav");
    		destruccion_2 = new Sonido("src/SonidosJuego/Audio_Destruccion1.wav");
    		destruccion_3 = new Sonido("src/SonidosJuego/Audio_Destruccion1.wav");
    	}catch (Exception e) {
			System.err.println("No encontro el archivo de audio");
		}
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
        public void keyTyped(KeyEvent e) {
        }

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
                for(int i=0;i<5;i++){
                    for(int j=0;j<11;j++){
                        if(x>aliens[i][j].getX() && x<aliens[i][j].getX()+55 && y>aliens[i][j].getY() && y<aliens[i][j].getY()+55 && aliens[i][j].isVisible()==true){
                            aliens[i][j].setVisible(false);
                            remove();
                        }
                    }
                }
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
    public class AlienThread extends Thread {
        private JPanel panel;
        private int x0 = 25;
        private int y0 = 25;
        private int espacio = 55;

        public AlienThread(JPanel panel) {
            this.panel = panel;
            aliens = new JPanel[filas][columnas];
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    JPanel alienPanel = new JPanel();
                    alienPanel.setBounds(x0 + j * espacio, y0 + i * espacio, 40, 40);
                    alienPanel.setBackground(Color.GREEN);
                    aliens[i][j] = alienPanel;
                    panel.add(alienPanel);
                }
            }
        }

        @Override
        public void run() {
            int dx = 1;
            int dy = 0;
            while (true) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                x0 += dx;
                y0 += dy;
                if (x0 < 0 || x0 + columnas * espacio > panel.getWidth()) {
                    dx = -dx;
                    y0 += espacio;
                }
                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        aliens[i][j].setBounds(x0 + j * espacio, y0 + i * espacio, 40, 40);
                    }
                }
                panel.repaint();
            }
        }
    }


}
