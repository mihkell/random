package eu.nomme.client.activities;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.FocusPanel;

import eu.nomme.client.ClientFactory;
import eu.nomme.client.activities.ui.interfaces.IHomeUI;
import eu.nomme.client.activities.ui.interfaces.IHomeUI.IHomeUIAcitvity;
import eu.nomme.client.places.MyPlace;

public class HomeActivity extends AbstractActivity implements IHomeUIAcitvity{
	
	
	private ClientFactory clientFactory;
	private IHomeUI homeUI;


	public HomeActivity(ClientFactory clientFactory){
		this.clientFactory = clientFactory;
		
		
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		
		homeUI = clientFactory.getHomeUI();
		
		homeUI.setActivity(this);
		
		homeUI.setClicked(getPlace());
		
		panel.setWidget(homeUI);
		
		FocusPanel fMainPanel = (FocusPanel) clientFactory.getMainPanel();
		
		fMainPanel.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				homeUI.removeVisible();
				
			}
		});
		
	}

	@Override
	public void goTo(String placeName) {
		
		
		String newPlaceName = placeName.toUpperCase()+":"+ placeName.toLowerCase();
		
		Place place = clientFactory.getHistoryMapper().getPlace(newPlaceName);
		if (place == null){
			
			return;
			
		}
		homeUI.setClicked(placeName);
		clientFactory.getPlaceController().goTo(place);
		
		
	}

	/*
	 * @return is String name equal to current places token. 
	 */
	@Override
	public boolean isPlace(String name) {
		
		MyPlace currentPlace = (MyPlace) clientFactory.getPlaceController().getWhere();
		
		if(currentPlace.getPlaceToken().equals(name.toLowerCase()))
			return true;
		
		
		return false;
		
	}
	/*
	 * Returns the current places token - lowercased.
	 */
	public String getPlace(){
		
		MyPlace currentPlace = (MyPlace) clientFactory.getPlaceController().getWhere();
		
		return currentPlace.getPlaceToken();
		
		
	}
	
}
