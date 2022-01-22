public class Practica2 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java Practica2 <int>");
            System.exit(1);
        } else {
            int z;
            int n = -1;
            try {
                n = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Uso: java Practica2 <int>");
                System.exit(1);
            }
            int[] v = new int[n];
            generateArr(v, n);
            for (int i = 0; i < n; i++) {
                System.out.println(i + ":" + v[i]);
            }
            z = v[(int) (Math.random() * n)];
            System.out.println("El numero aleatorio es: " + z);
            int index = findIndex(z, v, 0, n - 1);
            System.out.println("El índice encontrado: " + index);
            if (index == -1) {
                System.out.println("El numero no esta en el array");
            } else {
                System.out.println("El numero encontrado: " + v[index]);
            }
        }
    }

    private static void generateArr(int[] v, int n) {
        int min = 0;
        int max = 1000;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                v[i] = (int) Math.round(Math.random() * (max - min) + min);
            } else {
                min = v[i - 1] - 1;
                max = v[i - 1] + 1;
                v[i] = (int) Math.round(Math.random() * (max - min) + min);
            }
        }
        if (v[0] >= v[n - 1]) {
            generateArr(v, n);
        }
    }

    private static int findIndex(int z, int[] v, int i, int j) {
        int[] minmax = new int[2];
        if (i > j) {
            if (i < v.length && v[i] == z) {
                return i;
            }
            return -1;
        }
        if (v[i] == z)
            return i;
        minmax = minMax(v, i, j / 2);
        if (z > minmax[0] && z < minmax[1])
            return findIndex(z, v, i, (i + j) / 2);
        else
            return findIndex(z, v, (i + j) / 2 + 1, j);
    }

    private static int[] minMax(int[] v, int i, int j) {
        int min = 10000;
        int max = -1;
        for (int k = i; k < j; k++) {
            if (max < v[k]) {
                max = v[k];
            }
            if (min > v[k]) {
                min = v[k];
            }
        }
        int minmax[] = { min, max };
        return minmax;
    }

}
