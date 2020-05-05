package springboot.microservices.moviecatalogservices;

public class MovieItem 
{
	private String name;
	private String description;
	public MovieItem(String name, String description) 
	{
		super();
		this.name = name;
		this.description = description;
	}
	
	public MovieItem() 
	{
		
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getDescription() 
	{
		return description;
	}
	public void setDescription(String name) 
	{
		this.name = name;
	}


}
