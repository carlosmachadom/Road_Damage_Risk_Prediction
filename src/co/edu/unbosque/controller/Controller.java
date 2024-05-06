package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.view.VistaVentana;
import co.edu.unbosque.DAO.FuzzyVariablesDAO;
import co.edu.unbosque.DTO.FuzzyInputDTO;

public class Controller implements ActionListener {
    
    public VistaVentana vista;

    private final FuzzyVariablesDAO fuzzyVariablesDAO;

    public Controller() {
        fuzzyVariablesDAO = new FuzzyVariablesDAO();
        vista = new VistaVentana();
        funcionar();
        run();
    }

    private void run() {
        fuzzyVariablesDAO.putFuzzifiedVariable(new FuzzyInputDTO("trafico", 100.3));
        fuzzyVariablesDAO.putFuzzifiedVariable(new FuzzyInputDTO("peso_vehiculos", .5));
        fuzzyVariablesDAO.putFuzzifiedVariable(new FuzzyInputDTO("humedad", .2));
        fuzzyVariablesDAO.putFuzzifiedVariable(new FuzzyInputDTO("precipitacion", .1));
        fuzzyVariablesDAO.putFuzzifiedVariable(new FuzzyInputDTO("riesgo_de_alto_deterioro", .9));

        fuzzyVariablesDAO.evaluate();

        FuzzyInputDTO f = fuzzyVariablesDAO.getDefuzzifiedVariable("trafico");
        FuzzyInputDTO g = fuzzyVariablesDAO.getDefuzzifiedVariable("peso_vehiculos");
        FuzzyInputDTO h = fuzzyVariablesDAO.getDefuzzifiedVariable("humedad");
        FuzzyInputDTO i = fuzzyVariablesDAO.getDefuzzifiedVariable("precipitacion");
        FuzzyInputDTO j = fuzzyVariablesDAO.getDefuzzifiedVariable("riesgo_de_alto_deterioro");

        System.out.println(f.getkey() + " <=> " + f.getValue());
        System.out.println(g.getkey() + " <=> " + g.getValue());
        System.out.println(h.getkey() + " <=> " + h.getValue());
        System.out.println(i.getkey() + " <=> " + i.getValue());
        System.out.println(j.getkey() + " <=> " + j.getValue());
    }
  
    private void funcionar() {
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
		  
	  }
}
