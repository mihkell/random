package eu.nomme.client.activities.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import eu.nomme.client.activities.ui.interfaces.IAboutUI;

public class AboutUI extends Composite implements IAboutUI {

	private static AboutUIUiBinder uiBinder = GWT.create(AboutUIUiBinder.class);

	interface AboutUIUiBinder extends UiBinder<Widget, AboutUI> {
	}

	@UiField HTML textBox;
	
	@UiField HTMLPanel htmlPanel;

	private AboutUIActivity activity;

	@UiField Image image;
	
	public AboutUI() {
		initWidget(uiBinder.createAndBindUi(this));
		getTextBox().setStyleName("textBox");
		getImage().setStyleName("textImage");
	}

	@Override
	public void setActivity(AboutUIActivity activity) {
		this.activity = activity;
		
	}

	@Override
	public void setImageURL(String url) {
		this.getImage().setUrl(url);
		
	}

	@Override
	public void setText(String text) {
		getTextBox().setText(text);
		
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public HTML getTextBox() {
		return textBox;
	}

	public void setTextBox(HTML textBox) {
		this.textBox = textBox;
	}

}
