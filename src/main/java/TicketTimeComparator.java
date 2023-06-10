import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        int flightTimeO1 = o1.getTimeTo() - o1.getTimeFrom();
        int flightTimeO2 = o2.getTimeTo() - o2.getTimeFrom();

        if (flightTimeO1 < flightTimeO2){
            return -1;
            } else if (flightTimeO1 > flightTimeO2){
            return 1;
        } else {
            return 0;
        }
    }
}
