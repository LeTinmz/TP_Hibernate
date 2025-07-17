package org.example.DAO;

import org.example.Entities.Article;

public class ArticleDAO extends BaseDAO<Article>{
    public ArticleDAO(Class<Article> articleClass) {
        super(articleClass);
    }
}
