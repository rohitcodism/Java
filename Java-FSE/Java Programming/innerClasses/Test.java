public class Test {
    public static void main(String[] args) {
        Hotel h1 = new Hotel("Sunshine", 15, 10);
        h1.reserveRooms("Rohit", 6);
        h1.reserveRooms("XYZ", 5);
        h1.reserveRooms("Mohit", 5);
        h1.reserveRooms("", 5);
    }
}
