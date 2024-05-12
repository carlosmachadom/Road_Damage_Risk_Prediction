package co.edu.unbosque.DAO;
import co.edu.unbosque.model.persistence.FclFileManager;
import co.edu.unbosque.DTO.FuzzyInputDTO;

public class FuzzyVariablesDAO {

    private FclFileManager fclFileManager;

    public FuzzyVariablesDAO() {
        fclFileManager = new FclFileManager();
        fclFileManager.loadFclFile();
    }
    
    public FuzzyVariablesDAO(String fileName) {
    	fclFileManager = new FclFileManager(fileName);
    	fclFileManager.loadFclFile();
    }

    public void putFuzzifiedVariable(FuzzyInputDTO variable) {    	
        fclFileManager.setVariable(variable.getkey(), variable.getValue());
    }

    public FuzzyInputDTO getDefuzzifiedVariable(String key) {
    	FuzzyInputDTO fuzzyDTO = null;
    	
    	double value = fclFileManager.getDefuzzifiedVariable(key);
        
    	if (value != -1) {
    		fuzzyDTO = new FuzzyInputDTO(key, value);
        }
        
        return fuzzyDTO;
    }
    
    public FuzzyInputDTO getVariable(String key) {
    	FuzzyInputDTO fuzzyDTO = null;
    	
    	double value = fclFileManager.getVariable(key);
    	
    	if (value != -1) {
    		fuzzyDTO = new FuzzyInputDTO(key, value);
    	}
    	
    	return fuzzyDTO;
    }

    public void evaluate() {
        fclFileManager.evaluate();
    }
}
