/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package caballos;

import java.util.Scanner;

/**
 *
 * @author grier
 */
public class Caballos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int turno = 0;
        char[][] hipodromo;
        int participantes = cantidadParticipantes();
        int apuesta = elegirCaballo(participantes);
        hipodromo = new char[participantes][50];
        iniciarHipodromo(hipodromo);
        while (avanzarCaballo(hipodromo, turno) < 50) {
            if (turno < participantes - 1) {
                turno++;
            } else {
                turno = 0;
            }
        }
        if (apuesta == turno) {
            System.out.println("Ganaste caballo ganador" + turno);
        } else {
            System.out.println("Perdiste, [" + apuesta + "] gana el caballo " + turno);
        }
    }

    public static int avanzarCaballo(char[][] hipodromo, int turno) {
        int contador = 0;
        int numeroAleatorio = 0;
        numeroAleatorio = (int) (Math.random() * 6 + 1);
        for (int i = 0; i < hipodromo[0].length; i++) {
            if (hipodromo[turno][i] == '.' && numeroAleatorio > 0) {
                hipodromo[turno][i] = '#';
                numeroAleatorio--;
            }
            if (numeroAleatorio == 0) {
                break;
            }
            contador++;
        }
        mostrarHipodromo(hipodromo);
        return contador;
    }

    public static int cantidadParticipantes() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Cuantos jugadores habran? ");
        int jugador = sc.nextInt();
        return jugador;
    }

    public static int elegirCaballo(int participantes) {
        Scanner sc = new Scanner(System.in);
        System.out.print("A cual caballo apuestas? ");
        int caballo = sc.nextInt();
        if (caballo > 5) {
            do {
                System.out.println("No hay mas caballos");
            } while (caballo < 6);
        } else {
            System.out.println("Caballo " + caballo + " escogido");
        }
        return caballo;
    }

    public static void iniciarHipodromo(char[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = '.';
            }
        }
    }

    public static void mostrarHipodromo(char[][] hipodromo) {
        for (int i = 0; i < hipodromo.length; i++) {
            System.out.print("[" + i + "]");
            for (int j = 0; j < hipodromo[i].length; j++) {
                System.out.print(hipodromo[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
