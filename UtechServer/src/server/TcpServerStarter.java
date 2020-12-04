package server;

import java.io.IOException;

public final class TcpServerStarter {

    public static void main(String[] args){
          try{
                TcpServer tcpServer = new TcpServer();
                tcpServer.start();
          }
          catch(IOException e){
                e.printStackTrace();
          }
    }
}
