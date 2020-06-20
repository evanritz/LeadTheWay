
int sect1 = 13;
int sect2 = 12;
int sect3 = 11;
int sectarr[] = {sect1, sect2, sect3};

// the setup function runs once when you press reset or power the board
void setup() {
  // initialize digital pin LED_BUILTIN as an output.
  pinMode(sect1, OUTPUT);
  pinMode(sect2, OUTPUT);
  pinMode(sect3, OUTPUT);
}

// the loop function runs over and over again forever
void loop() {
  for (int i = 0; i < sizeof(sectarr); i++){
    digitalWrite(sectarr[i], HIGH);   // turn the LED on (HIGH is the voltage level)
    delay(1000);                       // wait for a second
    digitalWrite(sectarr[i], LOW);    // turn the LED off by making the voltage LOW
    delay(1000);                       // wait for a second
  }
}
