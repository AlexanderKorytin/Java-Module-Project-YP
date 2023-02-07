import java.util.Scanner;
public class Main
{

    public static void main(String[] args) {
        print("Введие количество человек оплачивающих счет:");
        int numberPeople =  waitInt(1,100);
        print("Число гостей — " + numberPeople);
    }

    public static int waitInt (int numPeopleMin, int numPeopleMax)
    {
        int numberPeople = 0;
        String message = "Введите целое число > %d и < %d";
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            if (scanner.hasNextInt())
            {
                numberPeople = scanner.nextInt();
                if(numberPeople>numPeopleMin&&numberPeople<numPeopleMax)
                {
                    scanner.close();
                    return numberPeople;
                }
                else
                {
                    print(String.format(message, numPeopleMin, numPeopleMax));
                }
            }
            if (!scanner.hasNextInt()) {
                print(String.format(message, numPeopleMin, numPeopleMax));
                scanner.next();
            }
        }
    }

    public static void print(String massege)
    {
        System.out.println(massege);
    }
}
