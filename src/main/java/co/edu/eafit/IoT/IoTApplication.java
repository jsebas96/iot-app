package co.edu.eafit.IoT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class IoTApplication {

	Casa casa = new Casa();

	public static void main(String[] args) {
		SpringApplication.run(IoTApplication.class, args);
	}

	@GetMapping("/")
    public String index() {
        return String.format("Bienvenido!");
    }

	@GetMapping("/temperatura")
    public String temperatura() {
        return String.format("La temperatura actual es de %s!", this.casa.temperatura);
    }

	@GetMapping("/subirTemperatura")
    public String subirTemperatura(@RequestParam(value = "numero", defaultValue = "0") Double numero) {
		;
        return String.format("La nueva temperatura es de %s!", this.casa.subirTemperatura(numero));
    }

	@GetMapping("/bajarTemperatura")
    public String bajarTemperatura(@RequestParam(value = "numero", defaultValue = "0") Double numero) {
		
        return String.format("La nueva temperatura es de %s!", this.casa.bajarTemperatura(numero));
    }

}
