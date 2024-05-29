package resources;

import pojo.AddBooker;
import pojo.BookingDates;

public class TestData2{

	
	
	public AddBooker addBookerLoad(String firstname, String lastname, String depositpaid,String additionalneeds)
	{
		AddBooker b =new AddBooker();
		b.setFirstname(firstname);
		b.setLastname(lastname);
		b.setDepositpaid(depositpaid);
		b.setAdditionalneeds(additionalneeds);
		b.setTotalprice(111);
		
		
		BookingDates booking =new BookingDates();
		booking.setCheckin("2018-01-01");
		booking.setCheckout("2019-01-01");
		b.setBookingdates(booking);
		return b;
	}
	
//	public String deletePlacePayload(String placeId)
//	{
//		return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
//	}
}
