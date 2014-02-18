package eu.nomme.client.activities;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import eu.nomme.client.ClientFactory;
import eu.nomme.client.activities.ui.interfaces.IAboutUI;
import eu.nomme.client.activities.ui.interfaces.IAboutUI.AboutUIActivity;
import eu.nomme.resource.SiteResource;

public class AboutActivity extends AbstractActivity implements AboutUIActivity {

	private ClientFactory clientFactory;
	private IAboutUI aboutUI;

	public AboutActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {

		aboutUI = clientFactory.getAboutUI();

		getText();

		aboutUI.setImage(SiteResource.INSTANCE.aboutimg());

		panel.setWidget(aboutUI);
	}

	private void getText(){
		aboutUI.setText(SiteResource.INSTANCE.aboutText().getText());
	}


}
