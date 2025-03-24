package com.HT7;

/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Ing. Douglas Barrios
 * @author: Julián Divas
 * Creación: 22/03/2025
 * última modificación: 22/03/2025
 * File Name: Nodo.java
 * Descripción: Clase que representa los nodos de un BST, cuyos valores son objetos producto
 */

public class Nodo{
    /**
     * El valor correspondiente del nodo es un objeto producto
     */
    Producto producto;
    /*
     * Los nodos hijos derecho e izquierdo del nodo trabajado
     */
    Nodo leftNode, rightNode;

    /**
     * Constructor correspondiente
     * @param producto objeto producto asociado al valor del nodo
     */
    public Nodo(Producto producto){
        this.producto = producto;
    }

    //Get y set de producto
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    //Get y set de leftnode
    public Nodo getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Nodo leftNode) {
        this.leftNode = leftNode;
    }

    //Get y set de rightnode
    public Nodo getRightNode() {
        return rightNode;
    }

    public void setRightNode(Nodo rightNode) {
        this.rightNode = rightNode;
    }
    
}