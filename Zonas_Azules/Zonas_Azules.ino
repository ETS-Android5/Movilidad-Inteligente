#include <SoftwareSerial.h>                                      // Defina el tipo de sensor

SoftwareSerial espSerial =  SoftwareSerial(2,3);             // Arduino RX 2 y TX 3 
                               
String apiKey = "I9SFHFDDL5EJYW11";                          // Remplace con el API KEY WRITE de ThingSpeak
String ssid="Android";                             // Nombre red Wifi
String password ="ihaz5486";                      // Contraseña

//======================================================================== tiempoRespuesta
void tiempoRespuesta(int waitTime){
    long t=millis();
    char c;
    while (t+waitTime>millis()){
      if (espSerial.available()){
        c=espSerial.read();
        Serial.print(c);
      }
    }                   
}
//========================================================================

boolean thingSpeakWrite(int value1){
  String cmd = "AT+CIPSTART=\"TCP\",\"";                  // Conexión TCP
  cmd += "184.106.153.149";                               // api.thingspeak.com
  cmd += "\",80";
  espSerial.println(cmd);                                 // Mandar datos seriales al ESP8266
  Serial.println(cmd);
  if(espSerial.find("Error")){
     Serial.println("AT+CIPSTART error");
    return false;
  }  
  String getStr = "GET /update?api_key=";                  // Prepara el String GET a mandar
  getStr += apiKey;  
  getStr +="&field1=";
  getStr += String(value1);                                // Convertir de flotante a String
  getStr += "\r\n";                                        // Salto de linea
  // enviar la longitud de la cadena
  cmd = "AT+CIPSEND=";
  cmd += String(getStr.length());
  espSerial.println(cmd);                                  // Enviar datos
  Serial.println(cmd);  
  delay(1000);
  if(espSerial.find(">")){                                 // Si Ok envíe la cadena de GET
    espSerial.print(getStr);
    Serial.print(getStr);
  }
  else{
    espSerial.println("AT+CIPCLOSE");                      // Error al enviar datos
    Serial.println("AT+CIPCLOSE");
    return false;
  }
  return true;
}
//================================================================================ setup

void setup() {     
  for(int i=4; i<=8; i++){
    pinMode(i,INPUT);
  }
  Serial.begin(115200);   
  espSerial.begin(115200);  // Habilite la comunicación serial
                            //La velocidad problable del módulo ESP8266 es 115200 bauds
                            // Por esa razón se debe configurar primero esta velocidad (115200) y correr el programa las líneas de código 
                            // a continuación cambian la velocidad pero necesitan que se les quite el comentario.
                            // Corra el código con las siguientes líneas descomentadas y luego vuelva a correr pero cambiando 115200 por 
                            //9600 y volviendo a comentar las líneas  
//  espSerial.println("AT+RST");                                  // Habilite estas líneas para resetear el módulo
//  tiempoRespuesta(1000);
//  espSerial.println("AT+UART_CUR=9600,8,1,0,0");                 // Habilite estas líneas para configurar el módulo con velocidad de 9600
//  tiempoRespuesta(1000);
  
  espSerial.println("AT+CWMODE=1");                              // Configure el ESP8266 como cliente
  tiempoRespuesta(1000);
  espSerial.println("AT+CWJAP=\""+ssid+"\",\""+password+"\"");   // Configure la red y la contraseña para la conexión WIFI
  tiempoRespuesta(5000);
  Serial.println("Setup completed");
}

void loop() {
  int lectura, lectura2, n, aux, x;
  lectura=0;
  for(int i=4; i<=8; i++){
    lectura += digitalRead(i);          // Lee el sensor infrarrojo
  }

//  lectura = digitalRead(4);
  lectura2 = lectura;                 
  n = 0;
  aux = 15;    
  x = thingSpeakWrite(lectura);              // Enviar datos a ThingSpeak
                                         // Thingspeak necesita al menos 15 segundos para actualizar 
  while (lectura2 == lectura  && x == true){           // Lee cuando hay un cambio en la señal 
    lectura=0;
    for(int i=4; i<=8; i++){
      lectura += digitalRead(i);          // Lee el sensor infrarrojo
    }
    delay(1000);    
    n++;
  }
  
  if(n<15){                             // Actualice los datos cada 15 segundos
    aux -=n;
    aux *=1000; 
    delay(aux);
  }
}
