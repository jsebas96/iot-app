package co.edu.eafit.IoT;

public class Casa {

    public Double temperatura = 22.0;

    private Double maxTemp = 34.0;
    private Double minTemp = 12.0;

    public Double subirTemperatura(Double numero) {
        Double value = Math.abs(numero);
        if (this.temperatura + value < this.maxTemp){
            this.temperatura+= value;
        }            
        else {
            this.temperatura = this.maxTemp;
        }

        return this.temperatura;
            
    }
    
    public Double bajarTemperatura(Double numero) {
        Double value = Math.abs(numero);
        if (this.temperatura - value > this.minTemp){
            this.temperatura-= value;
        }
        else {
            this.temperatura = this.minTemp;
        }           
        
        return this.temperatura;
    }
}