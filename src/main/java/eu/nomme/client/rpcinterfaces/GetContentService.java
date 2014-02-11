package eu.nomme.client.rpcinterfaces;

import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import eu.nomme.shared.SimpleItem;
@RemoteServiceRelativePath("getcontentservice")
public interface GetContentService extends RemoteService {

	Map<String, List<SimpleItem>>getGallery();
	
}
