package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	public Integer room;
	public Date checkIn;
	public Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation() {
		super();
	}

	public Reservation(Integer room, Date checkIn, Date checkOut) {
		this.room = room;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoom() {
		return room;
	}

	public void setRoom(Integer room) {
		this.room = room;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long hostingDuration() {

		long diff = checkOut.getTime() - checkIn.getTime();

		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public String updateDates(Date checkIn, Date checkOut) {
		
		Date now = new Date();

		if (checkIn.before(now) || checkOut.before(now)) {
			return "Error in reservation! Reservation dates must be future dates!";
		}

		if (!checkOut.after(checkIn)) {
			return "Error in reservation! Check-out must be after Check-in date.";
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}

	@Override
	public String toString() {

		return "Room: " + room + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut) + ", "
				+ this.hostingDuration() + " nights";
	}

}
