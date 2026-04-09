package Level_3;

class BoxOffice {
    private int availableTickets = 2; // Only 2 tickets left!

    // 🔥 THE PRO MOVE: 'synchronized' ensures only one thread accesses this at a time
    public synchronized void bookTicket(String passengerName, int ticketsToBook) {
        System.out.println("🔄 " + passengerName + " is trying to book " + ticketsToBook + " ticket(s)...");
        
        if (availableTickets >= ticketsToBook) {
            System.out.println("✅ " + passengerName + " successfully booked " + ticketsToBook + " ticket(s)!");
            availableTickets -= ticketsToBook;
        } else {
            System.out.println("❌ Transaction Failed! " + passengerName + " could not book. Only " + availableTickets + " ticket(s) left.");
        }
        System.out.println("🎟️ Tickets remaining: " + availableTickets + "\n");
    }
}

public class TicketBookingSystem {
    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println("🎫 MULTI-THREADED BOX OFFICE 🎫");
        System.out.println("=====================================\n");

        BoxOffice irctc = new BoxOffice();

        // 3 Users trying to book at the exact same millisecond
        Thread user1 = new Thread(() -> irctc.bookTicket("Ankit Sonkar", 1));
        Thread user2 = new Thread(() -> irctc.bookTicket("Aftab Ansari", 1));
        Thread user3 = new Thread(() -> irctc.bookTicket("Ravi Kumar", 1)); // This guy will fail

        user1.start();
        user2.start();
        user3.start();
    }
}