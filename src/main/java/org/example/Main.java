package org.example;

import org.example.entity.Client;
import org.example.entity.Order;
import org.example.entity.OrderItem;
import org.example.entity.Product;
import org.example.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        String name, email, productName;
        double price;
        int quantityItem;
        Date birthDate;
        System.out.println("DADOS DO CLIENTE");
        System.out.println("-------------------------");

        System.out.print("Nome: ");
        name = sc.nextLine();

        System.out.print("E-mail: ");
        email = sc.next();

        System.out.print("Data de nascimento (DD/MM/AAAA): ");
        birthDate = simpleDateFormat.parse(sc.next());

        Client client = new Client(name, email, birthDate);

        System.out.println("\nDADOS DO PEDIDO: ");
        System.out.println("-------------------------\n");

        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next()); //convertendo string para enum

        // instanciando order associado ao cliente
        Order order = new Order(new Date(), status, client);

        System.out.print("Quantos itens no pedido? ");
        int quantity = sc.nextInt();

        for (int i = 0; i < quantity; i++) {
            System.out.printf("Insira o #%dº pedido %n", i + 1);
            System.out.println();
            System.out.print("Nome do produto: ");
            sc.nextLine();
            productName = sc.nextLine();
            System.out.print("Preço do produto: ");
            price = sc.nextDouble();
            System.out.print("Quantidade: ");
            quantityItem = sc.nextInt();

            System.out.println("-------------------------");

            // instanciando o produto
            Product product = new Product(productName, price);
            // instanciando item do pedido associado ao produto
            OrderItem orderItem = new OrderItem(quantityItem,price,product);

            // adiconando o item na lista de itens do pedido
            order.addItem(orderItem);
        }

        System.out.println(order);

        sc.close();
    }
}