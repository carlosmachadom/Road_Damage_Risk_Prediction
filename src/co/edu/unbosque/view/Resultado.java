package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.model.Query;

@SuppressWarnings("serial")
public class Resultado extends JPanel {
	private Query consulta;
    
	private JPanel contenidoRespuesta;
	
    private JButton botonInicio;
	
	public Resultado(Query consulta) {
		
		this.consulta = consulta;
		
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
    	
    	JLabel stepper = new JLabel("Finalizado");
    	stepper.setFont(fuente);
    	stepper.setBorder(margen);
    	stepper.setForeground(colorFuente);
    	
    	header.add(titulo);
    	header.add(Box.createHorizontalGlue());
    	header.add(stepper);
    	
    	add(header, BorderLayout.NORTH);
	}
	
	public void insertarContenidoPrincipal() {
		contenidoRespuesta = new JPanel();
		contenidoRespuesta.setLayout(new BoxLayout(contenidoRespuesta, BoxLayout.Y_AXIS));
		contenidoRespuesta.setBackground(new Color(0,0,0,180));
		contenidoRespuesta.setBorder(new EmptyBorder(40,12,12,40));
		
		insertarTitulo();
		
		JPanel contenedorRespuesta = new JPanel();
		contenedorRespuesta.setLayout(new FlowLayout(FlowLayout.LEADING));
		contenedorRespuesta.setBorder(new EmptyBorder(0,40,0,40));
		contenedorRespuesta.setBackground(new Color(0,0,0,0));
		
		Font fuente = new Font("Arial", Font.BOLD, 48);
		Color colorFuente = new Color(252, 255, 218);
		
		JLabel rta = new JLabel(consulta.getResultado());
		rta.setFont(fuente);
    	rta.setForeground(colorFuente);	
		
		contenedorRespuesta.add(rta);
		
		contenidoRespuesta.add(contenedorRespuesta);
		contenidoRespuesta.add(renderQueryPanel());
		contenidoRespuesta.add(insertarBotones());
		
		add(contenidoRespuesta, BorderLayout.CENTER);
	}
	
