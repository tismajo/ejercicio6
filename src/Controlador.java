import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Controlador {
    public void crearVerificarCSV() {
        File inventarioTienda = new File("ticketsCSV.csv");
        if (!inventarioTienda.exists()) {
            try {
                inventarioTienda.createNewFile();
                System.out.println("Todo listo para empezar...");
            } catch (IOException e) {
                System.out.println("Error encontrado: " + e.getMessage());
            }
        }
    }
    
    public void nuevoTicketPrioridadAlta(double totalHoras, int mult, double comision){
        PrioridadAlta PA = new PrioridadAlta();
        double resultado = PA.calcularIngreso(totalHoras, mult, comision);
        agregarDatosCSV("Alta", totalHoras, mult, comision, resultado);
    }

    public void nuevoTicketPrioridadMedia(double totalHoras, int mult, double comision){
        PrioridadMedia PM = new PrioridadMedia();
        double resultado = PM.calcularIngreso(totalHoras, mult, comision);
        agregarDatosCSV("Media", totalHoras, mult, comision, resultado);
    }

    public void nuevoTicketPrioridadBaja(double totalHoras, int mult){
        PrioridadBaja PB = new PrioridadBaja();
        double resultado = PB.calcularIngreso(totalHoras, mult, 0);
        agregarDatosCSV("Baja", totalHoras, mult, 0, resultado);
    }

    public void agregarDatosCSV(String prioridad, double totalHoras, int mult, double comision, double resultado){
        String archivo = "ticketsCSV.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))){
            writer.write(prioridad + "," + totalHoras + "," + mult + "," + comision + "," + resultado);
            writer.newLine();
            System.out.println("Dato agregado con éxito.");
        } catch(IOException e){
            System.out.println("Error al escribir: "+ e.getMessage());
        }
    }

    public void verIngresos(){
        String archivoCSV = "ticketsCSV.csv";
        String separador = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;
            double suma = 0.0;

            while ((linea = br.readLine()) != null) {
                String[] columnas = linea.split(separador);
                if (columnas.length > 4) {
                    double valorColumna = Double.parseDouble(columnas[4]);
                    suma += valorColumna;
                }
            }

            System.out.println("El total de ingresos es: Q" + suma);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }

    public void listarTickets(){
        int contadorPrioridadAlta = 0;
        int contadorPrioridadMedia = 0;
        int contadorBaja = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("ticketsCSV.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] columnas = linea.split(",");
                for (String dato : columnas) {
                    if (dato.equalsIgnoreCase("Alta")) {
                        contadorPrioridadAlta++;
                    } else if (dato.equalsIgnoreCase("Media")) {
                        contadorPrioridadMedia++;
                    } else if (dato.equalsIgnoreCase("Baja")) {
                        contadorBaja++;
                    }
                }
            }
            System.out.println("Listado de prioridades:");
            System.out.println("Alta: " + contadorPrioridadAlta);
            System.out.println("Media: " + contadorPrioridadMedia);
            System.out.println("Baja: " + contadorBaja);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }
}