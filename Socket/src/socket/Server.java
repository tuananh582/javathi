/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author duong
 */
public class Server {
     public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1223);
        System.out.println("Sever đang chạy........");
        try {
            // đợi Client vào
            Socket socket = server.accept();
            System.out.println("Client đã vào");
            // lấy dữ liệu từ Client
            DataInputStream input = new DataInputStream(socket.getInputStream());
            int a = input.readInt();
            int b = input.readInt();
            // tinh toan
            int tong = a+b;
            // tra du lieu ve Client
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            output.writeInt(tong);
            socket.close();
            System.out.println("Đã xử lí xong");
            
            
            
        } catch (Exception e) {
        }
        
    }
    
}
