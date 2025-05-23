package by.cherkas.exam.validators;

import by.cherkas.exam.exceptions.ExceptionMessages;
import by.cherkas.exam.exceptions.ProductNotValidException;
import by.cherkas.exam.product.Product;
import io.micrometer.common.util.StringUtils;

public class ProductValidator {

    public static void execute(Product product){
        if(StringUtils.isEmpty(product.getName()))
            throw new ProductNotValidException(ExceptionMessages.PRODUCT_NAME_REQUIRED.getMessage());
        if(StringUtils.isEmpty(product.getManufacturer()))
            throw new ProductNotValidException(ExceptionMessages.MANUFACTURER_REQUIRED.getMessage());
        if(product.getCategory().getCategory().isEmpty())
            throw new ProductNotValidException(ExceptionMessages.CATEGORY_REQUIRED.getMessage());
        if(product.getPrice() <= 0)
            throw new ProductNotValidException(ExceptionMessages.MINIMAL_PRICE.getMessage());
        if(ProfanityCheck.checkProfanity(product))
            throw new ProductNotValidException(ExceptionMessages.PROFANITY_DETECTED.getMessage());
    }
}
