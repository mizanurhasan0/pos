/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author world
 */
public class PurchaseProductModel {

    private String inventory_id,UserId, UserRole, CustomerName, CompanyName, Phone, Email, Unique_id, product_id,
            ProductName, Manufacturer, Quantity, Price, Discount, sellsPrice, TotalPrice, Date;

    public PurchaseProductModel() {
    }

    public PurchaseProductModel(String inventory_id,String UserId, String UserRole, String CustomerName, String CompanyName, String Phone, String Email, String Unique_id, String product_id, String ProductName, String Manufacturer, String Quantity, String Price, String Discount, String sellsPrice, String TotalPrice, String Date) {
        this.inventory_id=inventory_id;
        this.UserId = UserId;
        this.UserRole = UserRole;
        this.CustomerName = CustomerName;
        this.CompanyName = CompanyName;
        this.Phone = Phone;
        this.Email = Email;
        this.Unique_id = Unique_id;
        this.product_id = product_id;
        this.ProductName = ProductName;
        this.Manufacturer = Manufacturer;
        this.Quantity = Quantity;
        this.Price = Price;
        this.Discount = Discount;
        this.sellsPrice = sellsPrice;
        this.TotalPrice = TotalPrice;
        this.Date = Date;
    }

    public String getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(String inventory_id) {
        this.inventory_id = inventory_id;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getUserRole() {
        return UserRole;
    }

    public void setUserRole(String UserRole) {
        this.UserRole = UserRole;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getUnique_id() {
        return Unique_id;
    }

    public void setUnique_id(String Unique_id) {
        this.Unique_id = Unique_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String Manufacturer) {
        this.Manufacturer = Manufacturer;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String Quantity) {
        this.Quantity = Quantity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String Discount) {
        this.Discount = Discount;
    }

    public String getSellsPrice() {
        return sellsPrice;
    }

    public void setSellsPrice(String sellsPrice) {
        this.sellsPrice = sellsPrice;
    }

    public String getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(String TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

}
