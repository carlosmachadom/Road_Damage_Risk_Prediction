package co.edu.unbosque.DAO;

import co.edu.unbosque.controller.Controller;
import co.edu.unbosque.model.persistence.FclFileManager;
import net.sourceforge.jFuzzyLogic.FIS;
import co.edu.unbosque.DTO.FuzzyInputDTO;

public class FuzzyVariablesDAO {

    private FclFileManager fclFileManager;

    public FuzzyVariablesDAO() {
        fclFileManager = new FclFileManager();
        fclFileManager.loadFclFile();
    }

    public void putFuzzifiedVariable(FuzzyInputDTO variable) {
        fclFileManager.setVariable(variable.getkey(), variable.getValue());
    }

    public FuzzyInputDTO getDefuzzifiedVariable(String key) {
    	FuzzyInputDTO fuzzyDTO = new FuzzyInputDTO(key, Double.NaN);
    	
    	double value = fclFileManager.getDefuzzifiedVariable(key);
        
    	if (value != -1) {
    		fuzzyDTO = new FuzzyInputDTO(key, value);
        }
        
        return fuzzyDTO;
    }

    public void evaluate() {
        fclFileManager.evaluate();
    }
}
