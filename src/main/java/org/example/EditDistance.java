package org.example;

public class EditDistance {

    /**
     * metodo stampa la matrice e la edit distance
     *
     * @param X la prima stringa
     * @param Y la seconda stringa
     */
    public void Print(String X, String Y) {
        int[][] M = EditistanceMatrix(X, Y);
        StampaMatrice(X, Y, M);
        System.out.println();
        System.out.print("LA EDIT DISTANCE TRA " + X + " E " + Y + " E'=");
        StampaUltimoElemento(M);
    }


    /**
     * metodo che genera la matrice
     *
     * @param X la prima stringa
     * @param Y la seconda stringa
     * @return la matrice
     */
    public int[][] EditistanceMatrix(String X, String Y) {

        int n = X.length(); //lunghezza della stringa X
        int m = Y.length(); //lunghezza della stringa Y


        // Matrice M di dimensioni (n+1) x (m+1)
        int[][] M = new int[n + 1][m + 1];

        //inizializzazione prima colona
        for (int i = 0; i <= n; i++) {
            M[i][0] = i;
        }

        //inizializzazione prima riga
        for (int j = 0; j <= m; j++) {
            M[0][j] = j;
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int p = 1;                                       //in caso di missmatch
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    p = 0;                                         //in caso di match
                }
                M[i][j] = Math.min(
                        Math.min(M[i - 1][j] + 1,                  //cancellazione
                                M[i][j - 1] + 1),                 //aggiunta
                        M[i - 1][j - 1] + p                //match o sostituzione
                );
            }
        }


        return M;
    }


    /**
     * metodo che stampa la matrice Edit Distance
     *
     * @param X la prima stringa
     * @param Y la seconda stringa
     * @param M la matrice da stampare
     */
    public void StampaMatrice(String X, String Y, int[][] M) {
        int n = X.length();
        int m = Y.length();

        // Spazio iniziale per allineare la riga Ø
        System.out.print("  0 ");
        for (int j = 0; j < m; j++) {
            System.out.print(Y.charAt(j) + " ");
        }
        System.out.println();

        // Stampa ogni riga con intestazione da X
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                System.out.print("0 ");
            } else {
                System.out.print(X.charAt(i - 1) + " ");
            }

            for (int j = 0; j <= m; j++) {
                System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }
    }


    /**
     * metodo che stampa l'ultimo elemento della matrice
     *
     * @param matrice la matrice
     */
    public void StampaUltimoElemento(int[][] matrice) {
        int ultimariga = matrice.length - 1;
        int ultimacolonna = matrice[ultimariga].length - 1;

        System.out.println(matrice[ultimariga][ultimacolonna]);
    }


}
