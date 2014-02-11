package eu.nomme.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class ContactPlace extends Place implements MyPlace {
	
	
	static String token = "contact";
	
	@Prefix("CONTACT")
	public static class Tokenizer implements PlaceTokenizer<ContactPlace>{

		@Override
		public ContactPlace getPlace(String token) {
			return new ContactPlace();
		}

		@Override
		public String getToken(ContactPlace place) {
			return token;
		}
		
		
		
		
		
	}

	@Override
	public String getPlaceToken() {
		return token;
	}
}
