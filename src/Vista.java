import java.util.Scanner;

public class Vista {
    Scanner scn = new Scanner(System.in);
    Controlador c = new Controlador();

    public void mostrarMenu() {
            while (true) {
                c.crearVerificarCSV();
                System.out.println("\nM E N Ú");
                System.out.println("Ingresa el número de opción: ");
                System.out.println("1. Nuevo ticket\n2. Ver ingresos totales\n3. Cantidad de tickets por prioridad\n0. Salir");
                int opcion = scn.nextInt();
                switch (opcion) {
                    case 1:
                    scn = new Scanner(System.in);
                    System.out.print("¿Qué prioridad deseas ingresar? (Alta, media, baja): ");
                    String resp = scn.nextLine();
                    System.out.print("Ingresa el total de horas: ");
                    scn = new Scanner(System.in);
                    double totalHoras = scn.nextInt();
                    if (resp.equalsIgnoreCase("Alta")){
                        System.out.print("¿Qué día es?: ");
                        scn = new Scanner(System.in);
                        String dia = scn.nextLine();
                        if (dia.equalsIgnoreCase("lunes") || dia.equalsIgnoreCase("martes") || dia.equalsIgnoreCase("miércoles") || dia.equalsIgnoreCase("jueves") || dia.equalsIgnoreCase("viernes")) {
                            c.nuevoTicketPrioridadAlta(totalHoras, 8, 0.05);
                        }else if(dia.equalsIgnoreCase("sabado") || dia.equalsIgnoreCase("domingo")){
                            c.nuevoTicketPrioridadAlta(totalHoras, 8, 0.2);
                        }
                        
                    } else if (resp.equalsIgnoreCase("Media")){
                        System.out.print("Ingresa la cantidad de comisión (se acepta de 0.05 a 0.10): ");
                        scn = new Scanner(System.in);
                        double comision = scn.nextDouble();
                        c.nuevoTicketPrioridadMedia(totalHoras, 10, comision);
                    } else if (resp.equalsIgnoreCase("Baja")){
                        c.nuevoTicketPrioridadBaja(totalHoras, 10);
                    }
                        break;
                    case 2:
                    c.verIngresos();
                        break;
                    case 3:
                    c.listarTickets();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, ingrese una opción válida :)");
                        break;
                }
            }
    }
}
