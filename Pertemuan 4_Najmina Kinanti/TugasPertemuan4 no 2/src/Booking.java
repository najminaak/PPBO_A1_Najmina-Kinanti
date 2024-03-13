import java.util.Random;

public class Booking {
    int bookid;
    Film film;
    int numberOfTickets;

    Booking(Film film, int numberOfTickets) {
        this.bookid = generateBookid();
        this.film = film;
        this.numberOfTickets = numberOfTickets;
    }

    int generateBookid() {
        return new Random().nextInt(999);
    }

    @Override
    public String toString() {
        return "Booking ID: " + bookid + ", Film: " + film.title + ", Number of Tickets: " + numberOfTickets;
    }
}
