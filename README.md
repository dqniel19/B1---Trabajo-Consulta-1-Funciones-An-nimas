Trabajo de Consulta: Funciones Anónimas

Parte 1 – Explorar: la programación funcional en el mundo real

Busca 2 casos reales que usen programación funcional o funciones anónimas.

Caso 1: Procesamiento Masivo de Datos en Tiempo Real con Apache Spark (Scala / Java)

Qué problema resuelven: Las grandes empresas tecnológicas, financieras y de comercio electrónico procesan petabytes de datos distribuidos en clústeres de computadoras (por ejemplo, análisis de registros de clics de usuarios, motores de recomendación o detección de fraude en milisegundos). El reto es transformar, filtrar y agregar volúmenes masivos de datos de manera eficiente sin bloquear los hilos de ejecución.Qué lenguaje o herramienta usan: Apache Spark, un motor de análisis unificado escrito principalmente en Scala (que también ofrece APIs para Java y Python).   

Qué ventaja les da el enfoque funcional: Spark se basa fuertemente en estructuras de datos inmutables y operaciones de orden superior (map, filter, reduce, flatMap). Al pasar funciones anónimas (lambdas) como parámetros a estas operaciones, el código de transformaciones se vuelve altamente declarativo. Spark puede distribuir este código de manera transparente a través de cientos de nodos en la nube sabiendo que, al ser funciones puras sin efectos secundarios colaterales, la ejecución paralela es segura y tolerante a fallos.

Ejemplo de código real (Repositorio de GitHub):
En el repositorio oficial de ejemplos de Apache Spark, las operaciones sobre colecciones distribuidas (RDDs o DataFrames) utilizan funciones anónimas constantemente. Por ejemplo, filtrando registros de logs:

```scala
// Ejemplo inspirado en Apache Spark (Scala)
val logLines = sc.textFile("hdfs://etl/logs/access.log")
// La función anónima (line => ...) filtra las líneas que contienen errores 500
val errorLogs = logLines.filter(line => line.contains("ERROR 500"))
val errorCount = errorLogs.count()
```

Repositorio: https://github.com/apache/spark

Caso 2: Procesamiento de Datos Financieros y Científicos con Pandas (Python)

Qué problema resuelven: Los analistas de datos, científicos e instituciones financieras necesitan manipular, limpiar y transformar tablas multidimensionales gigantescas (millones de filas de transacciones bursátiles, historiales médicos o métricas de sensores) de forma limpia, evitando bucles for imperativos tradicionales que son lentos y propensos a errores de índices.Qué lenguaje o herramienta usan: La librería pandas de Python.   

Qué ventaja les da el enfoque funcional: Pandas permite aplicar funciones anónimas de Python (lambda) directamente sobre columnas completas (Series) o filas enteras (DataFrame.apply()). Esto permite calcular métricas complejas, normalizar datos monetarios o aplicar reglas de negocio dinámicas en una sola línea expresiva, mejorando la legibilidad y reduciendo drásticamente la cantidad de código repetitivo (boilerplate).

Ejemplo de código real (Repositorio de GitHub):
Un caso típico en análisis financiero usando funciones anónimas para categorizar transacciones en un DataFrame:Pythonimport pandas as pd

# Dataset simulado de transacciones
data = {'transaccion': [1, 2, 3], 'monto': [150.0, 45.0, 1200.0]}
df = pd.DataFrame(data)

# Aplicando una función anónima para clasificar el tipo de riesgo fiscal o comercial
df['categoria'] = df['monto'].apply(lambda x: 'Alto Riesgo' if x > 1000 else 'Normal')
print(df)

Repositorio: https://github.com/pandas-dev/pandas

Parte 2: Entender: ¿qué es una función anónima?

¿Qué es una función anónima y de dónde viene el nombre lambda?   

Una función anónima es un bloque de código ejecutable que no posee un identificador o nombre explícito en el código fuente. Se utiliza comúnmente para definir lógica de forma rápida y puntual sin la necesidad de declarar una función formal con nombre.El nombre lambda proviene del cálculo lambda ($\lambda$-calculus), un sistema formal desarrollado en la década de 1930 por el matemático estadounidense Alonzo Church para investigar la definición de funciones, la aplicación y la recursión. Church utilizó la letra griega minúscula $\lambda$ (lambda) como operador para abstraer funciones sin nombre.

```python
# Ejemplo en Python de una función anónima (lambda) que calcula el doble de un número
duplicar = lambda x: x * 2
print(duplicar(5))  # Salida: 10
```

¿En qué se diferencia de una función nombrada? Escribe la misma lógica de ambas formas.   

Función nombrada: Se declara utilizando una palabra clave específica (def, fun, etc.), cuenta con un identificador único que permite llamarla desde cualquier parte de su ámbito y suele ocupar varias líneas con bloques estructurados.

Función anónima: Carece de nombre, suele definirse "al vuelo" en el mismo lugar donde se va a utilizar (por ejemplo, como argumento de otra función) y por lo general se limita a una sola expresión concisa.

```python
# A) Función nombrada tradicional
def calcular_area(base, altura):
    return base * altura

print(calcular_area(4, 5))  # Salida: 20


# B) Función anónima (lambda) equivalente
area_lambda = lambda base, altura: base * altura

print(area_lambda(4, 5))  # Salida: 20
```

¿Qué significa que las funciones sean ciudadanos de primera clase? ¿Por qué eso permite pasar una lambda a map o filter?   
Que las funciones sean ciudadanos de primera clase significa que el lenguaje las trata como cualquier otro tipo de dato común (como un entero, una cadena o un objeto). Esto implica que una función puede:

Asignarse a variables.

Almacenarse en estructuras de datos (listas, mapas).

Retornarse desde otras funciones.

Pasarse como argumento a otras funciones (lo que da origen a las funciones de orden superior).

Esto es exactamente lo que permite enviar una función anónima a métodos como map o filter, ya que estas colecciones esperan recibir como parámetro una función ejecutable para aplicarla elemento por elemento.

```scala
// Ejemplo en Scala demostrando funciones como ciudadanos de primera clase
val numeros = List(1, 2, 3, 4, 5)

// 'filter' recibe una función anónima (n => n % 2 == 0) como argumento
val numerosPares = numeros.filter(n => n % 2 == 0)

println(numerosPares) // Salida: List(2, 4)
```

¿Qué es un closure? Muestra una lambda que use una variable definida fuera de ella.   

Un closure (cierre) es una función anónima (o nombrada) que "captura" o referencia variables libres que se encuentran definidas en un ámbito exterior (fuera de su propio cuerpo local). Esto permite que la función recuerde y acceda a los valores de esas variables externas incluso cuando el ámbito donde fueron creadas ya haya finalizado su ejecución.

```python
# Ejemplo de Closure en Python
def generar_multiplicador(factor):
    # 'factor' es una variable definida fuera de la función anónima (ámbito exterior)
    return lambda x: x * factor

# Creamos una función closure que recuerda que el factor es 3
multiplicar_por_tres = generar_multiplicador(3)

print(multiplicar_por_tres(10))  # Salida: 30 (captura el 3 y opera sobre el 10)
```
