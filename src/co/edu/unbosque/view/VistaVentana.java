package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * La clase VistaVentana representa la ventana principal de la aplicación "Pavement Forecast".
 * Esta ventana contiene un diseño principal (LayoutPrincipal) donde se muestran los componentes principales de la interfaz.
 * 
 * Extiende JFrame para poder crear una ventana gráfica.
 */
@SuppressWarnings("serial")
public class VistaVentana extends JFrame {

    private LayoutPrincipal layout;

    /**
     * Constructor de la clase VistaVentana.
     * Configura la ventana principal con título, tamaño, diseño y componentes iniciales.
     */
    public VistaVentana() {
        super();
        setTitle("Pavement Forecast"); // Establece el título de la ventana
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Establece la ventana maximizada al iniciar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
        getContentPane().setLayout(new BorderLayout()); // Establece el layout principal como BorderLayout
        setMinimumSize(new Dimension(1440, 960)); // Establece el tamaño mínimo de la ventana
        
        inicializarComponentes(); // Inicializa y configura los componentes de la ventana
        
        setResizable(true); // Permite redimensionar la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setVisible(true); // Hace visible la ventana
    }
    
    /**
     * Método para inicializar y configurar los componentes principales de la ventana.
     * Crea e agrega el LayoutPrincipal al centro del contenido de la ventana.
     */
    public void inicializarComponentes() {
        layout = new LayoutPrincipal(); // Crea una instancia del LayoutPrincipal
        getContentPane().add(layout, BorderLayout.CENTER); // Agrega el LayoutPrincipal al centro de la ventana
    }

    /**
     * Método getter para obtener el LayoutPrincipal actual de la ventana.
     * 
     * @return El LayoutPrincipal actual de la ventana.
     */
    public LayoutPrincipal getLayoutPrincipal() {
        return layout;
    }

    /**
     * Método setter para establecer un nuevo LayoutPrincipal en la ventana.
     * 
     * @param layout El nuevo LayoutPrincipal a establecer.
     */
    public void setLayoutPrincipal(LayoutPrincipal layout) {
        this.layout = layout;
    }   
}