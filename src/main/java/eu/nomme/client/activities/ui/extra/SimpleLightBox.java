package eu.nomme.client.activities.ui.extra;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

import eu.nomme.resource.SiteResource;
import eu.nomme.resource.SiteResource.LightBox;

public class SimpleLightBox extends Composite {

	private static SimpleLightBoxUiBinder uiBinder = GWT
			.create(SimpleLightBoxUiBinder.class);

	interface SimpleLightBoxUiBinder extends UiBinder<Widget, SimpleLightBox> {
	}

	@UiField HTMLPanel htmlPanel;

	@UiField FlowPanel thumnailContainer;

	@UiField HTML textArea;

	@UiField Image mainImage;

	@UiField FlowPanel imageContainer;

	@UiField FlowPanelMouse backBtn;

	@UiField FlowPanelMouse nextBtn;

	private PopupPanel popupPanel;

	private LightBox CSS;
	// For forward and backward movement
	private SlideImages slideImages = new SlideImages();

	public SimpleLightBox() {
		SiteResource.INSTANCE.lightBox().ensureInjected();



		CSS = SiteResource.INSTANCE.lightBox();

		this.popupPanel = new PopupPanel();

		initWidget(uiBinder.createAndBindUi(this));

		mainImageHandlers(mainImage, popupPanel);

		textArea.setText("- Design of the brooch is bent"
				+ " and combines smooth and rocky surfices. "
				+ "Tip - looks good on scarf. Designer Tonis Lukats");

		nextBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				mainImage.setUrl(slideImages.next().getUrl());

			}
		});

		backBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				mainImage.setUrl(slideImages.previous().getUrl());

			}
		});

	}

	/*
	 * Set images to be displayed.
	 */
	public void setImage(String[] imageUrls){

		thumnailContainer.clear();

		slideImages.newSet(imageUrls);

		if(imageUrls != null && imageUrls.length != 0){
			mainImage.setUrl(slideImages.getCurrentImg().getUrl());
		}else return;

		for(int i = 0; i < imageUrls.length; i++){

			String url = imageUrls[i];

			//TODO: check if url.split(".")[0]+ "-thum " + ".jpg" exists
			Image thum = new Image(url.split("\\.")[0]+ "-thum" + ".jpg");
			thum.getElement().setAttribute("data-id", ""+i );
			thum.setStyleName(CSS.thumnail());
			thumClicked(thum, i);
			thumnailContainer.add(thum);


		}
	}

	private void thumClicked(final Image img, final int i){

		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				mainImage.setUrl(slideImages.setCurrentImg(i).getUrl());

			}
		});

	}



	/*
	 * Sets the width of the image that is initially clipped to panel
	 */
	public void setPopupWidth(String width){
		mainImage.setWidth(width);

	}

	public void setText(String text){
		textArea.setText(text);
	}

	public void pop(){

		final SimpleLightBox slb = this;
		popupPanel.add(slb);
		popupPanel.setGlassEnabled(true);
		popupPanel.setAutoHideEnabled(true);
		popupPanel.setModal(true);
		popupPanel.center();
		popupPanel.setWidth("40vw");
		popupPanel.addCloseHandler(new CloseHandler<PopupPanel>() {

			@Override
			public void onClose(CloseEvent<PopupPanel> event) {
				popupPanel.remove(slb);

			}
		});

	}

	private void mainImageHandlers(Image mainImage, final PopupPanel popupPanel){

		mainImage.addLoadHandler(new LoadHandler() {

			@Override
			public void onLoad(LoadEvent event) {
				popupPanel.center();

			}
		});

	}
}
