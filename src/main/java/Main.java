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
            print("Введите сумму товара в виде 00,00:");
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
        message = "Добавленные товары:\n %s. \nНаобщую сумму: %.2f.\n%.2f %s с каждого";
        print(String.format(message, nameList, priceProd, resultRub, rub));

    }
// далее метод запрашивающий целочисленное значение >numPeopleMin и <numPeopleMax
    // и игнорирующий введение любых других символов, строк и т.д.
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
                    return numberPeople;
                }
                else
                {
                    print(String.format(message, numPeopleMin, numPeopleMax));
                }
            }
            if (!scanner.hasNextInt()) {
                print(String.format(message, numPeopleMin, numPeopleMax));
                scanner.nextLine();
            }
        }
    }
// далее метод вывода сообщения в консоль (лень)
    public static void print(String massege)
    {
        System.out.println(massege);
    }
    // объявляем новый класс - строка меню(прайса)
    public static class MenuBar
    {
        float priceDish;
        String nameDish;

        public MenuBar(String nameDish, float priceDish)
        {
            this.nameDish = nameDish;
            this.priceDish = priceDish;
        }
        // далее метод определяющий окончание слова "рубль"
        // в зависимости от полученной суммы товаров
        public String printResult(float result)
        {
            String rubl = "Рублей";
            if(result%100<=11&&result%100>=19)
            {
                rubl = "рублей";
            }
            switch(((int)result)%10)
            {
                case 0:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    rubl = "рублей";
                    break;
                case 1:
                    rubl = "рубль";
                    break;
                case 2:
                case 3:
                case 4:
                    rubl = "рубля";
                    break;
            }
            return rubl;
        }
        //далее метод заполняющий строку наименованиями
        // введенных пользователем товаров
        public String writeMenu()
        {
            Scanner scan = new Scanner(System.in);
            nameDish = nameDish + "\n" + scan.nextLine();
            return nameDish;
        }
        // далее метод запрашивающий цену товара и прибавляющий ее к
        // сумме ранее введенных цен
        public float priceSum()
        {
            Scanner scan = new Scanner(System.in);
            while (true)
            {
                if (scan.hasNextDouble())
                {
                    priceDish = priceDish + scan.nextFloat();
                    System.out.println("Товар успешно добавлен.\nДобавить еще товар? - введите любой символ!\n\nЧтобы завершить введите \"Завершить\"");
                    return priceDish;
                }
                else
                {
                    System.out.println("Введите сумму товара в виде 00,00");
                    scan.nextLine();
                }
            }
        }
    }
}

