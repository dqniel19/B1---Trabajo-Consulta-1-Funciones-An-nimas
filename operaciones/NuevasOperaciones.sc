// Definición de la clase de objetos
case class Producto(nombre: String, categoria: String, precio: Double, stock: Int)

val productos = List(
  Producto("Laptop", "Tecnología", 1200.0, 5),
  Producto("Mouse Gamer", "Tecnología", 45.0, 15),
  Producto("Teclado Mecánico", "Tecnología", 85.0, 8),
  Producto("Monitor 24\"", "Tecnología", 220.0, 4),
  Producto("Silla Ergonómica", "Muebles", 250.0, 3),
  Producto("Escritorio", "Muebles", 180.0, 2),
  Producto("Audífonos Inalámbricos", "Tecnología", 95.0, 12),
  Producto("Cafetera", "Hogar", 60.0, 7),
  Producto("Licuadora", "Hogar", 45.0, 10),
  Producto("Lámpara LED", "Hogar", 25.0, 20),
  Producto("Mochila para Laptop", "Accesorios", 40.0, 0),
  Producto("Smartwatch", "Tecnología", 150.0, 6)
)

// 1. ORDENAMIENTO (sortBy): Ordenar catálogo de menor a mayor precio
val productosOrdenados = productos.sortBy(p => p.precio)

// 2. AGRUPACIÓN (groupBy): Clasificar el inventario por su categoría
val productosPorCategoria = productos.groupBy(p => p.categoria)

// 3. PARTICIÓN (partition): Separar en dos listas (precio mayor a 100 y menores/iguales a 100)
val (caros, accesibles) = productos.partition(p => p.precio > 100.0)

// 4. BÚSQUEDA (find): Obtener el primer producto que se encuentre agotado (stock == 0)
val productoCritico = productos.find(p => p.stock == 0)

// 5. COMBINACIÓN DE OPERACIONES: Nombres de productos caros (> 100) ordenados por stock ascendente
val resultadoCombinado = productos
  .partition(p => p.precio > 100)._1
  .sortBy(p => p.stock)
  .map(p => p.nombre)