package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.view.VistaVentana;

/**
 * 
 */
public class Controller implements ActionListener{
	public VistaVentana vista;	
	
	public Controller() {
		vista = new VistaVentana();
		funcionar();
	}
	
	public void funcionar() {
		asignarOyentes();
	}
	
	public void asignarOyentes() {
		// Asignando oyentes de la pantalla de inicio
		vista.getLayoutPrincipal().getPantallaInicio().getBotonInicio().addActionListener(this);
		vista.getLayoutPrincipal().getPantallaInicio().getBotonInformacion().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		validarAccion(comando);
	}
	
	public void validarAccion(String command) {
		switch (command) {
		case "inicia_diagnostico":
			// Iniciar objeto para almacenar información
			vista.getLayoutPrincipal().insertarFormularioUno();		
		}
	}	
}
