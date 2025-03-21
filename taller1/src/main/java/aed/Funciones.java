package aed;

class Funciones {
    int cuadrado(int x) {
        return x*x;
    }

    double cuadradoDoble(double x) {
        return x*x;
    }

    double distancia(double x, double y) {
        return Math.sqrt(cuadradoDoble(x) + cuadradoDoble(y));
    }

    boolean esPar(int n) {
        if(n%2 == 0){
            return true;
        }
        return false;
    }

    boolean esBisiesto(int n) {
        if ( (n%4 == 0 && n%100 != 0) || n%400 == 0 ){
            return true;
        }
        return false;
    }

    int factorialIterativo(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res = res*i;
        }
        return res;
    }

    int factorialRecursivo(int n) {
        if (n > 1){
            return n * factorialIterativo(n-1);
        }
        return 1;
    }

    boolean esPrimo(int n) {
        if (n<=1) {
            return false;
        }
        for (int i = 2; i <= Math.floor(n/2); i++) {
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }

    int sumatoria(int[] numeros) {
        int res = 0;
        for (int i : numeros) {
            res+=i;
        }
        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        for (int i = 0; i < numeros.length; i++) {
            if (buscado == numeros[i]){
                return i;
            }
        }
        /* 
         * agregado porque la es necesario un caso para compilar. 
         * a menos que tome res = 0 y vaya mutando res
        */
        return -1; 
    }

    boolean tienePrimo(int[] numeros) {
        for (int i : numeros) {
            if (esPrimo(i)){
                return true;
            }
        }
        return false;
    }

    boolean todosPares(int[] numeros) {
        for (int i : numeros) {
            if (!esPar(i)){
                return false;
            }
        }
        return true;
    }

    boolean esPrefijo(String s1, String s2) {
            String[] letraS1 = s1.split("");
            String[] letraS2 = s2.split("");
            if (letraS1.length > letraS2.length) {
                return false;
            }
            for (int i = 0; i < letraS1.length; i++) {
                if (!letraS1[i].equals(letraS2[i])){
                    return false;
                }
            }
            return true;
        }
    
        boolean esSufijo(String s1, String s2) {
            return esPrefijo(reverse(s1), reverse(s2));
        }
    
        private String reverse(String palabra) {
            String res = "";
            String[] iterablStrings = palabra.split("");
            for (int i = iterablStrings.length - 1; i >= 0; i--) {
                res+=iterablStrings[i];
            }
            return res;
        }
}
