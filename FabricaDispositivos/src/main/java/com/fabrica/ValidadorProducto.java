package com.fabrica;

import java.util.Scanner;

/**
 * Clase encargada de validar los productos en la línea de ensamblaje
 */
public class ValidadorProducto {
    private Scanner scanner;

    public ValidadorProducto() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Valida un producto solicitando su estado al usuario
     * @param producto El producto a validar
     * @return true si el producto fue aceptado, false si fue rechazado
     */
    public boolean validarProducto(Producto producto) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("VALIDANDO PRODUCTO #" + producto.getId());
        System.out.println("=".repeat(60));
        System.out.println("Nombre: " + producto.getNombre());
        System.out.println("Modelo: " + producto.getModelo());

        System.out.println("\nSeleccione el estado del producto:");
        System.out.println("1. Aceptado");
        System.out.println("2. Defectuoso");
        System.out.println("3. En Revisión");
        System.out.println("4. Rechazado");
        System.out.print("Ingrese su opción (1-4): ");

        int opcion = obtenerOpcionValida(1, 4);

        String observaciones;
        switch (opcion) {
            case 1:
                producto.setEstado(EstadoProducto.ACEPTADO);
                observaciones = "Producto cumple con estándares de calidad";
                break;
            case 2:
                producto.setEstado(EstadoProducto.DEFECTUOSO);
                System.out.print("Describa el defecto encontrado: ");
                scanner.nextLine();
                observaciones = scanner.nextLine();
                break;
            case 3:
                producto.setEstado(EstadoProducto.EN_REVISIÓN);
                System.out.print("Motivo de la revisión: ");
                scanner.nextLine();
                observaciones = scanner.nextLine();
                break;
            case 4:
                producto.setEstado(EstadoProducto.RECHAZADO);
                System.out.print("Razón del rechazo: ");
                scanner.nextLine();
                observaciones = scanner.nextLine();
                break;
            default:
                producto.setEstado(EstadoProducto.EN_REVISIÓN);
                observaciones = "Estado no determinado";
        }

        producto.setObservaciones(observaciones);
        System.out.println("✓ Producto validado: " + producto.getEstado().getDescripcion());

        return producto.getEstado() == EstadoProducto.ACEPTADO;
    }

    /**
     * Obtiene una opción válida del usuario dentro de un rango
     * @param minimo Valor mínimo permitido
     * @param maximo Valor máximo permitido
     * @return La opción ingresada por el usuario
     */
    private int obtenerOpcionValida(int minimo, int maximo) {
        int opcion = -1;
        while (opcion < minimo || opcion > maximo) {
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                if (opcion < minimo || opcion > maximo) {
                    System.out.print("Opción inválida. Ingrese un número entre " + minimo + " y " + maximo + ": ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Error: Ingrese un número válido: ");
            }
        }
        return opcion;
    }

    public void cerrar() {
        scanner.close();
    }
}
