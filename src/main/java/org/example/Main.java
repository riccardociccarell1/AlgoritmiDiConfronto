package org.example;

public class Main {
    public static void main(String[] args) {
        EditDistance editdistance = new EditDistance();
        editdistance.Print("ALBERO", "LABBRO");
        editdistance.allinea("ALBERO", "LABBRO", editdistance.EditistanceMatrix("ALBERO", "LABBRO"));
        System.out.println();
        editdistance.allinea("AAAA", "BBBB", editdistance.EditistanceMatrix("AAAA", "BBBB"));

    }
}