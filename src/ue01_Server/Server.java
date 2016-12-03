package ue01_Server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Server
{
  public Server (int port) throws IOException, InterruptedException
  {
    ServerSocket ss=new ServerSocket(port);
    System.out.println("Server auf Port "+port+" geöffnet");
    
    Socket socket=ss.accept();//öffnet Server und wartet bis ein Client ein Connect macht und liefert den Socket des Clients zurück
    System.out.println("Verbindung hergestellt mit "+socket);
    
    OutputStream os = socket.getOutputStream();
    BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(os));
    
    //bw.write("Hallo!"); //es aknn auch ein HTML-String gesendet werden
    
    //Verbindungsaufnahme:
    bw.write("HTTP / 1.1 200 OK\n");
    bw.write("Content-Type: text/html\n\n");
    Thread.sleep(10);
    
    //HTML-Datei:
    bw.write("<!DOCTYPE html>\n" +
              "<body> Hallo </body>\n\n");
    bw.flush();
    Thread.sleep(10);
    
    
    bw.close();
    
    ss.close();
  }
  
  public static void main (String[] args)
  {
    try
    {
      Server server=new Server(4711);
    }
    catch (Exception ex)
    {
      ex.printStackTrace(System.err);
    }
  }
}
