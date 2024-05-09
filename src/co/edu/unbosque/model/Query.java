public class Query {
    
    private String tipoCarretera;
    
    private String materialCarretera;
    
    private double condicionesAmbientales;

    private int hummedadSuelo;

    private String traficoCarretera;

    private int tipoVehiculo;

    public Query(
              String tipoCarretera, String materialCarretera, double condicionesAmbientales, int hummedadSuelo, String traficoCarretera, int tipoVehiculo
                  ) {
        this.tipoCarretera = tipoCarretera;
        this.materialCarretera = condicionesAmbientales;
        this.hummedadSuelo = hummedadSuelo;
        this.traficoCarretera = traficoCarretera;
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getTipoCarretera() {
        return tipoCarretera;
    }

    public String getMaterialCarretera() {
        return materialCarretera;
    }

    public double getCondicionesAmbientales() {
        return condicionesAmbientales;
    }

    public int getHummedadSuelo() {
        return hummedadSuelo;
    }

    public String getTraficoCarretera() {
        return traficoCarretera;
    }

    public int getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoCarretera() {
        this.tipoCarretera = tipoCarretera;
    }

    public String setMaterialCarretera() {
        this.materialCarretera = materialCarretera;
    }

    public double setCondicionesAmbientales() {
        this.condicionesAmbientales = condicionesAmbientales;
    }

    public int setHummedadSuelo() {
        this.hummedadSuelo = hummedadSuelo;
    }

    public String setTraficoCarretera() {
        this.traficoCarretera = traficoCarretera;
    }

    public int setTipoVehiculo() {
        this.tipoVehiculo = tipoVehiculo;
    }
}
