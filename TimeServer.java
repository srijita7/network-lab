import java.io.*;
import java.net.*;
import java.util.Date;
public class TimeServer
{
	public static void main(String[] args) throws IOException
	{
		ServerSocket servSock=null;
		ObjectInputStream timeIn=null;
		try
		{
			servSock=new ServerSocket(1313);
		}
		catch(IOException e)
		{
			System.err.println("could not listen on port : 1313");
			System.exit(1);
		}
		Socket clntSock=null;
		for(;;)
		{
			try
			{
				clntSock=servSock.accept();
			}
			catch(IOException e)
			{
				System.out.println("Accept failed");
				System.exit(1);
			}
			ObjectOutputStream timeOut=new ObjectOutputStream(clntSock.getOutputStream());
			timeOut.writeObject(new Date());
			timeOut.close();
			clntSock.close();
		}
	}
}
	