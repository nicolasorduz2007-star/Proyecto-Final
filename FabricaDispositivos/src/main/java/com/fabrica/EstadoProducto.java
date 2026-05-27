package com.fabrica;

import java.util.Scanner;

public class EstadoProducto {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Variable para almacenar el estado del producto
        String estado;

        /*
         * BUCLE FOR (Iteración ascendente)
         * Recorre del 1 al 5 para simular los 5 productos
         */
        for (int i = 1; i <= 5; i++) {

            System.out.println("Producto #" + i);

            // Solicita el estado del producto
            System.out.print("Ingrese el estado (Procesado / Defectuoso): ");
            estado = sc.nextLine();

            System.out.println("Estado registrado: " + estado);
            System.out.println("--------------------------");
        }

        /*
         * BUCLE WHILE (Conteo descendente)
         * Simula el cierre del lote desde 5 hasta 1
         */
        int contador = 5;

        while (contador >= 1) {
            System.out.println("Cerrando lote del producto #" + contador);
            contador--;
        }

        System.out.println("Reporte final generado correctamente.");

        sc.close();
    }
}