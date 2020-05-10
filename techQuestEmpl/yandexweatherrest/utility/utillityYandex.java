package utility;


import java.time.LocalDate;



public class utillityYandex {
	
	public String today() {
	  	String today = LocalDate.now().toString();
	  	return today;
	}
	  	
	 public String tomorrow() {
		  	String tomorrow = LocalDate.now().plusDays(1).toString();
		  	return tomorrow;
	 }
	 
	 
	private static final String seasons[] = {
			  "winter", "winter", "spring", "spring", "spring", "summer", 
			  "summer", "summer", "fall", "fall", "fall", "winter"
			};
  

	
	public String season (String today) {
		String[] parts = today.split("-");
		int mounth = Integer.parseInt(parts[1])-1;
		String season = seasons[mounth];
		return season;
	}

}
