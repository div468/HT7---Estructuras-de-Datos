import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BSTTest {

    private BST<Producto> bst;

    // Inicializa un BST vacío antes de las pruebas
    @BeforeEach
    public void setUp() {
        bst = new BST<>();
    }

    /*
     * Comprueba que se añade un nodo correctamente
     */
    @Test
    public void testRaizIgual() {
        Producto producto = new Producto("SKU1", "Producto1", "Categoria1", 100.0, 150.0);

        bst.nuevoNodo(producto);

        Nodo raiz = bst.getRaiz();

        assertEquals(producto, raiz.getProducto(), "El producto en la raíz debería ser igual al primer producto que se insertó.");
    }
}