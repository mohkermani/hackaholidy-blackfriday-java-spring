package com.hackaholiday.blackfriday.blackfriday;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.hackaholiday.blackfriday.blackfriday.entity.Products;

@RestController
public class BlackFridayController {
    private final BetterLogic logic;

    public BlackFridayController(
            BetterLogic logic) {
        this.logic=logic;

    }

    @GetMapping(path = "/items/{asin}", produces = "application/json")
    public Products getOne(@PathVariable String asin) {
        return logic.getOne(asin);
    }

    @GetMapping(path = "/test/{categoryName}", produces = "application/json")
    public String ttestname(@PathVariable String categoryName) {
        return categoryName;
    }
    @GetMapping(path = "/categories/{categoryName}", produces = "application/json")
    public List<Products> getCategory(@PathVariable String categoryName) {
        return logic.getCategory(categoryName);
    }

    @GetMapping(path = "/categories", produces = "application/json")
    public List<String> getCategories() {
        return logic.getCategories();
    }

    @RequestMapping(path = "/add-item-to-basket", method = RequestMethod.POST)
    public Object addToBasket(@RequestBody Map<String, String> itemtoadd) {
        return logic.addToBasket(itemtoadd.get("product-id"), itemtoadd.get("user-id"), itemtoadd.get("basket-id"));
        // {
        // "product-id": "ad velit",
        // "user-id": "ut",
        // "basket-id": "quis id sint"
        // }
        }

    @RequestMapping(path = "/checkout-basket", method = RequestMethod.POST)
    public Object checkOut(@RequestBody Map<String, String> checkout) {
        // {
        // "user-id": "ut",
        // "basket-id": "quis id sint"
        // }
        return logic.checkOut(checkout.get("user-id"),checkout.get("basket-id"));
    }
}
