package modules.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
		
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer roomNumber, Date chekIn, Date chekOut) {
	
		this.roomNumber = roomNumber;
		this.checkIn = chekIn;
		this.checkOut = chekOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getChekIn() {
		return checkIn;
	}

	public Date getChekOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
	}
	
	public void  updateDates(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut; 
	}
	
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+", Check in (dd/MM/yyyy): "
				+ sdf.format(checkIn)
				+", Check out (dd/MM/yyyy): "
				+ sdf.format(checkOut)
				+","
				+duration()
				+ " nights";
	}
}
