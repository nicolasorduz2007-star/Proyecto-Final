import java.util.Scanner;

public class AdivinanzaLimpio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Genera numero secreto aleatorio entre 1 y 100
        int secreto = (int)(Math.random() * 100) + 1;
        
        // Variables requeridas
        int conteo_intentos = 0;
        int sumatoria_todos_intentos = 0;
        boolean bandera_rendido = false;
        
        int intento, opcion;
        boolean acerto = false;

        // Ciclo principal del juego
        while (!acerto && !bandera_rendido) {
            System.out.println("\n--- JUEGO DE ADIVINANZA ---");
            System.out.println("1. Adivinar");
            System.out.println("2. Rendirse");
            System.out.println("3. Hint (par/impar)");
            System.out.print("Elige una opcion: ");
            
            opcion = sc.nextInt();

            if (opcion == 1) {
                // Opcion 1: Adivinar
                System.out.print("Ingresa tu numero (1-100): ");
                intento = sc.nextInt();

                // Validar rango
                if (intento < 1 || intento > 100) {
                    System.out.println("El numero debe estar entre 1 y 100");
                    continue;
                }

                conteo_intentos++;
                sumatoria_todos_intentos += intento;

                // If-else anidado para comparar
                if (intento > secreto) {
                    System.out.println("BAJA - El numero secreto es menor");
                } else if (intento < secreto) {
                    System.out.println("SUBE - El numero secreto es mayor");
                } else {
                    System.out.println("GANASTE! El numero era: " + secreto);
                    acerto = true;
                }

            } else if (opcion == 2) {
                // Opcion 2: Rendirse
                System.out.println("Te rendiste. El numero secreto era: " + secreto);
                bandera_rendido = true;

            } else if (opcion == 3) {
                // Opcion 3: Hint (par/impar)
                if (secreto % 2 == 0) {
                    System.out.println("HINT: El numero es PAR");
                } else {
                    System.out.println("HINT: El numero es IMPAR");
                }
            } else {
                System.out.println("Opcion no valida. Intenta de nuevo");
            }
        }

        // Mostrar estadisticas finales
        System.out.println("\n========== REPORTE FINAL ==========");
        if (conteo_intentos > 0) {
            double promedio = (double) sumatoria_todos_intentos / conteo_intentos;
            System.out.println("Total de intentos: " + conteo_intentos);
            System.out.println("Sumatoria de intentos: " + sumatoria_todos_intentos);
            System.out.println("Promedio de intentos: " + String.format("%.2f", promedio));
        } else {
            System.out.println("No realizaste ningun intento.");
        }
        
        if (acerto) {
            System.out.println("Estado: GANASTE");
        } else {
            System.out.println("Estado: RENDIDO");
        }
        System.out.println("===================================\n");

        sc.close();
    }
}
