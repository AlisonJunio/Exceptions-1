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
	
	public String updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			return "Error in reservation: Reservation dates for update must be future dates";
		} 
		if (!checkOut.after(checkIn)) {
		return "Check-out date must be after check in date!";
		} else {
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
		}
	}
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+", Check in : "
				+ sdf.format(checkIn)
				+", Check out : "
				+ sdf.format(checkOut)
				+","
				+duration()
				+ " nights";
	}
}
