package ua.academy.lgs;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Journal> subscrition = new ArrayList<>();
    private double priceToPay;

    public Cart() {
    }

    public List<Journal> getSubscrition() {
        return subscrition;
    }

    public void setSubscrition(List<Journal> subscrition) {
        this.subscrition = subscrition;
    }

    public double getPriceToPay() {
        return priceToPay;
    }

    public void setPriceToPay(double priceToPay) {
        this.priceToPay = priceToPay;
    }


    @Override
    public String toString() {
        return "Cart{" +
                "subscrition=" + subscrition +
                ", priceToPay=" + priceToPay +
                '}';
    }
}