	public JPanel renderQueryPanel() {
		JPanel seccion = new JPanel();
		seccion.setBackground(new Color(0,0,0,0));
		seccion.setLayout(new BorderLayout());
		seccion.setBorder(new EmptyBorder(40,0,0,0));
		
		JPanel contenedorTituloConsulta = new JPanel();
    	contenedorTituloConsulta.setLayout(new FlowLayout(FlowLayout.LEADING));
    	contenedorTituloConsulta.setBorder(new EmptyBorder(0,40,0,40));
    	contenedorTituloConsulta.setBackground(new Color(0,0,0,0));
    	
    	JLabel tituloConsulta = new JLabel("Resumen consulta");
    	tituloConsulta.setFont(new Font("Arial", Font.BOLD, 32));
    	tituloConsulta.setForeground(new Color(242, 97, 63));
    	
    	contenedorTituloConsulta.add(tituloConsulta);

		JPanel limiter = new JPanel();
		limiter.setBackground(new Color(0,0,0,0));
		limiter.setPreferredSize(new Dimension(500, 600));
		limiter.setBorder(new EmptyBorder(0,40,0,40));
		limiter.setLayout(new FlowLayout(FlowLayout.LEADING));
		
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 1, 10, 10)); // Layout de cuadrícula para organizar los componentes
        panel.setBackground(new Color(0,0,0,0));
        panel.setBorder(new EmptyBorder(0,0,0,0));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 0); // Padding

        // Agregar JLabels con títulos y valores correspondientes
        panel.add(getQueryLabel("Tipo de Carretera: " + consulta.getTipoCarretera()), gbc);
        panel.add(getQueryLabel("Material de Carretera: " + consulta.getMaterialCarretera()), gbc);
        panel.add(getQueryLabel("Humedad del Suelo: " + String.valueOf(consulta.getHumedadSuelo()) + "%"), gbc);
        //panel.add(getQueryLabel("Condiciones Iniciales de la Vía: " + consulta.getCondicionesInicialesVia()));
        panel.add(getQueryLabel("Precipitación: " + String.valueOf(consulta.getPrecipitacion()) + "mm"), gbc);
        panel.add(getQueryLabel("Temperatura: " + String.valueOf(consulta.getTemperatura()) + "C°"), gbc);
        //panel.add(getQueryLabel("Condiciones Ambientales: " + consulta.getCondicionesAmbientales()));
        panel.add(getQueryLabel("Densidad Vehicular (Dos Ejes): " + consulta.getDensidadVehicularDosEjes()), gbc);
        panel.add(getQueryLabel("Densidad Vehicular (Tres Ejes): " + consulta.getDensidadVehicularTresEjes()), gbc);
        panel.add(getQueryLabel("Densidad Vehicular (Cuatro Ejes) :" + consulta.getDensidadVehicularCuatroEjes()), gbc);
        panel.add(getQueryLabel("Densidad Vehicular (Cinco Ejes): " + consulta.getDensidadVehicularCincoEjes()), gbc);
        
        limiter.add(panel);
        seccion.add(contenedorTituloConsulta, BorderLayout.NORTH);
        seccion.add(limiter, BorderLayout.CENTER);

        return seccion;
    }
	
	public JLabel getQueryLabel(String text) {
		Font fuente = new Font("Arial", Font.BOLD, 18);
		Color colorFuente = new Color(252, 255, 218);
		
		JLabel data = new JLabel(text);
		data.setFont(fuente);
		data.setForeground(colorFuente);	
		data.setHorizontalAlignment(SwingConstants.LEFT); 
    	
		return data;    	
	}
	
	public void insertarTitulo() {
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(new BoxLayout(panelTitulo, BoxLayout.X_AXIS));
		panelTitulo.setOpaque(false);
		
		Font fuente = new Font("Arial", Font.BOLD, 64);
		Color colorFuente = new Color(242, 97, 63);
		Border margen = BorderFactory.createEmptyBorder(0, 40, 0, 40);
		
    	JLabel titulo = new JLabel("Respuesta");
    	titulo.setFont(fuente);
    	titulo.setForeground(colorFuente);
    	titulo.setBorder(margen);
    	
    	JPanel panelSubTitulo = new JPanel();
    	panelSubTitulo.setLayout(new BoxLayout(panelSubTitulo, BoxLayout.X_AXIS));
    	panelSubTitulo.setOpaque(false);
    	
    	Font fuente2 = new Font("Arial", Font.BOLD, 24);
		Color colorFuente2 = new Color(252, 255, 218);
    	JLabel subtitulo = new JLabel("Riesgo de Deterioro Vial:");
    	subtitulo.setFont(fuente2);
    	subtitulo.setForeground(colorFuente2);
    	subtitulo.setBorder(BorderFactory.createEmptyBorder(0, 40, 20, 40));
    	
    	if(contenidoRespuesta != null) {
    		panelTitulo.add(titulo);
    		panelTitulo.add(Box.createHorizontalGlue());
    		panelSubTitulo.add(subtitulo);
    		panelSubTitulo.add(Box.createHorizontalGlue());
    		contenidoRespuesta.add(panelTitulo);
    		contenidoRespuesta.add(panelSubTitulo);    		
    	}
	}
	
	public JPanel insertarBotones() {
        JPanel contenedorBotones = new JPanel(new BorderLayout());
        contenedorBotones.setBackground(new Color(255, 255, 255, 0)); // Fondo transparente
        contenedorBotones.setBorder(new EmptyBorder(0, 40, 40, 40));

        JPanel seccionPrincipal = new JPanel();
        seccionPrincipal.setLayout(new FlowLayout(FlowLayout.LEADING)); // Layout horizontal
        seccionPrincipal.setBackground(new Color(255, 255, 255, 0)); // Fondo transparente

        botonInicio = new JButton("Volver al inicio");
        botonInicio.setBackground(new Color(242, 97, 63));
        botonInicio.setFocusPainted(false);
        botonInicio.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonInicio.setBorder(new EmptyBorder(12, 16, 12, 16));
        botonInicio.setMargin(new Insets(10, 20, 10, 20));
        Font fontBotonInicio = new Font("Arial", Font.BOLD, 24);
        botonInicio.setFont(fontBotonInicio);
        botonInicio.setForeground(new Color(252, 255, 218));
        botonInicio.setActionCommand("Cancelar");

        seccionPrincipal.add(botonInicio);

        contenedorBotones.add(seccionPrincipal, BorderLayout.NORTH);
        return contenedorBotones; // Agrega el contenedor de botones en el centro
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
	
	@Override
    public void paint(Graphics g) {
        ImageIcon imagenFondo = new ImageIcon("images" + File.separator + "Fondo_resultado.png");
        g.drawImage(imagenFondo.getImage(), 0, 0, getWidth(), getHeight(), this); // Dibuja la imagen de fondo

        setOpaque(false); // Hace el panel transparente
        super.paint(g); // Llama al método paint de la superclase JPanel
    }

	public JButton getBotonInicio() {
		return botonInicio;
	}

	public void setBotonInicio(JButton botonInicio) {
		this.botonInicio = botonInicio;
	}
}
