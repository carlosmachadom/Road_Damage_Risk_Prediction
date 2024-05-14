package co.edu.unbosque.model;

public class Query {
    private String tipoCarretera;
    private String materialCarretera;
    private int humedadSuelo;
    private String condicionesInicialesVia;
    private int precipitacion;
    private int temperatura;
    private String condicionesAmbientales;
    private String densidadVehicularDosEjes;
    private String densidadVehicularTresEjes;
    private String densidadVehicularCuatroEjes;
    private String densidadVehicularCincoEjes;
    private String resultado;

    // Constructor vacío
    public Query() {
        this.tipoCarretera = "";
        this.materialCarretera = "";
        this.humedadSuelo = 0;
        this.condicionesInicialesVia = "";
        this.precipitacion = 0;
        this.temperatura = 0;
        this.condicionesAmbientales = "";
        this.densidadVehicularDosEjes = "";
        this.densidadVehicularTresEjes = "";
        this.densidadVehicularCuatroEjes = "";
        this.densidadVehicularCincoEjes = "";
        this.resultado = "";
    }

    // Getters y setters
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

    public int getHumedadSuelo() {
        return humedadSuelo;
    }

    public void setHumedadSuelo(int humedadSuelo) {
        this.humedadSuelo = humedadSuelo;
    }

    public String getCondicionesInicialesVia() {
        return condicionesInicialesVia;
    }

    public void setCondicionesInicialesVia(String condicionesInicialesVia) {
        this.condicionesInicialesVia = condicionesInicialesVia;
    }

    public int getPrecipitacion() {
        return precipitacion;
    }

    public void setPrecipitacion(int precipitacion) {
        this.precipitacion = precipitacion;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public String getCondicionesAmbientales() {
        return condicionesAmbientales;
    }

    public void setCondicionesAmbientales(String condicionesAmbientales) {
        this.condicionesAmbientales = condicionesAmbientales;
    }

    public String getDensidadVehicularDosEjes() {
        return densidadVehicularDosEjes;
    }

    public void setDensidadVehicularDosEjes(String densidadVehicularDosEjes) {
        this.densidadVehicularDosEjes = densidadVehicularDosEjes;
    }

    public String getDensidadVehicularTresEjes() {
        return densidadVehicularTresEjes;
    }

    public void setDensidadVehicularTresEjes(String densidadVehicularTresEjes) {
        this.densidadVehicularTresEjes = densidadVehicularTresEjes;
    }

    public String getDensidadVehicularCuatroEjes() {
        return densidadVehicularCuatroEjes;
    }

    public void setDensidadVehicularCuatroEjes(String densidadVehicularCuatroEjes) {
        this.densidadVehicularCuatroEjes = densidadVehicularCuatroEjes;
    }
    
    public String getDensidadVehicularCincoEjes() {
        return densidadVehicularCincoEjes;
    }

    public void setDensidadVehicularCincoEjes(String densidadVehicularCincoEjes) {
        this.densidadVehicularCincoEjes = densidadVehicularCincoEjes;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

	@Override
	public String toString() {
		return "Query [tipoCarretera=" + tipoCarretera + ", materialCarretera=" + materialCarretera + ", humedadSuelo="
				+ humedadSuelo + ", condicionesInicialesVia=" + condicionesInicialesVia + ", precipitacion="
				+ precipitacion + ", temperatura=" + temperatura + ", condicionesAmbientales=" + condicionesAmbientales
				+ ", densidadVehicularDosEjes=" + densidadVehicularDosEjes + ", densidadVehicularTresEjes="
				+ densidadVehicularTresEjes + ", densidadVehicularCuatroEjes=" + densidadVehicularCuatroEjes
				+ ", densidadVehicularCincoEjes=" + densidadVehicularCincoEjes + ", resultado=" + resultado + "]";
	}
    
    
}
