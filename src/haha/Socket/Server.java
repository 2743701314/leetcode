package haha.Socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8888);
        System.out.println("监听端口号8888");
        Socket s = socket.accept();
        System.out.println("有链接过来"+ s);
        s.close();
        socket.close();
    }
}
