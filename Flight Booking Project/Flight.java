import java.util.ArrayList;
public class Flight {
    static int id = 0;
    int flightId;
    int tickets;
    int price;
    ArrayList<String> passengerDetails;
    ArrayList<Integer> passengerIDs;
    ArrayList<Integer> bookedTicketsPerPassenger;
    ArrayList<Integer> passengerCost;

    public Flight() {
        id = id + 1;
        flightId = id;
        tickets = 50;
        price = 5000;
        passengerDetails = new ArrayList<String>();
        passengerIDs = new ArrayList<Integer>();
        bookedTicketsPerPassenger = new ArrayList<Integer>();
        passengerCost = new ArrayList<Integer>();
    }
    public void addPassengerDetails(String passengerDetail, int passengerId, int ticket){
        passengerDetails.add(passengerDetail);
        passengerIDs.add(passengerId);
        bookedTicketsPerPassenger.add(ticket);
        passengerCost.add(ticket * price);

        price += 200 * ticket;
        tickets -= ticket;

        System.out.println("---- Booked Successfully ----");
    }

    public void cancelTicket(Flight f, int passengerId){
        int indexToRemove = passengerIDs.indexOf(passengerId);
        if ( indexToRemove < 0 ) {
            System.out.println("--- Invalid Passenger ID ---");
            return;
        }

        int ticketToRemove = bookedTicketsPerPassenger.get(indexToRemove);


        tickets += ticketToRemove;
        price -= 200 * ticketToRemove;

        System.out.println("Refund Amount: " + passengerCost.get(indexToRemove));

        passengerDetails.remove(indexToRemove);
        passengerIDs.remove(Integer.valueOf(passengerId));
        bookedTicketsPerPassenger.remove(indexToRemove);
        passengerCost.remove(indexToRemove);

        System.out.println( ticketToRemove > 1 ? "--- Tickets cancelled Successfully ---" : "--- Ticket cancelled Successfully ---");
    }
    public void flightSummary() {
        System.out.println("Flight ID: " + flightId + " -- Tickets: " + tickets + " -- Price: " + price);
    }

    public void printDetails() {
        System.out.println("Flight ID: " + flightId + " 👇");
        for (String detail : passengerDetails) {
            System.out.println(detail);
        }
    }
}

