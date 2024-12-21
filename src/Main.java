//Código Actividad n7
//Calculadora de área, potencia y perímetro
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcionFigura, opcionOperacion;
        boolean continuar = true;

        while (continuar) {
            // Menú principal para elegir figura
            System.out.println("=== Calculadora de Área, Perímetro y Potencia ===");
            System.out.println("Elija la figura geométrica o tipo de operación:");
            System.out.println("1. Círculo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Triángulo");
            System.out.println("4. Rectángulo");
            System.out.println("5. Pentágono");
            System.out.println("6. Potencia");
            System.out.println("7. Salir");
            System.out.print("Opción: ");
            opcionFigura = entrada.nextInt();

            if (opcionFigura == 7) {
                continuar = false;
                System.out.println("Saliendo del programa. ¡Gracias!");
                break;
            }

            // Operación específica
            if (opcionFigura == 6) { // Potencia
                calcularPotencia(entrada);
            } else {
                // Menú para elegir la operación
                System.out.println("Elija la operación:");
                System.out.println("1. Área");
                System.out.println("2. Perímetro");
                System.out.print("Opción: ");
                opcionOperacion = entrada.nextInt();

                // Llamar a métodos según la figura y operación seleccionada
                switch (opcionFigura) {
                    case 1: // Círculo
                        calcularCirculo(opcionOperacion, entrada);
                        break;
                    case 2: // Cuadrado
                        calcularCuadrado(opcionOperacion, entrada);
                        break;
                    case 3: // Triángulo
                        calcularTriangulo(opcionOperacion, entrada);
                        break;
                    case 4: // Rectángulo
                        calcularRectangulo(opcionOperacion, entrada);
                        break;
                    case 5: // Pentágono
                        calcularPentagono(opcionOperacion, entrada);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            }
            System.out.println(); // Salto de línea
        }

        entrada.close();
    }

    // Método recursivo para calcular la potencia
    public static double potenciaRecursiva(double base, int exponente) {
        if (exponente == 0) {
            return 1; // Caso base: cualquier número elevado a 0 es 1
        } else if (exponente > 0) {
            return base * potenciaRecursiva(base, exponente - 1);
        } else { // Manejo de exponentes negativos
            return 1 / potenciaRecursiva(base, -exponente);
        }
    }

    // Método para ingresar base y exponente
    public static void calcularPotencia(Scanner entrada) {
        System.out.print("Digite la base: ");
        double base = entrada.nextDouble();
        System.out.print("Digite el exponente (puede ser negativo): ");
        int exponente = entrada.nextInt();

        double resultado = potenciaRecursiva(base, exponente);
        System.out.printf("El resultado de %.2f elevado a %d es: %.2f\n", base, exponente, resultado);
    }

    // Métodos previos para figuras geométricas
    public static void calcularCirculo(int operacion, Scanner entrada) {
        System.out.print("Digite el radio del círculo: ");
        double radio = entrada.nextDouble();
        if (operacion == 1) {
            double area = Math.PI * Math.pow(radio, 2);
            System.out.printf("El área del círculo es: %.2f\n", area);
        } else if (operacion == 2) {
            double perimetro = 2 * Math.PI * radio;
            System.out.printf("El perímetro del círculo es: %.2f\n", perimetro);
        } else {
            System.out.println("Operación no válida.");
        }
    }

    public static void calcularCuadrado(int operacion, Scanner entrada) {
        System.out.print("Digite el lado del cuadrado: ");
        double lado = entrada.nextDouble();
        if (operacion == 1) {
            double area = Math.pow(lado, 2);
            System.out.printf("El área del cuadrado es: %.2f\n", area);
        } else if (operacion == 2) {
            double perimetro = 4 * lado;
            System.out.printf("El perímetro del cuadrado es: %.2f\n", perimetro);
        } else {
            System.out.println("Operación no válida.");
        }
    }

    public static void calcularTriangulo(int operacion, Scanner entrada) {
        if (operacion == 1) {
            System.out.print("Digite la base del triángulo: ");
            double base = entrada.nextDouble();
            System.out.print("Digite la altura del triángulo: ");
            double altura = entrada.nextDouble();
            double area = (base * altura) / 2;
            System.out.printf("El área del triángulo es: %.2f\n", area);
        } else if (operacion == 2) {
            System.out.print("Digite los tres lados del triángulo separados por espacios: ");
            double lado1 = entrada.nextDouble();
            double lado2 = entrada.nextDouble();
            double lado3 = entrada.nextDouble();
            double perimetro = lado1 + lado2 + lado3;
            System.out.printf("El perímetro del triángulo es: %.2f\n", perimetro);
        } else {
            System.out.println("Operación no válida.");
        }
    }

    public static void calcularRectangulo(int operacion, Scanner entrada) {
        System.out.print("Digite el largo del rectángulo: ");
        double largo = entrada.nextDouble();
        System.out.print("Digite el ancho del rectángulo: ");
        double ancho = entrada.nextDouble();
        if (operacion == 1) {
            double area = largo * ancho;
            System.out.printf("El área del rectángulo es: %.2f\n", area);
        } else if (operacion == 2) {
            double perimetro = 2 * (largo + ancho);
            System.out.printf("El perímetro del rectángulo es: %.2f\n", perimetro);
        } else {
            System.out.println("Operación no válida.");
        }
    }

    public static void calcularPentagono(int operacion, Scanner entrada) {
        if (operacion == 1) {
            System.out.print("Digite el lado del pentágono: ");
            double lado = entrada.nextDouble();
            System.out.print("Digite el apotema del pentágono: ");
            double apotema = entrada.nextDouble();
            double area = (5 * lado * apotema) / 2;
            System.out.printf("El área del pentágono es: %.2f\n", area);
        } else if (operacion == 2) {
            System.out.print("Digite el lado del pentágono: ");
            double lado = entrada.nextDouble();
            double perimetro = 5 * lado;
            System.out.printf("El perímetro del pentágono es: %.2f\n", perimetro);
        } else {
            System.out.println("Operación no válida.");
        }
    }
}


