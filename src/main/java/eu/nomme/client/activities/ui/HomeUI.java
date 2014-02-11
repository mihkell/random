package eu.nomme.client.activities.ui;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

import eu.nomme.client.activities.ui.extra.FlowPanelMouse;
import eu.nomme.client.activities.ui.extra.OListPanel;
import eu.nomme.client.activities.ui.interfaces.IHomeUI;
import eu.nomme.resource.SiteResource;
import eu.nomme.resource.SiteResource.Menu;

public class HomeUI extends Composite implements IHomeUI {

	private static HomeUIUiBinder uiBinder = GWT.create(HomeUIUiBinder.class);

	interface HomeUIUiBinder extends UiBinder<Widget, HomeUI> {
	}

	HashMap<String, FlowPanel> mapCenterMenuItems = new HashMap<String, FlowPanel>();

	@UiField HTMLPanel htmlPanel;

	@UiField OListPanel listLeft;

	@UiField OListPanel listRight;

	SimplePanel centerRow;

	@UiField OListPanel centerMenu;

	private String[] menuNames = {"NOMME", "CATALOGUE", "ORDER", "ABOUT", "CONTACT"};

	private IHomeUIAcitvity activity;

	private int menuItemBtnSize;

	private Menu CSS;


	public HomeUI(SimplePanel centerRow) {

		initWidget(uiBinder.createAndBindUi(this));
		SiteResource.INSTANCE.menu().ensureInjected();
		CSS = SiteResource.INSTANCE.menu();
		this.centerRow = centerRow;

		menuItemBtnSize = Window.getClientWidth()/10;

		configureSideMenus();

		configureCenterRow();

	}

	public void configureSideMenus(){

		for( String name : menuNames ){

			addCenterMenuItem(name);

			listLeft.add(getMenuItem(name));

			listRight.add(getMenuItem(name));

		}

	}


	public void configureCenterRow(){

		centerRow.setWidth((Window.getClientWidth() - menuItemBtnSize * 2) + "px");

		centerRow.addStyleName(CSS.centerRow());

		ScrollPanel sPanel = new ScrollPanel(centerRow);

		sPanel.setHeight("100%");

		htmlPanel.add(sPanel);

	}


	public void addCenterMenuItem(final String name){

		final FlowPanelMouse namePanel = new FlowPanelMouse();

		mapCenterMenuItems.put(name, namePanel);

		centerMenu.add(namePanel);

		centerRow.setVisible(true);

		Label label = new Label(name.toLowerCase());
		namePanel.add(label);
		namePanel.setStyleName(CSS.menuItem());
		namePanel.addMouseOutHandler(new MouseOutHandler() {

			@Override
			public void onMouseOut(MouseOutEvent event) {
				removeVisible();
			}
		});

		namePanel.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				event.stopPropagation();
				removeVisible();

				if(activity != null) activity.goTo(name);
				else System.out.println("Activity null");
			}
		});

	}


	/*
	 * Return Menu sidemenu item with it's handlers attached 
	 */
	public FlowPanel getMenuItem(final String name){

		final FlowPanelMouse namePanel = new FlowPanelMouse();
		final Label label = new Label(name.toLowerCase());
		namePanel.add(label);
		namePanel.setWidth(menuItemBtnSize + "px");
		namePanel.setStyleName(CSS.menuItem());

		namePanel.addMouseOverHandler(new MouseOverHandler() {

			@Override
			public void onMouseOver(MouseOverEvent event) {
				// makes the horizontal central :menuItem visible.
				if(!activity.getPlace(name)){
					centerMenu.setStyleName(CSS.centerMenuFront(), true);
					mapCenterMenuItems.get(name).setStyleName(CSS.visible(), true);
				}

			}
		});

		return namePanel;

	}

	public SimplePanel getCenterPanel(){
		return centerRow;
	}


	@Override
	public void setActivity(IHomeUIAcitvity activity) {
		this.activity = activity;
	}

	@Override
	public void setCenterPanel(SimplePanel centerRow) {
		//this.centerRow = centerRow;
	}

	@Override
	public void removeVisible() {

		for(Map.Entry<String, FlowPanel> entry: mapCenterMenuItems.entrySet()){
			entry.getValue().removeStyleName(CSS.visible());
		}

		centerMenu.setStyleName(CSS.centerMenuFront(), false);


	}




}