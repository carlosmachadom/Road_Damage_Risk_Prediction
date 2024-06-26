package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 * Panel de inicio que muestra el título y botones principales de la aplicación.
 */
@SuppressWarnings("serial")
public class Inicio extends JPanel {

	/**
	 * Boton de iniciopara diagnostico
	 */
    private JButton botonInicio;
    
    /**
     * Boton para la pantalla de información del proyecto
     */
    private JButton botonInformacion;

    /**
     * Constructor de la clase Inicio.
     * Configura el panel de inicio con un layout, dimensiones y componentes iniciales.
     */
    public Inicio() {
        setBorder(new EmptyBorder(0, 0, 0, 0)); // Establece un borde vacío para el panel
        setPreferredSize(new Dimension(1440, 960)); // Establece las dimensiones preferidas del panel
        setLayout(new BorderLayout()); // Utiliza BorderLayout como layout principal
        inicializarComponentes(); // Inicializa los componentes del panel de inicio
        setVisible(true); // Hace visible el panel
    }

    /**
     * Inicializa y configura los componentes del panel de inicio.
     * Inserta el título y los botones principales en el panel.
     */
    public void inicializarComponentes() {
        insertarTitulo(); // Inserta el título en la parte superior del panel
        insertarBotones(); // Inserta los botones en la parte central del panel
        insertarPieDePagina(); // Inserta el pie de página de la pantalla de inicio
    }

    /**
     * Inserta el título en la parte superior del panel.
     * El título incluye el nombre de la aplicación y una descripción adicional.
     */
    public void insertarTitulo() {
        JPanel textoInicio = new JPanel();
        textoInicio.setBackground(new Color(255, 255, 255, 0)); // Fondo transparente
        textoInicio.setLayout(new BoxLayout(textoInicio, BoxLayout.Y_AXIS)); // Layout vertical

        JLabel tituloH1 = new JLabel("Pavement Forecast");
        Color colorTitulo = new Color(252, 255, 218);
        Font fontTitulo = new Font("Arial", Font.BOLD, 64);
        Border margenTitulo = BorderFactory.createEmptyBorder(80, 40, 40, 40);
        tituloH1.setForeground(colorTitulo);
        tituloH1.setFont(fontTitulo);
        tituloH1.setBorder(margenTitulo);

        JLabel subTitulo = new JLabel("<html>Sistema difuso para  Predecir niveles de <br>daño en vías de <span color='#F2613F'>Bogotá D.C</span><html>");
        Color colorSubTitulo = new Color(252, 255, 218);
        Font fontSubTitulo = new Font("Arial", Font.BOLD, 32);
        Border margenSubTitulo = BorderFactory.createEmptyBorder(0, 40, 40, 40);
        subTitulo.setFont(fontSubTitulo);
        subTitulo.setBorder(margenSubTitulo);
        subTitulo.setForeground(colorSubTitulo);

        textoInicio.add(tituloH1);
        textoInicio.add(subTitulo);

        add(textoInicio, BorderLayout.NORTH); // Agrega el panel de texto en la parte superior
    }

    /**
     * Inserta los botones principales en la parte central del panel.
     * Los botones permiten iniciar el diagnóstico y acceder a información del proyecto.
     */
    public void insertarBotones() {
        JPanel contenedorBotones = new JPanel(new BorderLayout());
        contenedorBotones.setBackground(new Color(255, 255, 255, 0)); // Fondo transparente
        contenedorBotones.setBorder(new EmptyBorder(0, 40, 40, 40));

        JPanel seccionPrincipal = new JPanel();
        seccionPrincipal.setLayout(new BoxLayout(seccionPrincipal, BoxLayout.X_AXIS)); // Layout horizontal
        seccionPrincipal.setBackground(new Color(255, 255, 255, 0)); // Fondo transparente

        botonInicio = new JButton("Iniciar diagnóstico");
        botonInicio.setBackground(new Color(242, 97, 63));
        botonInicio.setFocusPainted(false);
        botonInicio.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonInicio.setBorder(new EmptyBorder(12, 16, 12, 16));
        botonInicio.setMargin(new Insets(10, 20, 10, 20));
        Font fontBotonInicio = new Font("Arial", Font.BOLD, 24);
        botonInicio.setFont(fontBotonInicio);
        botonInicio.setForeground(new Color(252, 255, 218));
        botonInicio.setActionCommand("inicia_diagnostico");

        botonInformacion = new JButton("Información de proyecto");
        botonInformacion.setBackground(new Color(252, 255, 218));
        botonInformacion.setFocusPainted(false);
        botonInformacion.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonInformacion.setBorder(new EmptyBorder(12, 16, 12, 16));
        botonInformacion.setMargin(new Insets(10, 20, 10, 20));
        Font fontBotonInformacion = new Font("Arial", Font.BOLD, 24);
        botonInformacion.setFont(fontBotonInformacion);
        botonInformacion.setForeground(new Color(72, 30, 20));
        botonInformacion.setActionCommand("Informacion_proyecto");

        seccionPrincipal.add(botonInicio);
        seccionPrincipal.add(Box.createHorizontalStrut(16)); // Espaciador horizontal
        seccionPrincipal.add(botonInformacion);

        contenedorBotones.add(seccionPrincipal, BorderLayout.NORTH);
        add(contenedorBotones, BorderLayout.CENTER); // Agrega el contenedor de botones en el centro
    }
    
    /**
     * Inserta el pie de página de la aplicación en la parte inferior del layout principal.
     * Se presenta la información de proyecto de la Universidad el Bosque.
     */
    public void insertarPieDePagina() {
    	JPanel piePagina = new JPanel();
    	piePagina.setBackground(new Color(242, 97, 63));
    	piePagina.setBorder(new EmptyBorder(12,12,12,12));
    	
    	JLabel textoPiePagina = new JLabel("Universidad el Bosque. 2024");
    	Font fontTextoPiePagina = new Font("Arial", Font.BOLD, 18);
    	textoPiePagina.setFont(fontTextoPiePagina);
    	textoPiePagina.setForeground(new Color(252, 255, 218));
    	
    	piePagina.add(textoPiePagina);
    	
    	add(piePagina, BorderLayout.SOUTH);
    }

    /**
     * Override del método paint para dibujar una imagen de fondo en el panel.
     * 
     * @param g El objeto Graphics utilizado para dibujar
     */
    @Override
    public void paint(Graphics g) {
        ImageIcon imagenFondo = new ImageIcon("images" + File.separator + "Fondo_inicio.png");
        g.drawImage(imagenFondo.getImage(), 0, 0, getWidth(), getHeight(), this); // Dibuja la imagen de fondo

        setOpaque(false); // Hace el panel transparente
        super.paint(g); // Llama al método paint de la superclase JPanel
    }

    /**
     * Getter para boton de inicio de diagnostico
     * @return botonInicio retorna el botón para inicio del diagnostico
     */
    public JButton getBotonInicio() {
        return botonInicio;
    }

    /**
     * Getter para botonInformación
     * @return botonInformacion retorna el boton que lleva a la pantallá de información del proyecto
     */
	public JButton getBotonInformacion() {
		return botonInformacion;
	}
}
