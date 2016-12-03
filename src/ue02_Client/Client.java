package ue02_Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URL;


/**
 *
 * @author florian
 */
public class Client
{

  public Client (String url) throws IOException, InterruptedException
  {
    Socket socket = new Socket();
    URL hostURL = new URL(url);
    SocketAddress add = new InetSocketAddress(hostURL.getHost(), hostURL.getPort());
    socket.connect(add, 2000); // wartet 2000ms auf Server
    
    System.out.println("Server connected");
    
    try(BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream())))
    {
      Thread.sleep(100);
      while(br.ready())
      {
        System.out.println(br.readLine());
      }
    }
  }
  
  
  public static void main (String[] args)
  {
    try
    {
      Client c=new Client("http://127.0.0.1:4711");
    }
    catch (Exception ex)
    {
      ex.printStackTrace(System.err);
    }
  }
}
