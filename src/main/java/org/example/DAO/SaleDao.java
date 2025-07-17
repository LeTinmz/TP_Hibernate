package org.example.DAO;

import org.example.Entities.Sale;

public class SaleDao extends BaseDAO<Sale>{

    public SaleDao(Class<Sale> saleClass) {
        super(saleClass);
    }
}
