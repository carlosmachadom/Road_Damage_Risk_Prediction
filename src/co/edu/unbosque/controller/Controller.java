package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import co.edu.unbosque.view.VistaVentana;
import co.edu.unbosque.DAO.FuzzyVariablesDAO;
import co.edu.unbosque.DTO.FuzzyInputDTO;

public class Controller implements ActionListener {
    
    public VistaVentana vista;

    private final FuzzyVariablesDAO mainFuzzySystemDAO;    
    private final FuzzyVariablesDAO condicionesInicialesViaFuzzySystemDAO;    
    private final FuzzyVariablesDAO condicionesAmbientalesFuzzySystemDAO;    

    public Controller() {
        mainFuzzySystemDAO = new FuzzyVariablesDAO();
        condicionesInicialesViaFuzzySystemDAO = new FuzzyVariablesDAO("condiciones_iniciales_via.fcl");
        condicionesAmbientalesFuzzySystemDAO = new FuzzyVariablesDAO("enviromental_conditions.fcl");
        vista = new VistaVentana();
        funcionar();
    }
  
    private void funcionar() {
	    asignarOyentes();
    }
  
    public void asignarOyentes() {
	    // Asignando oyentes de la pantalla de inicio
    	if (vista.getLayoutPrincipal().getPantallaInicio() != null) {
    		vista.getLayoutPrincipal().getPantallaInicio().getBotonInicio().addActionListener(this);
    		vista.getLayoutPrincipal().getPantallaInicio().getBotonInformacion().addActionListener(this);    		
    	}
		    
    	// Asignar oyentes en el formulario uno
    	if (vista.getLayoutPrincipal().getFormularioUno() != null) {
    		vista.getLayoutPrincipal().getFormularioUno().getBotonSiguiente().addActionListener(this);
    		vista.getLayoutPrincipal().getFormularioUno().getBotonCancelar().addActionListener(this);    		
    	}
    	
    	// Asignar oyentes en el formulario dos
    	if (vista.getLayoutPrincipal().getFormularioDos() != null) {
    		vista.getLayoutPrincipal().getFormularioDos().getBotonSiguiente().addActionListener(this);
    		vista.getLayoutPrincipal().getFormularioDos().getBotonCancelar().addActionListener(this);    		
    	}
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
			vista.getLayoutPrincipal().insertarFormularioUno();	
			asignarOyentes();
			break;
		case "Siguiente_formulario_uno":
			if (vista.getLayoutPrincipal().getFormularioUno() != null) {
				String tipoCarretera = vista.getLayoutPrincipal().getFormularioUno().getTipoCarretera().getSelectedItem().toString();
				String tipoMaterial = vista.getLayoutPrincipal().getFormularioUno().getMaterialCarretera().getSelectedItem().toString();
				
				double valorCarretera = 0;
				double valorMaterial = 0;
				
				switch (tipoCarretera) {
					case "Primaria":
						valorCarretera = 0.7; 
						break;
					case "Secundaria": 
						valorCarretera = 0.2;
						break;
					case "Terciaria":
						valorCarretera = 0.1;
						break;
					default:
						break;
				}				
				
				switch (tipoMaterial) {
				case "Igneos":
					valorMaterial = 0.1; 
					break;
				case "Sedimentarios": 
					valorMaterial = 0.3;
					break;
				case "Metamorficos":
					valorMaterial = 0.6;
					break;
				default:
					break;
				}
				
				mainFuzzySystemDAO.putFuzzifiedVariable(new FuzzyInputDTO("tipo_carretera", valorCarretera));
				condicionesInicialesViaFuzzySystemDAO.putFuzzifiedVariable(new FuzzyInputDTO("material_carretera", valorMaterial));
		    	
		    	String humedadSuelo = vista.getLayoutPrincipal().getFormularioUno().getHumedadSuelo().getText();
		    	
		    	if (!validateInput(humedadSuelo)) {
		    		try {
		    			int hSuelo = convertToInt(humedadSuelo);
		    			
		    			if(hSuelo >= 0 && hSuelo <= 100) {		    				
		    				condicionesInicialesViaFuzzySystemDAO.putFuzzifiedVariable(new FuzzyInputDTO("humedad_suelo", hSuelo));
		    				condicionesInicialesViaFuzzySystemDAO.evaluate();
		    				
		    				double condicionesVia = condicionesInicialesViaFuzzySystemDAO.getVariable("condiciones_iniciales_via").getValue();
		    				mainFuzzySystemDAO.putFuzzifiedVariable(new FuzzyInputDTO("condiciones_iniciales_via", condicionesVia));
		    				
		    				vista.getLayoutPrincipal().insertarFormularioDos();
		    				asignarOyentes();
		    			} else {
		    				JOptionPane.showMessageDialog(null, "Error: Humedad del suelo fuera de rango, esta debe estar entre 0% y 100%.", "Error de input", JOptionPane.ERROR_MESSAGE);
		    			}
		    		} catch (NumberFormatException e) {
		    			JOptionPane.showMessageDialog(null, "Error: El formato del string no es válido.", "Error de formato", JOptionPane.ERROR_MESSAGE);
		    		}
		    	} else {
		    		JOptionPane.showMessageDialog(null, "Error: El formato del string no es válido.", "Error de formato", JOptionPane.ERROR_MESSAGE);
		    	}
			}			
			break;
		case "Siguiente_formulario_dos":
			if (vista.getLayoutPrincipal().getFormularioDos() != null) {

				String temperaturaAmbiente = vista.getLayoutPrincipal().getFormularioDos().getTemperaturaAmbiente().getText();
				String nivelPrecipitaciones = vista.getLayoutPrincipal().getFormularioDos().getNivelPrecipitaciones().getText();
				
				try {
					if (!validateInput(temperaturaAmbiente) && !validateInput(nivelPrecipitaciones)) {
						double temperatura = convertToInt(temperaturaAmbiente);
						double precipitaciones = convertToInt(nivelPrecipitaciones);
						
						
						
						condicionesAmbientalesFuzzySystemDAO.putFuzzifiedVariable(new FuzzyInputDTO("temperatura", temperatura));		            		            
						condicionesAmbientalesFuzzySystemDAO.putFuzzifiedVariable(new FuzzyInputDTO("precipitacion", precipitaciones));
						condicionesAmbientalesFuzzySystemDAO.evaluate();
						
						double condicionesAmbientales = condicionesAmbientalesFuzzySystemDAO.getVariable("condiciones_ambientales").getValue();
		    			mainFuzzySystemDAO.putFuzzifiedVariable(new FuzzyInputDTO("condiciones_ambientales", condicionesAmbientales));						
						
						vista.getLayoutPrincipal().insertarFormularioTres();
						asignarOyentes();						
					} else {
						JOptionPane.showMessageDialog(null, "Error: Debes ingresar información.", "Sin datos", JOptionPane.ERROR_MESSAGE);
					}
		        } catch (NumberFormatException e) {
		        	 JOptionPane.showMessageDialog(null, "Error: El formato del string no es válido.", "Error de formato", JOptionPane.ERROR_MESSAGE);
		        }
			}			
			break;
		case "Enviar":
			// Obtener los vehiculos y trafico
			
			// Insertar en el JavaFuzzy los datos
			
			// Obtener respuesta
			
			// Insertar panel de respuesta
			break;
		case "Informacion_proyecto": 
			// Llevar a pantalla de información de proyecto
			asignarOyentes();
			break;
		case "Cancelar":
			// LLevar a pagina de inicio 
			// Reiniciar objeto de consulta
		default:
			break;
			
		}
	}
	
	public double convertToDouble(String str) throws NumberFormatException {
        double result;
        try {
            result = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            throw e;
        }
        return result;
    }
	
	public int convertToInt(String str) throws NumberFormatException {
		int result;
		try {
			result = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			throw e;
		}
		return result;
	}
	
	public boolean validateInput(String input) {
		boolean respuesta = false;
        
		if (input == null || input.isEmpty()) {
            respuesta = true;
        }
        
        return respuesta;
    }
}
