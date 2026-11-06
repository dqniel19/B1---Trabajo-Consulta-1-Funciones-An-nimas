# Lista base de productos
productos = [
    {"nombre": "Laptop", "categoria": "Tecnología", "precio": 1200.0, "stock": 5},
    {"nombre": "Mouse Gamer", "categoria": "Tecnología", "precio": 45.0, "stock": 15},
    {"nombre": "Teclado Mecánico", "categoria": "Tecnología", "precio": 85.0, "stock": 8},
    {"nombre": "Monitor 24\"", "categoria": "Tecnología", "precio": 220.0, "stock": 4},
    {"nombre": "Silla Ergonómica", "categoria": "Muebles", "precio": 250.0, "stock": 3},
    {"nombre": "Escritorio", "categoria": "Muebles", "precio": 180.0, "stock": 2},
    {"nombre": "Audífonos Inalámbricos", "categoria": "Tecnología", "precio": 95.0, "stock": 12},
    {"nombre": "Cafetera", "categoria": "Hogar", "precio": 60.0, "stock": 7},
    {"nombre": "Licuadora", "categoria": "Hogar", "precio": 45.0, "stock": 10},
    {"nombre": "Lámpara LED", "categoria": "Hogar", "precio": 25.0, "stock": 20},
    {"nombre": "Mochila para Laptop", "categoria": "Accesorios", "precio": 40.0, "stock": 0},
    {"nombre": "Smartwatch", "categoria": "Tecnología", "precio": 150.0, "stock": 6}
]

# 1. SELECCIÓN (filter): Productos de tecnología con precio menor a 500
baratos = list(filter(lambda p: p["categoria"] == "Tecnología" and p["precio"] < 500, productos))
print("1. Selección:", baratos, "\n")

# 2. TRANSFORMACIÓN (map): Obtener los nombres de todos los productos en mayúsculas
nombres_mayus = list(map(lambda p: p["nombre"].upper(), productos))
print("2. Transformación:", nombres_mayus, "\n")

# 3. VALIDACIÓN (any): Comprobar si existe algún producto agotado (stock == 0)
hay_agotados = any(map(lambda p: p["stock"] == 0, productos))
print("3. Validación (Hay agotados):", hay_agotados, "\n")

# 4. EXTREMOS (max con key): Encontrar el producto con el precio más alto
mas_caro = max(productos, key=lambda p: p["precio"])
print("4. Extremos (Más caro):", mas_caro)