# IoT App

### Con esta aplicación, usted podrá consultar la temperatura actual de su casa, además manipular el valor de referencia de temperatura para que el sistema encienda el calefactor o el ventilador.

## Consultar Información

Endpoint  | Tipo | Descripción
------------- | ------------- |-------------
/ | GET | Bienvenida
/temperatura  | GET | Temperatura de Referencia
/temperaturaCasa  | GET | Temperatura de la Casa
/subirTemperatura?numero=  | GET | Subir Temperatura de Referencia [12-34] °c
/bajarTemperatura?numero=  | GET | Bajar Temperatura de Referencia [12-34] °c
/calefaccion  | GET | Estado del Calefactor [Apagado / Encendido]
/ventilador  | GET | Estado del Ventilador [Apagado / Encendido]
/temperaturas  | GET | 	Consultar Temperatura de Referencia y Temperatura de la Casa
/actuadores  | GET | 	Consultar Estado del Calefactor y del Ventilador
