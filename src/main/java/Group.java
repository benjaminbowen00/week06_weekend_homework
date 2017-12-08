import java.util.ArrayList;

public class Group {
    private ArrayList<Guest> guests;

    public Group(){
        this.guests = new ArrayList<>();
    }

    public void addGuestToGroup(Guest guest){
        this.guests.add(guest);
    }

    public int getSize(){
        return this.guests.size();
    }
}
