package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product{
    private Date manufactureDate;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public UsedProduct(String name, Double price, Date manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    @Override
    public final String priceTag(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.getName())
                .append(" (used) $ ")
                .append(String.format("%.2f", super.getPrice()))
                .append(" (Manufacture date: ")
                .append(sdf.format(manufactureDate))
                .append(")");
        return sb.toString();
    }
}
