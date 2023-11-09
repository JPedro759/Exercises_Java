public class Consultant {
    private String _name, _email, _dateBirth;

    public Consultant(String name, String email, String dateBirth) {
        this._name = name;
        this._email = email;
        this._dateBirth = dateBirth;
    }

    public String getName() {
        return _name;
    }

    public String getEmail() {
        return _email;
    }

    public String getDateBirth() {
        return _dateBirth;
    }
}
