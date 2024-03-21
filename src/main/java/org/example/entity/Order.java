package org.example.entity;

import org.example.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private Date moment;
    private OrderStatus status;

    private Client client;

    private List<OrderItem> items = new ArrayList<>();

    public Order() {
    }

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public double total() {

        double sum = 0.0;
        for (OrderItem orderItem : items) {
            sum += orderItem.subTotal();
        }
        return sum;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Order moment: ");
        stringBuilder.append(simpleDateFormat.format(moment) + "\n");
        stringBuilder.append("Order status: ");
        stringBuilder.append(status + "\n");
        stringBuilder.append("Client: ");
        stringBuilder.append(client + "\n");
        stringBuilder.append("Order items: \n");
        for (OrderItem orderItem : items) {
            stringBuilder.append(orderItem + "\n");
        }
        stringBuilder.append("Total price: $");
        stringBuilder.append(String.format("%.2f", total()));
        return stringBuilder.toString();
    }
}
