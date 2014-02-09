package eu.nomme.client.activities.ui.extra;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.dom.client.OListElement;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Widget;


/*
 * Got this code from
 * http://stackoverflow.com/questions/3685680/how-to-mix-html-with-gwt-widgets
 * 
 */
public class OListPanel extends ComplexPanel {

	final OListElement ol = Document.get().createOLElement();

	public OListPanel() {
	    setElement(ol);
	}

	public void add(Widget w) {
	    LIElement li = Document.get().createLIElement();
	    ol.appendChild(li);
	    add(w, (Element)li.cast());
	}

	public void insert(Widget w, int beforeIndex) {
	    checkIndexBoundsForInsertion(beforeIndex);

	    LIElement li = Document.get().createLIElement();
	    ol.insertBefore(li, ol.getChild(beforeIndex));
	    insert(w, (Element)li.cast(), beforeIndex, false);
	}

	public boolean remove(Widget w) {
	    Element li = DOM.getParent(w.getElement());
	    boolean removed = super.remove(w);
	    if (removed) {
	        ol.removeChild(li);
	    }
	    return removed;
	}
	}
