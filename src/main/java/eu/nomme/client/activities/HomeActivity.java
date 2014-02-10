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

public class HomeActivity extends AbstractActivity implements IHomeUIAcitvity{
	
	
	private ClientFactory clientFactory;
	private EventBus eventBus;
	private IHomeUI homeUI;


	public HomeActivity(ClientFactory clientFactory){
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		
		this.eventBus = eventBus;
		
		homeUI = clientFactory.getHomeUI();
		
		homeUI.setActivity(this);
		
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
		
		
		placeName = placeName.toUpperCase()+":"+ placeName.toLowerCase();
		
		System.out.println("goTo(" + placeName +")");
		
		Place place = clientFactory.getHistoryMapper().getPlace(placeName);
		if (place == null){
			
			return;
			
		}
		
		clientFactory.getPlaceController().goTo(place);
		
		
	}

}
