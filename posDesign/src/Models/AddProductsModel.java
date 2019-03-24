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
public class AddProductsModel {

    private String id, name, type, manufacturer, vendor, unit, article_code, article_name, operating_voltage, diameter_bore,
            stroke, meansuring_sensing, switching_output, sku, output_signal, selling_price, service_description, status;

    private String images;

    public AddProductsModel() {
    }

    //service without image
    public AddProductsModel(String name, String type, String manufacturer, String vendor,
            String selling_price, String service_description, String status) {

        this.name = name;
        this.type = type;
        this.manufacturer = manufacturer;
        this.vendor = vendor;
        this.selling_price = selling_price;
        this.service_description = service_description;
        this.status = status;
    }

    //service with image
    public AddProductsModel(String name, String type, String manufacturer, String vendor, String image,
            String selling_price, String service_description, String status) {

        this.name = name;
        this.type = type;
        this.manufacturer = manufacturer;
        this.vendor = vendor;
        this.images = image;
        this.selling_price = selling_price;
        this.service_description = service_description;
        this.status = status;
    }

    //products with images
    public AddProductsModel(String name, String type, String manufacturer, String vendor, String unit,
            String article_code, String article_name, String operating_voltage, String diameter_bore, String stroke,
            String meansuring_sensing, String switching_output, String sku, String output_signal,
            String selling_price, String image, String service_description, String status) {
        this.name = name;
        this.type = type;
        this.manufacturer = manufacturer;
        this.vendor = vendor;
        this.unit = unit;
        this.article_code = article_code;
        this.article_name = article_name;
        this.operating_voltage = operating_voltage;
        this.diameter_bore = diameter_bore;
        this.stroke = stroke;
        this.meansuring_sensing = meansuring_sensing;
        this.switching_output = switching_output;
        this.sku = sku;
        this.output_signal = output_signal;
        this.selling_price = selling_price;
        this.service_description = service_description;
        this.images = image;
        this.status = status;

    }

    //product without images
    public AddProductsModel(String name, String type, String manufacturer, String vendor, String unit,
            String article_code, String article_name, String operating_voltage, String diameter_bore, String stroke,
            String meansuring_sensing, String switching_output, String sku, String output_signal,
            String selling_price, String service_description, String status) {

        this.name = name;
        this.type = type;
        this.manufacturer = manufacturer;
        this.vendor = vendor;
        this.unit = unit;
        this.article_code = article_code;
        this.article_name = article_name;
        this.operating_voltage = operating_voltage;
        this.diameter_bore = diameter_bore;
        this.stroke = stroke;
        this.meansuring_sensing = meansuring_sensing;
        this.switching_output = switching_output;
        this.sku = sku;
        this.output_signal = output_signal;
        this.selling_price = selling_price;
        this.service_description = service_description;
        this.status = status;

    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getArticle_code() {
        return article_code;
    }

    public void setArticle_code(String article_code) {
        this.article_code = article_code;
    }

    public String getArticle_name() {
        return article_name;
    }

    public void setArticle_name(String article_name) {
        this.article_name = article_name;
    }

    public String getOperating_voltage() {
        return operating_voltage;
    }

    public void setOperating_voltage(String operating_voltage) {
        this.operating_voltage = operating_voltage;
    }

    public String getDiameter_bore() {
        return diameter_bore;
    }

    public void setDiameter_bore(String diameter_bore) {
        this.diameter_bore = diameter_bore;
    }

    public String getStroke() {
        return stroke;
    }

    public void setStroke(String stroke) {
        this.stroke = stroke;
    }

    public String getMeansuring_sensing() {
        return meansuring_sensing;
    }

    public void setMeansuring_sensing(String meansuring_sensing) {
        this.meansuring_sensing = meansuring_sensing;
    }

    public String getSwitching_output() {
        return switching_output;
    }

    public void setSwitching_output(String switching_output) {
        this.switching_output = switching_output;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getOutput_signal() {
        return output_signal;
    }

    public void setOutput_signal(String output_signal) {
        this.output_signal = output_signal;
    }

    public String getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(String selling_price) {
        this.selling_price = selling_price;
    }

    public String getService_description() {
        return service_description;
    }

    public void setService_description(String service_description) {
        this.service_description = service_description;
    }
}
