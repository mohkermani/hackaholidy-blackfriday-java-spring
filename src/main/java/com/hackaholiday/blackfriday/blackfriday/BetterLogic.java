package com.hackaholiday.blackfriday.blackfriday;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import com.hackaholiday.blackfriday.blackfriday.entity.Products;
import com.hackaholiday.blackfriday.blackfriday.repository.BasketsRepository;
import com.hackaholiday.blackfriday.blackfriday.repository.InvoicesRepository;
import com.hackaholiday.blackfriday.blackfriday.repository.ProductCountsRepository;
import com.hackaholiday.blackfriday.blackfriday.repository.ProductsCategoryRepository;
import com.hackaholiday.blackfriday.blackfriday.repository.ProductsRepository;

import jakarta.annotation.PostConstruct;

@Service
public class BetterLogic extends Logic {

    private final TaskExecutor executor;

    public BetterLogic(ProductsRepository productRepository, ProductCountsRepository productCountsRepository,
            BasketsRepository basketsRepository, InvoicesRepository invoicesRepository,
            ProductsCategoryRepository productsCategoryRepository, TaskExecutor executor) {
        super(productRepository, productCountsRepository, basketsRepository, invoicesRepository,
                productsCategoryRepository);
        this.executor = executor;
    }

    private List<String> categories;
    private ConcurrentHashMap<String, List<Products>> categoriesMap = new ConcurrentHashMap<>();

    @Override
    public List<String> getCategories() {
        if (categories == null)
            return super.getCategories();
        else
            return categories;
    }

    @Override
    public List<Products> getCategory(String categoryName) {
        List<Products> list = categoriesMap.get(categoryName);
        if (list == null)
            categoriesMap.put(categoryName, super.getCategory(categoryName));
        return categoriesMap.get(categoryName);
    }

    @PostConstruct
    public void postConstruct() {
        executor.execute(new Runnable() {
            public void run() {

                System.out.println("Categories chaching");
                long time = System.currentTimeMillis();
                categories = BetterLogic.super.getCategories();
                System.out.println("Categories ready " + (System.currentTimeMillis() - time) / 1000 + "s");

                for (String categoryNameString : categories) {

                    executor.execute(new Runnable() {
                        public void run() {
                            long time = System.currentTimeMillis();
                            categoriesMap.put(categoryNameString, BetterLogic.super.getCategory(categoryNameString));
                            System.out.println("Category '" + categoryNameString + "' is ready. " + categoriesMap.size()
                                    + "/"
                                    + categories.size() + " " + (System.currentTimeMillis() - time) / 1000 + "s");

                        }
                    });
                }
            }
        });
    }

}
