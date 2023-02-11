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
        public String printResult(double result)
        {
            int num = (int)Math.floor(result);
            if( ((num%100) >=11 ) && ((num%100) <= 19) )
            {
                return "рублей";
            }
            switch(num%10)
            {
                case 1:
                    return "рубль";
                case 2:
                case 3:
                case 4:
                    return "рубля";
                default:
                    return "рублей";
            }
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
                        System.out.println("Товар успешно добавлен.\nДобавить еще товар? - введите любой символ:\n\nЧтобы завершить введите: \"Завершить\"");
                        return priceDish;
                    }
                    else if (priceNew==0)
                    {
                        System.out.println("Бесплатного ничего нет!\nВведите цену товара больше нуля:");
                    }
                    else
                    {
                        System.out.println("Введите цену товара больше нуля:");
                    }
                }
                else
                {
                    System.out.println("Ошибка ввода!\nВведите цену товара в формате 00.00:");
                }
            }
        }
    }

