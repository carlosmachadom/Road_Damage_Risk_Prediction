package co.edu.unbosque.model;

public class Query {
    
    private String tipoCarretera;
    
    private String materialCarretera;
    
    private int humedadSuelo;
    
    private String convidionesInicialesVia;

    private double precipitacion;
    
    private double temperatura;
    
    private double condicionesAmbientales;

    private String traficoCarretera;

    private int tipoVehiculo;
    
    
    private String resultado;

    public Query() {    	
        this.tipoCarretera = "";
        this.materialCarretera = "";
        this.humedadSuelo = 0;
        this.traficoCarretera = "";
        this.tipoVehiculo = 0;
        this.precipitacion = 0;
        this.temperatura = 0;
    }

	public String getTipoCarretera() {
		return tipoCarretera;
	}

	public void setTipoCarretera(String tipoCarretera) {
		this.tipoCarretera = tipoCarretera;
	}

	public String getMaterialCarretera() {
		return materialCarretera;
	}

	public void setMaterialCarretera(String materialCarretera) {
		this.materialCarretera = materialCarretera;
	}

	public double getCondicionesAmbientales() {
		return condicionesAmbientales;
	}

	public void setCondicionesAmbientales(double condicionesAmbientales) {
		this.condicionesAmbientales = condicionesAmbientales;
	}

	public int getHumedadSuelo() {
		return humedadSuelo;
	}

	public void setHumedadSuelo(int humedadSuelo) {
		this.humedadSuelo = humedadSuelo;
	}

	public String getTraficoCarretera() {
		return traficoCarretera;
	}

	public void setTraficoCarretera(String traficoCarretera) {
		this.traficoCarretera = traficoCarretera;
	}

	public int getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(int tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public double getPrecipitacion() {
		return precipitacion;
	}

	public void setPrecipitacion(double precipitacion) {
		this.precipitacion = precipitacion;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
}
