package vista;

import javax.swing.*;
import java.awt.*;
import controlador.ControladorNecesidad;

public class PlataformaODS10 extends JFrame {

    private JPanel panelM1, panelM2, panelM3;
    private CardLayout cardM1, cardM2, cardM3;
    private JTextField txtNombre, txtApellidos, txtDescripcion, txtRecursoDescripcion;
    private JTextField txtTelefono, txtDireccion, txtNombreAyudante, txtTelefonoAyudante;
    private JTextField txtDireccionEntrega, txtCantidadRecursos;
    private JComboBox<String> comboGrupo, comboTipoRecurso;
    private JLabel lblResumen1; // Resumen para Registro de Usuario
    private JLabel lblResumen2; // Resumen para Recursos y Ayudas

    private final Color verdeSuave = new Color(144, 190, 109);
    private final Color beigeClaro = new Color(255, 250, 240);
    private final Color verdeOscuro = new Color(90, 135, 100);

    public PlataformaODS10() {
        setTitle("Plataforma ODS 10 - Reducción de Desigualdades Sociales");
        setSize(900, 600); // Aumenté un poco el tamaño para acomodar los nuevos campos
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setBackground(beigeClaro);
        UIManager.put("TabbedPane.contentAreaColor", beigeClaro);

        JTabbedPane tabs = new JTabbedPane();
        tabs.setFont(new Font("Segoe UI", Font.BOLD, 14));

        cardM1 = new CardLayout();
        panelM1 = new JPanel(cardM1);
        panelM1.setBackground(beigeClaro);
        panelM1.add(m1_sub1(), "1");
        panelM1.add(m1_sub2(), "2");
        panelM1.add(m1_sub3(), "3");
        tabs.add("Registro de Usuario", panelM1);

        cardM2 = new CardLayout();
        panelM2 = new JPanel(cardM2);
        panelM2.setBackground(beigeClaro);
        panelM2.add(m2_sub1(), "1");
        panelM2.add(m2_sub2(), "2");
        panelM2.add(m2_sub3(), "3");
        tabs.add("Recursos y Ayudas", panelM2);

        cardM3 = new CardLayout();
        panelM3 = new JPanel(cardM3);
        panelM3.setBackground(beigeClaro);
        panelM3.add(m3_sub1(), "1");
        panelM3.add(m3_sub2(), "2");
        panelM3.add(m3_sub3(), "3");
        tabs.add("Seguimiento de Impacto", panelM3);
        
        add(tabs);
        setVisible(true);
    }

    private JPanel m1_sub1() {
        JPanel contenido = crearPanelFormulario();
        GridBagConstraints gbc = crearGbc();

        txtNombre = new JTextField(20);
        txtApellidos = new JTextField(20);
        txtTelefono = new JTextField(20);
        txtDireccion = new JTextField(20);

        JLabel lbl1 = estilizarLabel(new JLabel("Nombre:"));
        JLabel lbl2 = estilizarLabel(new JLabel("Apellidos:"));
        JLabel lbl3 = estilizarLabel(new JLabel("Teléfono:"));
        JLabel lbl4 = estilizarLabel(new JLabel("Dirección:"));

        gbc.gridx = 0; gbc.gridy = 0; contenido.add(lbl1, gbc);
        gbc.gridx = 1; contenido.add(txtNombre, gbc);
        gbc.gridx = 0; gbc.gridy = 1; contenido.add(lbl2, gbc);
        gbc.gridx = 1; contenido.add(txtApellidos, gbc);
        gbc.gridx = 0; gbc.gridy = 2; contenido.add(lbl3, gbc);
        gbc.gridx = 1; contenido.add(txtTelefono, gbc);
        gbc.gridx = 0; gbc.gridy = 3; contenido.add(lbl4, gbc);
        gbc.gridx = 1; contenido.add(txtDireccion, gbc);

        return crearPanelConNavegacion(contenido, "Siguiente >>>", () -> cardM1.show(panelM1, "2"), false);
    }

