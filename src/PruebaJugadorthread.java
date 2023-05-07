/*import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PruebaJugadorthread extends JFrame {
    private int x = 200;
    private int y = 200;
    private int speed = 5;

    public PruebaJugadorthread() {
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
        panelPrincipal.setSize(700,700);
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



        btnIniciar_Juego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(panelPrincipal);
                repaint();
                revalidate();
            }
        });

        this.repaint();
        this.revalidate();
    }
}
*/