package eu.nomme.client.activities;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import eu.nomme.client.ClientFactory;
import eu.nomme.client.activities.ui.interfaces.IOrderUI;

public class OrderActivity extends AbstractActivity {
	
	private ClientFactory clientFactory;
	private IOrderUI orderUI;

	public OrderActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
		
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		
		orderUI = clientFactory.getOrderUI();
		
		panel.setWidget(orderUI);

	}

}
