package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class ReservationBean {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Room number: ");
			int room = sc.nextInt();

			System.out.print("Check-in Date (dd/MM/yyyy): ");
			sc.nextLine();
			Date checkin = sdf.parse(sc.next());

			System.out.print("Check-out Date (dd/MM/yyyy): ");
			sc.nextLine();
			Date checkout = sdf.parse(sc.next());

			Reservation reservation = new Reservation(room, checkin, checkout);
			System.out.println("Reservation: " + reservation);

			System.out.println("Atualização da Reserva");

			System.out.print("Check-in Date (dd/MM/yyyy): ");
			sc.nextLine();
			checkin = sdf.parse(sc.next());

			System.out.print("Check-out Date (dd/MM/yyyy): ");
			sc.nextLine();
			checkout = sdf.parse(sc.next());

			reservation.updateDates(checkin, checkout);

			System.out.println("Reservation: " + reservation);
		} catch (ParseException e) {
			System.err.println("Invalid date format.");
		} catch (DomainException e) {
			System.err.println("Error in reservation! " + e.getMessage());
		} catch (RuntimeException e) {
			System.err.println("Unexpected error!");
		} finally {
			sc.close();
		}

	}

}
