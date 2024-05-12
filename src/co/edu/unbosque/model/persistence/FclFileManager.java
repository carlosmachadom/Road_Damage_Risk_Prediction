package co.edu.unbosque.model.persistence;

import java.io.File;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunction;
import net.sourceforge.jFuzzyLogic.rule.LinguisticTerm;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * Clase encargada de la comunicación con el archivo FCL
 */
public class FclFileManager {
	private FIS fis;
	private final File file;
	
	public FclFileManager() {
		file = new File("src" + File.separator + "static" + File.separator + "road_system.fcl");
		fis = new FIS();
	}
	
	public FclFileManager(String fileName) {
		file = new File("src" + File.separator + "static" + File.separator + fileName);
		fis = new FIS();
	}
	
	public void loadFclFile() {
        String path = file.getPath();
        
        try {
            fis = FIS.load(path, true);
            
            if (fis == null) {
                throw new IllegalArgumentException("Error loading FCL file: " + path);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
	
	public void setVariable(String variable, double value) {
		if (fis != null) {
	        fis.setVariable(variable, value);
	    }
	}
	
	public double getDefuzzifiedVariable(String key) {
		double value = 0;
		
        if (fis != null && fis.getVariable(key) != null) {
            value = fis.getVariable(key).getLatestDefuzzifiedValue();
        } else {
        	value = -1;
        }
        
        return value;
    }
	
	public double getVariable(String key) {
		double value = 0;
		
		if (fis != null && fis.getVariable(key) != null) {
			value = fis.getVariable(key).getValue();
		} else {
			value = -1;
		}
		
		return value;
	}
	
	public String getFuzzifiedVariable(String key) {	
		String etiquetaAsociada = null;
		
		// Obtener el bloque de funciones del sistema difuso
        FunctionBlock functionBlock = fis.getFunctionBlock(null);
        
        // Obtener la variable de salida
        Variable outputVariable = functionBlock.getVariable(key);      
        
        double maxMembership = -1;

        // Iterar sobre los términos lingüísticos de la variable de salida
        for (String label : outputVariable.getLinguisticTerms().keySet()) {
        	double membership = outputVariable.getMembership(label);
        	
            if (membership > maxMembership) {
                maxMembership = membership;
                etiquetaAsociada = label;
            }
        }

        return etiquetaAsociada;
    }
	
	/**
	 * Evalua los input
	 */
	public void evaluate() {
        if (fis != null) {
            fis.evaluate();
        }
    }
}


