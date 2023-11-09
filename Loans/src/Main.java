import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nNome do colaborador: ");
        String name = scanner.nextLine();

        System.out.print("Data de admissão do colaborador (em formato dd/MM/yyyy): ");
        String admissionDateStr = scanner.nextLine();

        Date admissionDate = null;

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            admissionDate = dateFormat.parse(admissionDateStr);
        } catch (Exception e) {
            System.out.print("Data de admissão inválido!");
        }

        System.out.print("Tempo da casa (em anos): ");
        int timeHome = scanner.nextInt();

        System.out.print("Salário atual do colaborador: ");
        double salary = scanner.nextDouble();

        Collaborator collaborator = new Collaborator(name, admissionDate, timeHome, salary);

        if (collaborator.getTimeHome() > 5) {
            Loan loan = new Loan(collaborator);

            System.out.print("\nInforme o valor do empréstimo: ");
            double loanValue = scanner.nextDouble();

            scanner.nextLine();

            if(loanValue % 2 == 0 && loanValue <= 2 * collaborator.getSalary()){
                System.out.println(collaborator);
                System.out.println("\nValor do empréstimo: " + loanValue + " reais\n");

                System.out.println("Escolha a opção de retirada: ");
                System.out.println("\n1 - Notas para maior valor");
                System.out.println("2 - Notas para menor valor");
                System.out.println("3 - Notas meio a meio");

                System.out.print("\nOpção: ");
                String op = scanner.nextLine();

                switch(op){
                    case "1" -> loan.calculateNotesForGreatestValue(loanValue);
                    case "2" -> loan.calculateNoteForLowestValue(loanValue);
                    case "3" -> loan.calculateHalfAndHalfNotes(loanValue);
                    default -> System.out.println("\nEscolha inválida!");
                }
            } else {
                System.out.println("Insira um valor válido!");
            }
        } else {
            System.out.println("\nAgradecemos seu interesse, mas você não atende os requisitos mínimos do programa.");
        }
    }
}