package eu.nomme.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class OrderPlace extends Place implements MyPlace {
	
	
	static String token = "order";
	
	@Prefix("ORDER")
	public static class Tokenizer implements PlaceTokenizer<OrderPlace>{

		@Override
		public OrderPlace getPlace(String token) {
			
			return new OrderPlace();
		}

		@Override
		public String getToken(OrderPlace place) {
			return token;
		}
		
		
		
	}

	@Override
	public String getPlaceToken() {
		
		return token;
	}

}
