import java.util.ArrayList;

public class MovieApp {
    ArrayList<Film> listFilm = new ArrayList<>();

    void addFilm(Film film) {
        listFilm.add(film);
    }

    void displayAllFilms() {
        if (listFilm.isEmpty()) {
            System.out.println("Daftar film kosong.");
        } else {
            System.out.println("List of Films:");
            for (Film film : listFilm) {
                System.out.println(film.title + " - " + film.genre + " - Duration: " + film.duration + " mins - Available Seats: " + film.availableSeats);
            }
        }
    }

    void searchFilm(String title) {
        for (Film film : listFilm) {
            if (film.title.equals(title)) {
                System.out.println("Film Tersedia");
                return;
            }
        }
        System.out.println("Film Tidak Tersedia");
    }

    void bookFilm(Film film, int numberOfTickets) {
        if (film.availableSeats >= numberOfTickets) {
            Booking booking = new Booking(film, numberOfTickets);
            System.out.println("Pesanan berhasil dengan detail pesanan:");
            System.out.println("Film: " + film.title);
            System.out.println("Jumlah Tiket: " + numberOfTickets);
            System.out.println("Booking ID: " + booking.bookid);
            film.availableSeats -= numberOfTickets;
        } else {
            System.out.println("Pesanan tidak dapat diproses. Kursi tidak tersedia.");
        }
    }

    void searchBooking(int bookid) {
        for (Film film : listFilm) {
            if (film.bookid == bookid) {
                System.out.println("Pesanan Ditemukan");
                return;
            }
        }
        System.out.println("Pesanan Tidak Ditemukan");
    }
}
