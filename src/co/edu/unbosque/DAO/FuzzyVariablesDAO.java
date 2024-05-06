package co.edu.unbosque.DAO;

import co.edu.unbosque.model.persistence.FclFileManager;
import net.sourceforge.jFuzzyLogic.FIS;
import co.edu.unbosque.DTO.FuzzyInputDTO;

public class FuzzyVariablesDAO {

    private final FIS fis;

    public FuzzyVariablesDAO() {
        FclFileManager fclFileManager = new FclFileManager();
        fclFileManager.loadFclFile();
        this.fis = fclFileManager.getFis();
    }

    public void putFuzzifiedVariable(FuzzyInputDTO variable) {
        if (fis != null) {
            fis.setVariable(variable.getkey(), variable.getValue());
        }
    }

    public FuzzyInputDTO getDefuzzifiedVariable(String key) {
        if (fis != null && fis.getVariable(key) != null) {
            double value = fis.getVariable(key).getValue();
            return new FuzzyInputDTO(key, value);
        }
        return new FuzzyInputDTO(key, Double.NaN);
    }

    public void evaluate() {
        if (fis != null) {
            fis.evaluate();
        }
    }
}
