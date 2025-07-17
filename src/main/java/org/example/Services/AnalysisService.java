package org.example.Services;

import org.example.DAO.ArticleDAO;
import org.example.DAO.ClientDAO;
import org.example.DAO.SaleDao;
import org.example.DTO.ArticleSalesReportDTO;
import org.example.Entities.Article;
import org.example.Entities.Client;
import org.example.Entities.Sale;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnalysisService {
    private final ArticleDAO articleDAO = new ArticleDAO(Article.class);
    private final ClientDAO clientDAO = new ClientDAO(Client.class);
    private final SaleDao saleDAO = new SaleDao(Sale.class);

    public ArticleSalesReportDTO getSalesByArticleId(int articleId) {
        List<Sale> sales = saleDAO.get();
        List<Sale> salesOfGivenArticle = new ArrayList<>();
        Set<Client> clientsForGivenArticle = new HashSet<>();
        int quantitySold = 0;
        double totalPrice = 0;
        for(Sale sale : sales) {
            for(Article article : sale.getContent()){
                if(article.getId() == articleId){
                    salesOfGivenArticle.add(sale);
                    quantitySold++;
                    totalPrice+=article.getPrice();
                    clientsForGivenArticle.add(sale.getClient());

                }
            }
        }
        return ArticleSalesReportDTO.builder().articleName(articleDAO.get(articleId).getName()).quantitySold(quantitySold).clientNumber(clientsForGivenArticle.size()).build();
    }

    public List<Sale> getSalesByClientId(int clientId) {
        List<Sale> sales = saleDAO.get();
        List<Sale> salesOfGivenClient = new ArrayList<>();
        for(Sale sale : sales) {
            if(sale.getClient().getId() == clientId){
                salesOfGivenClient.add(sale);
            }
        }
        return salesOfGivenClient;
    }

    public List<Sale> getSalesByPeriod(LocalDate startDate, LocalDate endDate) {
        List<Sale> sales = saleDAO.get();
        List<Sale> salesOfGivenPeriod = new ArrayList<>();
        for(Sale sale : sales) {
            if(sale.getDate().isAfter(startDate) && sale.getDate().isBefore(endDate)){
                salesOfGivenPeriod.add(sale);
            }
        }
        return salesOfGivenPeriod;
    }


}
