import java.util.Scanner;
public class Main
{
    public static void main(String[] args) {
        print("Введие количество человек оплачивающих счет:");
        int numberPeople = waitInt(1, 100);
        String nameList, message;
        float priceProd;
        MenuBar list = new MenuBar("",0.0f);
        Scanner scan = new Scanner(System.in);
        print("Введите наименование товара:");
        while (true)
        {
            nameList = list.writeMenu();
            print("Введите сумму товара в виде 00,00:");
            priceProd = list.priceSum();
            if(scan.nextLine().equalsIgnoreCase("Завершить"))
            {break;}
            else{print("Введите наименование товара:");}
        }
        print("Число гостей — " + numberPeople);
        message = "Длбавленные товары:\n %s. \nНаобщую сумму: %.2f.\n по %.2f %s с каждого";
        print(String.format(message, nameList, priceProd, priceProd/numberPeople, "рубля"));
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

    public String writeMenu()
     {
         Scanner scan = new Scanner(System.in);
         nameDish = nameDish + "\n" + scan.nextLine();
         return nameDish;
      }
     public float priceSum()
      {
          Scanner scan = new Scanner(System.in);
          while (true)
          {
              if (scan.hasNextDouble())
              {
                  priceDish = priceDish + scan.nextFloat();
                  System.out.println("Товар успешно добавлен.\nдобавить еще товар? - введите любой символ!\n\nЧтобы завершить введите \"Завершить\"");
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

