import java.util.Locale;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        print("Введие количество человек оплачивающих счет:");
        int numberPeople = waitInt(1, 100); // запрашиваем
        // и получаем от пользователя количество человек оплачивающих счет
        String nameList, message, rub = "";
        float priceProd =0.0f, resultRub = 0.0f;
        MenuBar list = new MenuBar("",0.0f);
        Scanner scan = new Scanner(System.in);
        print("Введите наименование товара:");
        // далее производим вычисление и выводим результат
        while (true)
        {
            nameList = list.writeMenu(); // заполняем строку наименованиями
            // введенных пользователем товаров
            print("Введите цену товара в виде 00.00:");
            priceProd = list.priceSum(); // запрашиваем цену товара и прибавляем ее к
            // сумме ранее введенных цен

            if(scan.nextLine().equalsIgnoreCase("Завершить"))
            {
              break;
            }
            else
            {
              print("Введите наименование товара:");
            }
        }
        resultRub = priceProd/numberPeople;
        rub = list.printResult(resultRub); // определяем окончание слова "рубль"
        // в зависимости от полученной суммы товаров
        Locale.setDefault(Locale.US);
        message = "Добавленные товары: %s \nНаобщую сумму: %.2f\n%.2f %s с каждого из %d!";
        print(String.format(message, nameList, priceProd, resultRub, rub, numberPeople));

    }
// далее метод запрашивающий целочисленное значение >numPeopleMin и <numPeopleMax
    // и игнорирующий введение любых других символов, строк и т.д.
    public static int waitInt (int numPeopleMin, int numPeopleMax)
    {
        int numberPeople;
        String message = "Введите целое число > %d и < %d:";
        while (true)
        {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt())
            {
                numberPeople = scanner.nextInt();
                if(numberPeople>numPeopleMin&&numberPeople<numPeopleMax)
                {
                    return numberPeople;
                }
                else
                {
                    print(String.format(message, numPeopleMin, numPeopleMax));
                }
            }
            else
            {
                print(String.format(message, numPeopleMin, numPeopleMax));
            }
        }
    }
// далее метод вывода сообщения в консоль (лень)
    public static void print(String massege)
    {
        System.out.println(massege);
    }
}

