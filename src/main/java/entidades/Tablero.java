package entidades;

public class Tablero {
    private int[][] tablero;
    private static final int N = 8;

    // Constructor con tablero inicial
    public Tablero(int[][] tableroInicial) {
        tablero = new int[N][N];
        cargarTablero(tableroInicial);
    }

    // Cargar tablero completo predefinido
    public void cargarTablero(int[][] tableroInicial) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tablero[i][j] = tableroInicial[i][j];
            }
        }
    }

    // Verificar si una posición es segura
    private boolean esSeguro(int fila, int col) {
        // Verificar cada posicion de la fila, si hay una dama en esa fila returna falso
        for (int i = 0; i < N; i++) {
            if (tablero[fila][i] == 1) {
                return false;
            }
        }

        // Verificar cada posicion de la columna, si hay una dama en esa columna returna falso
        for (int i = 0; i < N; i++) {
            if (tablero[i][col] == 1) {
                return false;
            }
        }

        // Verificar diagonales
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //revisa si hay una dama en la celda (i,j) y ignora la posicion de(fila, col)
                if (tablero[i][j] == 1 && (i != fila || j != col)) {
                    if (Math.abs(i - fila) == Math.abs(j - col)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // Contar reinas en el tablero
    public int contarReinas() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    // Resolver completando las reinas faltantes
    public boolean resolver() {
        int reinasActuales = contarReinas();

        // Si ya hay 8 reinas, verificar si es válida
        if (reinasActuales == 8) {
            return esConfiguracionValida();
        }

        // Usar backtracking para completar
        return backtrack();
    }

    // Verificar si la configuración actual es válida
    private boolean esConfiguracionValida() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i][j] == 1) {
                    if (!esSeguro(i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // Algoritmo Backtracking para completar las reinas y volver atras si no hay respuesta.
    private boolean backtrack() {
        // Buscar primera posición vacía
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i][j] == 0 && esSeguro(i, j)) {
                    tablero[i][j] = 1;

                    // Si llegamos a 8 reinas, terminamos
                    if (contarReinas() == 8) {
                        return true;
                    }

                    // Continuar buscando
                    if (backtrack()) {
                        return true;
                    }

                    // Backtrack
                    tablero[i][j] = 0;
                }
            }
        }
        return false;
    }

    // Mostrar tablero
    public void mostrar() {
        System.out.println("\nTablero (" + contarReinas() + " reinas):");
        System.out.println("  0 1 2 3 4 5 6 7");
        for (int i = 0; i < N; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < N; j++) {
                System.out.print(tablero[i][j] == 1 ? "O " : "X ");
            }
            System.out.println();
        }
        System.out.println();
    }
}