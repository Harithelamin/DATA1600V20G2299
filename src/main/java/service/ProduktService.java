package service;


import bilInfo.Produkt;

import java.io.IOException;
import java.util.List;

public interface ProduktService {
    public void lagereProdukt(List<Produkt> produkter) throws IOException, ClassNotFoundException;
    public List<Produkt> Produkt();

}
