
/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Ing. Douglas Barrios
 * @author: Julián Divas
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
     * Método encargado de añadir un Nodo al BST, en base al priceCurrent del objeto producto,que es el valor del Nodo
     * @param producto el objeto asociado al nuevo nodo a crearse en el BST
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
}