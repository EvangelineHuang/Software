import java.rmi.*;
public class helloRemoteClient
{
	public static void main(String[] args)
	{
		new helloRemoteClient().go();
	}
	public void go()
	{
		try
		{
			helloRemote service = (helloRemote) Naming.lookup("rmi://127.0.0.1/remoteTest");
			
			String s = service.sayHello();
			System.out.println(s);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
