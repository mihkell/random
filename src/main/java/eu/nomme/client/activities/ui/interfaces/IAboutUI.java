package eu.nomme.client.activities.ui.interfaces;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;

public interface IAboutUI extends IsWidget {
	
	public interface AboutUIActivity{
		
		
	}
	
	void setActivity(AboutUIActivity activity);
	
	void setImageURL(String url);
	
	void setText(String text);

	Image getImage();

	HTML getTextBox();

	void setImage(ImageResource image);
}
