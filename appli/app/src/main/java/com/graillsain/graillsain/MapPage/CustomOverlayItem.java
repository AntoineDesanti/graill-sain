package com.graillsain.graillsain.MapPage;

import org.osmdroid.api.IGeoPoint;
import org.osmdroid.views.overlay.OverlayItem;

public class CustomOverlayItem extends OverlayItem {
    public CustomOverlayItem(String aTitle, String aSnippet, IGeoPoint aGeoPoint) {
        super(aTitle, aSnippet, aGeoPoint);
    }

    public CustomOverlayItem(String aUid, String aTitle, String aDescription, IGeoPoint aGeoPoint) {
        super(aUid, aTitle, aDescription, aGeoPoint);
    }
}
