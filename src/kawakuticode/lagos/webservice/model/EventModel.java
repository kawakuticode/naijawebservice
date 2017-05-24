package kawakuticode.lagos.webservice.model;

import java.util.Date;

public class EventModel {
	Date event_date; 
	String event_name,
	type_of_event,  
	time_start, 
	time_end, place , 
	adress, city,  
	organizer_name, 
    organizer_telephone, 
    organizer_email, 
    link_to_event;
	public Date getEvent_date() {
		return event_date;
	}
	public void setEvent_date(Date event_date) {
		this.event_date = event_date;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public String getType_of_event() {
		return type_of_event;
	}
	public void setType_of_event(String type_of_event) {
		this.type_of_event = type_of_event;
	}
	public String getTime_start() {
		return time_start;
	}
	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}
	public String getTime_end() {
		return time_end;
	}
	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getOrganizer_name() {
		return organizer_name;
	}
	public void setOrganizer_name(String organizer_name) {
		this.organizer_name = organizer_name;
	}
	public String getOrganizer_telephone() {
		return organizer_telephone;
	}
	public void setOrganizer_telephone(String organizer_telephone) {
		this.organizer_telephone = organizer_telephone;
	}
	public String getOrganizer_email() {
		return organizer_email;
	}
	public void setOrganizer_email(String organizer_email) {
		this.organizer_email = organizer_email;
	}
	public String getLink_to_event() {
		return link_to_event;
	}
	public void setLink_to_event(String link_to_event) {
		this.link_to_event = link_to_event;
	}
	@Override
	public String toString() {
		return "EventModel [event_date=" + event_date + ", event_name=" + event_name + ", type_of_event="
				+ type_of_event + ", time_start=" + time_start + ", time_end=" + time_end + ", place=" + place
				+ ", adress=" + adress + ", city=" + city + ", organizer_name=" + organizer_name
				+ ", organizer_telephone=" + organizer_telephone + ", organizer_email=" + organizer_email
				+ ", link_to_event=" + link_to_event + "]";
	}
	
	
	
	


}
