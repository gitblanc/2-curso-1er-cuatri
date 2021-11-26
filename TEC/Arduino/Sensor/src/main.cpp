#include <Arduino.h>
const int Trigger = 2;
const int Echo = 3;

void setup() {
  Serial.begin(9600);
  pinMode(Trigger, OUTPUT);
  pinMode(Echo, INPUT);
  digitalWrite(Trigger, LOW);
}

void loop() {
  int velocidad_sonido = 340;
  int tiempo_echo_a_nivel_alto = Echo;
  float distancia = velocidad_sonido * tiempo_echo_a_nivel_alto * 1/2;
  float comprueba_distancia =  0.034 * tiempo_echo_a_nivel_alto * 0.5;
  Serial.println("Distancia: ");
  Serial.println(distancia);
  Serial.println("Comprueba Distancia: ");
  Serial.println(comprueba_distancia);
}