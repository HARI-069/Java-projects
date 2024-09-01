import java.util.*;
public class BookFlightTickets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Flight> flights = new ArrayList<Flight>();

        for (int i = 0; i < 2; flights.add(new Flight()), i++);

        int passengerId = 1;

        while( true ) {
            System.out.println("-----------------------------------------------------------");
            System.out.println("1. Book   2. Cancel   3. Print Details");
            int choice = scan.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("Enter Flight ID: ");
                    int fID = scan.nextInt();

                    if (fID > flights.size()) {
                        System.out.println("Flight " + fID + " is not Available");
                        break;
                    }

                    Flight currentFlight = null;

                    for (Flight f : flights) {
                        if (f.flightId == fID) {
                            currentFlight = f;
                            f.flightSummary();
                            break;
                        }
                    }

                    System.out.println("Enter no.of Tickets: ");
                    int t = scan.nextInt();

                    if (t > currentFlight.tickets) {
                        System.out.println("Not Enough Tickets.");
                        break;
                    }
                    book(fID, passengerId, t, currentFlight);
                    passengerId++;
                    break;
                }
                case 2: {
                    System.out.println("Enter flight ID and Passenger ID to CANCEL ticket: ");
                    int fid = scan.nextInt();

                    if (fid > flights.size()) {
                        System.out.println("--- Invalid Flight ID ---");
                        break;
                    }

                    Flight currentFlight = null;
                    for (Flight f : flights) {
                        if (f.flightId == fid) {
                            currentFlight = f;
                            break;
                        }
                    }

                    int Pid = scan.nextInt();
                    cancel(currentFlight, Pid);
                    break;
                }
                case 3: {
                    for (Flight f : flights) {
                        if (f.passengerIDs.isEmpty()) {
                            System.out.println("No Passenger Details for Flight: " + f.flightId);
                        } else {
                            print(f);
                        }
                    }
                    break;
                }
                default:
                    break;
            }
        }
    }
    public static void book(int fId, int passengerId, int t, Flight currentFlight) {
        String passengerDetail = "Passenger ID: " + passengerId + " -- No.of Tickets Booked: " + t;
        currentFlight.addPassengerDetails(passengerDetail, passengerId, t);
        currentFlight.flightSummary();
        currentFlight.printDetails();
    }

    public static void cancel(Flight currentFlight, int passengerId) {
        currentFlight.cancelTicket(currentFlight , passengerId);
        currentFlight.flightSummary();
        currentFlight.printDetails();
    }
    public static void print(Flight currentFlight) {
        currentFlight.flightSummary();
        currentFlight.printDetails();
    }
}
