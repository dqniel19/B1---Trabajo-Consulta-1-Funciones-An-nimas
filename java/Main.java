import java.util.List;
import java.util.Comparator;

public class Main {

    // Definición del registro base
    public record Producto(String nombre, String categoria, double precio, int stock) {}

    public static void main(String[] args) {

        // Lista base de productos
        List<Producto> productos = List.of(
                new Producto("Laptop", "Tecnología", 1200.0, 5),
                new Producto("Mouse Gamer", "Tecnología", 45.0, 15),
                new Producto("Teclado Mecánico", "Tecnología", 85.0, 8),
                new Producto("Monitor 24\"", "Tecnología", 220.0, 4),
                new Producto("Silla Ergonómica", "Muebles", 250.0, 3),
                new Producto("Escritorio", "Muebles", 180.0, 2),
                new Producto("Audífonos Inalámbricos", "Tecnología", 95.0, 12),
                new Producto("Cafetera", "Hogar", 60.0, 7),
                new Producto("Licuadora", "Hogar", 45.0, 10),
                new Producto("Lámpara LED", "Hogar", 25.0, 20),
                new Producto("Mochila para Laptop", "Accesorios", 40.0, 0),
                new Producto("Smartwatch", "Tecnología", 150.0, 6)
        );

        // 1. SELECCIÓN (filter): Productos de tecnología con precio menor a 500
        List<Producto> baratos = productos.stream()
                .filter(p -> p.categoria().equals("Tecnología") && p.precio() < 500)
                .toList();
        System.out.println("1. Selección: " + baratos + "\n");

        // 2. TRANSFORMACIÓN (map): Obtener los nombres de todos los productos en mayúsculas
        List<String> nombresMayus = productos.stream()
                .map(p -> p.nombre().toUpperCase())
                .toList();
        System.out.println("2. Transformación: " + nombresMayus + "\n");

        // 3. VALIDACIÓN (anyMatch): Comprobar si existe algún producto agotado (stock == 0)
        boolean hayAgotados = productos.stream()
                .anyMatch(p -> p.stock() == 0);
        System.out.println("3. Validación (Hay agotados): " + hayAgotados + "\n");

        // 4. EXTREMOS (max): Encontrar el producto con el precio más alto
        Producto masCaro = productos.stream()
                .max(Comparator.comparingDouble(Producto::precio))
                .orElse(null);
        System.out.println("4. Extremos (Más caro): " + masCaro);
    }
}