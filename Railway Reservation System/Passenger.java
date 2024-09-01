public class Passenger {
    static int id = 1;
    String name;
    int age;
    String berth;
    int passengerId;
    String allocated;
    int seatNumber;

    public Passenger(String name, int age, String berth) {
        this.name = name;
        this.age = age;
        this.berth = berth;
        this.passengerId = id++;
        allocated = "";
        seatNumber = -1;
    }
}
