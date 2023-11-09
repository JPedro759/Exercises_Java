import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        String ConsultantFile = "consultants.txt";
        String BirthdayPersonFile = "birthday_persons.txt";

        Calendar calendar = new GregorianCalendar();
        int currentMonth = calendar.get(Calendar.MONTH) + 1;

        try (BufferedReader br = new BufferedReader(new FileReader(ConsultantFile)); BufferedWriter bw = new BufferedWriter(new FileWriter(BirthdayPersonFile))) {

            String line;

            while ((line = br.readLine()) != null) {
                String data[] = line.split("\\|");

                if(data.length == 3){
                    String name = data[0];
                    String email = data[1];
                    String dateBirth = data[2];

                    String[] partsDateBirth = dateBirth.split("/");

                    if(partsDateBirth.length == 3){
                        int MonthBirth = Integer.parseInt(partsDateBirth[1]);

                        if(MonthBirth == currentMonth) {
                            Consultant consultant = new Consultant(name, email, dateBirth);
                            bw.write(consultant.getName() + "|" + consultant.getEmail() + "|" + consultant.getDateBirth());
                            bw.newLine();
                        }
                    }
                }
            }

            System.out.println("\nAniversariantes do mês foram adicionados em " + BirthdayPersonFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}