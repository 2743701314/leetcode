package haha;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Net {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress host = InetAddress.getLocalHost();
        String ip = host.getHostAddress();
        System.out.println(ip);
    }
}
