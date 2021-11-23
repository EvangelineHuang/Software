import java.rmi.*;

public interface helloRemote extends Remote
{
	public String sayHello() throws RemoteException;

}
