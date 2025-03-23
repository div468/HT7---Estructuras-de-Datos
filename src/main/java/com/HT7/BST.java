package com.HT7;

/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Ing. Douglas Barrios
 * @author: Julián Divas, Marcelo Detlefsen
 * Creación: 22/03/2025
 * última modificación: 22/03/2025
 * File Name: BST.java
 * Descripción: Binary Seartch Tree encargado de ordenar nodos en base al atrbuto
 * priceCurrent de los productos de sus nodos
 */

public class BST<T extends Comparable<T>>{
    /**
     * Nodo raiz donde inicia nuestro binary search tree
     */
    private Nodo raiz;

    /**
     * Se inicializa el BST de forma nula para asegurar un correcto orden de nodos.
     */
    public BST(){
        this.raiz = null;
    }

    /**
     * Método encargado de añadir un Nodo al BST, en base al priceCurrent del objeto producto,que es el valor del Nodo
     * @param producto el objeto producto asociado al nuevo nodo a crearse en el BST
     */
    public void añadirNodo(Producto producto){
        Nodo nodo = new Nodo(producto);
        if (raiz == null){
            raiz = nodo;
        }
        else {
            Nodo nodoinicial = raiz;
            Nodo padre;
            while (nodoinicial != null){
                padre = nodoinicial;
                if(producto.getPriceCurrent() < nodoinicial.getProducto().getPriceCurrent()){
                    nodoinicial = nodoinicial.leftNode;
                    if (nodoinicial == null){
                        padre.leftNode = nodo;
                        return;
                    }
                }
                else {
                    nodoinicial = nodoinicial.rightNode;
                    if (nodoinicial == null){
                        padre.rightNode = nodo;
                        return;
                    }
                }
            }
        }
    }

        /**
     * Método encargado de buscar un producto en el BST en base a su SKU
     * @param sku código único SKU del producto a buscar
     * @return el producto asociado al SKU buscado
     */
    public Producto buscarPorSKU(String sku) {
        return buscarPorSKU(raiz, sku);
    }

    /**
     * Método encargado de buscar un producto en el BST en base a su SKU.
     * Este método recorre todo el árbol (inorder traversal) ya que el árbol está
     * organizado por precio, no por SKU.
     * @param nodo nodo raiz del BST
     * @param sku código único SKU del producto a buscar
     * @return el producto asociado al SKU buscado
     */
    private Producto buscarPorSKU(Nodo nodo, String sku) {
        if (nodo == null) {
            return null;
        }
        
        // Buscar en el subárbol izquierdo
        Producto encontradoIzquierda = buscarPorSKU(nodo.getLeftNode(), sku);
        if (encontradoIzquierda != null) {
            return encontradoIzquierda;
        }
        
        // Verificar el nodo actual
        if (nodo.getProducto().getSku().equals(sku)) {
            return nodo.getProducto();
        }
        
        // Buscar en el subárbol derecho
        return buscarPorSKU(nodo.getRightNode(), sku);
    }
}