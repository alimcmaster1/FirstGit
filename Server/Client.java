package Server;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by alistair on 06/08/17.
 */
public class Client {

    public static void main(String []args){
        try{

            Socket echosocket = new Socket("localhost", 8000);
            DataOutputStream os = new DataOutputStream(echosocket.getOutputStream());
            DataInputStream is = new DataInputStream(echosocket.getInputStream());

            System.out.println("Enter Data:");
            Scanner reader = new Scanner(System.in);
            String line = reader.next();
            System.out.println(line + "" + "echo data");
            os.writeUTF(line);
            String response;
            while( (response = is.readUTF()) != null){
                System.out.println("Server: " + response);
            }

        }catch(IOException e){
            System.out.print(e.getMessage());
        }
    }
}
