import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaJuego extends JFrame {
    private int x = 350;
    private int y = 630;
    private int velocidad = 15;

    public VentanaJuego() {
        iniciarComponentes();
    }

    public void iniciarComponentes() {
        this.setVisible(true);
        this.setTitle("Space Invaders");
        this.setSize(700,700);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panelMenu();
    }

    public void panelMenu() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setSize(690,700);
        panelPrincipal.setLocation(0,0);
        panelPrincipal.setBackground(Color.BLACK);
        panelPrincipal.setLayout(null);
        this.add(panelPrincipal);

        JLabel etiquetaTitulo = new JLabel("SPACE INVADERS",JLabel.CENTER);
        etiquetaTitulo.setFont(new Font("Consolas",Font.BOLD,30));
        etiquetaTitulo.setSize(400,40);
        etiquetaTitulo.setLocation(150,100);
        etiquetaTitulo.setForeground(Color.white);
        panelPrincipal.add(etiquetaTitulo);

        JButton btnIniciar_Juego = new JButton("Comenzar juego");
        btnIniciar_Juego.setFont(new Font("Consolas",Font.BOLD,20));
        btnIniciar_Juego.setSize(200,40);
        btnIniciar_Juego.setLocation(250,160);
        btnIniciar_Juego.setOpaque(true);
        btnIniciar_Juego.setForeground(Color.white);
        btnIniciar_Juego.setBackground(Color.black);
        btnIniciar_Juego.setBorderPainted(false);
        btnIniciar_Juego.setFocusPainted(false);
        panelPrincipal.add(btnIniciar_Juego);

        JPanel juegoinicio = new Paneldejuego();
        juegoinicio.setSize(700,700);
        juegoinicio.setLocation(0,0);
        juegoinicio.setBackground(Color.BLUE);
        juegoinicio.setLayout(null);
        this.add(juegoinicio);

        btnIniciar_Juego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(panelPrincipal);
                juegoinicio.requestFocusInWindow();
                repaint();
                revalidate();
            }
        });

        this.repaint();
        this.revalidate();
    }

    private class Paneldejuego extends JPanel implements KeyListener {
        private int coordenadaX = 345;
        private int coordenadaY = 680;

        public Paneldejuego() {
            this.setPreferredSize(new Dimension(700, 700));
            this.addKeyListener(this);
            this.setFocusable(true);
            this.requestFocusInWindow();

        }


        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.WHITE);
            g.fillRect(x, y, 10, 10);
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
}