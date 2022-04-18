import java.io.*;
import java.net.*;
import java.util.Date;

public class MulticastDateClient{
	public static void main(String[] args) throws IOException{
		MulticastSocket socket=new MulticastSocket(1313);
		InetAddress group=InetAddress.getByName("230.0.0.1");
		socket.joinGroup(group);
		for(int i=0;i<10;i++){
			byte[] buf=new byte[256];
			DatagramPacket packet=new DatagramPacket(buf,buf.length);
			socket.receive(packet);
			String received=new String(packet.getData());
			System.out.println("Current server time"+received);
		}
		socket.leaveGroup(group);
		socket.close();
	}
}