package com.hackaholiday.blackfriday.blackfriday;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.hackaholiday.blackfriday.blackfriday.entity.Baskets;
import com.hackaholiday.blackfriday.blackfriday.entity.Invoices;
import com.hackaholiday.blackfriday.blackfriday.entity.InvoicesPK;
import com.hackaholiday.blackfriday.blackfriday.entity.ProductCounts;
import com.hackaholiday.blackfriday.blackfriday.entity.Products;
import com.hackaholiday.blackfriday.blackfriday.repository.BasketsRepository;
import com.hackaholiday.blackfriday.blackfriday.repository.InvoicesRepository;
import com.hackaholiday.blackfriday.blackfriday.repository.ProductCountsRepository;
import com.hackaholiday.blackfriday.blackfriday.repository.ProductsCategoryRepository;
import com.hackaholiday.blackfriday.blackfriday.repository.ProductsRepository;

@Service
public class Logic {
    
    private final ProductsRepository productRepository;
    private final ProductCountsRepository productCountsRepository;
    private final BasketsRepository basketsRepository;
    private final InvoicesRepository invoicesRepository;
    private final ProductsCategoryRepository productsCategoryRepository;
    public Logic(ProductsRepository productRepository, ProductCountsRepository productCountsRepository,
            BasketsRepository basketsRepository, InvoicesRepository invoicesRepository,
            ProductsCategoryRepository productsCategoryRepository) {
        this.productRepository = productRepository;
        this.productCountsRepository = productCountsRepository;
        this.basketsRepository = basketsRepository;
        this.invoicesRepository = invoicesRepository;
        this.productsCategoryRepository=productsCategoryRepository;
    }
    
    public Products getOne(String asin) {
        return productRepository.findByAsin(asin);
    }

    public List<Products> getCategory(String categoryName) {
        return productRepository.findByCategoryName(categoryName);
    }
    public List<String> getCategories() {
        return productsCategoryRepository.findAll().stream().map(prd -> prd.getCategoryName()).distinct()
                .collect(Collectors.toList());
    }

    
    public Object addToBasket(String asin,String userId,String basketId) {
        if(asin==null)
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"asin is required");
        Products product = productRepository.findByAsin(asin);
        if (product == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        ProductCounts count=productCountsRepository.findByAsin(asin);
        if(count==null || count.getCount()<=0){
            throw new  ResponseStatusException(HttpStatus.BAD_REQUEST,"No product left");
        }
        return basketsRepository.saveAndFlush(new Baskets(basketId, asin, userId));
    }

    public Object checkOut(String userId,String basketId) {
        List<Baskets> basket = basketsRepository.findIt(basketId, userId);
        if(basket==null || basket.size()==0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        for (Baskets basketitem : basket) {
            ProductCounts counts=productCountsRepository.findByAsin(basketitem.getBasketsPK().getProductId());
            if(counts==null || counts.getCount()<=0){
                throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
            }
        }
        for (Baskets basketitem : basket) {
            ProductCounts counts=productCountsRepository.findByAsin(basketitem.getBasketsPK().getProductId());
            counts.setCount(counts.getCount()-1);
            productCountsRepository.saveAndFlush(counts);
            basketitem.setIsCheckedOut(true);
            basketsRepository.saveAllAndFlush(basket);
        }

        return invoicesRepository.saveAndFlush(new Invoices(new InvoicesPK(basketId, userId),basket.toString()));
    }
}
