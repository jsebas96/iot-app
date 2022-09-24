package co.edu.eafit.IoT;

import java.security.SecureRandom;

public class Casa {

    public Double temperatura = 22.0;
    private Double temperaturaCasa = 24.0;
    private final Double maxTemp = 34.0;
    private final Double minTemp = 12.0;

    SecureRandom random = new SecureRandom();

    public Double getTemperaturaCasa() {
        temperaturaCasa = 13 + (33 - 13) * random.nextDouble();
        temperaturaCasa = Math.round(temperaturaCasa * 10.0) / 10.0;
        return temperaturaCasa;
    }

    public Double subirTemperatura(Double numero) {
        Double value = Math.abs(numero);
        if (this.temperatura + value < this.maxTemp) {
            this.temperatura += value;
        } else {
            this.temperatura = this.maxTemp;
        }

        return this.temperatura;

    }

    public Double bajarTemperatura(Double numero) {
        Double value = Math.abs(numero);
        if (this.temperatura - value > this.minTemp) {
            this.temperatura -= value;
        } else {
            this.temperatura = this.minTemp;
        }

        return this.temperatura;
    }

    public String getCalefactor() {
        if (this.temperaturaCasa >= this.temperatura) {
            return "apagado";
        } else {
            return "encendido";
        }
    }

    public String getVentilador() {
        if (this.temperaturaCasa > this.temperatura) {
            return "apagado";
        } else {
            return "encendido";
        }
    }
}
