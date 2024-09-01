import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("--------------------------------------------------");
        System.out.println("1. Book \n2. Cancel \n3. Print Booked Tickets \n4. Print Available Tickets \n5. Exit");

        boolean loop = true;
        while(loop) {
            System.out.println("--------------------------------------------------");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                {
                    System.out.println("Enter Name, Age and Berth Preference: ");
                    String name = scan.next();
                    int age = scan.nextInt();
                    String berth = scan.next();

                    Passenger p = new Passenger(name, age, berth);

                    bookTicket(p);
                }
                break;
            }
        }
    }

    public static void bookTicket(Passenger p){
        TicketBooker booker = new TicketBooker();

        if(TicketBooker.availableWaitingList == 0) {
            System.out.println("--- No Tickets Available ---");
            return;
        }

        if ( p.berth.equals("U") && TicketBooker.availableLowerBerth > 0 ||
                p.berth.equals("M") && TicketBooker.availableMiddleBerth > 0 ||
                p.berth.equals("L") && TicketBooker.availableUpperBerth > 0 )
        {
            System.out.println("Preferred Berth Available");
            if (p.berth.equals("L")) {

                System.out.println("--- Lower Berth Given ---");
                booker.bookTicket(p, TicketBooker.lowerBerthPosition.get(0), "L");
                TicketBooker.availableLowerBerth--;
                TicketBooker.lowerBerthPosition.remove(0);

            } else if (p.berth.equals("M")) {

                System.out.println("--- Middle Berth Given ---");
                booker.bookTicket(p, TicketBooker.middleBerthPosition.get(0), "M");
                TicketBooker.availableMiddleBerth--;
                TicketBooker.middleBerthPosition.remove(0);
                
            } else if (p.berth.equals("U")) {

                System.out.println("--- Upper Berth Available ---");
                booker.bookTicket(p, TicketBooker.upperBerthPosition.get(0), "U");
                TicketBooker.availableUpperBerth--;
                TicketBooker.upperBerthPosition.remove(0);

            }

        } else if (TicketBooker.availableRacBerth > 0) {

            System.out.println("RAC Available");
            booker.addToRAC(p, TicketBooker.racPosition.get(0), "RAC");

        } else if (TicketBooker.availableWaitingList > 0) {

            System.out.println("RAC Available");
            booker.addToWaitingList(p, TicketBooker.waitingPosition.get(0), "WL");

        }
    }
}