package co.edu.unbosque.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import co.edu.unbosque.view.VistaVentana;
import co.edu.unbosque.DAO.FuzzyVariablesDAO;
import co.edu.unbosque.DTO.FuzzyInputDTO;
import co.edu.unbosque.model.Query;

public class Controller implements ActionListener {
    
    public VistaVentana vista;

    private final FuzzyVariablesDAO mainFuzzySystemDAO;    
    private final FuzzyVariablesDAO condicionesInicialesViaFuzzySystemDAO;    
    private final FuzzyVariablesDAO condicionesAmbientalesFuzzySystemDAO;    
    private final FuzzyVariablesDAO condicionesTraficoFuzzySystemDAO;  
    
    private Query consulta;

    public Controller() {
        mainFuzzySystemDAO = new FuzzyVariablesDAO();
        condicionesInicialesViaFuzzySystemDAO = new FuzzyVariablesDAO("condiciones_iniciales_via.fcl");
        condicionesAmbientalesFuzzySystemDAO = new FuzzyVariablesDAO("enviromental_conditions.fcl");
        condicionesTraficoFuzzySystemDAO = new FuzzyVariablesDAO("condiciones_trafico.fcl");
        
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
    	
    	// Asignar oyentes en el formulario tres
    	if (vista.getLayoutPrincipal().getFormularioTres() != null) {
    		vista.getLayoutPrincipal().getFormularioTres().getBotonEnviar().addActionListener(this);
    		vista.getLayoutPrincipal().getFormularioTres().getBotonCancelar().addActionListener(this);    		
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
			consulta = new Query();
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
		    				
		    				consulta.setTipoCarretera(tipoCarretera);
		    				consulta.setMaterialCarretera(tipoMaterial);
		    				consulta.setHumedadSuelo(hSuelo);
		    				
		    				vista.getLayoutPrincipal().insertarFormularioDos();
		    				asignarOyentes();
		    			} else {
		    				JOptionPane.showMessageDialog(null, "Error: Humedad del suelo fuera de rango, esta debe estar entre 0% y 100%.", "Error de input", JOptionPane.ERROR_MESSAGE);
		    			}
		    		} catch (NumberFormatException e) {
		    			JOptionPane.showMessageDialog(null, "Error: Por favor ingrese un numero valido.", "Error de formato", JOptionPane.ERROR_MESSAGE);
		    		}
		    	} else {
		    		JOptionPane.showMessageDialog(null, "Error: Por favor ingresa información.", "Error de formato", JOptionPane.ERROR_MESSAGE);
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
						
						consulta.setTemperatura(temperatura);
						consulta.setPrecipitacion(precipitaciones);
						
						if (temperatura >= -5 && temperatura <= 30) {
							condicionesAmbientalesFuzzySystemDAO.putFuzzifiedVariable(new FuzzyInputDTO("temperatura", temperatura));
						} else {
							JOptionPane.showMessageDialog(null, "Error: Temperatura fuera de rango, esta debe estar entre -5 y 30 grados.", "Error de input", JOptionPane.ERROR_MESSAGE);
						}
						
						if (precipitaciones >= 0 && precipitaciones <= 300) {
							condicionesAmbientalesFuzzySystemDAO.putFuzzifiedVariable(new FuzzyInputDTO("precipitacion", precipitaciones));							
						} else {
							JOptionPane.showMessageDialog(null, "Error: Temperatura fuera de rango, esta debe estar entre 0 y 300 mm.", "Error de input", JOptionPane.ERROR_MESSAGE);
						}		
						
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
		case "Enviar_datos":
			// Obtener los vehiculos y trafico
			if (vista.getLayoutPrincipal().getFormularioTres() != null) {
			    Component[] lista = vista.getLayoutPrincipal().getFormularioTres().getLista().getComponents();

			    for (Component listElement : lista) {
			    	
			    	String densidadTraficoTerm = "";
        			double densidadTraficoValue = 0;
			    	
			        if (listElement instanceof JPanel) {
			            JPanel panel = (JPanel) listElement;
			            for (Component innerComponent : panel.getComponents()) {			            	
			                if (innerComponent instanceof JPanel) {
			                    JPanel innerPanel = (JPanel) innerComponent;
			                    for (Component component : innerPanel.getComponents()) {			                    	
			                    	if (component instanceof JPanel) {			                    		
			                    		JPanel contenedorFinal = (JPanel) component;			                    		
			                    		for (Component c : contenedorFinal.getComponents()) {
			                    			double tipoVehiculo = 0;			                    			
			                    			double nivelTrafico = 0;
			                    			
			                    			if (c instanceof JLabel) {
			                    				JLabel tituloSeccion = (JLabel) c;
			                    				String vehiculoActual = tituloSeccion.getText();
			                    				
			                    				if (vehiculoActual.contains("2")) {
			                    					tipoVehiculo = 0.05;
			                    					densidadTraficoTerm = "densidad_vehicular_dos_ejes";			                    					
			                    				} else if (vehiculoActual.contains("3")) {
			                    					tipoVehiculo = 0.15;
			                    					densidadTraficoTerm = "densidad_vehicular_tres_ejes";
			                    					
			                    				} else if (vehiculoActual.contains("4")) {
			                    					tipoVehiculo = 0.35;
			                    					densidadTraficoTerm = "densidad_vehicular_cuatro_ejes";
			                    					
			                    				} else if(vehiculoActual.contains("5")) {
			                    					tipoVehiculo = 0.45;
			                    					densidadTraficoTerm = "densidad_vehicular_cinco_ejes";			                    								                    					
			                    				}
			                    				
			                    				condicionesTraficoFuzzySystemDAO.putFuzzifiedVariable(new FuzzyInputDTO("tipo_vehiculo", tipoVehiculo));
			                    				
			                    			} else if (c instanceof JComboBox) {
			                    				JComboBox<String> selectorTrafico = (JComboBox<String>) c;
			                    				String elementoSeleccionado = selectorTrafico.getSelectedItem().toString();
			                    				
			                    				if (elementoSeleccionado.contains("Alto")) {
			                    					nivelTrafico = 0.6;
			                    				} else if (elementoSeleccionado.contains("Medio")) {
			                    					nivelTrafico = 0.3;			                    					
			                    				} else if (elementoSeleccionado.contains("Bajo")) {
			                    					nivelTrafico = 0.1;			                    					
			                    				}
			                    				
			                    				condicionesTraficoFuzzySystemDAO.putFuzzifiedVariable(new FuzzyInputDTO("nivel_trafico", nivelTrafico));
			                    			}			
			                    		}	
			                    	}	
			                    }
			                }
			            }
			        }
			        
			        
			        
			        condicionesTraficoFuzzySystemDAO.evaluate();			        
			        densidadTraficoValue = condicionesTraficoFuzzySystemDAO.getDefuzzifiedVariable("condiciones_vehiculares").getValue();			        
			        mainFuzzySystemDAO.putFuzzifiedVariable(new FuzzyInputDTO(densidadTraficoTerm, densidadTraficoValue));
			    }
			    
			    // Evaluar en el JavaFuzzy los datos
			    mainFuzzySystemDAO.evaluate();			    
			    // Obtener respuesta
			    double respuestaDefuzzificada = mainFuzzySystemDAO.getDefuzzifiedVariable("riesgo_de_alto_deterioro").getValue();
			    String respuestaFuzzificada = mainFuzzySystemDAO.getFuzzifiedVariable("riesgo_de_alto_deterioro");
			    consulta.setResultado(respuestaFuzzificada);
			    
			    // Insertar panel de respuesta			    
			    vista.getLayoutPrincipal().insertarPantallaDeRespuesta(respuestaFuzzificada.replace("_", " ").toUpperCase());
				asignarOyentes();
			}
			
			break;
		case "Informacion_proyecto": 
			// Llevar a pantalla de información de proyecto
			asignarOyentes();
			break;
		case "Cancelar":
			vista.getLayoutPrincipal().insertarPantallaDeInicio();
			asignarOyentes();
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
