package com.graillsain.graillsain.MapPage;

import android.graphics.drawable.Drawable;

import com.graillsain.graillsain.Models.Producer;

import org.osmdroid.api.IGeoPoint;
import org.osmdroid.views.overlay.OverlayItem;

public class ProducerOverlayItem extends OverlayItem {
    private Producer producer;

    public ProducerOverlayItem(String aTitle, String aSnippet, IGeoPoint aGeoPoint, Producer producer) {
        super(aTitle, aSnippet, aGeoPoint);
        this.producer = producer;
    }

    public ProducerOverlayItem(String aTitle, String aSnippet, IGeoPoint aGeoPoint) {
        super(aTitle, aSnippet, aGeoPoint);
    }

    public ProducerOverlayItem(String aUid, String aTitle, String aDescription, IGeoPoint aGeoPoint) {
        super(aUid, aTitle, aDescription, aGeoPoint);
    }

    @Override
    public Drawable getMarker(int stateBitset) {
        return super.getMarker(stateBitset);
    }

    @Override
    public void setMarker(Drawable marker) {
        super.setMarker(marker);
    }

    @Override
    public void setMarkerHotspot(HotspotPlace place) {
        super.setMarkerHotspot(place);
    }

    @Override
    public HotspotPlace getMarkerHotspot() {
        return super.getMarkerHotspot();
    }

    @Override
    public Drawable getDrawable() {
        return super.getDrawable();
    }

    @Override
    public int getWidth() {
        return super.getWidth();
    }

    @Override
    public int getHeight() {
        return super.getHeight();
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
}
