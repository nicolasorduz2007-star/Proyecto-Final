package com.fabrica;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa la línea de ensamblaje de la fábrica
 * Gestiona la validación de productos y genera reportes
 */
public class LineaEnsamblaje {
    private List<Producto> productos;
    private int productosAceptados;
    private int productosRechazados;
    private int productosEnRevision;
    private ValidadorProducto validador;

    public LineaEnsamblaje() {
        this.productos = new ArrayList<>();
        this.productosAceptados = 0;
        this.productosRechazados = 0;
        this.productosEnRevision = 0;
        this.validador = new ValidadorProducto();
    }

    /**
     * Agrega un producto a la línea de ensamblaje
     * @param producto El producto a agregar
     */
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    /**
     * Inicia el proceso de validación de todos los productos
     */
    public void iniciarValidacion() {
        System.out.println("\n" + "█".repeat(60));
        System.out.println("█ INICIANDO PROCESO DE VALIDACIÓN DE PRODUCTOS");
        System.out.println("█ Total de productos a validar: " + productos.size());
        System.out.println("█".repeat(60));

        // Recorrer cada producto y validarlo
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            validador.validarProducto(producto);
            contabilizarResultado(producto);

            // Indicador de progreso
            System.out.println("Progreso: " + (i + 1) + " de " + productos.size() + " productos validados");
        }

        validador.cerrar();
    }

    /**
     * Contabiliza el resultado de la validación de un producto
     * @param producto El producto validado
     */
    private void contabilizarResultado(Producto producto) {
        switch (producto.getEstado()) {
            case ACEPTADO:
                productosAceptados++;
                break;
            case RECHAZADO:
            case DEFECTUOSO:
                productosRechazados++;
                break;
            case EN_REVISIÓN:
                productosEnRevision++;
                break;
        }
    }

    /**
     * Genera y muestra el reporte final del proceso de validación
     */
    public void generarReporte() {
        System.out.println("\n\n" + "█".repeat(60));
        System.out.println("█ REPORTE FINAL DE PROCEDIMIENTO");
        System.out.println("█".repeat(60));

        System.out.println("\n📊 ESTADÍSTICAS GENERALES:");
        System.out.println("   Total de productos procesados: " + productos.size());
        System.out.println("   ✓ Productos aceptados: " + productosAceptados + " (" + calcularPorcentaje(productosAceptados) + "%)");
        System.out.println("   ✗ Productos rechazados: " + productosRechazados + " (" + calcularPorcentaje(productosRechazados) + "%)");
        System.out.println("   ⚠ Productos en revisión: " + productosEnRevision + " (" + calcularPorcentaje(productosEnRevision) + "%)");

        System.out.println("\n📋 DETALLE DE PRODUCTOS:");
        System.out.println("-".repeat(60));

        for (Producto producto : productos) {
            String icono = obtenerIconoEstado(producto.getEstado());
            System.out.printf("%s Producto ID#%d: %s (Modelo: %s)%n",
                    icono, producto.getId(), producto.getNombre(), producto.getModelo());
            System.out.printf("   Estado: %s%n", producto.getEstado().getDescripcion());
            System.out.printf("   Observaciones: %s%n", producto.getObservaciones());
            System.out.println("-".repeat(60));
        }

        System.out.println("\n📈 CONCLUSIONES:");
        generarConclusiones();

        System.out.println("\n" + "█".repeat(60));
        System.out.println("█ FIN DEL REPORTE");
        System.out.println("█".repeat(60) + "\n");
    }

    /**
     * Calcula el porcentaje de un valor respecto al total de productos
     * @param cantidad La cantidad a calcular
     * @return El porcentaje redondeado a una decimal
     */
    private double calcularPorcentaje(int cantidad) {
        if (productos.isEmpty()) return 0;
        return Math.round((cantidad * 100.0 / productos.size()) * 10.0) / 10.0;
    }

    /**
     * Obtiene el icono representativo del estado de un producto
     * @param estado El estado del producto
     * @return El icono correspondiente
     */
    private String obtenerIconoEstado(EstadoProducto estado) {
        return switch (estado) {
            case ACEPTADO -> "✓";
            case RECHAZADO, DEFECTUOSO -> "✗";
            case EN_REVISIÓN -> "⚠";
        };
    }

    /**
     * Genera conclusiones basadas en los resultados de la validación
     */
    private void generarConclusiones() {
        double tasaAceptacion = calcularPorcentaje(productosAceptados);

        if (tasaAceptacion >= 80) {
            System.out.println("   ✓ Proceso de control de calidad EXITOSO");
            System.out.println("   ✓ La línea de ensamblaje está operando correctamente");
        } else if (tasaAceptacion >= 60) {
            System.out.println("   ⚠ ADVERTENCIA: Tasa de aceptación moderada");
            System.out.println("   ⚠ Se recomienda revisar el proceso de ensamblaje");
        } else {
            System.out.println("   ✗ ALERTA: Tasa de aceptación baja");
            System.out.println("   ✗ Se requiere intervención inmediata en la línea");
        }

        if (productosEnRevision > 0) {
            System.out.println("   • " + productosEnRevision + " producto(s) pendiente(s) de revisión adicional");
        }
    }

    // Getters
    public List<Producto> getProductos() {
        return productos;
    }

    public int getProductosAceptados() {
        return productosAceptados;
    }

    public int getProductosRechazados() {
        return productosRechazados;
    }

    public int getProductosEnRevision() {
        return productosEnRevision;
    }
}
