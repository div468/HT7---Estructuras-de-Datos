import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Ing. Douglas Barrios
 * @author: Marcelo Detlefsen
 * Creación: 23/03/2025
 * última modificación: 23/03/2025
 * File Name: Main.java
 * Descripción: Clase principal que maneja la lectura del CSV y la búsqueda de productos por SKU
 */
public class Main {
    
    /**
     * Método principal que ejecuta el programa
     * @param args argumentos de línea de comando
     */
    public static void main(String[] args) {
        // Crear un HashMap que mapea categorías a sus respectivos BSTs
        HashMap<String, BST<Producto>> categoryBSTs = new HashMap<>();
        
        // Leer el archivo CSV
        String csvFile = "skus.csv";
        
        try {
            readCSV(csvFile, categoryBSTs);
            System.out.println("Archivo CSV cargado exitosamente.");
            
            // Interacción con el usuario
            Scanner scanner = new Scanner(System.in);
            boolean continuar = true;
            
            while (continuar) {
                System.out.println("\nMarcelo Detlefsen - Hoja de Trabajo 7 - Julían Divas");
                System.out.println("        --- Sistema de Búsqueda de Productos ---");
                System.out.println("1. Buscar un producto en base al SKU.");
                System.out.println("2. Salir del programa.");
                System.out.print("Ingrese su opción: ");
                
                int opcion;
                try {
                    opcion = scanner.nextInt();
                    scanner.nextLine(); // Consume el salto de línea
                } catch (Exception e) {
                    System.out.println("SKU no válido inválida. Por favor ingrese un número existente.");
                    scanner.nextLine(); // Limpiar el buffer
                    continue;
                }
                
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el SKU del producto: ");
                        String sku = scanner.nextLine();
                        buscarProductoPorSKU(sku, categoryBSTs);
                        break;
                    case 2:
                        continuar = false;
                        System.out.println("Saliendo del programa... ¡Espero te haya sido útil!");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            }
            
            scanner.close();
            
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }
    
    /**
     * Lee el archivo CSV y carga los productos en BSTs organizados por categoría
     * @param csvFile ruta del archivo CSV
     * @param categoryBSTs mapa que contiene los BSTs organizados por categoría
     * @throws IOException si hay un error al leer el archivo
     */
    private static void readCSV(String csvFile, HashMap<String, BST<Producto>> categoryBSTs) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        String line;
        int lineNumber = 0;
        
        // Leer la primera línea (encabezados)
        line = br.readLine();
        lineNumber++;
        
        // Procesar las líneas de datos
        while ((line = br.readLine()) != null) {
            lineNumber++;
            try {
                // Dividir la línea en campos
                String[] data = line.split(",");
                
                // Verificar si hay suficientes columnas
                if (data.length < 19) {
                    System.out.println("Advertencia: La línea " + lineNumber + " no tiene suficientes columnas. Se omitirá.");
                    continue;
                }
                
                // Extraer los datos relevantes y verificar que no estén vacíos
                String category = data[0].trim();
                String sku = data[6].trim();
                String productName = data[18].trim();
                
                // Convertir precios, manejando valores vacíos o no numéricos
                double priceCurrent = 0.0;
                double priceRetail = 0.0;
                
                try {
                    if (data[10] != null && !data[10].trim().isEmpty()) {
                        priceCurrent = Double.parseDouble(data[10].trim());
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Advertencia: Precio mayorista inválido en la línea " + lineNumber + ". Se usará 0.0.");
                }
                
                try {
                    if (data[9] != null && !data[9].trim().isEmpty()) {
                        priceRetail = Double.parseDouble(data[9].trim());
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Advertencia: Precio retail inválido en la línea " + lineNumber + ". Se usará 0.0.");
                }
                
                // Verificar que los campos obligatorios no estén vacíos
                if (sku.isEmpty() || productName.isEmpty() || category.isEmpty()) {
                    System.out.println("Advertencia: Campos obligatorios vacíos en la línea " + lineNumber + ". Se omitirá.");
                    continue;
                }
                
                // Crear un objeto Producto
                Producto producto = new Producto(sku, productName, category, priceCurrent, priceRetail);
                
                // Obtener o crear el BST para esta categoría
                BST<Producto> bst = categoryBSTs.getOrDefault(category, new BST<>());
                
                // Añadir el producto al BST
                bst.añadirNodo(producto);
                
                // Guardar el BST actualizado en el mapa
                categoryBSTs.put(category, bst);
                
            } catch (Exception e) {
                System.out.println("Error al procesar la línea " + lineNumber + ": " + e.getMessage() + ". Se omitirá.");
            }
        }
        
        br.close();
    }
    
    /**
     * Busca un producto por su SKU en todos los BSTs de categorías
     * @param sku el SKU del producto a buscar
     * @param categoryBSTs mapa que contiene los BSTs organizados por categoría
     */
    private static void buscarProductoPorSKU(String sku, HashMap<String, BST<Producto>> categoryBSTs) {
        Producto productoMasBarato = null;
        
        // Buscar el producto en cada categoría
        for (String category : categoryBSTs.keySet()) {
            BST<Producto> bst = categoryBSTs.get(category);
            Producto producto = bst.buscarPorSKU(sku);
            
            if (producto != null) {
                // Si es el primer producto encontrado o tiene un precio menor al actual más barato
                if (productoMasBarato == null || producto.getPriceCurrent() < productoMasBarato.getPriceCurrent()) {
                    productoMasBarato = producto;
                }
            }
        }
        
        // Mostrar el resultado
        if (productoMasBarato != null) {
            System.out.println("\n=== Producto Encontrado ===");
            System.out.println("SKU: " + productoMasBarato.getSku());
            System.out.println("Nombre: " + productoMasBarato.getProductName());
            System.out.println("Categoría: " + productoMasBarato.getCategory());
            System.out.println("Precio Retail: $" + productoMasBarato.getPriceRetail());
            System.out.println("Precio Mayorista: $" + productoMasBarato.getPriceCurrent());
        } else {
            System.out.println("No se encontró ningún producto con el SKU: " + sku);
        }
    }
}