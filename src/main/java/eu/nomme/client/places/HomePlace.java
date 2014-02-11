package eu.nomme.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class HomePlace extends Place implements MyPlace{
	
	
	static String token = "nomme";
	
	@Prefix("NOMME")
    public static class Tokenizer implements PlaceTokenizer<HomePlace> {
    	
        @Override
        public String getToken(HomePlace place) {
            return token;
        }

        @Override
        public HomePlace getPlace(String token) {
            return new HomePlace();
        }
    }

	@Override
	public String getPlaceToken() {
		return token;
	}
	

}
