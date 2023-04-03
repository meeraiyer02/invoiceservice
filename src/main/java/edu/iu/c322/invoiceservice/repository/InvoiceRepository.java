package edu.iu.c322.invoiceservice.repository;

import edu.iu.c322.invoiceservice.model.Invoice;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvoiceRepository {
    private List<Invoice> orders = new ArrayList<>();


    public Invoice findCustomerID(int id){
        return getOrderById(id);
        /*
        for (int i = 0; i < orders.size(); i++){
            if (orders.get(i).getCustomerId() == id ){
                o =orders.get(i);
                return o;
            }
        }

        return null;
        */

    }

    public int create(Invoice order){
        orders.add(order);
        return order.getInvoiceID();
    }


    public void update(Invoice order, int id){
        Invoice x = getOrderById(id);
        if (x != null){
            x.setStatus("shipped");
        }
        else {
            throw new IllegalStateException("Not Valid ID");
        }
    }

    public void delete(int id){
        Invoice x = getOrderById(id);
        if (x != null){
            orders.remove(x);
        }
        else {
            throw new IllegalStateException("Not Valid ID");
        }
    }

    private Invoice getOrderById(int id){
        return  orders.stream().filter(x -> x.getInvoiceID() == id).findAny().orElse(null);
    }


}
