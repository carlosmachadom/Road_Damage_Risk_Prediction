package co.edu.unbosque.DTO;

public class FuzzyInputDTO {

    private String key;

    private double value;

    public FuzzyInputDTO(String key, double value) {
        this.key = key;
        this.value = value;
    }

    public String getkey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
