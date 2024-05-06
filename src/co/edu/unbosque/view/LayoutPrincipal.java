/**
 * 
 */
package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * Clase layout que va a contener todas las pantallas
 */
public class LayoutPrincipal extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Inicio pantallaInicio;
	private FormularioUnoTipoCarretera formularioUno;
	private FormularioDosCondicionesAmbientales formularioDos;
	private FormularioTresTraficoVehicular formularioTres;
	private Resultado pantallaRespuesta;
	private Informacion pantallaInformacion;
	
	public LayoutPrincipal() {
		setLayout(new BorderLayout());
		
		inicializarComponentes();
		
		setVisible(true);
	}
	
	public void inicializarComponentes() {
		insertarPantallaDeInicio();
	}
	
	public void insertarPantallaDeInicio() {
		removerPaneles();
		repintarRevalidarPanel();
		
		// Agregar pantalla de inicio
		pantallaInicio = new Inicio();
		add(pantallaInicio);
		
		repintarRevalidarPanel();
	}
	
	public void insertarFormularioUno() {
		removerPaneles();
		repintarRevalidarPanel();
		
		// Agregar formulario 1
		formularioUno = new FormularioUnoTipoCarretera();
		add(formularioUno);
		
		repintarRevalidarPanel();
	}
	
	public void insertarFormularioDos() {
		removerPaneles();
		repintarRevalidarPanel();
		
		// Agregar formulario 2
		
		repintarRevalidarPanel();
	}
	
	public void insertarFormularioTres() {
		removerPaneles();
		repintarRevalidarPanel();
		
		// Agregar formulario 3
		
		repintarRevalidarPanel();
	}
	
	public void insertarPantallaDeRespuesta() {
		removerPaneles();
		repintarRevalidarPanel();
		
		// Agregar pantalla de respuesta
		
		repintarRevalidarPanel();
	}
	
	public void insertarPantallaInformacion() {
		removerPaneles();
		repintarRevalidarPanel();
		
		// Agregar pantalla de Información
		
		repintarRevalidarPanel();
	}
	
	public void removerPaneles() {
		removeAll();
	}
	
	public void repintarRevalidarPanel() {
		revalidate();
		repaint();
	}

	public Inicio getPantallaInicio() {
		return pantallaInicio;
	}

	public void setPantallaInicio(Inicio pantallaInicio) {
		this.pantallaInicio = pantallaInicio;
	}

	public FormularioUnoTipoCarretera getFormularioUno() {
		return formularioUno;
	}

	public void setFormularioUno(FormularioUnoTipoCarretera formularioUno) {
		this.formularioUno = formularioUno;
	}

	public FormularioDosCondicionesAmbientales getFormularioDos() {
		return formularioDos;
	}

	public void setFormularioDos(FormularioDosCondicionesAmbientales formularioDos) {
		this.formularioDos = formularioDos;
	}

	public FormularioTresTraficoVehicular getFormularioTres() {
		return formularioTres;
	}

	public void setFormularioTres(FormularioTresTraficoVehicular formularioTres) {
		this.formularioTres = formularioTres;
	}

	public Resultado getPantallaRespuesta() {
		return pantallaRespuesta;
	}

	public void setPantallaRespuesta(Resultado pantallaRespuesta) {
		this.pantallaRespuesta = pantallaRespuesta;
	}

	public Informacion getPantallaInformacion() {
		return pantallaInformacion;
	}

	public void setPantallaInformacion(Informacion pantallaInformacion) {
		this.pantallaInformacion = pantallaInformacion;
	}
}
