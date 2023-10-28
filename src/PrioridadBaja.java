public class PrioridadBaja implements Ticket{
    public double calcularIngreso(double totalHoras, int mult, double comision){
        double calculo1 = totalHoras*mult;
        return calculo1;
    }
}
