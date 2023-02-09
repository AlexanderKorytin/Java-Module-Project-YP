import java.util.Locale;
import java.util.Scanner;
public class MenuBar
{
        float priceDish;
        String nameDish;

        MenuBar(String nameDish, float priceDish)
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
            while (true)
            {
                Scanner scan = new Scanner(System.in);
                scan.useLocale(Locale.US);
                if (scan.hasNextFloat())
                {
                    float priceNew = scan.nextFloat();
                    if (priceNew>0)
                    {
                        priceDish = priceDish + priceNew;
                        System.out.println("Товар успешно добавлен.\nДобавить еще товар? - введите любой символ!\n\nЧтобы завершить введите \"Завершить\"");
                        return priceDish;
                    }
                    else
                    {
                        System.out.println("Введите цену товара в виде 00.00");
                    }
                }
                else
                {
                    System.out.println("Введите цену товара в виде 00.00");
                }
            }
        }
    }

