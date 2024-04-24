/**
 * 
 */
package co.edu.unbosque.model.persistence;

/**
 * 
 */
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.RuleBlock;

/**
 * 
 */
public class FclFileManager {
	private FIS fis;

    /**
     * Carga el archivo FCL.
     * @param filePath Ruta al archivo FCL.
     * @return true si el archivo FCL fue cargado con éxito, false de lo contrario.
     */
    public boolean loadFclFile(String filePath) {
        fis = FIS.load(filePath, true);
        if (fis == null) {
            System.err.println("Error loading FCL file.");
            return false;
        }
        return true;
    }

    /**
     * Establece una variable de entrada en el sistema difuso.
     * @param variableName Nombre de la variable.
     * @param value Valor a establecer.
     */
    public void setInputVariable(String variableName, double value) {
        if (fis != null) {
            fis.setVariable(variableName, value);
        }
    }

    /**
     * Evalúa el sistema difuso.
     */
    public void evaluate() {
        if (fis != null) {
            fis.evaluate();
        }
    }

    /**
     * Obtiene el valor de una variable de salida del sistema difuso.
     * @param variableName Nombre de la variable.
     * @return Valor de la variable.
     */
    public double getOutputVariable(String variableName) {
        if (fis != null) {
            return fis.getVariable(variableName).getValue();
        }
        return Double.NaN; // Devuelve NaN si FIS es nulo.
    }
    
    // Método para mostrar funciones de pertenencia
//    public void showFuzzyChart() {
//        if (fis != null) {
//            fis.showFuzzyChart();
//        }
//    }

    // Método para mostrar la visualización de las reglas
//    public void showRuleBlockChart() {
//        if (fis != null) {
//            RuleBlock ruleBlock = fis.getRuleBlock(null); // null para obtener el primer RuleBlock
//            if (ruleBlock != null) {
//                ruleBlock.chart();
//            }
//        }
//    }

    // Método para mostrar la visualización del resultado
//    public void showOutputChart() {
//        if (fis != null) {
//            fis.chart();
//        }
//    }
}
