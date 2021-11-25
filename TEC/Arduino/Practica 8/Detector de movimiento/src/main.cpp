#include <Arduino.h>

void setup() {
  pinMode(A2, INPUT);
  pinMode(A3, INPUT);
}

void loop() {
  if(analogRead(A2) == 1){
    analogWrite(A3,1);
  }else{
    analogWrite(A3,0);
  }
}