public class Hotel {
    private String name;
    private int totalRooms;
    private int reservedRooms;

    Hotel(String name, int totalRooms, int reservedRooms){
        this.name = name;
        this.totalRooms = totalRooms;
        this.reservedRooms = reservedRooms;
    }
    void reserveRooms(String name, int numRooms){
        class ReservationValidator{
            boolean isValid(){
                if(name.isBlank()){
                    System.out.println("User name is empty.");
                    return false;
                }
                if(reservedRooms+numRooms > totalRooms){
                    System.out.println("Rooms Unavailable.");
                    return false;
                }
                if(numRooms <= 0){
                    System.out.println("Invalid number of rooms.");
                    return false;
                }

                reservedRooms+=numRooms;
                return true;
            }
        }

        ReservationValidator validator = new ReservationValidator();
        boolean isValidReservation = validator.isValid();

        if(isValidReservation){
            System.out.println("Reservation successful.");
        }else{
            System.out.println("Reservation failed.");
        }
    }
}