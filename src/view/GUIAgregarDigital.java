package view;

import controller.ControllerVideoJuego;
import model.VideoJuego;
import model.VideoJuegoDigital;
import model.VideoJuegoFisico;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIAgregarDigital extends JFrame {

    private JTextField idTexto, nombreTexto, precioTexto, stockTexto,
            plataformaTexto, generoTexto, calificacionEdadTexto, fechaLanzamientotexto, claveActivacionTexto, expiracionClaveTexto;

    private JTextArea descripcionTexto;
    private JLabel idLabel, nombreLabel, precioLabel, stockLabel, descripcionLabel,
            plataformaLabel, generoLabel, calificacionEdadLabel, fechaLanzamientoLabel, claveActivacionLabel, experacionClaveLabel;
    private JButton agregarBTN;
    public GUIAgregarDigital()  {

        Color color = new Color(86, 133, 176);
        Border grayBorder = BorderFactory.createLineBorder(Color.GRAY, 1);
        JLabel titulo = new JLabel("Agregar juego digital");
        Font fuenteActual = titulo.getFont();
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setFont(new Font(fuenteActual.getName(), fuenteActual.getStyle(), 20));
        JPanel panelLabels = new JPanel();
        panelLabels.setLayout(new GridLayout(11,1));
        panelLabels.setBackground(color);
        JPanel panelTexto = new JPanel();
        panelTexto.setLayout(new GridLayout(11,1));
        panelTexto.setBackground(color);

        setTitle("Agregar video juego");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(color);

        idLabel = new JLabel("Id: ");
        idLabel.setHorizontalAlignment(JLabel.CENTER);
        nombreLabel = new JLabel("Nombre: ");
        nombreLabel.setHorizontalAlignment(JLabel.CENTER);
        precioLabel = new JLabel("Precio: ");
        precioLabel.setHorizontalAlignment(JLabel.CENTER);
        stockLabel = new JLabel("Stock");
        stockLabel.setHorizontalAlignment(JLabel.CENTER);
        descripcionLabel = new JLabel("Descripcion: ");
        descripcionLabel.setHorizontalAlignment(JLabel.CENTER);
        plataformaLabel = new JLabel("Plataforma: ");
        plataformaLabel.setHorizontalAlignment(JLabel.CENTER);
        generoLabel = new JLabel("Genero: ");
        generoLabel.setHorizontalAlignment(JLabel.CENTER);
        calificacionEdadLabel = new JLabel("Edad Minima: ");
        calificacionEdadLabel.setHorizontalAlignment(JLabel.CENTER);
        fechaLanzamientoLabel = new JLabel("Fecha Lanzamiento: ");
        fechaLanzamientoLabel.setHorizontalAlignment(JLabel.CENTER);
        claveActivacionLabel = new JLabel("Clave: ");
        claveActivacionLabel.setHorizontalAlignment(JLabel.CENTER);
        experacionClaveLabel = new JLabel("Vence: ");
        experacionClaveLabel.setHorizontalAlignment(JLabel.CENTER);

        idTexto = new JTextField();
        idTexto.setBorder(grayBorder);
        nombreTexto = new JTextField();
        nombreTexto.setBorder(grayBorder);
        precioTexto = new JTextField();
        precioTexto.setBorder(grayBorder);
        stockTexto = new JTextField();
        stockTexto.setBorder(grayBorder);
        descripcionTexto = new JTextArea();
        descripcionTexto.setBorder(grayBorder);
        plataformaTexto = new JTextField();
        plataformaTexto.setBorder(grayBorder);
        generoTexto = new JTextField();
        generoTexto.setBorder(grayBorder);
        calificacionEdadTexto = new JTextField();
        calificacionEdadTexto.setBorder(grayBorder);
        fechaLanzamientotexto = new JTextField();
        fechaLanzamientotexto.setBorder(grayBorder);
        claveActivacionTexto = new JTextField();
        claveActivacionTexto.setBorder(grayBorder);
        expiracionClaveTexto = new JTextField();
        expiracionClaveTexto.setBorder(grayBorder);

        agregarBTN = new JButton("Agregar");

        panelLabels.add(idLabel);
        panelLabels.add(nombreLabel);
        panelLabels.add(precioLabel);
        panelLabels.add(stockLabel);
        panelLabels.add(descripcionLabel);
        panelLabels.add(plataformaLabel);
        panelLabels.add(generoLabel);
        panelLabels.add(calificacionEdadLabel);
        panelLabels.add(fechaLanzamientoLabel);
        panelLabels.add(claveActivacionLabel);
        panelLabels.add(experacionClaveLabel);

        panelTexto.add(idTexto);
        panelTexto.add(nombreTexto);
        panelTexto.add(precioTexto);
        panelTexto.add(stockTexto);
        panelTexto.add(descripcionTexto);
        panelTexto.add(plataformaTexto);
        panelTexto.add(generoTexto);
        panelTexto.add(calificacionEdadTexto);
        panelTexto.add(fechaLanzamientotexto);
        panelTexto.add(claveActivacionTexto);
        panelTexto.add(expiracionClaveTexto);

        add(titulo, BorderLayout.NORTH);
        add(panelLabels, BorderLayout.WEST);
        add(panelTexto, BorderLayout.CENTER);
        add(agregarBTN, BorderLayout.SOUTH);

        agregarBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarVideoJuego();
            }
        });
    }

    private void agregarVideoJuego() {
        try {
            int idint = Integer.parseInt(idTexto.getText());
            String nombre = nombreTexto.getText();
            double precioDouble = Double.parseDouble(precioTexto.getText());
            int stockint = Integer.parseInt(stockTexto.getText());
            String descripcion = descripcionTexto.getText();
            String plataforma = plataformaTexto.getText();
            String genero = generoTexto.getText();
            String calificacionEdad = calificacionEdadTexto.getText();
            String fechaLanzamiento = fechaLanzamientotexto.getText();
            String claveActivacion = claveActivacionTexto.getText();
            String expiracionClave = expiracionClaveTexto.getText();


            VideoJuego nuevoVideoJuego = new VideoJuegoDigital(idint, nombre, precioDouble, stockint, descripcion, plataforma, genero, calificacionEdad, fechaLanzamiento, claveActivacion,expiracionClave );


            ControllerVideoJuego.agregarVideoJuego(nuevoVideoJuego);
            JOptionPane.showMessageDialog(this, "Videojuego agregado exitosamente: " , "Exito", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al agregar el videojuego: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


}


