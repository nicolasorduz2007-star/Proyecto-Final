import java.util.*;

// Clase que representa un producto del inventario
class Producto {
    String nombre;
    int cantidad;
    double precio;

    // Constructor para inicializar los atributos del producto
    public Producto(String nombre, int cantidad, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }
}

public class Inventario {


// Lista donde se almacenan los productos
static ArrayList<Producto> productos = new ArrayList<>();

// Lista donde se registran las ventas realizadas
static ArrayList<String> ventas = new ArrayList<>();

// Objeto Scanner para leer datos del usuario
static Scanner sc = new Scanner(System.in);

public static void main(String[] args) {
    int opcion;

    // Ciclo principal del sistema (menú)
    do {
        mostrarMenu(); // Muestra el menú
        opcion = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        // Evaluar la opción elegida por el usuario
        switch (opcion) {
            case 1:
                agregarProducto(); // Llama al método para agregar productos
                break;
            case 2:
                realizarVenta(); // Llama al método para vender productos
                break;
            case 3:
                reporteVentas(); // Muestra el reporte de ventas
                break;
            case 4:
                reporteStock(); // Muestra el stock disponible
                break;
            case 5:
                System.out.println("Gracias por usar el sistema.");
                break;
            default:
                System.out.println("Opción inválida");
        }
    } while (opcion != 5); // Repetir hasta que el usuario decida salir
}

// Método que muestra el menú principal
public static void mostrarMenu() {
    System.out.println("\n--- Sistema de Inventario ---");
    System.out.println("1. Agregar producto");
    System.out.println("2. Realizar venta");
    System.out.println("3. Reporte de ventas");
    System.out.println("4. Reporte de stock");
    System.out.println("5. Salir");
    System.out.print("Seleccione: ");
}

// Método para agregar un nuevo producto al inventario
public static void agregarProducto() {
    System.out.print("Nombre: ");
    String nombre = sc.nextLine();

    System.out.print("Cantidad: ");
    int cantidad = sc.nextInt();

    System.out.print("Precio: ");
    double precio = sc.nextDouble();

    // Validación para evitar datos negativos
    if (cantidad < 0 || precio < 0) {
        System.out.println("Error: valores negativos");
        return;
    }

    // Se agrega el producto a la lista
    productos.add(new Producto(nombre, cantidad, precio));
    System.out.println("Producto agregado.");
}

// Método para realizar una venta
public static void realizarVenta() {
    System.out.print("Producto: ");
    String nombre = sc.nextLine();

    // Se recorre la lista de productos para buscar coincidencia
    for (Producto p : productos) {
        if (p.nombre.equalsIgnoreCase(nombre)) {

            System.out.print("Cantidad a vender: ");
            int cant = sc.nextInt();

            // Validar que haya suficiente stock
            if (cant > p.cantidad) {
                System.out.println("No hay suficiente stock");
                return;
            }

            // Calcular el total de la venta
            double total = cant * p.precio;

            // Actualizar el stock del producto
            p.cantidad -= cant;

            // Guardar la venta en la lista
            ventas.add("Producto: " + p.nombre + 
                       " | Cantidad: " + cant + 
                       " | Total: " + total);

            System.out.println("Venta realizada. Total: " + total);
            return;
        }
    }

    // Si no se encuentra el producto
    System.out.println("Producto no encontrado");
}

// Método que muestra todas las ventas realizadas
public static void reporteVentas() {
    // Verifica si hay ventas registradas
    if (ventas.isEmpty()) {
        System.out.println("No hay ventas registradas.");
    } else {
        System.out.println("\n--- REPORTE DE VENTAS ---");

        // Recorre la lista de ventas y las muestra
        for (String v : ventas) {
            System.out.println(v);
        }
    }
}

// Método que muestra el stock actual de productos
public static void reporteStock() {
    // Verifica si hay productos registrados
    if (productos.isEmpty()) {
        System.out.println("No hay productos registrados.");
    } else {
        System.out.println("\n--- REPORTE DE STOCK ---");

        // Recorre todos los productos y muestra su información
        for (Producto p : productos) {
            System.out.println("Producto: " + p.nombre + 
                               " | Stock: " + p.cantidad);
        }
    }
}

}
