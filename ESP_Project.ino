#include <HTTPClient.h>
#include <WiFi.h>


HTTPClient client;

NetworkServer server(80);

void setup() {
  // put your setup code here, to run once:
  pinMode(23, INPUT);
  pinMode(22, OUTPUT);
  pinMode(18, OUTPUT);


  Serial.begin(115200);
  WiFi.begin("Redmi Note 8", "12345678");

  while (WiFi.status() != WL_CONNECTED) {
    Serial.print('.');
    delay(1000);
  }

  delay(1000);
  Serial.println("Connected to WiFi!");

  server.begin();
  Serial.println("Server Started");
  Serial.println(WiFi.localIP());

}



void sendTemp(String status) {
  client.begin("https://335f-175-157-50-131.ngrok-free.app/ESEProject/server?status=" + String(status));
  client.GET();
}

int x = 0;
int lightStatus=0;

void loop() {
  // alarm system
  int val = digitalRead(23);
  if (val == 1) {
    digitalWrite(22, HIGH);
    if (x == 0) {
      sendTemp("yes");
      x = 1;
    }

  } else{
    digitalWrite(22, LOW);
    if (x == 1) {
      sendTemp("no");
      x = 0;
    }
  }

// light controle

   NetworkClient client = server.accept();  

  if (client) {                     
    Serial.println("New Client.");  
    String currentLine = "";        
    while (client.connected()) {   
      if (client.available()) {     
        char c = client.read();    
        Serial.write(c);            
        if (c == '\n') {            

         
          if (currentLine.length() == 0) {
         
            client.println("HTTP/1.1 200 OK");
            client.println("Content-type:text/html");
            client.println();

            client.print("Click <a href=\"/H\">here</a> to turn the LED on pin 5 on.<br>");
            client.print("Click <a href=\"/L\">here</a> to turn the LED on pin 5 off.<br>");

            client.println();
            break;
          } else {  
            currentLine = "";
          }
        } else if (c != '\r') {  
          currentLine += c;     
        }

        if (currentLine.endsWith("GET /H")) {
          digitalWrite(18, HIGH);  
        }
        if (currentLine.endsWith("GET /L")) {
          digitalWrite(18, LOW); 
        }
      }
    }
    client.stop();
    Serial.println("Client Disconnected.");
  }


}
