/**
 * Importa el controlador que maneja la lógica de negocio del peoyecto
 */
package co.edu.unbosque.controller;

/**
 * Clase pricipal, sirve como punto de entrada a la app
 */
public class AplMain {

	/**
	 * Metodo de inicio de aplicación
	 * @param args
	 */
	public static void main(String[] args) {
		Controller app = new Controller();
		app.funcionar();
	}

}
