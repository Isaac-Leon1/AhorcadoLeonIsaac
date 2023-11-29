import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String [] palabras = {"tomate","esfero","elefante","rojo","casa","computadora","mesa","laptop","koala","vaca"};
        Random random = new Random();
        int n = random.nextInt(palabras.length);
        String palabraOculta=palabras[n];
        int nPalabraOculta = palabraOculta.length();
        boolean juegoGanado=false, letraEncontrada=false;

        char [] palabraJuego = new char[nPalabraOculta];
        for (int i = 0; i < palabraJuego.length; i++) {
            palabraJuego[i]= '_';
        }
        int intentos=7;
        System.out.println("\t\tAHORCADO");
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\t\t\tTienes "+ intentos+" intentos.");
            System.out.println("Ingrese una letra: ");
            char letraIngresada = scanner.next().charAt(0);
            boolean bandera=false;
            for (int i = 0; i < palabraOculta.length(); i++) {
                if (palabraOculta.charAt(i)==letraIngresada){
                    palabraJuego[i] = letraIngresada;
                    letraEncontrada=true;
                }
            }
            if (letraEncontrada==true){
                System.out.println("Has encontrado una letra!");
                for (char l:palabraJuego){
                    if(l=='_'){
                        bandera=false;
                        break;
                    }else {
                        bandera=true;
                    }
                }
            }else {
                System.out.println("No hay esa letra en la palabra");
                intentos--;
            }
            letraEncontrada=false;
            if (bandera==true){
                System.out.println("Has descubierto la palabra!!");
                juegoGanado=true;
            }

            System.out.println(palabraJuego);


        }while (intentos!=0 && juegoGanado==false);
        if (!juegoGanado){
            System.out.println("Has perdido :(");
        }
        System.out.println("Gracias por jugar!!");
    }
}