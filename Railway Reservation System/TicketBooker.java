import java.util.*;

public class TicketBooker {
    static int availableLowerBerth = 1;
    static int availableMiddleBerth = 1;
    static int availableUpperBerth = 1;
    static int availableRacBerth = 1;
    static int availableWaitingList = 1;


    static Queue<Integer> RacList = new LinkedList<>();
    static Queue<Integer> waitingList = new LinkedList<>();
    static List<Integer> bookedList = new ArrayList<>();

    static List<Integer> lowerBerthPosition = new ArrayList<>(Arrays.asList(1));
    static List<Integer> middleBerthPosition = new ArrayList<>(Arrays.asList(1));
    static List<Integer> upperBerthPosition = new ArrayList<>(Arrays.asList(1));
    static List<Integer> racPosition = new ArrayList<>(Arrays.asList(1));
    static List<Integer> waitingPosition = new ArrayList<>(Arrays.asList(1));

    static Map<Integer, Passenger> passengers = new HashMap<>();

    public void bookTicket(Passenger p, int berthInfo, String allocatedBerth) {
        p.seatNumber = berthInfo;
        p.berth = allocatedBerth;

        passengers.put(p.passengerId, p);

        bookedList.add(p.passengerId);

        System.out.println("--- Booked Successfully ---");
    }

    public void addToRAC (Passenger p, int berthInfo, String allocatedBerth) {
        p.seatNumber = berthInfo;
        p.allocated = allocatedBerth;

        passengers.put(berthInfo, p);

        availableRacBerth--;
        RacList.remove(0);

        System.out.println("--- Added to RAC Successfully ---");

    }

    public void addToWaitingList (Passenger p, int berthInfo, String allocatedBerth) {
        p.seatNumber = berthInfo;
        p.allocated = allocatedBerth;

        passengers.put(berthInfo, p);

        availableWaitingList--;
        waitingList.remove(0);

        System.out.println("--- Added to WL Successfully ---");

    }
}
