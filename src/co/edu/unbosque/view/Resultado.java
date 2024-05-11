package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Resultado extends JPanel{
	private String respuesta;
	private JPanel contenidoRespuesta;
	
	public Resultado(String rta) {		
		this.respuesta = rta;
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
		contenidoRespuesta.setBackground(new Color(0,0,0,70));
		contenidoRespuesta.setBorder(new EmptyBorder(40,12,12,40));
		
		insertarTitulo();
		
		JLabel rta = new JLabel(respuesta);
		
		
		add(contenidoRespuesta, BorderLayout.CENTER);
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
    	JLabel subtitulo = new JLabel("El nivel de riesgo de la carretera a sufrir un deterioro alto es:");
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
	
	public void insertarRespuesta() {
		
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
        ImageIcon imagenFondo = new ImageIcon("src\\images\\Fondo_formulario_dos.jpg");
        g.drawImage(imagenFondo.getImage(), 0, 0, getWidth(), getHeight(), this); // Dibuja la imagen de fondo

        setOpaque(false); // Hace el panel transparente
        super.paint(g); // Llama al método paint de la superclase JPanel
    }

}
