import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class NetworkListener implements Runnable {

    Socket socket;
    private boolean running = false;

    private Window _window;

    public NetworkListener(Window window){
        _window = window;
    }

    @Override
    public void run() {
        running = true;
        try {
            socket = new Socket("localhost", 8192);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(running){
            try{
                InputStream inputStream = socket.getInputStream();
                _window.canvas._worldImg = ImageIO.read(inputStream);
                _window.render();
                while (inputStream.available() > 0) {
                    inputStream.read();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            if(socket.isClosed()){
                System.out.println("Closed!");
            }
        }
    }
    public static void main(String[] args) {
        new Window();
    }
}
