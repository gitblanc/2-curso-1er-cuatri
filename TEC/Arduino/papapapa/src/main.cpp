#include <Arduino.h>
const int Trigger = 12;
const int Echo = 13;

void setup() {
  Serial.begin(9600);
  pinMode(Trigger, OUTPUT);
  pinMode(Echo, INPUT);
  digitalWrite(Trigger, LOW);
}

void loop() {
  digitalWrite(Trigger, HIGH);
  delayMicroseconds(10);          //Enviamos un pulso de 10us
  digitalWrite(Trigger, LOW);
  long t = pulseIn(Echo, HIGH); //obtenemos el ancho del pulso
  long d = 0.034 * t * 1/2 /100;          //escalamos el tiempo a una distancia en cm
  Serial.println("Distancia: ");
  Serial.println(d);
  delay(1000);
}