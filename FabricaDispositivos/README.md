# Sistema de Validación de Productos - Fábrica de Dispositivos Electrónicos

## Descripción
Este programa implementa un sistema de validación de productos en una línea de ensamblaje de dispositivos electrónicos. El algoritmo recorre cada uno de los 5 productos, solicita su estado al operario y genera un reporte final con estadísticas y conclusiones.

## Estructura del Proyecto

```
FabricaDispositivos/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── fabrica/
│   │               ├── Main.java                 # Programa principal
│   │               ├── Producto.java             # Clase que representa un producto
│   │               ├── EstadoProducto.java       # Enumeración de estados
│   │               ├── ValidadorProducto.java    # Valida productos (interacción con usuario)
│   │               └── LineaEnsamblaje.java      # Gestiona la línea y genera reportes
│   └── test/
│       └── java/
└── README.md
```

## Clases Principales

### 1. **Producto.java**
Representa un dispositivo electrónico con los siguientes atributos:
- `id`: Identificador único del producto
- `nombre`: Nombre del dispositivo
- `modelo`: Modelo del dispositivo
- `estado`: Estado del producto (ACEPTADO, DEFECTUOSO, EN_REVISIÓN, RECHAZADO)
- `observaciones`: Comentarios sobre el producto

### 2. **EstadoProducto.java**
Enumeración que define los estados posibles:
- **ACEPTADO**: Producto cumple con estándares
- **DEFECTUOSO**: Tiene defectos identificados
- **EN_REVISIÓN**: Requiere análisis adicional
- **RECHAZADO**: No cumple con requisitos

### 3. **ValidadorProducto.java**
Clase encargada de:
- Validar cada producto interactuando con el usuario
- Solicitar el estado de cada dispositivo
- Registrar observaciones según el estado seleccionado
- Validar entrada del usuario

### 4. **LineaEnsamblaje.java**
Gestiona:
- Lista de productos a validar
- Conteos de productos por estado
- Proceso de validación secuencial
- Generación de reporte final con:
  - Estadísticas generales (aceptados, rechazados, en revisión)
  - Porcentajes
  - Detalle de cada producto
  - Conclusiones y recomendaciones

### 5. **Main.java**
Programa principal que:
1. Inicializa la línea de ensamblaje
2. Crea 5 productos de ejemplo (Smartphone, Tablet, Laptop, Auriculares, Smartwatch)
3. Inicia el proceso de validación
4. Genera el reporte final

## Ejecución

### Compilar el proyecto:
```bash
javac -d bin src/main/java/com/fabrica/*.java
```

### Ejecutar el programa:
```bash
java -cp bin com.fabrica.Main
```

## Flujo del Algoritmo

```
1. INICIO
2. Crear línea de ensamblaje
3. Cargar 5 productos
4. PARA CADA producto:
   a. Mostrar información del producto
   b. Solicitar estado al operario
   c. Si es defectuoso/rechazado → solicitar descripción
   d. Si está en revisión → solicitar motivo
   e. Registrar observaciones
   f. Contabilizar resultado
5. Calcular estadísticas:
   - Total aceptados
   - Total rechazados
   - Total en revisión
6. MOSTRAR reporte con:
   - Estadísticas
   - Detalle de productos
   - Análisis y conclusiones
7. FIN
```

## Ejemplo de Interacción

```
SISTEMA DE VALIDACIÓN DE PRODUCTOS
FÁBRICA DE DISPOSITIVOS ELECTRÓNICOS

📦 CARGANDO PRODUCTOS EN LA LÍNEA DE ENSAMBLAJE...

✓ Producto 1: Smartphone
✓ Producto 2: Tablet
✓ Producto 3: Laptop
✓ Producto 4: Auriculares Inalámbricos
✓ Producto 5: Smartwatch

============================================================
VALIDANDO PRODUCTO #1
============================================================
Nombre: Smartphone
Modelo: SGX-2024

Seleccione el estado del producto:
1. Aceptado
2. Defectuoso
3. En Revisión
4. Rechazado
Ingrese su opción (1-4): 1
✓ Producto validado: Aceptado

[Continúa con los siguientes productos...]
```

## Reporte Final

El reporte incluye:

- **Estadísticas Generales**: Total procesado, aceptados (%), rechazados (%), en revisión (%)
- **Detalle de Productos**: Información de cada dispositivo con estado y observaciones
- **Conclusiones**: 
  - Si tasa de aceptación ≥ 80%: Proceso exitoso
  - Si tasa de aceptación 60-80%: Advertencia, revisar proceso
  - Si tasa de aceptación < 60%: Alerta, intervención inmediata

## Características

✓ Validación interactiva de 5 productos
✓ Manejo de múltiples estados
✓ Entrada robusta del usuario
✓ Reporte detallado con estadísticas
✓ Análisis y recomendaciones automáticas
✓ Interfaz clara y estructurada

## Requisitos

- Java 8 o superior

## Notas

- El programa requiere entrada del usuario durante la validación
- Las observaciones se registran según el estado seleccionado
- Las estadísticas se calculan en tiempo real
- El reporte se genera automáticamente al finalizar
