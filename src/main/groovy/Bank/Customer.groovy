package Bank

import Bank.Products.Product

class Customer {
    int id
    String name
    ArrayList<Product> products;

    Customer(String name) {
        this.id = Generator.generateId()
        this.name = name
        this.products = new ArrayList<>()
    }
}
