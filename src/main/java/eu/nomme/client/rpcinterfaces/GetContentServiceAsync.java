package eu.nomme.client.rpcinterfaces;

import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import eu.nomme.shared.SimpleItem;

public interface GetContentServiceAsync {

	void getGallery(AsyncCallback<Map<String, List<SimpleItem>>> callback);

}
