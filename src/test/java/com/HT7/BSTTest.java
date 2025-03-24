package com.HT7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Ing. Douglas Barrios
 * @author: Marcelo Detlefsen
 * Creación: 23/03/2025
 * última modificación: 23/03/2025
 * File Name: BSTTest.java
 * Descripción: Pruebas unitarias para la clase BST
 */
public class BSTTest {
    
    private BST<Producto> bst;
    private Producto producto1;
    private Producto producto2;
    private Producto producto3;
    
    @BeforeEach
    void setUp() {
        // Inicializar el BST antes de cada prueba
        bst = new BST<>();
        
        // Crear productos de prueba con diferentes precios
        producto1 = new Producto("SKU001", "Producto 1", "Electrónica", 100.0, 150.0);
        producto2 = new Producto("SKU002", "Producto 2", "Electrónica", 50.0, 75.0);
        producto3 = new Producto("SKU003", "Producto 3", "Electrónica", 200.0, 250.0);
    }
    
    @Test
    void testAñadirNodo() {
        // Añadir un nodo al BST vacío
        bst.añadirNodo(producto1);
        
        // Buscar el producto por SKU
        Producto encontrado = bst.buscarPorSKU("SKU001");
        
        // Verificar que se ha encontrado el producto correcto
        assertNotNull(encontrado, "El producto debería encontrarse en el BST");
        assertEquals("SKU001", encontrado.getSku(), "El SKU del producto encontrado debería ser SKU001");
    }
    
    @Test
    void testAñadirMultiplesNodos() {
        // Añadir múltiples nodos al BST
        bst.añadirNodo(producto1); // 100.0
        bst.añadirNodo(producto2); // 50.0
        bst.añadirNodo(producto3); // 200.0
        
        // Buscar cada producto por SKU
        Producto encontrado1 = bst.buscarPorSKU("SKU001");
        Producto encontrado2 = bst.buscarPorSKU("SKU002");
        Producto encontrado3 = bst.buscarPorSKU("SKU003");
        
        // Verificar que todos los productos se han encontrado
        assertNotNull(encontrado1, "El producto 1 debería encontrarse en el BST");
        assertNotNull(encontrado2, "El producto 2 debería encontrarse en el BST");
        assertNotNull(encontrado3, "El producto 3 debería encontrarse en el BST");
        
        // Verificar los datos de los productos encontrados
        assertEquals("Producto 1", encontrado1.getProductName(), "El nombre del producto 1 debería ser 'Producto 1'");
        assertEquals("Producto 2", encontrado2.getProductName(), "El nombre del producto 2 debería ser 'Producto 2'");
        assertEquals("Producto 3", encontrado3.getProductName(), "El nombre del producto 3 debería ser 'Producto 3'");
    }
    
    @Test
    void testBuscarProductoInexistente() {
        // Añadir algunos productos al BST
        bst.añadirNodo(producto1);
        bst.añadirNodo(producto2);
        
        // Buscar un SKU que no existe
        Producto encontrado = bst.buscarPorSKU("SKU999");
        
        // Verificar que el resultado es nulo
        assertNull(encontrado, "No debería encontrar un producto con SKU inexistente");
    }
    
    @Test
    void testBSTVacio() {
        // BST vacío, no se añade ningún producto
        
        // Buscar en un BST vacío
        Producto encontrado = bst.buscarPorSKU("SKU001");
        
        // Verificar que el resultado es nulo
        assertNull(encontrado, "No debería encontrar productos en un BST vacío");
    }
    
    @Test
    void testOrdenPorPrecio() {
        // Crear dos productos con el mismo SKU pero diferentes precios
        Producto productoA = new Producto("MISMO_SKU", "Producto A", "Categoría", 75.0, 100.0);
        Producto productoB = new Producto("DIFERENTE_SKU", "Producto B", "Categoría", 50.0, 80.0);
        
        // Añadir los productos al BST
        bst.añadirNodo(productoA);
        bst.añadirNodo(productoB);
        
        // Verificar que el productoB (precio menor) está a la izquierda del productoA
        // Esto se puede verificar indirectamente asegurando que ambos productos se pueden encontrar correctamente
        Producto encontradoA = bst.buscarPorSKU("MISMO_SKU");
        Producto encontradoB = bst.buscarPorSKU("DIFERENTE_SKU");
        
        assertNotNull(encontradoA, "El producto A debería encontrarse en el BST");
        assertNotNull(encontradoB, "El producto B debería encontrarse en el BST");
        assertEquals(75.0, encontradoA.getPriceCurrent(), "El precio del producto A debería ser 75.0");
        assertEquals(50.0, encontradoB.getPriceCurrent(), "El precio del producto B debería ser 50.0");
    }
    
    @Test
    void testProductosConMismoSKU() {
        // Crear dos productos con el mismo SKU pero diferentes precios
        Producto productoA = new Producto("MISMO_SKU", "Producto A", "Categoría", 100.0, 150.0);
        Producto productoB = new Producto("MISMO_SKU", "Producto B", "Categoría", 80.0, 120.0);
        
        // Añadir los productos al BST
        bst.añadirNodo(productoA);
        bst.añadirNodo(productoB);
        
        // Buscar el producto por SKU
        Producto encontrado = bst.buscarPorSKU("MISMO_SKU");
        
        // Verificar que se encuentra uno de los productos (no podemos asegurar cuál debido a la implementación del BST)
        assertNotNull(encontrado, "Un producto con el SKU debería encontrarse en el BST");
        assertEquals("MISMO_SKU", encontrado.getSku(), "El SKU del producto encontrado debería ser MISMO_SKU");
    }
}