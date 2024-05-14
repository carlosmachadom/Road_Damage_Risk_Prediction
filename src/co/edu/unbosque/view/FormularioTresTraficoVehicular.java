/**
 * 
 */
package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 * 
 */
@SuppressWarnings("serial")
public class FormularioTresTraficoVehicular extends JPanel {
	private JPanel contenedorFormulario;
	private JPanel lista;
	private JButton botonEnviar;
	private JButton botonCancelar;
	
	public FormularioTresTraficoVehicular() {
		setBorder(new EmptyBorder(0, 0, 0, 0));
        setPreferredSize(new Dimension(1440, 960));
        setLayout(new BorderLayout());
        inicializarComponentes();
        setVisible(true);
	}
	
	public void inicializarComponentes() {
		insertarCabecera();
		insertarContenidoPrincipal();
		insertarPieDePagina();
	}
	
	public void insertarCabecera() {
		JPanel header = new JPanel();
		header.setBackground(new Color(242, 97, 63));
		header.setBorder(new EmptyBorder(12,12,12,12));
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
    	
		Font fuente = new Font("Arial", Font.BOLD, 24);
		Color colorFuente = new Color(252, 255, 218);
		Border margen = BorderFactory.createEmptyBorder(0, 40, 0, 40);
		
    	JLabel titulo = new JLabel("Pavement Forecast");
    	titulo.setFont(fuente);
    	titulo.setBorder(margen);
    	titulo.setForeground(colorFuente);
    	
    	JLabel stepper = new JLabel("Paso 3 de 3");
    	stepper.setFont(fuente);
    	stepper.setBorder(margen);
    	stepper.setForeground(colorFuente);
    	
    	header.add(titulo);
    	header.add(Box.createHorizontalGlue());
    	header.add(stepper);
    	
    	add(header, BorderLayout.NORTH);
	}
	
	public void insertarContenidoPrincipal() {
		contenedorFormulario = new JPanel();
		contenedorFormulario.setLayout(new BoxLayout(contenedorFormulario, BoxLayout.Y_AXIS));
		contenedorFormulario.setBackground(new Color(0,0,0,70));
		contenedorFormulario.setBorder(new EmptyBorder(40,12,12,40));
		
		insertarTitulo();
		insertarCamposFormulario();
		insertarBotones();
		
		add(contenedorFormulario, BorderLayout.CENTER);
	}
	
	public void insertarTitulo() {
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(new BoxLayout(panelTitulo, BoxLayout.X_AXIS));
		panelTitulo.setOpaque(false);
		
		Font fuente = new Font("Arial", Font.BOLD, 64);
		Color colorFuente = new Color(242, 97, 63);
		Border margen = BorderFactory.createEmptyBorder(0, 40, 0, 40);
		
    	JLabel titulo = new JLabel("Información de vehiculos");
    	titulo.setFont(fuente);
    	titulo.setForeground(colorFuente);
    	titulo.setBorder(margen);
    	
    	JPanel panelSubTitulo = new JPanel();
    	panelSubTitulo.setLayout(new BoxLayout(panelSubTitulo, BoxLayout.X_AXIS));
    	panelSubTitulo.setOpaque(false);
    	
    	Font fuente2 = new Font("Arial", Font.BOLD, 24);
		Color colorFuente2 = new Color(252, 255, 218);
    	JLabel subtitulo = new JLabel("Vehiculos pesados permitidos");
    	subtitulo.setFont(fuente2);
    	subtitulo.setForeground(colorFuente2);
    	subtitulo.setBorder(BorderFactory.createEmptyBorder(0, 40, 20, 40));
    	
    	if(contenedorFormulario != null) {
    		panelTitulo.add(titulo);
    		panelTitulo.add(Box.createHorizontalGlue());
    		panelSubTitulo.add(subtitulo);
    		panelSubTitulo.add(Box.createHorizontalGlue());
    		contenedorFormulario.add(panelTitulo);
    		contenedorFormulario.add(panelSubTitulo);    		
    	}
	}	
	
