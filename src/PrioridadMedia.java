public class PrioridadMedia implements Ticket {
    public double calcularIngreso(double totalHoras, int mult, double comision){
        double calculo1 = totalHoras*mult;
        double calculo2 = calculo1*comision;
        double resultado = calculo1 + calculo2;
        return resultado;
    }
}
