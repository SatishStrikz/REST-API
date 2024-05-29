package resources;
//enum is special class in java which has collection of constants or  methods
public enum ResouresOfAPI {
	
	AddAuthAPI("/auth"),
	getBookerAPI("/booking"),
	AddBookerAPI("/booking");
	//deletePlaceAPI("/maps/api/place/delete/json");
	private String resource;
	
	ResouresOfAPI(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	

}
