
/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Ing. Douglas Barrios
 * @author: Julián Divas
 * Creación: 22/03/2025
 * última modificación: 22/03/2025
 * File Name: Producto.java
 * Descripción: Clase dedicada a almacenar todos los datos de los productos del CSV
 */

public class Producto implements Comparable<Producto>{
    /**
     * Código de identificación único del producto
     */
    private String sku;
    /*
     * Nombre del producto
     */
    private String productName;
    /*
     * Categoría a la que pertenece el producto
     */
    private String category;
    /*
     * Precio mayorista del producto
     */
    private double priceCurrent;
    /*
     * Precio al consumidor del producto
     */
    private double priceRetail;

    /**
     * Constructor correspondiente de la clase
     * @param sku código único SKU del producto
     * @param productName Nombre del producto
     * @param category categoría a la que pertenece el producto
     * @param priceCurrent precio mayorista
     * @param priceRetail precio a consumidores 
     */
    public Producto(String sku, String productName, String category, double priceCurrent, double priceRetail) {
        this.sku = sku;
        this.productName = productName;
        this.category = category;
        this.priceCurrent = priceCurrent;
        this.priceRetail = priceRetail;
    }

    //Gets correspondientes
    public String getSku() {
        return sku;
    }
    public void setSku(String sku) {
        this.sku = sku;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getCategory() {
        return category;
    }
    //Sets correspondientes
    public void setCategory(String category) {
        this.category = category;
    }
    public double getPriceCurrent() {
        return priceCurrent;
    }
    public void setPriceCurrent(double priceCurrent) {
        this.priceCurrent = priceCurrent;
    }
    public double getPriceRetail() {
        return priceRetail;
    }
    public void setPriceRetail(double priceRetail) {
        this.priceRetail = priceRetail;
    }

    /**
     * Método de la interfaz comparable para comparar los distintos precios de los productos
     * @param producto el producto con el que se comparará el precio
     * @return Un numero negativo si priceCurrent del producto actual es menor al del producto argumento
     *  y un numero positivo si el priceCurrent del producto actual es mayor al del producto argumento.
     * En caso de que los priceCurrent sean iguales, se compara el priceRetail para mayor exactitud
     */
    @Override
    public int compareTo(Producto producto) {
        int comparacion = Double.compare(this.priceCurrent,producto.priceCurrent);
        if (comparacion != 0){
            return comparacion;
        } 
        else{
            return Double.compare(this.priceRetail, producto.priceRetail);
        }
    }
}