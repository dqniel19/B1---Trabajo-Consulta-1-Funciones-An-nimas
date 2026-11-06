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

// 1. SELECCIÓN (filter): Productos de tecnología con precio menor a 500
val baratos = productos.filter(p => p.categoria == "Tecnología" && p.precio < 500)

// 2. TRANSFORMACIÓN (map): Obtener los nombres de todos los productos en mayúsculas 
val nombresMayus = productos.map(p => p.nombre.toUpperCase)

// 3. VALIDACIÓN (exists): Comprobar si existe algún producto agotado (stock == 0) 
val hayAgotados = productos.exists(p => p.stock == 0)

// 4. EXTREMOS (maxBy): Encontrar el producto con el precio más alto
val masCaro = productos.maxBy(p => p.precio)

  