    private void actualizarResumenUsuario() {
    String resumen = "<html><center><h2>Revisa la información antes de guardar:</h2>" +
            "<table border='0' cellpadding='5'>" +
            "<tr><td align='right'><b>Nombre:</b></td><td>" + txtNombre.getText() + "</td></tr>" +
            "<tr><td align='right'><b>Apellidos:</b></td><td>" + txtApellidos.getText() + "</td></tr>" +
            "<tr><td align='right'><b>Teléfono:</b></td><td>" + txtTelefono.getText() + "</td></tr>" +
            "<tr><td align='right'><b>Dirección:</b></td><td>" + txtDireccion.getText() + "</td></tr>" +
            "<tr><td align='right'><b>Grupo:</b></td><td>" + comboGrupo.getSelectedItem() + "</td></tr>" +
            "<tr><td align='right'><b>Descripción:</b></td><td>" + txtDescripcion.getText() + "</td></tr>" +
            "</table></center></html>";

    lblResumen1.setText(resumen);
    }
    private JPanel m1_sub2() {
        JPanel contenido = crearPanelFormulario();
        GridBagConstraints gbc = crearGbc();

        comboGrupo = new JComboBox<>(new String[]{"Niño", "Adulto Mayor", "Discapacidad"});
        txtDescripcion = new JTextField(20);

        JLabel lbl1 = estilizarLabel(new JLabel("Grupo Vulnerable:"));
        JLabel lbl2 = estilizarLabel(new JLabel("Descripción de necesidades:"));

        gbc.gridx = 0; gbc.gridy = 0; contenido.add(lbl1, gbc);
        gbc.gridx = 1; contenido.add(comboGrupo, gbc);
        gbc.gridx = 0; gbc.gridy = 1; contenido.add(lbl2, gbc);
        gbc.gridx = 1; contenido.add(txtDescripcion, gbc);

        return crearPanelConNavegacion(contenido, "Siguiente >>>", () -> {
        actualizarResumenUsuario();
        cardM1.show(panelM1, "3");
        }, true, () -> cardM1.show(panelM1, "1"));
    }

    private void limpiarCamposRegistro() {
    txtNombre.setText("");
    txtApellidos.setText("");
    txtTelefono.setText("");
    txtDireccion.setText("");
    txtDescripcion.setText("");
    comboGrupo.setSelectedIndex(0);
    }
    private JPanel m1_sub3() {
    JPanel contenido = new JPanel(new BorderLayout(10, 10));
    contenido.setBackground(beigeClaro);

    lblResumen1 = new JLabel(); // Contenido dinámico
    lblResumen1.setFont(new Font("Segoe UI", Font.PLAIN, 14));

    JButton btnFinalizar = crearBoton("Finalizar", e -> {
    // Mostrar mensaje como si se hubiera guardado
    JOptionPane.showMessageDialog(null, "Usuario guardado correctamente");

    // Limpiar los campos y volver al panel anterior
    limpiarCamposRegistro();
    cardM1.show(panelM1, "1");
    });

    contenido.add(lblResumen1, BorderLayout.CENTER);
    contenido.add(btnFinalizar, BorderLayout.SOUTH);

    return crearPanelConNavegacion(contenido, null, null, true, () -> cardM1.show(panelM1, "2"));
}

    private JPanel m2_sub1() {
        JPanel contenido = crearPanelFormulario();
        GridBagConstraints gbc = crearGbc();

        JLabel label = estilizarLabel(new JLabel("Tipo de ayuda:"));
        comboTipoRecurso = new JComboBox<>(new String[]{"Donación", "Voluntariado"});

        gbc.gridx = 0; gbc.gridy = 0; contenido.add(label, gbc);
        gbc.gridx = 1; contenido.add(comboTipoRecurso, gbc);

        return crearPanelConNavegacion(contenido, "Siguiente >>>", () -> cardM2.show(panelM2, "2"), false);
    }

