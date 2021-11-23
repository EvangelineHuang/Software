import java.rmi.*;
import java.rmi.server.*;

public class HelloRemoteImpl extends UnicastRemoteObject implements helloRemote
{
	private static final long serialVersionUID = 1L;

	protected HelloRemoteImpl() throws RemoteException
	{
	}

	public String sayHello()
	{
		return "Hello World";
	}
	public static void main(String[] args)
	{
		try
		{
			helloRemote service = new HelloRemoteImpl();
			Naming.rebind("remoteTest", service);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
