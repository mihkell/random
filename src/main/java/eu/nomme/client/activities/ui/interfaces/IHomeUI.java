package eu.nomme.client.activities.ui.interfaces;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;

public interface IHomeUI extends IsWidget {
	
	public interface IHomeUIAcitvity{
		void goTo(String place);

	}

	public SimplePanel getCenterPanel();
	
	void setActivity(IHomeUIAcitvity activity);
	
	void setCenterPanel(SimplePanel centerRow);
	
	void removeVisible();

}
