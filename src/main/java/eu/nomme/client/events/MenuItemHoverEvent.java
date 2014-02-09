package eu.nomme.client.events;


import com.google.gwt.event.shared.GwtEvent;

public class MenuItemHoverEvent extends GwtEvent<MenuItemHoverEventHandler> {

	public static Type<MenuItemHoverEventHandler> TYPE = new Type<MenuItemHoverEventHandler>();
	
	@Override
	public Type<MenuItemHoverEventHandler> getAssociatedType() {
		
		return TYPE;
	}

	@Override
	protected void dispatch(MenuItemHoverEventHandler handler) {
		handler.onMouseHover(this);

	}

}
