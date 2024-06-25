package org.rest.cucmber.pojo;

import java.util.List;

public class AddPlaceAPI {
	private String accuracy;
	private String name;
	private String phone_number;
	private String address;
	private String website;
	private String language;
	private List<String> types;
	private Location location;

//	public AddPlaceAPI(String accuracy, String name, String phone_number, String address, String website,
//			String language, List<String> types, double lat, double lng) {
//
//		accuracy = this.accuracy;
//		name = this.name;
//		phone_number = this.phone_number;
//		address = this.address;
//		website = this.website;
//		language = this.language;
//		types = this.types;
//		location = new Location(lat, lng);
//	}

	public String getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
