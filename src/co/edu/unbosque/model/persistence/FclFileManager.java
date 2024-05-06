package co.edu.unbosque.model.persistence;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.RuleBlock;

public class FclFileManager {

    private FIS fis;

    public void loadFclFile(String filePath) {
        fis = FIS.load(filePath, true);
    }

    public void setInputVariable(String keyName, double value) {
        if (fis != null) {
            fis.setVariable(keyName, value);
        }
    }

    public void evaluate() {
        if (fis != null) {
            fis.evaluate();
        }
    }

    public double getOutputVariable(String variableName) {
        if (fis != null) {
            return fis.getVariable(variableName).getValue();
        }
        return Double.NaN;

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
}