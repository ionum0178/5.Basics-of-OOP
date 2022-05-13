package by.javalearning.theme4;

import java.util.List;

public class OffersLogic {

    private Offers offer = new Offers();
    private List<Voucher> ofertas;
    
    public void newOffer(Voucher voucher) {
	ofertas=offer.getOffers();
	ofertas.add(voucher);
	offer.setOffers(ofertas);
    }
    
    public void clearOffers() {
	ofertas=offer.getOffers();
	ofertas.clear();
	offer.setOffers(ofertas);
    }
    
    public void clearWorkOffers() {
	ofertas=offer.getWorkoffers();
	ofertas.clear();
	offer.setOffers(ofertas);
    }
    
    public void newWorkOffer(Voucher voucher) {
	ofertas=offer.getWorkoffers();
	ofertas.add(voucher);
	offer.setOffers(ofertas);
    }

}
