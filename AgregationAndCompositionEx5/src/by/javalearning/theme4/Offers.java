package by.javalearning.theme4;

import java.util.ArrayList;
import java.util.List;

public class Offers {

    private static List<Voucher> offers = new ArrayList<>();
    private static List<Voucher> workoffers = new ArrayList<>();
    

    public List<Voucher> getOffers() {
        return offers;
    }

    public List<Voucher> getWorkoffers() {
        return workoffers;
    }

    public void setOffers(List<Voucher> offers) {
        Offers.offers = offers;
    }

    public void setWorkoffers(List<Voucher> workoffers) {
        Offers.workoffers = workoffers;
    }
    
}
