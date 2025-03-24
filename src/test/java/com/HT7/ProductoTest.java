package com.HT7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Ing. Douglas Barrios
 * @author: Julián Divas
 * Creación: 24/03/2025
 * última modificación: 24/03/2025
 * File Name: ProductoTest.java
 * Descripción: Clase dedicada a las pruebas unitarias de la clase Producto.java
 */

public class ProductoTest {

    private Producto prueba;
    
    @BeforeEach
    public void setUp(){
        prueba = new Producto("01010", "Refri", "Electrodomésticos", 100.00, 150.00);
    }

    //Pruebas de getters
    @Test
    public void probar_getters(){
        assertEquals(prueba.getSku(), "01010", "Deben ser iguales");
        assertEquals(prueba.getProductName(), "Refri", "Deben ser iguales");
        assertEquals(prueba.getCategory(), "Electrodomésticos", "Deben ser iguales");
        assertEquals(prueba.getPriceCurrent(), 100.00, "Deben ser iguales");
        assertEquals(prueba.getPriceRetail(), 150.00, "Deben ser iguales");
    }

    //Pruebas de setters
    @Test
    public void probar_setters(){
        prueba.setSku("0001");
        prueba.setProductName("Microondas");
        prueba.setPriceRetail(200.00);
        prueba.setPriceCurrent(250.00);
        prueba.setCategory("Ondas");
        assertEquals(prueba.getSku(), "0001", "Deben ser iguales");
        assertEquals(prueba.getProductName(), "Microondas", "Deben ser iguales");
        assertEquals(prueba.getCategory(), "Ondas", "Deben ser iguales");
        assertEquals(prueba.getPriceCurrent(), 250.00, "Deben ser iguales");
        assertEquals(prueba.getPriceRetail(), 200.00, "Deben ser iguales");
    }
}
