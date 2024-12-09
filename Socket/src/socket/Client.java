
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author duong
 */
public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost",1223)){
            while (true) {
// nhap du lieu
            Scanner sc = new Scanner(System.in);
                System.out.println("Nhap so a:");
                int a = sc.nextInt();
                System.out.println("Nhap so b");
                int b = sc.nextInt();
                // gui du lieu sang server
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                output.writeInt(a);
                output.writeInt(b);
                //lay ket qua tra ve tu server
                DataInputStream input = new DataInputStream(socket.getInputStream());
                int tong=input.readInt();
                //hienthiketqua
                System.out.println("Tong 2 so a va b la :"+tong);
            break; 
                
            }
            
        } catch (Exception e) {
        }
    }
    
}

