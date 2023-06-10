import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    AviaSouls manager = new AviaSouls();
    Ticket ticket1 = new Ticket("NY", "SPB", 25_000, 02, 10);
    Ticket ticket2 = new Ticket("NY", "SPB", 26_000, 03, 12);
    Ticket ticket3 = new Ticket("SPB", "NY", 31_000, 06, 18);
    Ticket ticket4 = new Ticket("SPB", "NY", 34_000, 07, 17);
    Ticket ticket5 = new Ticket("SPB", "NY", 31_000, 10, 20);
    Ticket ticket6 = new Ticket("MSK", "SPB", 4_000, 19, 20);
    Ticket ticket7 = new Ticket("MSK", "SPB", 2_500, 18, 20);
    Ticket ticket8 = new Ticket("NY", "SPB", 2_100, 15, 21);

    @BeforeEach
    public void allTicket() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
    }

    @Test
    public void testSortPriceValid() {
        Ticket[] expected = {ticket3, ticket5, ticket4};
        Ticket[] actual = manager.search("SPB", "NY");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testSortPriceNoValid() {
        Ticket[] expected = {};
        Ticket[] actual = manager.search("MSK", "NY");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortComparator1() {
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket8, ticket1, ticket2};
        Ticket[] actual = manager.searchAndSortBy("NY", "SPB", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testSortComparator2() {
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket4, ticket5, ticket3};
        Ticket[] actual = manager.searchAndSortBy("SPB", "NY", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
