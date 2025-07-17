package org.example;

import org.example.DAO.ArticleDAO;
import org.example.DAO.ClientDAO;
import org.example.Entities.Article;
import org.example.Entities.Client;
import org.example.Entities.Clothes;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
            Client client = Client.builder().firstName("John").lastName("Doe").build();
            ClientDAO clientDAO = new ClientDAO(Client.class);

            Client savedClient = clientDAO.createOrUpdate(client);
            clientDAO.delete(1);

            ArticleDAO articleDAO = new ArticleDAO(Article.class);
            Clothes shirt = Clothes.builder().name("Shirt").price(12.5).build();
            articleDAO.createOrUpdate(shirt);
        ;
        }

}