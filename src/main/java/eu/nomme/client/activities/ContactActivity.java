package eu.nomme.client.activities;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import eu.nomme.client.ClientFactory;
import eu.nomme.client.activities.ui.AboutUI;
import eu.nomme.client.activities.ui.interfaces.IAboutUI;

public class ContactActivity extends AbstractActivity {
	
	private ClientFactory clientFactory;
	private IAboutUI aboutUI;


	public ContactActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		
		aboutUI = clientFactory.getAboutUI();
		
		aboutUI.setText(
				"Nomme OY \n"
				+ "Raudtee 64 \n"
				+ "11619 Tallinn\n"
				+ "Estonia\n"
				+ "\n"
				+ "Email: info@nomme.eu\n"
				+ "We will respond to your emails within 24h.\n"
				+ "\n"
				+ "Registration number: 12178186\n"
				+ "IBAN: EE111010220200363223\n"
				+ "SWIFT Code: EEUHEE2X \n");
		
		
		
		aboutUI.getImage().setUrl("/nomme.eu-contact.jpg");
		
		panel.setWidget(aboutUI);

	}

}
