package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class ReservationBean {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int room = sc.nextInt();

		System.out.print("Check-in Date: ");
		sc.nextLine();
		Date checkin = sdf.parse(sc.next());

		System.out.print("Check-out Date: ");
		sc.nextLine();
		Date checkout = sdf.parse(sc.next());
		
		if(!checkout.after(checkin)) {
			System.out.println("Error in reservation! Check-out must be after Check-in date.");
		} else {
			Reservation reservation = new Reservation(room, checkin, checkout);
			System.out.println("Reservation: " + reservation);
			
			System.out.println("Atualização da Reserva");
			
			System.out.print("Check-in Date: ");
			sc.nextLine();
			checkin = sdf.parse(sc.next());

			System.out.print("Check-out Date: ");
			sc.nextLine();
			checkout = sdf.parse(sc.next());
			
			String erro = reservation.updateDates(checkin, checkout);
			
			if(erro == null) {
				System.out.println("Reservation: " + reservation);
			} else {
				System.out.println("Erro in reservation: " + erro);
			}
			
		}// end else

		

		sc.close();

	}

}
