/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.time.LocalDate;


/**
 *
 * @author ACER
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // tabla de amortizacion francesa

        // entradas
        float monto = 1000;
        int nummeses = 4;
        double tasaInteres = 0.05; // 5% mensual
        double numerador = (tasaInteres * Math.pow((1 + tasaInteres), nummeses));
        double denominador = Math.pow((1 + tasaInteres), nummeses) - 1;
        double cuota = monto * (numerador / denominador);
        double pagoInteres = 0;
        double pagoCapital = 0;  //amortizacion
        double SaldoCapital = monto;
        LocalDate date = LocalDate.now();
        LocalDate newDate;
       

        System.out.println("Fecha Inicial");
        System.out.println(date);

        // mesinicial + numeromeses <=12  sumar +1
        // resulta 13 > sumar 1 al año  y mes = 01
        for (int i = 0; i <= nummeses; i++) {

            if (i == 0) {
                System.out.println("Nª Cuota: " + i);
                System.out.printf("Cuota: %.4f", cuota);
                System.out.println(" ");
                System.out.println("PagoInteres: " + pagoInteres);
                System.out.println("PagoCapital: " + pagoCapital);
                System.out.println("SaldoCapital: " + monto);

                System.out.println("-----------------------------------");

            } else {
                pagoInteres = Math.round((tasaInteres * SaldoCapital) * 100.0) / 100.0;
                pagoCapital = Math.round((cuota - pagoInteres) * 100.0) / 100.0;
                SaldoCapital = Math.round((SaldoCapital - pagoCapital) * 100.0) / 100.0;
                newDate= date.plusMonths(i-(i-1));
                date = newDate;
                newDate = date;
                System.out.println("Nª Cuota: " + i);
                System.out.printf("Cuota: %.4f", cuota);
                System.out.println("");
                System.out.println("Fecha de Cuota: "+ newDate);
                System.out.println("PagoInteres: " + pagoInteres);
                System.out.println("PagoCapital: " + pagoCapital);
                System.out.println("SaldoCapital: " + SaldoCapital);

                System.out.println("-----------------------------------");
            }
        }

    }

}
