package co.edu.eafit.IoT;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

//Pruebas de integración
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    
    @Test
    public void testSaludoPorDefecto() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port,
                String.class)).contains("Bienvenido!");
    }
    
    @Test
    public void testTemperaturaPorDefecto() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/temperatura",
                String.class)).containsPattern("La temperatura actual es de 22.0");
    }
    
    @Test
    public void testTemperaturaMaxima() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/subirTemperatura?numero=100",
                String.class)).containsPattern("La nueva temperatura es de 34.0");
    }
    
    @Test
    public void testTemperaturaMinima() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/bajarTemperatura?numero=100",
                String.class)).containsPattern("La nueva temperatura es de 12.0");
    }
    
    @Test
    public void testStateCalefactor() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/calefaccion",
                String.class)).containsAnyOf("apagado", "encendido");
    }
    
    @Test
    public void testStateVentilador() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/ventilador",
                String.class)).containsAnyOf("apagado", "encendido");
    }
}
