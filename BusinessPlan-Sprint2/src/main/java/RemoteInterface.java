import java.rmi.*;
public interface RemoteInterface extends Remote
{
	
	public void addUser(String userName, String newUserName, String newUserPassword, boolean is_admin) throws RemoteException;
            
	public void changePermission(BusinessPlan loadedPlan, String userName, boolean editable) throws RemoteException;

    public void editPlan(String content, Part part) throws RemoteException;
    
    public void addPlan(BusinessPlan plan) throws RemoteException;

	public BusinessPlan getPlanByYear(int year, String name);

}
