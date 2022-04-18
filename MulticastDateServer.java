import java.io.*;
import java.net.*;
import java.util.Date;

public class MulticastDateServer
{
	public static void main(String[]args)throws IOException,InterruptedException
	{
		DatagramSocket socket=new DatagramSocket(5050);
		for(int i=0;i<10;i++){
			byte[]buf=new Date().toString().getBytes();
			InetAddress group=InetAddress.getByName("230.0.0.1");
			DatagramPacket packet=new DatagramPacket(buf,buf.length,group,1313);
			socket.send(packet);
			Thread.sleep(1500);
		}
		socket.close();
	}
}