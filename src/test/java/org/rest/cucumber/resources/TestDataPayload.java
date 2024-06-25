package org.rest.cucumber.resources;

import java.util.ArrayList;
import java.util.List;

import org.rest.cucmber.pojo.AddPlaceAPI;
import org.rest.cucmber.pojo.DeletePlaceAPI;
import org.rest.cucmber.pojo.Location;
import org.rest.cucmber.pojo.UpdatePlaceAPI;

public class TestDataPayload {

	AddPlaceAPI p = new AddPlaceAPI();
	UpdatePlaceAPI u = new UpdatePlaceAPI();
	DeletePlaceAPI d = new DeletePlaceAPI();
	Location l = new Location();
	List<String> list = new ArrayList<>();

	public AddPlaceAPI testDataA(String name, String language, String address) {
		p.setAccuracy("50");
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("http://google.com");

		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);

		list.add("shoe park");
		list.add("shop");
		p.setTypes(list);

		p.setName(name);
		p.setAddress(address);
		p.setLanguage(language);

		return p;
	}

	public UpdatePlaceAPI testDataU(String place_id, String address, String key) {

		u.setPlace_id(place_id);
		u.setAddress(address);
		u.setKey(key);

		return u;
	}

	public DeletePlaceAPI testDataD(String place_id) {

		d.setPlace_id(place_id);

		return d;
	}

}
