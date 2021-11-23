import java.util.Hashtable;
import java.rmi.*;
import java.rmi.server.*;

public class BPServer extends UnicastRemoteObject implements RemoteInterface
{
	
	private static final long serialVersionUID = 1L;
	private Hashtable<String, User> userDict;
	private Hashtable<String, BusinessPlan> BPDict;
	
	protected BPServer() throws RemoteException
	{
	}
	
	public void addUser(String userName, String newUserName, String newUserPassword, boolean is_admin) 
	{
		User admin = userDict.get(userName);
		if (admin.is__admin)
		{
			User newUser = new User(newUserName, newUserPassword, admin.department, is_admin);
			userDict.put(newUserName,newUser);
		}
	}
    
	public void changePermission(BusinessPlan loadedPlan, String userName, boolean is_editable)
	{
		User admin = userDict.get(userName);
		if (admin.is__admin)
		{
			if (loadedPlan.is_editable == true)
			{
				loadedPlan.is_editable = false;
			}
			else
			{
				loadedPlan.is_editable = false;
			}
		}
		
	}

    public void editPlan(String content, Part part) 
    {
    	part.description = content;
    }
    
    public void addPlan(BusinessPlan plan) 
    {
    	BPDict.put(plan.name + Integer.toString(plan.year),  plan);
    }
    
    public static void main(String[] args)
    {
    	try {
    		RemoteInterface service = new BPServer();
    		Naming.rebind("BPService", service);		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    public BusinessPlan getPlanByYear(int year, String name)
	{
    	return BPDict.get(name+Integer.toString(year));
	}		

}



	
	

