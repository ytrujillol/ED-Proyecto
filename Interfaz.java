import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz extends JFrame {
    // Declaración de los 4 botones
    String[] materias = {"Seleccione una Materia","Física", "Matemáticas", "Programacion", "Electronica"};
    String[] prioridades = {"Baja", "Media", "Alta"};
    JComboBox<String> materiaComboBox = new JComboBox<>(materias);
    JComboBox<String> prioridadComboBox = new JComboBox<>(prioridades);
    JPanel panel = new JPanel();

    private JButton boton1, boton2, boton3, boton4,inicio,siguiente;
    int control=0;
    private JLabel titulo, texto,asignatura,prioridad,observacion;
    JTextField observaciones;
    public Interfaz() {
        // 1. Configuración básica de la ventana (JFrame)
        panel.add(materiaComboBox);
        panel.add(prioridadComboBox);

        setTitle("Manejo de tutorias");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
        setSize(650, 500); // Establece el tamaño de la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        getContentPane().setBackground(Color.WHITE);
        // 2. Usar un Gestor de Diseño (Layout Manager)
        // FlowLayout organiza los componentes en una fila de izquierda a derecha.
        setLayout(null);
        //inicializacion de todos los elentos
        //inicio
        titulo = new JLabel("Bienvenido, Estudiante");
        texto = new JLabel("Gestión de tutorías universitarias. Selecciona una opción:");
        //agregar
        asignatura = new JLabel("Asignatura:");
        prioridad = new JLabel("Prioridad:");
        observacion = new JLabel("Observaciones:");
        siguiente = new JButton("Siguiente");
        observaciones = new JTextField();
        //Inicialización de los botones
        boton1 = new JButton("Programar una tutoria");
        boton2 = new JButton("Ver historial de tutorias");
        boton3 = new JButton("Ver tutorias programadas");
        boton4 = new JButton("Cancelar tutorias");
        inicio = new JButton("Inicio");
        //Sector Diseño
        //boton SIGUIENTE
        siguiente.setBackground(Color.BLUE);
        siguiente.setForeground(Color.WHITE);
        siguiente.setBounds(75,358,500,60);
        //Label TITULO
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        titulo.setBounds(75, 75, 500, 60);
        titulo.setForeground(Color.BLUE);
        //Label TEXTO del inicio
        texto.setFont(new Font("Arial",Font.PLAIN, 15));
        texto.setBounds(75, 130, 500, 30);
        //Labels ASIGNATURA, PRIORIDAD Y OBSERVACION del menu de agregar tutoria
        asignatura.setBounds(75,93,500,30);
        asignatura.setFont(new Font("Arial", Font.BOLD, 15));
        prioridad.setBounds(75,173,500,30);
        prioridad.setFont(new Font("Arial", Font.BOLD, 15));
        observacion.setBounds(75,258,500,30);
        observacion.setFont(new Font("Arial", Font.BOLD, 15));
        //MATERIA Y PRIORIDAD (Desplegables)
        materiaComboBox.setBounds(75,123,500,50);
        prioridadComboBox.setBounds(75,208,500,50);
        //campo de texto observaciones
        observaciones.setBounds(75,288,500,60);
        //formatos
        Color colorBorde = Color.BLUE;
        Border borde = new LineBorder(colorBorde, 1);
        Color colorsBorde = Color.WHITE;
        Border sborde = new LineBorder(colorsBorde, 1);
        //botones, boton1, 2, 3, 4 son los botones en la pestaña de inicio
        boton1.setBounds(75,163,500,50);
        boton2.setBounds(75,233,500,50);
        boton3.setBounds(75,303,500,50);
        boton4.setBounds(75,373,500,50);
        boton1.setBackground(Color.BLUE);
        boton1.setForeground(Color.WHITE);
        boton2.setBorder(borde);
        boton3.setBorder(borde);
        boton4.setBorder(borde);

        //Boton regresar al INICIO
        inicio.setBounds(75,20,100,40);
        inicio.setBackground(Color.WHITE);
        inicio.setForeground(Color.BLUE);
        inicio.setBorder(sborde);

        //Elementos que no pertenecen al apartado de inicio
        materiaComboBox.setVisible(false);
        asignatura.setVisible(false);
        prioridadComboBox.setVisible(false);
        prioridad.setVisible(false);
        observacion.setVisible(false);
        observaciones.setVisible(false);
        siguiente.setVisible(false);
        //Listener de cada boton
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //
                control=1;
                boton1.setVisible(false);
                boton2.setVisible(false);
                boton3.setVisible(false);
                boton4.setVisible(false);
                titulo.setVisible(false);
                texto.setVisible(false);
                materiaComboBox.setVisible(true);
                asignatura.setVisible(true);
                prioridadComboBox.setVisible(true);
                prioridad.setVisible(true);
                observacion.setVisible(true);
                observaciones.setVisible(true);
                siguiente.setVisible(true);
            }
        });
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //listar pasadas
                control=2;
                boton1.setVisible(false);
                boton2.setVisible(false);
                boton3.setVisible(false);
                boton4.setVisible(false);
                titulo.setVisible(false);
                texto.setVisible(false);
            }
        });
        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Listar programadas
                control=3;
                boton1.setVisible(false);
                boton2.setVisible(false);
                boton3.setVisible(false);
                boton4.setVisible(false);
                titulo.setVisible(false);
                texto.setVisible(false);
            }
        });
        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Listar programadas
                control=4;
                boton1.setVisible(false);
                boton2.setVisible(false);
                boton3.setVisible(false);
                boton4.setVisible(false);
                titulo.setVisible(false);
                texto.setVisible(false);
            }
        });
        inicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Volver al menu de inicio
                control=0;
                boton1.setVisible(true);
                boton2.setVisible(true);
                boton3.setVisible(true);
                boton4.setVisible(true);
                titulo.setVisible(true);
                texto.setVisible(true);
                materiaComboBox.setVisible(false);
                asignatura.setVisible(false);
                prioridadComboBox.setVisible(false);
                prioridad.setVisible(false);
                observacion.setVisible(false);
                observaciones.setVisible(false);
                siguiente.setVisible(false);
            }
        });
        siguiente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                control=10;
                //DEBE LISTAR LOS DISPONIBLES
                materiaComboBox.setVisible(false);
                asignatura.setVisible(false);
                prioridadComboBox.setVisible(false);
                prioridad.setVisible(false);
                observacion.setVisible(false);
                observaciones.setVisible(false);
                siguiente.setVisible(false);

            }
        });
        // Agregar cada elemento a la ventana
        add(boton1);
        add(boton2);
        add(boton3);
        add(boton4);
        add(titulo);
        add(texto);
        add(inicio);
        add(panel);
        add(materiaComboBox);
        add(asignatura);
        add(prioridadComboBox);
        add(prioridad);
        add(observacion);
        add(observaciones);
        add(siguiente);
    }
}