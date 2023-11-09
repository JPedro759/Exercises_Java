public class Loan {
    private Collaborator _collaborator;

    public Loan(Collaborator collaborator) {
        this._collaborator = collaborator;
    }

    public void calculateNotesForGreatestValue(double value) {
        System.out.println("\nNotas de maior valor:");

        int notes100 = (int) (value / 100);
        int notes50 = (int) ((value % 100) / 50);

        if (notes100 > 0) System.out.println(notes100 + "x 100 reais");
        if (notes50 > 0) System.out.println(notes50 + "x 50 reais");
    }

    public void calculateNoteForLowestValue(double value) {
        System.out.println("\nNotas de menor valor:");

        int notes20 = (int) (value / 20);
        int notes10 = (int) ((value % 20) / 10);
        int notes5 = (int) ((value % 20) % 10 / 5);
        int notes2 = (int) ((value % 20) % 10 % 5 / 2);

        if (notes20 > 0) System.out.println(notes20 + "x 20 reais");
        if (notes10 > 0) System.out.println(notes10 + "x 10 reais");
        if (notes5 > 0) System.out.println(notes5 + "x 5 reais");
        if (notes2 > 0) System.out.println(notes2 + "x 2 reais");
    }

    public void calculateHalfAndHalfNotes(double value) {
        double halfValue = value / 2;

        System.out.println(halfValue + " reais em notas de maior valor:");
        calculateNotesForGreatestValue(halfValue);

        System.out.println(halfValue + " reais em notas de menor valor:");
        calculateNoteForLowestValue(halfValue);
    }
}
