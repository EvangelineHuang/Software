
public class User
{
	public String name;
	public String password;
	public String department;
	public boolean is__admin;
	
	public User(String name, String password, String department, boolean is_admin) 
	{
		this.name = name;
		this.password = password;
		this.department = department;
		this.is__admin = is_admin;
	}
	//only for test, will not be used in practice. 
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getDepartment()
	{
		return department;
	}

	public void setDepartment(String department)
	{
		this.department = department;
	}

	public boolean isIs__admin()
	{
		return is__admin;
	}

	public void setIs__admin(boolean is__admin)
	{
		this.is__admin = is__admin;
	}
}
