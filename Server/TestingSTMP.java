package Server;

import java.net.*;
import java.io.*;

/**
 * Created by alistair on 06/08/17.
 */
public class TestingSTMP {
    public static void main(String args []){
        ServerSocket echoServer = null;
        String line;
        DataInputStream is;
        DataOutputStream os;
        Socket clientSocket = null;

        try{
            echoServer = new ServerSocket(8000 );
        }catch( IOException e ){
            System.out.println(e);
        }


        try{
            clientSocket = echoServer.accept();
            is = new DataInputStream(clientSocket.getInputStream());
            os = new DataOutputStream(clientSocket.getOutputStream());

            while(true){
                line = is.readUTF();
                os.writeUTF(line + "Server Echo");
            }


        }catch( IOException e ){
            System.out.println(e);
        }

    }

}
