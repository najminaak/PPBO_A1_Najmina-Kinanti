public class Main {
    public static void main(String[] args) {
        MovieApp movieApp = new MovieApp();

        Film avenger = new Film("Avengers", "Action", 180, 50);
        Film joker = new Film("Joker", "Drama", 112, 60);
        movieApp.addFilm(avenger);
        movieApp.addFilm(joker);

        movieApp.displayAllFilms();

        System.out.println();

        movieApp.searchFilm("Joker");
        movieApp.searchFilm("Harry Potter");

        System.out.println();

        movieApp.bookFilm(avenger, 2);
        movieApp.bookFilm(joker, 100);
        movieApp.displayAllFilms();

        System.out.println();

        movieApp.searchBooking(123);
        movieApp.searchBooking(657);
    }
}