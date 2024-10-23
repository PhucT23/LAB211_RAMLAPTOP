package Controller;

import Model.RamItems;
import java.util.Comparator;
import java.util.Scanner;

public class Sort {
    public Comparator<RamItems> sortByTypeBusBrand() {
        return new Comparator<RamItems>() {
            @Override
            public int compare(RamItems item1, RamItems item2) {
                int typeCompare = item1.getType().compareTo(item2.getType());
                if (typeCompare != 0) {
                    return typeCompare;
                }
                int busCompare = item1.getBus().compareTo(item2.getBus());
                if (busCompare != 0) {
                    return busCompare;
                }
                return item1.getBrand().compareTo(item2.getBrand());
            }
        };
    }
}