	public void insertarCamposFormulario() {
		Font fuente = new Font("Arial", Font.BOLD, 24);
		Color colorFuente = new Color(252, 255, 218);
		
		// Lista de elementos seleccionados
		JPanel seccionLista = new JPanel();
		seccionLista.setBackground(new Color(0, 0, 0, 0));
		seccionLista.setBorder(new EmptyBorder(0,0,0,0));
		seccionLista.setLayout(new BorderLayout());
        
        JPanel tituloCampos = new JPanel();
        tituloCampos.setBackground(new Color(250, 250, 250, 0));
        tituloCampos.setBorder(new EmptyBorder(0,40,0,40));
        tituloCampos.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JLabel ejesTitulo = new JLabel("Ejes");
        ejesTitulo.setFont(fuente);
        ejesTitulo.setForeground(colorFuente);
        ejesTitulo.setBorder(new EmptyBorder(0,0,0,0));
        
        JLabel traficoTitulo = new JLabel("Nivel de trafico");
        traficoTitulo.setFont(fuente);
        traficoTitulo.setForeground(colorFuente);
        traficoTitulo.setBorder(new EmptyBorder(0,0,0,0));        
        
        JPanel separador = new JPanel();
        separador.setPreferredSize(new Dimension(180, 10));
        separador.setBackground(new Color(0,0,0,0));
        
        tituloCampos.add(ejesTitulo);
        tituloCampos.add(separador);
        tituloCampos.add(traficoTitulo);        
        
        seccionLista.add(tituloCampos, BorderLayout.NORTH);
        
        lista = new JPanel();
        lista.setBackground(new Color(242, 97, 63, 0));
        lista.setBorder(new EmptyBorder(0,0,0,0));
        lista.setLayout(new BoxLayout(lista, BoxLayout.Y_AXIS));
        
        JPanel vehiculo2Ejes = getListElement("2");
        JPanel vehiculo3Ejes = getListElement("3");
        JPanel vehiculo4Ejes = getListElement("4");
        JPanel vehiculo5Ejes = getListElement("5");
        
        lista.add(vehiculo2Ejes);
        lista.add(vehiculo3Ejes);
        lista.add(vehiculo4Ejes);
        lista.add(vehiculo5Ejes);
        
        seccionLista.add(lista, BorderLayout.CENTER);
        
        
        if(contenedorFormulario != null) {
    		contenedorFormulario.add(seccionLista);
    		revalidate();
    		repaint();
    	}
	}
	
	public JPanel getListElement(String num) {		
		JPanel seccion = new JPanel();
		seccion.setLayout(new FlowLayout(FlowLayout.LEADING));
		seccion.setBackground(new Color(0,0,0,0));
		seccion.setBorder(new EmptyBorder(0,40,12,40));
		
		JPanel container = new JPanel();
		container.setBackground(new Color(0,0,0,0));
		container.setPreferredSize(new Dimension(360, 80));
		
		JPanel separador = new JPanel();
        separador.setPreferredSize(new Dimension(180, 10));
        separador.setBackground(new Color(0,0,0,0));
		
		JPanel listElement = new JPanel();
		listElement.setLayout(new FlowLayout(FlowLayout.LEFT));
		listElement.setBackground(new Color(72, 30, 20));
		listElement.setBorder(new EmptyBorder(12,12,12,12));
		
		Font fuente = new Font("Arial", Font.BOLD, 24);
		Color colorFuente = new Color(252, 255, 218);
		JLabel tituloSeccion = new JLabel(num+" ejes");
        tituloSeccion.setFont(fuente);
        tituloSeccion.setForeground(colorFuente);
        
        
        String[] nivelTrafico = {"Bajo", "Medio", "Alto"};
        JComboBox<String> selectorTrafico = new JComboBox<String>(nivelTrafico);
        
        listElement.add(tituloSeccion);
        listElement.add(separador);
        listElement.add(selectorTrafico);
		
        container.add(listElement);
        
        seccion.add(container);
        
		return seccion;
	}
	
	public void insertarBotones() {
		JPanel contenedorBotones = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contenedorBotones.setBackground(new Color(255, 255, 255, 0));
        contenedorBotones.setBorder(new EmptyBorder(0, 40, 40, 40));


        botonCancelar = new JButton("Cancelar");
        botonCancelar.setBackground(new Color(252, 255, 218));
        botonCancelar.setFocusPainted(false);
        botonCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonCancelar.setBorder(new EmptyBorder(12, 16, 12, 16));
        botonCancelar.setMargin(new Insets(10, 20, 10, 20));
        Font fontBotonInformacion = new Font("Arial", Font.BOLD, 24);
        botonCancelar.setFont(fontBotonInformacion);
        botonCancelar.setForeground(new Color(72, 30, 20));
        botonCancelar.setActionCommand("Cancelar");
        
        botonEnviar = new JButton("Enviar");
        botonEnviar.setBackground(new Color(242, 97, 63));
        botonEnviar.setFocusPainted(false);
        botonEnviar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonEnviar.setBorder(new EmptyBorder(12, 16, 12, 16));
        botonEnviar.setMargin(new Insets(10, 20, 10, 20));
        Font fontBotonInicio = new Font("Arial", Font.BOLD, 24);
        botonEnviar.setFont(fontBotonInicio);
        botonEnviar.setForeground(new Color(252, 255, 218));
        botonEnviar.setActionCommand("Enviar_datos");

        contenedorBotones.add(botonCancelar);
        contenedorBotones.add(Box.createHorizontalStrut(16));
        contenedorBotones.add(botonEnviar);
        
        if(contenedorFormulario != null) {
    		contenedorFormulario.add(contenedorBotones);
    	}
	}
	
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
        ImageIcon imagenFondo = new ImageIcon("src\\images\\Fondo_formulario_tres.jpg");
        g.drawImage(imagenFondo.getImage(), 0, 0, getWidth(), getHeight(), this); // Dibuja la imagen de fondo

        setOpaque(false); // Hace el panel transparente
        super.paint(g); // Llama al método paint de la superclase JPanel
    }

	public JPanel getLista() {
		return lista;
	}

	public JButton getBotonEnviar() {
		return botonEnviar;
	}

	public JButton getBotonCancelar() {
		return botonCancelar;
	}
}
