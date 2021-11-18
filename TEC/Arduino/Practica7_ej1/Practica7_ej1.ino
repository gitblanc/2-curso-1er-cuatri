void setup() {
  pinMode(A0,INPUT);
  Serial.begin(9600);//velocidad de refresco

}

void loop() {
  float valor = (float) analogRead(A0);
  float voltaje = (valor*5.0)/1023.0;
  float resistance = (50000.0-voltaje*10000.0)/voltaje;
  float temperature = 1/((1.0/298.0)+(1.0/3977.0)*log(resistance/10000.0));
  float celsius = temperature-273.15;
  Serial.println("VOLTAJE");
  Serial.println(voltaje);
  Serial.println("RESISTENCIA");
  Serial.println(resistance);
  Serial.println("TEMPERATURA");
  Serial.println(celsius);
  delay(1000);
}
