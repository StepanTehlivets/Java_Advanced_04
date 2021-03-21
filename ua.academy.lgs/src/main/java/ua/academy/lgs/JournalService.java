package ua.academy.lgs;

import java.util.ArrayList;
import java.util.List;

public class JournalService {
    private List<Journal> listOfJournals = new ArrayList<>();
    private List<Journal> journalsInCart = new ArrayList<>();
    private double toPay;
    private static JournalService journalService;

    private JournalService() {}

    public static JournalService getJournalService() {
        if(journalService == null) {
            journalService = new JournalService();
        }
        return journalService;
    }

    public List<Journal> getListOfJournals() {
        return listOfJournals;
    }

    public void saveJournal(Journal journal) {
        listOfJournals.add(journal);
    }

    public Journal getJournal(String name) {
        return listOfJournals.stream().filter(journal -> journal.getName().equals(name)).findAny().orElse(null);
    }

    public List<Journal> getJournalsInCart() {
        return journalsInCart;
    }
    public void addToCart(Journal journal) {
        journalsInCart.add(journal);
    }

    public double getToPay() {
        return toPay;
    }

    public void setToPay(double toPay) {
        this.toPay = toPay;
    }
}
