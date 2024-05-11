package co.edu.unbosque.controller;

import net.sourceforge.jFuzzyLogic.FIS;

import java.io.File;

public class FclFileManager {

        private final File file = new File("src" + File.separator + "static" + File.separator + "road_system.fcl");

        private FIS fis;

        public void loadFclFile() {
            String path = file.getPath();
            try {
                fis = FIS.load(path, true);
                if (fis == null) {
                    throw new IllegalArgumentException("Error loading FCL file: " + path);
                }
            } catch (NullPointerException e) {
                e.getMessage();
            }
        }

        public FIS getFis() {
            return fis;
        }

}
