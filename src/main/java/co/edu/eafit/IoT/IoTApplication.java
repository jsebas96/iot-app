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
        return String.format("<style> .title { font-size: 24px; text-align: center; margin-top: 5px; margin-bottom-5px; } p {margin: auto; color: #0064F0; text-align: center;} table, th, td {border: 1px solid black;} .center {margin-top: 25px; width: 50%%; margin-left: auto; margin-right: auto;}</style> <div class=\"title\"> Bienvenido!</div> <br /> <p>Con esta aplicación, usted podrá consultar la temperatura actual de su casa, además manipular el valor de referencia de temperatura para que el sistema encienda el calefactor o el ventilador.</p> <div>"
                + "<table class=\"center\">"
                + "<tr>"
                + "<th>Endpoint</th>"
                + "<th>Tipo</th>"
                + "<th>Descripción"
                + "</th>"
                + "</tr>"
                + "<tr>"
                + "<td>/</td>"
                + "<td>GET</td>"
                + "<td>Inicio</td>"
                + "</tr>"
                + "<tr>"
                + "<td>/temperatura</td>"
                + "<td>GET</td>"
                + "<td>Temperatura de Referencia</td>"
                + "</tr>"
                + "<tr>"
                + "<td>/temperaturaCasa</td>"
                + "<td>GET</td>"
                + "<td>Temperatura de la Casa</td>"
                + "</tr>"
                + "<tr>"
                + "<td>/subirTemperatura?numero=</td>"
                + "<td>GET</td>"
                + "<td>Subir Temperatura de Referencia [12-34] °c</td>"
                + "</tr>"
                + "<tr>"
                + "<td>/bajarTemperatura?numero=</td>"
                + "<td>GET</td>"
                + "<td>Bajar Temperatura de Referencia [12-34] °c</td>"
                + "</tr>"
                + "<tr>"
                + "<td>/calefaccion</td>"
                + "<td>GET</td>"
                + "<td>Estado del Calefactor [Apagado / Encendido]</td>"
                + "</tr>"
                + "<tr>"
                + "<td>/ventilador</td>"
                + "<td>GET</td>"
                + "<td>Estado del Ventilador [Apagado / Encendido]</td>"
                + "</tr>"
                + "<tr>"
                + "<td>/temperaturas</td>"
                + "<td>GET</td>"
                + "<td>Consultar Temperatura de Referencia y Temperatura de la Casa</td>"
                + "</tr>"
                + "<tr>"
                + "<td>/actuadores</td>"
                + "<td>GET</td>"
                + "<td>Consultar Estado del Calefactor y del Ventilador</td>"
                + "</tr>"
                + "</table></div>");
    }

    @GetMapping("/temperatura")
    public String temperatura() {
        return String.format("<style>.info {font-size: 20px; position: absolute; margin: 0; top: 50%%; left: 50%%; -ms-transform: translate(-50%%, -50%%); transform: translate(-50%%, -50%%)}</style><div class=\"info\">La temperatura actual es de %s</div>", this.casa.temperatura);
    }

    @GetMapping("/temperaturaCasa")
    public String temperaturaCasa() {
        return String.format("<style>.info {font-size: 20px; position: absolute; margin: 0; top: 50%%; left: 50%%; -ms-transform: translate(-50%%, -50%%); transform: translate(-50%%, -50%%)}</style><div class=\"info\">La temperatura actual de la casa es de %s</div>", this.casa.getTemperaturaCasa());
    }

    @GetMapping("/temperaturas")
    public String getTemperaturas() {
        return String.format("<style>.info {font-size: 20px; position: absolute; margin: 0; top: 50%%; left: 50%%; -ms-transform: translate(-50%%, -50%%); transform: translate(-50%%, -50%%)}</style><div class=\"info\">La temperatura actual de la casa es de %s <br /> La temperatura actual es de %s</div>", this.casa.getTemperaturaCasa(), this.casa.temperatura);
    }

    @GetMapping("/subirTemperatura")
    public String subirTemperatura(@RequestParam(value = "numero", defaultValue = "0") Double numero) {
        return String.format("<style>.info {font-size: 20px; position: absolute; margin: 0; top: 50%%; left: 50%%; -ms-transform: translate(-50%%, -50%%); transform: translate(-50%%, -50%%)}</style><div class=\"info\">La nueva temperatura es de %s</div>", this.casa.subirTemperatura(numero));
    }

    @GetMapping("/bajarTemperatura")
    public String bajarTemperatura(@RequestParam(value = "numero", defaultValue = "0") Double numero) {
        return String.format("<style>.info {font-size: 20px; position: absolute; margin: 0; top: 50%%; left: 50%%; -ms-transform: translate(-50%%, -50%%); transform: translate(-50%%, -50%%)}</style><div class=\"info\">La nueva temperatura es de %s</div>", this.casa.bajarTemperatura(numero));
    }

    @GetMapping("/calefaccion")
    public String getCalefactor() {
        return String.format("<style>.info {font-size: 20px; position: absolute; margin: 0; top: 50%%; left: 50%%; -ms-transform: translate(-50%%, -50%%); transform: translate(-50%%, -50%%)}</style><div class=\"info\">El calefactor está %s</div>", this.casa.getCalefactor());
    }

    @GetMapping("/ventilador")
    public String getVentilador() {
        return String.format("<style>.info {font-size: 20px; position: absolute; margin: 0; top: 50%%; left: 50%%; -ms-transform: translate(-50%%, -50%%); transform: translate(-50%%, -50%%)}</style><div class=\"info\">El ventilador está %s</div>", this.casa.getVentilador());
    }

    @GetMapping("/actuadores")
    public String getActuadores() {
        return String.format("<style>.info {font-size: 20px; position: absolute; margin: 0; top: 50%%; left: 50%%; -ms-transform: translate(-50%%, -50%%); transform: translate(-50%%, -50%%)}</style><div class=\"info\">El calefactor está %s <br /> El ventilador está %s</div>", this.casa.getCalefactor(), this.casa.getVentilador());
    }

}
