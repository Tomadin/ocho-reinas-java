package com.mycompany.egi_algebra;

import entidades.Tablero;
import java.util.Scanner;

public class rompecabezas {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----- PROBLEMA DE LAS 8 DAMAS -----\n");
        
        int opc;
        do {
            System.out.println("Selecciona un tablero:");
            System.out.println("1. Tablero 1 (7 reinas)");
            System.out.println("2. Tablero 2 (6 reinas)");
            System.out.println("3. Tablero 3 (5 reinas)");
            System.out.println("4. Tablero 4 (4 reinas)");
            System.out.println("5. Tablero 5 (3 reinas)");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            opc = sc.nextInt();
            switch (opc) {
                case 1:
                    Tablero tablero1 = new Tablero(new int[][]{
                        {0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0, 1, 0, 0},
                        {1, 0, 0, 0, 0, 0, 0, 0}
                    });
                    resolverTableroObjeto(tablero1, "Tablero 1");
                    break;
                    
                case 2:
                    Tablero tablero2 = new Tablero(new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 1, 0, 0, 0, 0, 0, 0}
                    });
                    resolverTableroObjeto(tablero2, "Tablero 2");
                    break;
                    
                case 3:
                    Tablero tablero3 = new Tablero(new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0},
                        {1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0}
                    });
                    resolverTableroObjeto(tablero3, "Tablero 3");
                    break;
                    
                case 4:
                    Tablero tablero4 = new Tablero(new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0},
                        {1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 0, 0, 0, 0}
                    });
                    resolverTableroObjeto(tablero4, "Tablero 4");
                    break;
                case 5:
                    Tablero tablero5 = new Tablero(new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0}
                    });
                    resolverTableroObjeto(tablero5, "Tablero 5");
                    break; 
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida\n");
            }
        } while (opc != 6);
        sc.close();
    }
    
    private static void resolverTableroObjeto(Tablero tableroObj, String nombre) {
        System.out.println("\n--- " + nombre + " ---");
        
        System.out.println("Estado inicial:");
        tableroObj.mostrar();
        
        System.out.println("Resolviendo...");
        
        boolean solucion = tableroObj.resolver();

        if (solucion) {
            System.out.println("¡SOLUCIÓN ENCONTRADA!");
            tableroObj.mostrar();
        } else {
            System.out.println("No hay solución para este tablero");
        }
    }
    
}