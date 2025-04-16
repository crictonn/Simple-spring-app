package by.cherkas.exam.exceptions;

import lombok.Getter;

@Getter
public enum ExceptionMessages {
    PRODUCT_NOT_FOUND("Product Not Found"),
    PROFANITY_DETECTED("Please don't use foul language"),
    PRODUCT_NAME_REQUIRED("Product name is required"),
    MANUFACTURER_REQUIRED("Manufacturer is required"),
    CATEGORY_REQUIRED("Category is required"),
    MINIMAL_PRICE("Price must be grater then zero");


    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }
}
