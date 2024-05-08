public class Atmosphere {
  
  private int precipitacion;
  
  private double temperatura;

  public Atmosphere(int precipitacion, double temperatura) {
        this.precipitacion = precipitacion;
        this.temperatura = temperatura;
  }

  public int getPrecipitacion() {
        return precipitacion;
  }

  public double getTemperatura() {
        return temperatura;
  }

  public void setPrecipitacion() {
        this.precipitacion = precipitacion;
  }

  public double setTemperatura() {
        this.temperatura = temperatura;
  }
}
