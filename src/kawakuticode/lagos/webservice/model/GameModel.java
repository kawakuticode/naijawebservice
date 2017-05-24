package kawakuticode.lagos.webservice.model;

import java.util.Date;

public class GameModel {
	Date game_date; 
	String game_name , 
	    type_of_game, 
	    time_start, 
	    time_end, 
	    place ,
	    address,  
	    city , 
	    organizer_name, 
	    organizer_telephone, 
	    organizer_email;
	public Date getGame_date() {
		return game_date;
	}
	public void setGame_date(Date game_date) {
		this.game_date = game_date;
	}
	public String getGame_name() {
		return game_name;
	}
	public void setGame_name(String game_name) {
		this.game_name = game_name;
	}
	public String getType_of_game() {
		return type_of_game;
	}
	public void setType_of_game(String type_of_game) {
		this.type_of_game = type_of_game;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	@Override
	public String toString() {
		return "GameModel [game_date=" + game_date + ", game_name=" + game_name + ", type_of_game=" + type_of_game
				+ ", time_start=" + time_start + ", time_end=" + time_end + ", place=" + place + ", address=" + address
				+ ", city=" + city + ", organizer_name=" + organizer_name + ", organizer_telephone="
				+ organizer_telephone + ", organizer_email=" + organizer_email + "]";
	}
	
	
	

	
}
