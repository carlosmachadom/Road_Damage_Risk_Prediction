package co.edu.unbosque.model.persistence;

import java.io.File;

import net.sourceforge.jFuzzyLogic.FIS;

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
            value = fis.getVariable(key).getValue();
        } else {
        	value = -1;
        }
        
        return value;
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