    private void actualizarResumenRecurso() {
    String resumen = "<html><center><h3>Resumen del recurso:</h3>" +
            "<b>Tipo:</b> " + comboTipoRecurso.getSelectedItem() + "<br>" +
            "<b>Ayudante:</b> " + txtNombreAyudante.getText() + "<br>" +
            "<b>Teléfono:</b> " + txtTelefonoAyudante.getText() + "<br>" +
            "<b>Dirección entrega:</b> " + txtDireccionEntrega.getText() + "<br>" +
            "<b>Descripción:</b> " + txtRecursoDescripcion.getText() + "<br>" +
            "<b>Cantidad:</b> " + txtCantidadRecursos.getText() + "</center></html>";

    lblResumen2.setText(resumen);
    }
    private JPanel m2_sub2() {
        JPanel contenido = crearPanelFormulario();
        GridBagConstraints gbc = crearGbc();

        txtNombreAyudante = new JTextField(20);
        txtTelefonoAyudante = new JTextField(20);
        txtDireccionEntrega = new JTextField(20);
        txtRecursoDescripcion = new JTextField(20);
        txtCantidadRecursos = new JTextField(20);

        JLabel lbl1 = estilizarLabel(new JLabel("Nombre del ayudante:"));
        JLabel lbl2 = estilizarLabel(new JLabel("Teléfono del ayudante:"));
        JLabel lbl3 = estilizarLabel(new JLabel("Dirección de entrega:"));
        JLabel lbl4 = estilizarLabel(new JLabel("Descripción del recurso:"));
        JLabel lbl5 = estilizarLabel(new JLabel("Cantidad de recursos:"));

        gbc.gridx = 0; gbc.gridy = 0; contenido.add(lbl1, gbc);
        gbc.gridx = 1; contenido.add(txtNombreAyudante, gbc);
        gbc.gridx = 0; gbc.gridy = 1; contenido.add(lbl2, gbc);
        gbc.gridx = 1; contenido.add(txtTelefonoAyudante, gbc);
        gbc.gridx = 0; gbc.gridy = 2; contenido.add(lbl3, gbc);
        gbc.gridx = 1; contenido.add(txtDireccionEntrega, gbc);
        gbc.gridx = 0; gbc.gridy = 3; contenido.add(lbl4, gbc);
        gbc.gridx = 1; contenido.add(txtRecursoDescripcion, gbc);
        gbc.gridx = 0; gbc.gridy = 4; contenido.add(lbl5, gbc);
        gbc.gridx = 1; contenido.add(txtCantidadRecursos, gbc);

        return crearPanelConNavegacion(contenido, "Siguiente >>>", () -> {
        actualizarResumenRecurso();
        cardM2.show(panelM2, "3");
        }, true, () -> cardM2.show(panelM2, "1"));
    }

    private JPanel m2_sub3() {
    JPanel contenido = new JPanel(new BorderLayout(10, 10));
    contenido.setBackground(beigeClaro);

    lblResumen2 = new JLabel(); // Contenido dinámico
    lblResumen2.setHorizontalAlignment(SwingConstants.CENTER);
    lblResumen2.setFont(new Font("Segoe UI", Font.PLAIN, 14));

    JButton btn = crearBoton("Guardar recurso", e -> {
        // Aquí iría la lógica para guardar en la base de datos
        JOptionPane.showMessageDialog(this,
                "Recurso registrado exitosamente",
                "Éxito", JOptionPane.INFORMATION_MESSAGE);

        // Limpiar campos
        cardM2.show(panelM2, "1");
        txtNombreAyudante.setText("");
        txtTelefonoAyudante.setText("");
        txtDireccionEntrega.setText("");
        txtRecursoDescripcion.setText("");
        txtCantidadRecursos.setText("");
    });

    contenido.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
    contenido.add(lblResumen2, BorderLayout.CENTER);
    contenido.add(btn, BorderLayout.SOUTH);

    return crearPanelConNavegacion(contenido, null, null,
            true, () -> cardM2.show(panelM2, "2"));
    }

