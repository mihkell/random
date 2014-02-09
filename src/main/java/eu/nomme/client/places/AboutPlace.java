package eu.nomme.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class AboutPlace extends Place {
	
	@Prefix("ABOUT")
	public static class Tokenizer implements PlaceTokenizer<AboutPlace>{

		@Override
		public AboutPlace getPlace(String token) {
			
			return new AboutPlace();
		}

		@Override
		public String getToken(AboutPlace place) {
			return "about";
		}
		
		
	}

}
