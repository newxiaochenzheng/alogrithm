package com.test;

public class ConcreteFactory extends Factory {
    @Override
    public <T extends Product> Product createProduct(Class<T> clazz) {
        Product product = null;
        try {
            product = (Product) Class.forName(clazz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
}
