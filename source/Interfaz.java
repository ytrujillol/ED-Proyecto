import data_structures.HashMap;
import data_structures.ListaEnlazada;
import modules.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Interfaz extends JFrame {

    private final GestorTutorias gestor;
    private final String idEstudiante;
    private final HashMap<String, ListaEnlazada<Tutoria>> tutoriasEstudiante;
    private final HashMap<String, Tutor[]> tutoresPorAsignatura;

    String[] materias = {
            "Seleccione una Materia",
            "Cálculo Diferencial", "Álgebra Lineal", "Programación Básica",
            "Programación Avanzada", "Física I", "Física II"
    };
    String[] prioridades = {"Baja", "Media", "Alta"};

    JComboBox<String> materiaComboBox = new JComboBox<>(materias);
    JComboBox<String> prioridadComboBox = new JComboBox<>(prioridades);

    JPanel panel = new JPanel();

    private JButton boton1, boton2, boton3, boton4, inicio, siguiente;

    int control = 0;

    private JLabel titulo, texto, asignatura, prioridad, observacion;

    JTextField observaciones;

    private JLabel tituloHistorial;
    private JTextArea areaHistorial;
    private JScrollPane scrollHistorial;

    private JLabel tituloProgramadas;
    private JTextArea areaProgramadas;
    private JScrollPane scrollProgramadas;

    private JLabel tituloCancelar;
    private JLabel textoCancelar;
    private JList<String> listaCancelar;
    private DefaultListModel<String> modeloCancelar;
    private JScrollPane scrollCancelar;
    private JButton btnCancelarSeleccionada;
    private final List<Tutoria> tutoriasParaCancelar = new ArrayList<>();

    public Interfaz(GestorTutorias gestor,
                    String idEstudiante,
                    HashMap<String, ListaEnlazada<Tutoria>> tutoriasEstudiante,
                    HashMap<String, Tutor[]> tutoresPorAsignatura) {

        this.gestor = gestor;
        this.idEstudiante = idEstudiante;
        this.tutoriasEstudiante = tutoriasEstudiante;
        this.tutoresPorAsignatura = tutoresPorAsignatura;

        initUI();
    }

    private void initUI() {
        setTitle("Manejo de tutorías");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 500);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(0xF6F8FA));
        setLayout(null);

        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 650, 500); // similar a max-width: 570px y margin
        panel.setBorder(new LineBorder(new Color(0xE5E7EB), 1, true));
        add(panel);


        // Labels de inicio
        titulo = new JLabel("Bienvenido, Estudiante");
        texto = new JLabel("Gestión de tutorías universitarias. Selecciona una opción:");

        // Labels del formulario
        asignatura = new JLabel("Asignatura:");
        prioridad = new JLabel("Prioridad:");
        observacion = new JLabel("Observaciones:");
        siguiente = new JButton("Siguiente");
        observaciones = new JTextField();

        // Botones principales
        boton1 = new JButton("Programar una tutoría");
        boton2 = new JButton("Ver historial de tutorías");
        boton3 = new JButton("Ver tutorías programadas");
        boton4 = new JButton("Cancelar tutorías");
        inicio = new JButton("Inicio");

        // Botón SIGUIENTE (azul)
        siguiente.setBackground(new Color(0x2563EB));
        siguiente.setForeground(Color.WHITE);
        siguiente.setBounds(75, 330, 500, 50);

        // Label TITULO
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBounds(75, 50, 500, 40);
        titulo.setForeground(new Color(0x2563EB));

        // Label TEXTO del inicio
        texto.setFont(new Font("Arial", Font.PLAIN, 14));
        texto.setBounds(75, 90, 500, 30);

        // Labels de formulario
        asignatura.setBounds(75, 110, 500, 30);
        asignatura.setFont(new Font("Arial", Font.BOLD, 15));

        prioridad.setBounds(75, 180, 500, 30);
        prioridad.setFont(new Font("Arial", Font.BOLD, 15));

        observacion.setBounds(75, 250, 500, 30);
        observacion.setFont(new Font("Arial", Font.BOLD, 15));

        // Combos
        materiaComboBox.setBounds(75, 140, 500, 35);
        prioridadComboBox.setBounds(75, 210, 500, 35);

        // Observaciones
        observaciones.setBounds(75, 280, 500, 35);

        // Bordes
        Color colorBorde = new Color(0x2563EB);
        Border borde = new LineBorder(colorBorde, 1);
        Color colorsBorde = Color.WHITE;
        Border sborde = new LineBorder(colorsBorde, 1);

        // Botones de inicio
        boton1.setBounds(75, 140, 500, 40);
        boton2.setBounds(75, 190, 500, 40);
        boton3.setBounds(75, 240, 500, 40);
        boton4.setBounds(75, 290, 500, 40);

        boton1.setBackground(new Color(0x2563EB));
        boton1.setForeground(Color.WHITE);

        boton2.setBorder(borde);
        boton3.setBorder(borde);
        boton4.setBorder(borde);

        // Botón regresar al INICIO
        inicio.setBounds(75, 10, 100, 30);
        inicio.setBackground(Color.WHITE);
        inicio.setForeground(new Color(0x2563EB));
        inicio.setBorder(sborde);

        // ========= HISTORIAL =========
        tituloHistorial = new JLabel("Historial de tutorías");
        tituloHistorial.setFont(new Font("Arial", Font.BOLD, 18));
        tituloHistorial.setForeground(new Color(0x2563EB));
        tituloHistorial.setBounds(75, 60, 500, 30);

        areaHistorial = new JTextArea();
        areaHistorial.setEditable(false);
        areaHistorial.setLineWrap(true);
        areaHistorial.setWrapStyleWord(true);
        scrollHistorial = new JScrollPane(areaHistorial);
        scrollHistorial.setBounds(75, 100, 500, 250);

        // ========= PROGRAMADAS =========
        tituloProgramadas = new JLabel("Tutorías programadas");
        tituloProgramadas.setFont(new Font("Arial", Font.BOLD, 18));
        tituloProgramadas.setForeground(new Color(0x2563EB));
        tituloProgramadas.setBounds(75, 60, 500, 30);

        areaProgramadas = new JTextArea();
        areaProgramadas.setEditable(false);
        areaProgramadas.setLineWrap(true);
        areaProgramadas.setWrapStyleWord(true);
        scrollProgramadas = new JScrollPane(areaProgramadas);
        scrollProgramadas.setBounds(75, 100, 500, 250);

        // ========= CANCELAR =========
        tituloCancelar = new JLabel("Cancelar tutoría");
        tituloCancelar.setFont(new Font("Arial", Font.BOLD, 18));
        tituloCancelar.setForeground(new Color(0x2563EB));
        tituloCancelar.setBounds(75, 60, 500, 30);

        textoCancelar = new JLabel("Seleccione una tutoría programada para cancelar:");
        textoCancelar.setFont(new Font("Arial", Font.PLAIN, 13));
        textoCancelar.setBounds(75, 90, 500, 20);

        modeloCancelar = new DefaultListModel<>();
        listaCancelar = new JList<>(modeloCancelar);
        scrollCancelar = new JScrollPane(listaCancelar);
        scrollCancelar.setBounds(75, 115, 500, 185);

        btnCancelarSeleccionada = new JButton("Cancelar tutoría seleccionada");
        btnCancelarSeleccionada.setBounds(75, 310, 500, 40);
        btnCancelarSeleccionada.setBackground(new Color(0xE5E7EB));
        btnCancelarSeleccionada.setForeground(Color.DARK_GRAY);
        btnCancelarSeleccionada.setBorder(new LineBorder(new Color(0x2563EB), 1));

        // ========= VISIBILIDADES INICIALES =========
        // Formulario oculto
        materiaComboBox.setVisible(false);
        asignatura.setVisible(false);
        prioridadComboBox.setVisible(false);
        prioridad.setVisible(false);
        observacion.setVisible(false);
        observaciones.setVisible(false);
        siguiente.setVisible(false);

        // Historial / programadas / cancelar ocultos
        tituloHistorial.setVisible(false);
        scrollHistorial.setVisible(false);

        tituloProgramadas.setVisible(false);
        scrollProgramadas.setVisible(false);

        tituloCancelar.setVisible(false);
        textoCancelar.setVisible(false);
        scrollCancelar.setVisible(false);
        btnCancelarSeleccionada.setVisible(false);

        // Programar una tutoría
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control = 1;
                mostrarFormularioSolicitar();
            }
        });

        // Ver historial
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control = 2;
                mostrarHistorial();
            }
        });

        // Ver programadas
        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control = 3;
                mostrarProgramadas();
            }
        });

        // Cancelar tutorías
        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control = 4;
                mostrarCancelar();
            }
        });

        // Volver al Inicio
        inicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control = 0;
                mostrarInicio();
            }
        });

        // Siguiente = solicitar tutoría con GestorTutorias
        siguiente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                solicitarTutoriaDesdeFormulario();
            }
        });

        // Botón cancelar seleccionada
        btnCancelarSeleccionada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelarSeleccionada();
            }
        });

        panel.add(boton1);
        panel.add(boton2);
        panel.add(boton3);
        panel.add(boton4);
        panel.add(titulo);
        panel.add(texto);
        panel.add(inicio);

        // Formulario
        panel.add(materiaComboBox);
        panel.add(asignatura);
        panel.add(prioridadComboBox);
        panel.add(prioridad);
        panel.add(observacion);
        panel.add(observaciones);
        panel.add(siguiente);

        // Historial
        panel.add(tituloHistorial);
        panel.add(scrollHistorial);

        // Programadas
        panel.add(tituloProgramadas);
        panel.add(scrollProgramadas);

        // Cancelar
        panel.add(tituloCancelar);
        panel.add(textoCancelar);
        panel.add(scrollCancelar);
        panel.add(btnCancelarSeleccionada);
    }

    // ========= CAMBIO DE VISTAS =========

    private void ocultarInicio() {
        boton1.setVisible(false);
        boton2.setVisible(false);
        boton3.setVisible(false);
        boton4.setVisible(false);
        titulo.setVisible(false);
        texto.setVisible(false);
    }

    private void mostrarInicio() {
        // Mostrar inicio
        boton1.setVisible(true);
        boton2.setVisible(true);
        boton3.setVisible(true);
        boton4.setVisible(true);
        titulo.setVisible(true);
        texto.setVisible(true);

        // Ocultar formulario
        materiaComboBox.setVisible(false);
        asignatura.setVisible(false);
        prioridadComboBox.setVisible(false);
        prioridad.setVisible(false);
        observacion.setVisible(false);
        observaciones.setVisible(false);
        siguiente.setVisible(false);

        // Ocultar otras secciones
        tituloHistorial.setVisible(false);
        scrollHistorial.setVisible(false);

        tituloProgramadas.setVisible(false);
        scrollProgramadas.setVisible(false);

        tituloCancelar.setVisible(false);
        textoCancelar.setVisible(false);
        scrollCancelar.setVisible(false);
        btnCancelarSeleccionada.setVisible(false);
    }

    private void mostrarFormularioSolicitar() {
        ocultarInicio();

        materiaComboBox.setVisible(true);
        asignatura.setVisible(true);
        prioridadComboBox.setVisible(true);
        prioridad.setVisible(true);
        observacion.setVisible(true);
        observaciones.setVisible(true);
        siguiente.setVisible(true);

        // Ocultar otras secciones
        tituloHistorial.setVisible(false);
        scrollHistorial.setVisible(false);
        tituloProgramadas.setVisible(false);
        scrollProgramadas.setVisible(false);
        tituloCancelar.setVisible(false);
        textoCancelar.setVisible(false);
        scrollCancelar.setVisible(false);
        btnCancelarSeleccionada.setVisible(false);
    }

    private void mostrarHistorial() {
        ocultarInicio();

        ListaEnlazada<Tutoria> historial = gestor.verHistorial(idEstudiante);
        if (historial == null || historial.size() == 0) {
            areaHistorial.setText("No hay tutorías realizadas.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < historial.size(); i++) {
                Tutoria t = historial.get(i);
                sb.append(describirTutoriaLarga(t)).append("\n\n");
            }
            areaHistorial.setText(sb.toString());
        }

        tituloHistorial.setVisible(true);
        scrollHistorial.setVisible(true);

        materiaComboBox.setVisible(false);
        asignatura.setVisible(false);
        prioridadComboBox.setVisible(false);
        prioridad.setVisible(false);
        observacion.setVisible(false);
        observaciones.setVisible(false);
        siguiente.setVisible(false);

        tituloProgramadas.setVisible(false);
        scrollProgramadas.setVisible(false);
        tituloCancelar.setVisible(false);
        textoCancelar.setVisible(false);
        scrollCancelar.setVisible(false);
        btnCancelarSeleccionada.setVisible(false);
    }

    private void mostrarProgramadas() {
        ocultarInicio();

        ListaEnlazada<Tutoria> lista = tutoriasEstudiante.get(idEstudiante);
        if (lista == null || lista.size() == 0) {
            areaProgramadas.setText("No tienes tutorías programadas.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < lista.size(); i++) {
                Tutoria t = lista.get(i);
                sb.append(describirTutoriaLarga(t)).append("\n\n");
            }
            areaProgramadas.setText(sb.toString());
        }

        tituloProgramadas.setVisible(true);
        scrollProgramadas.setVisible(true);

        materiaComboBox.setVisible(false);
        asignatura.setVisible(false);
        prioridadComboBox.setVisible(false);
        prioridad.setVisible(false);
        observacion.setVisible(false);
        observaciones.setVisible(false);
        siguiente.setVisible(false);

        tituloHistorial.setVisible(false);
        scrollHistorial.setVisible(false);
        tituloCancelar.setVisible(false);
        textoCancelar.setVisible(false);
        scrollCancelar.setVisible(false);
        btnCancelarSeleccionada.setVisible(false);
    }

    private void mostrarCancelar() {
        ocultarInicio();

        modeloCancelar.clear();
        tutoriasParaCancelar.clear();

        ListaEnlazada<Tutoria> lista = tutoriasEstudiante.get(idEstudiante);
        if (lista == null || lista.size() == 0) {
            modeloCancelar.addElement("No hay tutorías para cancelar.");
        } else {
            for (int i = 0; i < lista.size(); i++) {
                Tutoria t = lista.get(i);
                modeloCancelar.addElement(describirTutoriaCorta(t));
                tutoriasParaCancelar.add(t);
            }
        }

        tituloCancelar.setVisible(true);
        textoCancelar.setVisible(true);
        scrollCancelar.setVisible(true);
        btnCancelarSeleccionada.setVisible(true);

        materiaComboBox.setVisible(false);
        asignatura.setVisible(false);
        prioridadComboBox.setVisible(false);
        prioridad.setVisible(false);
        observacion.setVisible(false);
        observaciones.setVisible(false);
        siguiente.setVisible(false);

        tituloHistorial.setVisible(false);
        scrollHistorial.setVisible(false);
        tituloProgramadas.setVisible(false);
        scrollProgramadas.setVisible(false);
    }

    private void solicitarTutoriaDesdeFormulario() {
        String asignaturaSel = (String) materiaComboBox.getSelectedItem();
        String prioridadTexto = (String) prioridadComboBox.getSelectedItem();

        if (asignaturaSel == null || asignaturaSel.startsWith("Seleccione")) {
            JOptionPane.showMessageDialog(this, "Selecciona una asignatura.");
            return;
        }

        int prioridadValor;
        switch (prioridadTexto) {
            case "Media" -> prioridadValor = 3;
            case "Alta" -> prioridadValor = 5;
            default -> prioridadValor = 1;
        }

        Tutor[] tutores = tutoresPorAsignatura.get(asignaturaSel);
        if (tutores == null || tutores.length == 0) {
            JOptionPane.showMessageDialog(this, "No hay tutores registrados para esa asignatura.");
            return;
        }

        String[] opcionesTutores = new String[tutores.length];
        for (int i = 0; i < tutores.length; i++) {
            opcionesTutores[i] = tutores[i].getNombre() + " (" + tutores[i].getDocumento() + ")";
        }

        String seleccion = (String) JOptionPane.showInputDialog(
                this,
                "Selecciona un tutor:",
                "Tutor disponible",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesTutores,
                opcionesTutores[0]
        );

        if (seleccion == null) return; // canceló

        int indiceTutor = 0;
        for (int i = 0; i < opcionesTutores.length; i++) {
            if (opcionesTutores[i].equals(seleccion)) {
                indiceTutor = i;
                break;
            }
        }

        Tutor tutorSeleccionado = tutores[indiceTutor];
        String horario = JOptionPane.showInputDialog(
                this,
                "Escribe el horario (ejemplo: 10:00 - 11:00):"
        );
        if (horario == null || horario.isBlank()) return;

        gestor.solicitarTutoria(
                tutorSeleccionado.getDocumento(),
                idEstudiante,
                asignaturaSel,
                horario,
                prioridadValor
        );

        JOptionPane.showMessageDialog(this, "Tutoría registrada correctamente.");
        mostrarProgramadas();
    }

    private void cancelarSeleccionada() {
        if (tutoriasParaCancelar.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay tutorías seleccionables.");
            return;
        }

        int index = listaCancelar.getSelectedIndex();
        if (index < 0 || index >= tutoriasParaCancelar.size()) {
            JOptionPane.showMessageDialog(this, "Selecciona una tutoría de la lista.");
            return;
        }

        Tutoria t = tutoriasParaCancelar.get(index);
        gestor.cancelarTutoria(t);
        JOptionPane.showMessageDialog(this, "Tutoría cancelada.");
        mostrarCancelar();
        mostrarProgramadas();
    }

    private String describirTutoriaLarga(Tutoria t) {
        String prioridadTexto;
        switch (t.getPrioridad()) {
            case 5 -> prioridadTexto = "Alta";
            case 3 -> prioridadTexto = "Media";
            default -> prioridadTexto = "Baja";
        }

        return "Asignatura: " + t.getAsignatura() + "\n"
                + "Fecha: " + t.getFecha() + "\n"
                + "Horario: " + t.getHorario() + "\n"
                + "Prioridad: " + prioridadTexto + "\n"
                + "Estado: " + t.getEstado();
    }

    private String describirTutoriaCorta(Tutoria t) {
        return t.getAsignatura() + " | " + t.getFecha() + " | " + t.getHorario();
    }
}