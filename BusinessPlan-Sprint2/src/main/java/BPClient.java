import java.rmi.*;
public class BPClient 
{
	private RemoteInterface service; 
	private BusinessPlan loadedPlan;
	
	public BPClient(int year, String name, RemoteInterface server) 
	{
			service	= server;	
			loadedPlan = service.getPlanByYear(year, name);
		
	}
	
	public void getPlanByYear(int year, String name)
	{

	}

	public void addUser(String userName, String newUserName, String newUserPassword, boolean is_admin)
	{
	
			try
			{
				service.addUser(userName, newUserName, newUserPassword,is_admin);
			} catch (RemoteException e)
			{
		
				e.printStackTrace();
			}

	}
    public void changePermission(BusinessPlan loadedPlan, String userName, boolean is_editable)
    {
		try
		{	
			service.changePermission(loadedPlan, userName, is_editable);
		}
		catch(RemoteException e)
		{
			e.printStackTrace();
		}
    }
    public void editPlan(String content, Part part)
    {
		try
		{
			service.editPlan(content, part);
		}
		catch(RemoteException e)
		{
			e.printStackTrace();
		}
    }
    public void addPlan(BusinessPlan plan) 
    {
		try
		{			
			service.addPlan(plan);
		}
		catch(RemoteException e)
		{
			e.printStackTrace();
		}
    }


	public void createNewPlan(String name, String department, int year, String planName)
	{
		BusinessPlan newPlan = null;
		if (planName == "VMOSA")
		{
			newPlan = new VMOSA(name, department, year);
		}
		else if (planName == "VMSGOA")
		{
			newPlan = new VMSGOA(name, department, year);
		}
		else if (planName == "Centre")
		{
			newPlan = new Centre(name, department, year);
		}
		
		if (newPlan != null) 
		{
			try
			{			
				service.addPlan(newPlan);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else 
		{
			System.out.println("No such BusinessP Plan, please try again!");
		}
	}


}
