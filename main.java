import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner calc = new Scanner(System.in); //создаем возможность ввести пример
        System.out.print("впишите пример :");

        String str = calc.nextLine();//пишем пример
        //System.out.println("вот строка:" +str);

        System.out.println(calc(str));

    }
    public static String calc(String str) {
        //проверяем какое действие вписали
        int index1 = str.indexOf("+");
        int index2 = str.indexOf("-");
        int index3 = str.indexOf("/");
        int index4 = str.indexOf("*");
        String z = "";
        if(index1>-1){
            String [] strs = str.split("\\+"); //разделитель
            int lastIndex = strs.length -1;
            //System.out.println("длинна массива равна " +lastIndex);
            if(lastIndex!=1){
                //System.out.print("не корректный пример. напишите 2 числа и одно из 4 арифметических действий указанных в условии");
                return "Пример введен некорректно (ошибка при проверке арифметического знака)";
            } else{
                //System.out.println("вы выбрали сложение");
                try {
                    int num1 = Integer.parseInt(strs[0].trim());
                    if(num1 > 0 && num1 < 11) {
                        //System.out.println("Первое число арабское и равно: " + num1);
                        // Если первое число арабское и подходит по диапазону тогда проверям второе:
                        try {
                            int num2 = Integer.parseInt(strs[1].trim());
                            if(num2 > 0 && num1 < 11) {
                                int num3 = num1 + num2;//финальное действие арабскими
                                //System.out.print("ответ сумма арабских чисел:" + num3);
                                String snum3 = String.valueOf(num3);
                                return "Ответ: " +  snum3;
                            } else {
                                //System.out.println("второе число не пренедлежит заданному диапазону");
                                return "Второе число не удовлетворяет условию диапазона";
                            }

                        } catch (NumberFormatException e) {
                            //System.out.println("второе число должно быть арабское как и первое");
                            return "Второе число должно арабским если первое арабское";
                        }
                    } else {
                        //System.out.println("первое число не пренедлежит заданному диапазону");
                        return "Первое число не пренедлежит заданному диапазону";
                    }

                } catch (NumberFormatException e) {
                    //System.out.println("число не арабское");// тогда ищем римское
                    //System.out.println("первое число такое:" + strs[0].trim());
                    String[] romnums = new String[10]; //создаем массив который понадобиться для определения корректности введенных римских цифр
                    romnums[0] = "I";
                    romnums[1] = "II";
                    romnums[2] = "III";
                    romnums[3] = "IV";
                    romnums[4] = "V";
                    romnums[5] = "VI";
                    romnums[6] = "VII";
                    romnums[7] = "VIII";
                    romnums[8] = "IX";
                    romnums[9] = "X";
                    int q1 = 0;
                    int q2 = 0;
                    for(int j = 0; j< romnums.length; j++) { // делаем проверку правильности ввода римского числа сравнивая с массивом
                        q1 = q1 +1;
                        if(romnums[j].equals(strs[0].trim())) {
                            q1 = 0;
                            int val1 = j + 1;
                            //System.out.println("первое число римское и оно равно: "+ val1);
                            //если первое число римское тогда проверям второе
                            for(int y = 0; y < romnums.length; y++) {
                                q2 = q2 +1;
                                if(romnums[y].equals(strs[1].trim())) {
                                    q2 = 0;
                                    int val2 = y + 1;
                                    //System.out.println("второе число римское и оно равно: "+ val2);
                                    //если второе число тоже римсое тога производим арифметическое действие и переводим получившееся число в римское
                                    int val3 = val1 + val2; //финальное действие с римскими
                                    //System.out.println("сумма римских на арабском" +val3);

                                    int input = val3;

                                    String[] vals = new String[9];
                                    vals[0] = "C"; vals[1] = "XC"; vals[2] = "L"; vals[3] = "XL"; vals[4] = "X"; vals[5] = "IX"; vals[6] = "V";
                                    vals[7] = "IV"; vals[8] = "I";

                                    int[] nums = new int[9];
                                    nums[0] = 100; nums[1] = 90; nums[2] = 50; nums[3] = 40; nums[4] = 10; nums[5] = 9; nums[6] = 5; nums[7] = 4;
                                    nums[8] = 1;

                                    int d;
                                    String strBuilder ="";
                                    // вычесляем римское число и составляем строку
                                    for(int i = 0; i < 9; i++) { //начинаем цикл
                                        while(input >= nums[i]) {
                                            d = input/nums[i];
                                            input = input % nums[i];
                                            for(int p =0; p < d; p++) {
                                                strBuilder = strBuilder + vals[i];
                                            }

                                        }

                                    }
                                    //System.out.println("Ответ на римском: " + strBuilder);
                                    return "Ответ: " + strBuilder;
                                }
                            }
                            if(q2 == 10){
                                return "Второе число введено не корректно";
                            }

                            break;
                        }
                    }
                    if(q1 == 10) {
                        //System.out.println("Первое число не соответствует формату");
                        return "Первое число введено не корректно.";
                    }
                }
            }
        } else if (index2>-1) {
            String [] strs = str.split("-"); //разделитель
            int lastIndex = strs.length -1;
            //System.out.println("длинна массива равна " +lastIndex);
            if(lastIndex!=1){
                //System.out.print("не корректный пример. напишите 2 числа и одно из 4 арифметических действий указанных в условии");
                return "Пример введен некорректно";
            } else{
                //System.out.println("вы выбрали вычитание");
                try {
                    int num1 = Integer.parseInt(strs[0].trim());
                    if(num1 > 0 && num1 < 11) {
                        //System.out.println("Первое число арабское и равно: " + num1);
                        // Если первое число арабское и подходит по диапазону тогда проверям второе:
                        try {
                            int num2 = Integer.parseInt(strs[1].trim());
                            if(num2 > 0 && num1 < 11) {
                                int num3 = num1 - num2;//финальное действие арабскими
                                //System.out.print("результат: " + num3);
                                String snum3 = String.valueOf(num3);
                                return "Ответ: " +  snum3;
                            } else {
                                //System.out.println("второе число не пренедлежит заданному диапазону");
                                return "второе число не пренедлежит заданному диапазону";
                            }

                        } catch (NumberFormatException e) {
                            //System.out.println("второе число должно быть арабское как и первое");
                            return "второе число должно быть арабское как и первое";
                        }
                    } else {
                        //System.out.println("первое число не пренедлежит заданному диапазону");
                        return "первое число не пренедлежит заданному диапазону";
                    }

                } catch (NumberFormatException e) {
                    //System.out.println("число не арабское");
                    //System.out.println("первое число такое:" + strs[0].trim());
                    String[] romnums = new String[10]; //создаем массив который понадобиться для определения корректности введенных римских цифр
                    romnums[0] = "I";
                    romnums[1] = "II";
                    romnums[2] = "III";
                    romnums[3] = "IV";
                    romnums[4] = "V";
                    romnums[5] = "VI";
                    romnums[6] = "VII";
                    romnums[7] = "VIII";
                    romnums[8] = "IX";
                    romnums[9] = "X";
                    int q1 = 0;
                    int q2 = 0;
                    for(int j = 0; j< romnums.length; j++) { // делаем проверку правильности ввода арабского числа сравнивая с массивом
                        q1 = q1 + 1;
                        if(romnums[j].equals(strs[0].trim())) {
                            q1 = 0;
                            int val1 = j + 1;
                            //System.out.println("первое число римское и оно равно: " + val1);
                            //если первое число римское тогда проверям второе
                            for(int y = 0; y < romnums.length; y++) {
                                q2 = q2 + 1;
                                if(romnums[y].equals(strs[1].trim())) {
                                    q2 = 0;
                                    int val2 = y + 1;
                                    //System.out.println("второе число римское и оно равно: "+ val2);
                                    //если второе число тоже римсое тога производим арифметическое действие и переводим получившееся число в римское
                                    int val3 = val1 - val2; //предфинальное действие с римскими
                                    //System.out.println("результат: " +val3);
                                    if(val3 <1 ){
                                        return "Ответ в римских числах не может быть меньше единицы";
                                    }
                                    int input = val3;

                                    String[] vals = new String[9];
                                    vals[0] = "C"; vals[1] = "XC"; vals[2] = "L"; vals[3] = "XL"; vals[4] = "X"; vals[5] = "IX"; vals[6] = "V";
                                    vals[7] = "IV"; vals[8] = "I";

                                    int[] nums = new int[9];
                                    nums[0] = 100; nums[1] = 90; nums[2] = 50; nums[3] = 40; nums[4] = 10; nums[5] = 9; nums[6] = 5; nums[7] = 4;
                                    nums[8] = 1;

                                    int d;
                                    String strBuilder ="";
                                    // вычесляем римское число и составляем строку
                                    for(int i = 0; i < 9; i++) { //начинаем цикл
                                        while(input >= nums[i]) {
                                            d = input/nums[i];
                                            input = input % nums[i];
                                            for(int p =0; p < d; p++) {
                                                strBuilder = strBuilder + vals[i];
                                            }

                                        }

                                    }
                                    //System.out.println("Ответ на римском: " + strBuilder);
                                    return "Ответ: " + strBuilder;
                                }
                            }
                            if(q2 == 10){
                                return "второе число введено не корректно.";
                            }
                            break;
                        }
                    }
                    if(q1 == 10) {
                        //System.out.println("Первое число не соответствует формату");
                        return "первое число введено не корректно.";
                    }
                }
            }
        } else if (index3>-1) {
            String [] strs = str.split("/"); //разделитель
            int lastIndex = strs.length -1;
            //System.out.println("длинна массива равна " +lastIndex);
            if(lastIndex!=1){
                //System.out.print("не корректный пример. напишите 2 числа и одно из 4 арифметических действий указанных в условии");
                return "не корректный пример";
            } else{
                //System.out.println("вы выбрали деление");
                try {
                    int num1 = Integer.parseInt(strs[0].trim());
                    if(num1 > 0 && num1 < 11) {
                        //System.out.println("Первое число арабское и равно: " + num1);
                        // Если первое число арабское и подходит по диапазону тогда проверям второе:
                        try {
                            int num2 = Integer.parseInt(strs[1].trim());
                            if(num2 > 0 && num1 < 11) {
                                int num3 = num1 / num2;//финальное действие арабскими
                                //System.out.print("результат: " + num3);
                                String snum3 = String.valueOf(num3);
                                return "Ответ: " +  snum3;
                            } else {
                                //System.out.println("второе число не пренедлежит заданному диапазону");
                                return "второе число не пренедлежит заданному диапазону";
                            }

                        } catch (NumberFormatException e) {
                            //System.out.println("второе число должно быть арабское как и первое");
                            return "второе число должно быть арабское как и первое";
                        }
                    } else {
                        //System.out.println("первое число не пренедлежит заданному диапазону");
                        return "первое число не пренедлежит заданному диапазону";
                    }

                } catch (NumberFormatException e) {
                    //System.out.println("число не арабское");
                    //System.out.println("первое число такое:" + strs[0].trim());
                    String[] romnums = new String[10]; //создаем массив который понадобиться для определения корректности введенных римских цифр
                    romnums[0] = "I";
                    romnums[1] = "II";
                    romnums[2] = "III";
                    romnums[3] = "IV";
                    romnums[4] = "V";
                    romnums[5] = "VI";
                    romnums[6] = "VII";
                    romnums[7] = "VIII";
                    romnums[8] = "IX";
                    romnums[9] = "X";
                    int q1 = 0;
                    int q2 = 0;
                    for(int j = 0; j< romnums.length; j++) { // делаем проверку правильности ввода римского числа сравнивая с массивом
                        q1 = q1+1;
                        if(romnums[j].equals(strs[0].trim())) {
                            q1 = 0;
                            int val1 = j + 1;
                            //System.out.println("первое число римское и оно равно: "+ val1);
                            //если первое число римское тогда проверям второе
                            for(int y = 0; y < romnums.length; y++) {
                                q2 = q2 + 1;
                                if(romnums[y].equals(strs[1].trim())) {
                                    q2 = 0;
                                    int val2 = y + 1;
                                    //System.out.println("второе число римское и оно равно: "+ val2);
                                    //если второе число тоже римсое тога производим арифметическое действие и переводим получившееся число в римское
                                    int val3 = val1 / val2; //предфинальное действие с римскими
                                    //System.out.println("результат: " +val3);

                                    int input = val3;

                                    String[] vals = new String[9];
                                    vals[0] = "C"; vals[1] = "XC"; vals[2] = "L"; vals[3] = "XL"; vals[4] = "X"; vals[5] = "IX"; vals[6] = "V";
                                    vals[7] = "IV"; vals[8] = "I";

                                    int[] nums = new int[9];
                                    nums[0] = 100; nums[1] = 90; nums[2] = 50; nums[3] = 40; nums[4] = 10; nums[5] = 9; nums[6] = 5; nums[7] = 4;
                                    nums[8] = 1;

                                    int d;
                                    String strBuilder ="";
                                    // вычесляем римское число и составляем строку
                                    for(int i = 0; i < 9; i++) { //начинаем цикл
                                        while(input >= nums[i]) {
                                            d = input/nums[i];
                                            input = input % nums[i];
                                            for(int p =0; p < d; p++) {
                                                strBuilder = strBuilder + vals[i];
                                            }

                                        }

                                    }
                                    //System.out.println("Ответ на римском: " + strBuilder);
                                    return "Ответ: " + strBuilder;
                                }
                            }
                            if(q2 == 10) {
                                return "второе число введено не корректно";
                            }
                            break;
                        }

                    }
                    if(q1 == 10) {
                        //System.out.println("Первое число не соответствует формату");
                        return "первое число введено не корректно";
                    }
                }
            }
        } else if (index4>-1) {
            String [] strs = str.split("\\*"); //разделитель
            int lastIndex = strs.length -1;
            //System.out.println("длинна массива равна " +lastIndex);
            if(lastIndex!=1){
                //System.out.print("не корректный пример. напишите 2 числа и одно из 4 арифметических действий указанных в условии");
                return "не корректный пример";
            } else{
                //System.out.println("вы выбрали умножение");
                try {
                    int num1 = Integer.parseInt(strs[0].trim());
                    if(num1 > 0 && num1 < 11) {
                        //System.out.println("Первое число арабское и равно: " + num1);
                        // Если первое число арабское и подходит по диапазону тогда проверям второе:
                        try {
                            int num2 = Integer.parseInt(strs[1].trim());
                            if(num2 > 0 && num1 < 11) {
                                int num3 = num1 * num2;//финальное действие арабскими
                                //System.out.print("результат: " + num3);
                                String snum3 = String.valueOf(num3);
                                return "Ответ: " +  snum3;
                            } else {
                                //System.out.println("второе число не пренедлежит заданному диапазону");
                                return "второе число не пренедлежит заданному диапазону";
                            }

                        } catch (NumberFormatException e) {
                            //System.out.println("второе число должно быть арабское как и первое");
                            return "второе число должно быть арабское как и первое";
                        }
                    } else {
                        //System.out.println("первое число не пренедлежит заданному диапазону");
                        return "первое число не пренедлежит заданному диапазону";
                    }

                } catch (NumberFormatException e) {
                    //System.out.println("число не арабское");
                    //System.out.println("первое число такое:" + strs[0].trim());
                    String[] romnums = new String[10]; //создаем массив который понадобиться для определения корректности введенных римских цифр
                    romnums[0] = "I";
                    romnums[1] = "II";
                    romnums[2] = "III";
                    romnums[3] = "IV";
                    romnums[4] = "V";
                    romnums[5] = "VI";
                    romnums[6] = "VII";
                    romnums[7] = "VIII";
                    romnums[8] = "IX";
                    romnums[9] = "X";
                    int q1 = 0;
                    int q2 = 0;
                    for(int j = 0; j< romnums.length; j++) { // делаем проверку правильности ввода арабского числа сравнивая с массивом
                        q1 = q1 + 1;
                        if(romnums[j].equals(strs[0].trim())) {
                            q1 = 0;
                            int val1 = j + 1;
                            //System.out.println("первое число римское и оно равно: "+ val1);
                            //если первое число римское тогда проверям второе
                            for(int y = 0; y < romnums.length; y++) {
                                q2 = q2 + 1;
                                if(romnums[y].equals(strs[1].trim())) {
                                    q2 = 0;
                                    int val2 = y + 1;
                                    //System.out.println("второе число римское и оно равно: "+ val2);
                                    //если второе число тоже римсое тога производим арифметическое действие и переводим получившееся число в римское
                                    int val3 = val1 * val2; //предфинальное действие с римскими
                                    //System.out.println("результат: " +val3);

                                    int input = val3;

                                    String[] vals = new String[9];
                                    vals[0] = "C"; vals[1] = "XC"; vals[2] = "L"; vals[3] = "XL"; vals[4] = "X"; vals[5] = "IX"; vals[6] = "V";
                                    vals[7] = "IV"; vals[8] = "I";

                                    int[] nums = new int[9];
                                    nums[0] = 100; nums[1] = 90; nums[2] = 50; nums[3] = 40; nums[4] = 10; nums[5] = 9; nums[6] = 5; nums[7] = 4;
                                    nums[8] = 1;

                                    int d;
                                    String strBuilder ="";
                                    // вычесляем римское число и составляем строку
                                    for(int i = 0; i < 9; i++) { //начинаем цикл
                                        while(input >= nums[i]) {
                                            d = input/nums[i];
                                            input = input % nums[i];
                                            for(int p =0; p < d; p++) {
                                                strBuilder = strBuilder + vals[i];
                                            }

                                        }

                                    }
                                    //System.out.println("Ответ на римском: " + strBuilder);
                                    return "Ответ: " + strBuilder;
                                }
                            }
                            if(q2 == 10) {
                                return "второе число введено не корректно.";
                            }

                            break;
                        }

                    }
                    if(q1 == 10) {
                        return "первое число введено не корректно.";
                    }
                }
            }
        } else {
            //System.out.println("не обнаружен арифметический знак");
            return "не обнаружен арифметический знак";
        }
        return "что то пошло не так";
    }
}
