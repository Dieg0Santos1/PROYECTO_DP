package vista;

import javax.swing.*;
import java.awt.*;
import controlador.ControladorNecesidad;

public class PlataformaODS10 extends JFrame {

    private JPanel panelM1, panelM2, panelM3;
    private CardLayout cardM1, cardM2, cardM3;
    private JTextField txtNombre, txtApellidos, txtDescripcion, txtRecursoDescripcion;
    private JComboBox<String> comboGrupo, comboTipoRecurso;

    private final Color verdeSuave = new Color(144, 190, 109);
    private final Color beigeClaro = new Color(255, 250, 240);
    private final Color verdeOscuro = new Color(90, 135, 100);

    public PlataformaODS10() {
        setTitle("Plataforma ODS 10 - Reducción de Desigualdades Sociales");
        setSize(850, 550);
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
        JPanel p = crearPanelFormulario();
        GridBagConstraints gbc = crearGbc();

        txtNombre = new JTextField(20);
        txtApellidos = new JTextField(20);

        JLabel lbl1 = estilizarLabel(new JLabel("Nombre:"));
        JLabel lbl2 = estilizarLabel(new JLabel("Apellidos:"));

        JButton btn = crearBoton("Siguiente ▶", e -> cardM1.show(panelM1, "2"));

        gbc.gridx = 0; gbc.gridy = 0; p.add(lbl1, gbc);
        gbc.gridx = 1; p.add(txtNombre, gbc);
        gbc.gridx = 0; gbc.gridy = 1; p.add(lbl2, gbc);
        gbc.gridx = 1; p.add(txtApellidos, gbc);
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2; p.add(btn, gbc);

        return p;
    }

    private JPanel m1_sub2() {
        JPanel p = crearPanelFormulario();
        GridBagConstraints gbc = crearGbc();

        comboGrupo = new JComboBox<>(new String[]{"Niño", "Adulto Mayor", "Discapacidad"});
        txtDescripcion = new JTextField(20);

        JLabel lbl1 = estilizarLabel(new JLabel("Grupo Vulnerable:"));
        JLabel lbl2 = estilizarLabel(new JLabel("Descripción:"));

        JButton btn = crearBoton("Siguiente ▶", e -> cardM1.show(panelM1, "3"));

        gbc.gridx = 0; gbc.gridy = 0; p.add(lbl1, gbc);
        gbc.gridx = 1; p.add(comboGrupo, gbc);
        gbc.gridx = 0; gbc.gridy = 1; p.add(lbl2, gbc);
        gbc.gridx = 1; p.add(txtDescripcion, gbc);
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2; p.add(btn, gbc);

        return p;
    }

    private JPanel m1_sub3() {
        JPanel p = new JPanel(new BorderLayout(10, 10));
        p.setBackground(beigeClaro);
        JLabel lbl = new JLabel("Presiona Finalizar para guardar en la base de datos.");
        lbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lbl.setHorizontalAlignment(SwingConstants.CENTER);

        JButton btnFinalizar = crearBoton("Finalizar ✅", e -> {
            String nombre = txtNombre.getText();
            String apellidos = txtApellidos.getText();
            String grupo = (String) comboGrupo.getSelectedItem();
            String descripcion = txtDescripcion.getText();
            new ControladorNecesidad().registrar(nombre, apellidos, grupo, descripcion);
            JOptionPane.showMessageDialog(this, "Registro guardado correctamente.");
            txtNombre.setText(""); txtApellidos.setText(""); txtDescripcion.setText("");
            cardM1.show(panelM1, "1");
        });

        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        p.add(lbl, BorderLayout.CENTER);
        p.add(btnFinalizar, BorderLayout.SOUTH);
        return p;
    }

    private JPanel m2_sub1() {
        JPanel p = crearPanelFormulario();
        GridBagConstraints gbc = crearGbc();

        JLabel label = estilizarLabel(new JLabel("Tipo de ayuda:"));
        comboTipoRecurso = new JComboBox<>(new String[]{"Donación", "Voluntariado"});

        JButton btn = crearBoton("Siguiente ▶", e -> cardM2.show(panelM2, "2"));

        gbc.gridx = 0; gbc.gridy = 0; p.add(label, gbc);
        gbc.gridx = 1; p.add(comboTipoRecurso, gbc);
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2; p.add(btn, gbc);

        return p;
    }

    private JPanel m2_sub2() {
        JPanel p = crearPanelFormulario();
        GridBagConstraints gbc = crearGbc();

        JLabel label = estilizarLabel(new JLabel("Descripción del recurso:"));
        txtRecursoDescripcion = new JTextField(20);

        JButton btn = crearBoton("Siguiente ▶", e -> cardM2.show(panelM2, "3"));

        gbc.gridx = 0; gbc.gridy = 0; p.add(label, gbc);
        gbc.gridx = 1; p.add(txtRecursoDescripcion, gbc);
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2; p.add(btn, gbc);

        return p;
    }

    private JPanel m2_sub3() {
        JPanel p = new JPanel(new BorderLayout(10, 10));
        p.setBackground(beigeClaro);
        JLabel lbl = new JLabel("Presiona Guardar para registrar el recurso.");
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        lbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JButton btn = crearBoton("Guardar recurso", e -> {
            String tipo = (String) comboTipoRecurso.getSelectedItem();
            String detalle = txtRecursoDescripcion.getText();
            JOptionPane.showMessageDialog(this,
                    "Tipo: " + tipo + "\nDescripción: " + detalle,
                    "Recurso registrado", JOptionPane.INFORMATION_MESSAGE);
            cardM2.show(panelM2, "1");
            txtRecursoDescripcion.setText("");
        });

        p.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        p.add(lbl, BorderLayout.CENTER);
        p.add(btn, BorderLayout.SOUTH);
        return p;
    }

    private JPanel m3_sub1() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(beigeClaro);
        JTextArea historial = new JTextArea("Historial:\n- Carlos solicitó silla de ruedas\n- Ana ofreció voluntariado");
        historial.setEditable(false);
        historial.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        p.add(new JScrollPane(historial), BorderLayout.CENTER);
        p.add(crearBoton("Siguiente ▶", e -> cardM3.show(panelM3, "2")), BorderLayout.SOUTH);
        return p;
    }

    private JPanel m3_sub2() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(beigeClaro);
        JLabel lbl = new JLabel("Impacto simulado: 8 recursos entregados, 3 voluntarios activos.");
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        p.add(lbl, BorderLayout.CENTER);
        p.add(crearBoton("Siguiente ▶", e -> cardM3.show(panelM3, "3")), BorderLayout.SOUTH);
        return p;
    }

    private JPanel m3_sub3() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(beigeClaro);
        JLabel lbl = new JLabel("¿Deseas exportar el reporte?");
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        JButton exportar = crearBoton("Exportar", e -> JOptionPane.showMessageDialog(this, "Reporte exportado correctamente (simulado)."));
        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        p.add(lbl, BorderLayout.CENTER);
        p.add(exportar, BorderLayout.SOUTH);
        return p;
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
        return p;
    }

    private GridBagConstraints crearGbc() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 10, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        return gbc;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PlataformaODS10::new);
    }
}