    private JPanel m3_sub1() {
        JPanel contenido = new JPanel(new BorderLayout());
        contenido.setBackground(beigeClaro);
        JTextArea historial = new JTextArea("Historial:\n- Carlos solicitó silla de ruedas\n- Ana ofreció voluntariado");
        historial.setEditable(false);
        historial.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        contenido.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contenido.add(new JScrollPane(historial), BorderLayout.CENTER);

        return crearPanelConNavegacion(contenido, "Siguiente >>>", () -> cardM3.show(panelM3, "2"), false);
    }

    private JPanel m3_sub2() {
        JPanel contenido = new JPanel(new BorderLayout());
        contenido.setBackground(beigeClaro);
        JLabel lbl = new JLabel("Impacto: 8 recursos entregados, 3 voluntarios activos.");
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        contenido.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contenido.add(lbl, BorderLayout.CENTER);

        return crearPanelConNavegacion(contenido, "Siguiente >>>", () -> cardM3.show(panelM3, "3"), 
                true, () -> cardM3.show(panelM3, "1"));
    }

    private JPanel m3_sub3() {
        JPanel contenido = new JPanel(new BorderLayout());
        contenido.setBackground(beigeClaro);
        JLabel lbl = new JLabel("¿Deseas exportar el reporte?");
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        JButton exportar = crearBoton("Exportar", e -> JOptionPane.showMessageDialog(this, "Reporte exportado correctamente."));
        contenido.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contenido.add(lbl, BorderLayout.CENTER);
        contenido.add(exportar, BorderLayout.SOUTH);

        return crearPanelConNavegacion(contenido, null, null, 
                true, () -> cardM3.show(panelM3, "2"));
    }


    private JPanel crearPanelConNavegacion(JPanel contenido, String textoBotonSiguiente, 
                                         Runnable accionSiguiente, boolean mostrarAtras) {
        return crearPanelConNavegacion(contenido, textoBotonSiguiente, accionSiguiente, mostrarAtras, null);
    }

    private JPanel crearPanelConNavegacion(JPanel contenido, String textoBotonSiguiente, 
                                         Runnable accionSiguiente, boolean mostrarAtras,
                                         Runnable accionAtras) {
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(beigeClaro);
        panelPrincipal.add(contenido, BorderLayout.CENTER);
        
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelBotones.setBackground(beigeClaro);
        
        if (mostrarAtras) {
            JButton btnAtras = crearBoton("<<< Atrás", e -> {
                if (accionAtras != null) {
                    accionAtras.run();
                }
            });
            panelBotones.add(btnAtras);
        }
        
        if (textoBotonSiguiente != null) {
            JButton btnSiguiente = crearBoton(textoBotonSiguiente, e -> {
                if (accionSiguiente != null) {
                    accionSiguiente.run();
                }
            });
            panelBotones.add(btnSiguiente);
        }
        
        if (panelBotones.getComponentCount() > 0) {
            panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
        }
        
        return panelPrincipal;
    }

    private JButton crearBoton(String texto, java.awt.event.ActionListener evento) {
        JButton boton = new JButton(texto);
        boton.setFocusPainted(false);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        boton.setBackground(verdeSuave);
        boton.setForeground(Color.WHITE);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setBorder(BorderFactory.createLineBorder(verdeOscuro));
        boton.addActionListener(evento);
        return boton;
    }

    private JLabel estilizarLabel(JLabel label) {
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        label.setForeground(new Color(50, 50, 50));
        return label;
    }

    private JPanel crearPanelFormulario() {
        JPanel p = new JPanel(new GridBagLayout());
        p.setBackground(beigeClaro);
        p.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return p;
    }

    private GridBagConstraints crearGbc() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 15, 8, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        return gbc;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(PlataformaODS10::new);
    }
}

