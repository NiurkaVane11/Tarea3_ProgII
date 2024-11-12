import java.time.LocalDate;
import java.util.Calendar;

/**
 * La clase `Clases` representa una fecha compuesta por día, mes y año.
 * Permite manipular la fecha con métodos para reiniciar, adelantar y normalizar
 * la fecha.
 * 
 * @author Niurka Vanesa Yupanqui
 * @version 1.0
 * @date 11/11/2024
 *       Progra II
 */
public class Clases {

    private int dia;
    private int mes;
    private int ano;

    /**
     * Constructor por defecto que inicializa la fecha a 1/1/2000.
     */
    public Clases() {
        this.dia = 1;
        this.mes = 1;
        this.ano = 2000;
    }

    // Métodos Getters y Setters
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * Reinicia la fecha a los valores proporcionados.
     * 
     * @param dia el nuevo día.
     * @param mes el nuevo mes.
     * @param ano el nuevo año.
     */
    public void metodoReiniciar(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    /**
     * Adelanta la fecha actual sumando los días, meses y años proporcionados.
     * 
     * @param dia el número de días a adelantar.
     * @param mes el número de meses a adelantar.
     * @param ano el número de años a adelantar.
     */
    public void metodoAdelantar(int dia, int mes, int ano) {
        LocalDate fechaActual = LocalDate.of(this.ano, this.mes, this.dia);

        // Sumar los días, meses y años usando la API de LocalDate
        fechaActual = fechaActual.plusDays(dia);
        fechaActual = fechaActual.plusMonths(mes);
        fechaActual = fechaActual.plusYears(ano);

        // Actualizar los valores de la fecha
        this.dia = fechaActual.getDayOfMonth();
        this.mes = fechaActual.getMonthValue();
        this.ano = fechaActual.getYear();
    }

    /**
     * Devuelve el número de días en un mes específico de un año.
     * 
     * @param mes el mes para calcular el número de días.
     * @param ano el año para calcular el número de días.
     * @return el número de días del mes.
     */
    public int metodoDias(int mes, int ano) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(ano, mes, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Normaliza la fecha asegurándose de que el día, mes y año estén en un rango
     * válido.
     * Si el día es mayor que los días del mes, se ajusta al valor máximo.
     * Si el mes es mayor que 12 o menor que 1, se ajusta a 1 o 12 respectivamente.
     * Si el año es menor que 1, se ajusta a 1.
     */
    public void metodoNormalizar() {
        // Asegurarnos de que los valores estén dentro de un rango válido
        if (this.ano < 1)
            this.ano = 1;
        if (this.mes < 1)
            this.mes = 1;
        if (this.mes > 12)
            this.mes = 12;

        int diasDelMes = metodoDias(this.mes, this.ano);
        if (this.dia < 1)
            this.dia = 1;
        if (this.dia > diasDelMes)
            this.dia = diasDelMes;

        // Usamos Calendar para normalizar la fecha
        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        calendar.set(this.ano, this.mes - 1, this.dia);

        this.mes = calendar.get(Calendar.MONTH) + 1;
        this.dia = calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Verifica si el año actual es bisiesto.
     * 
     * @return true si el año es bisiesto, false en caso contrario.
     */
    public boolean esBisiesto() {
        return (this.ano % 400 == 0) || (this.ano % 4 == 0 && this.ano % 100 != 0);
    }

    /**
     * Muestra la fecha en formato "día/mes/año" y si el año es bisiesto.
     */
    public void mostrarFechas() {
        System.out.println("La fecha es: " + getDia() + "/" + getMes() + "/" + getAno());
        if (esBisiesto()) {
            System.out.println("El año " + getAno() + " es bisiesto.");
        } else {
            System.out.println("El año " + getAno() + " no es bisiesto.");
        }
    }

    /**
     * Método principal para demostrar el uso de la clase `Clases`.
     * 
     * @param args los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        Clases clases = new Clases();

        clases.mostrarFechas();

        // Probar con otro año
        clases.setAno(1992);
        clases.mostrarFechas();
    }
}
