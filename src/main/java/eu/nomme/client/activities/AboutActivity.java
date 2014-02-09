package eu.nomme.client.activities;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;

import eu.nomme.client.ClientFactory;
import eu.nomme.client.activities.ui.interfaces.IAboutUI;
import eu.nomme.client.activities.ui.interfaces.IHomeUI;
import eu.nomme.client.activities.ui.interfaces.IAboutUI.AboutUIActivity;
import eu.nomme.client.activities.ui.interfaces.IHomeUI.IHomeUIAcitvity;

public class AboutActivity extends AbstractActivity implements AboutUIActivity {

	private ClientFactory clientFactory;
	private EventBus eventBus;
	private IAboutUI aboutUI;

	public AboutActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		
		this.eventBus = eventBus;
		
		aboutUI = clientFactory.getAboutUI();
		
		getText();
		
		aboutUI.setImageURL("/bg.jpg");

		panel.setWidget(aboutUI);
	}

	private void getText(){


		try {
			new RequestBuilder(RequestBuilder.GET, "/mainText.txt").sendRequest("", new RequestCallback() {


				@Override
				public void onResponseReceived(Request request, Response response) {
					aboutUI.setText(response.getText()+response.getText()+response.getText()+response.getText());

				}

				@Override
				public void onError(Request request, Throwable exception) {
					// TODO Auto-generated method stub

				}

			});
		} catch (RequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}