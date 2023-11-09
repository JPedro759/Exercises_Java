import java.text.SimpleDateFormat;
import java.util.Date;

public class Collaborator {
    private String _name;

    private Date _admissionDate;
    private int _timeHome;
    private double _salary;

    public Collaborator(String name, Date admissionDate, int timeHome, double salary) {
        this._name = name;
        this._admissionDate = admissionDate;
        this._timeHome = timeHome;
        this._salary = salary;
    }

    public String getName() {
        return this._name;
    }

    public String getAdmissionDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(this._admissionDate);
    }

    public int getTimeHome() {
        return this._timeHome;
    }

    public double getSalary() {
        return this._salary;
    }

    @Override
    public String toString() {
        return "\nNome do colaborador: " + getName() + "\nData de admissão: " + getAdmissionDate() + "\nTempo de casa: " + getTimeHome() + "\nSalário: " + getSalary();
    }
}
