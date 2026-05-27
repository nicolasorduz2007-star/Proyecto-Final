package com.fabrica;

/**
 * Programa principal para la validación de productos en la fábrica de dispositivos electrónicos
 * 
 * Este programa:
 * 1. Crea una línea de ensamblaje
 * 2. Agrega 5 productos a validar
 * 3. Valida cada producto solicitando su estado
 * 4. Genera un reporte final del procedimiento
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("\n");
        System.out.println("╔" + "═".repeat(58) + "╗");
        System.out.println("║" + " ".repeat(58) + "║");
        System.out.println("║" + centrar("SISTEMA DE VALIDACIÓN DE PRODUCTOS", 58) + "║");
        System.out.println("║" + centrar("FÁBRICA DE DISPOSITIVOS ELECTRÓNICOS", 58) + "║");
        System.out.println("║" + " ".repeat(58) + "║");
        System.out.println("╚" + "═".repeat(58) + "╝");

        // Crear la línea de ensamblaje
        LineaEnsamblaje linea = new LineaEnsamblaje();

        // Crear y agregar 5 productos a la línea
        System.out.println("\n📦 CARGANDO PRODUCTOS EN LA LÍNEA DE ENSAMBLAJE...\n");

        Producto producto1 = new Producto(1, "Smartphone", "SGX-2024");
        Producto producto2 = new Producto(2, "Tablet", "TAB-Pro-15");
        Producto producto3 = new Producto(3, "Laptop", "LPT-UltraBook");
        Producto producto4 = new Producto(4, "Auriculares Inalámbricos", "WH-1000XM4");
        Producto producto5 = new Producto(5, "Smartwatch", "SW-Elite");

        linea.agregarProducto(producto1);
        linea.agregarProducto(producto2);
        linea.agregarProducto(producto3);
        linea.agregarProducto(producto4);
        linea.agregarProducto(producto5);

        System.out.println("✓ Producto 1: " + producto1.getNombre());
        System.out.println("✓ Producto 2: " + producto2.getNombre());
        System.out.println("✓ Producto 3: " + producto3.getNombre());
        System.out.println("✓ Producto 4: " + producto4.getNombre());
        System.out.println("✓ Producto 5: " + producto5.getNombre());

        // Iniciar el proceso de validación
        linea.iniciarValidacion();

        // Generar el reporte final
        linea.generarReporte();
    }

    /**
     * Centra un texto en un ancho específico
     * @param texto El texto a centrar
     * @param ancho El ancho total
     * @return El texto centrado
     */
    private static String centrar(String texto, int ancho) {
        if (texto.length() >= ancho) {
            return texto;
        }
        int espacios = (ancho - texto.length()) / 2;
        return " ".repeat(espacios) + texto + " ".repeat(ancho - texto.length() - espacios);
    }
}
