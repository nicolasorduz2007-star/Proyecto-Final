import java.util.Scanner;
public class Adivinanza {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int secreto = (int)(Math.random() * 100) + 1;
        int intento, opcion;
        int conteo = 0;
        int suma = 0;
        boolean terminado = false;
        boolean bandera_rendido = false;

        while (!terminado) {
            System.out.println("1. Adivinar  2. Rendirse  3. Hint");
            opcion = sc.nextInt();

            if (opcion == 1) {
                System.out.print("Ingresa tu numero: ");
                intento = sc.nextInt();

                conteo++;
                suma += intento;

                if (intento > secreto) {
                    System.out.println("Baja");
                } else if (intento < secreto) {
                    System.out.println("Sube");
                } else {
                    System.out.println("Ganaste!");
                    terminado = true;
                }

            } else if (opcion == 2) {
                System.out.println("Te rendiste. El numero era: " + secreto);
                bandera_rendido = true;
                terminado = true;

            } else if (opcion == 3) {
                if (secreto % 2 == 0) {
                    System.out.println("Es par");
                } else {
                    System.out.println("Es impar");
                }
            }
        }

        if (conteo > 0) {
            double promedio = (double)suma / conteo;
            System.out.println("Intentos: " + conteo);
            System.out.println("Promedio: " + promedio);
        }

        if (bandera_rendido) {
            System.out.println("Estado: RENDIDO");
        } else {
            System.out.println("Estado: GANASTE");
        }

        sc.close();
    }
}