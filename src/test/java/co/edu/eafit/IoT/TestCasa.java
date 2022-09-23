package co.edu.eafit.IoT;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//Pruebas unitarias del proyecto
public class TestCasa {

    //Pruebas unitarias para temperatura
    @Test
    public void testTemperaturaBase() {
        Casa casa = new Casa();
        assertEquals(22.0, casa.temperatura);
    }

    @Test
    public void testTemperaturaUno() {
        Casa casa = new Casa();
        assertEquals(23.0, casa.subirTemperatura(1.0));
    }

    @Test
    public void testTemperaturaMenosUno() {
        Casa casa = new Casa();
        assertEquals(21.0, casa.bajarTemperatura(1.0));
    }

    @Test
    public void testSubirTemperaturaNegativo() {
        Casa casa = new Casa();
        assertEquals(23.0, casa.subirTemperatura(-1.0));
    }

    @Test
    public void testBajarTemperaturaNegativo() {
        Casa casa = new Casa();
        assertEquals(21.0, casa.bajarTemperatura(-1.0));
    }

}
