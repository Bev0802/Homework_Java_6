/* 3.Написать метод, который будет запрашивать у пользователя критерий 
(или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. 
Критерии фильтрации можно хранить в Map. Например:

“Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет … 

4. Далее нужно запросить минимальные значения для указанных критериев - 
сохранить параметры фильтрации можно также в Map.

5. Отфильтровать ноутбуки их первоначального множества и 
вывести проходящие по условиям.*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/* Создать множество ноутбуков.*/
public class SetNotebook {

    public static void main(String[] args) {

        Set <Notebook> lNotebooks = new HashSet <>();
        //Созадала множество ноутбуков.        
        lNotebooks.add(new Notebook("ASUS", 15, 16, "HHD", 1000, "Windows", "черный"));
        lNotebooks.add(new Notebook("Dell", 13, 6, "SSD", 250, "Linux", "серебро"));
        lNotebooks.add(new Notebook("Lenovo", 10, 6, "HHD", 500, "Windows", "белый"));
        lNotebooks.add(new Notebook("Dell", 14, 6, "SSD", 500, "Linux", "серебро"));
        lNotebooks.add(new Notebook("Lenovo", 15, 8, "HDD", 1000, "Windows", "черный"));
        lNotebooks.add(new Notebook("ASUS", 10, 4, "SSD", 500, "Linux", "белый"));
        lNotebooks.add(new Notebook("ASUS", 14, 8, "SSH", 250, "Windows", "серебро"));
        
        // Меню фильтра.

        Scanner sc = new Scanner(System.in, "cp866");
        String command = "";
        //*создание отсортированного списка*/
        Set <Notebook> FilerNotebooks = new HashSet <>();
            FilerNotebooks = lNotebooks; 

        while (!command.equalsIgnoreCase("0")) {
            //переменные для фильтра.
            String mader = null;
            int displaySize = 0;
            int ram = 0;
            String hdtype = null;
            int rom = 0;           
            String color = null;           
            
            //Диалог
            System.out.println("\nВведите команду для отбора ноутбуков по параметрам:\n" +
                    "0 - выход из фильтра;\n" +
                    "1 - посмотреть все имеющиеся ноутбуки;\n" +
                    "2 - отобрать ноутбуки по марке;\n" +
                    "3 - отобрать ноутбуки по размеру дисплея;\n" +
                    "4 - отобрать ноутбуки по типу жесткого диска;\n" +
                    "5 - отобрать ноутбуки по размеру оперативной памяти;\n" +
                    "6 - отобрать ноутбуки по размеру жесткого диска;\n" +
                    "7 - отобрать ноутбуки по цвету;\n" +
                    "8 - посмотреть отфильтрованные ноутбуки;\n" +
                    "9 - очистить фильтр\n");

            command = sc.nextLine();            
            String[] commands = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
            Boolean bool = Arrays
                .asList(commands).contains(command);

                if (bool == false) {
                    System.out.println("Ошибка! Вы ввели не верную команду, попробуйте ещё!");
                    continue;
                }
                
                else if (command.equalsIgnoreCase("0")){
                    System.out.println("Выход из фильтра");
                    System.exit(0);                
                }

                else if (command.equalsIgnoreCase("1")) {
                    println(lNotebooks);
                }

                else if (command.equalsIgnoreCase("2")) {                    
                    System.out.println("Введите марку(например: ASUS, Dell, Lenovo и тд.): ");
                    mader = sc.nextLine();                    
                    FilerNotebooks = filtrMader(FilerNotebooks, mader);
                    System.out.println(FilerNotebooks);
                }
                else if (command.equalsIgnoreCase("3")) {                    
                    System.out.println("Введите максимальный размер дисплея (например: 15, 14, 13, 10 и тд.): ");                   
                    displaySize = Integer.parseInt(sc.nextLine());

                    FilerNotebooks = filtrdisplaySize(FilerNotebooks, displaySize);
                    System.out.println(FilerNotebooks);
                }

                else if (command.equalsIgnoreCase("4")) {                    
                    System.out.println("Введите тип жесткого диска HDD или SSD: ");                  
                    hdtype = sc.nextLine();

                    FilerNotebooks = filtrHdtype(FilerNotebooks, hdtype);
                    System.out.println(FilerNotebooks);
                }

                else if (command.equalsIgnoreCase("5")) {                   
                    System.out.println("Введите минимальный размер оперативной памяти: ");                 
                    ram = Integer.parseInt(sc.nextLine());

                    FilerNotebooks = filtrRam(FilerNotebooks, ram);
                    System.out.println(FilerNotebooks);
                }

                else if (command.equalsIgnoreCase("6")) {                    
                    System.out.println("Введите минимальный размер жесткого диска: ");                  
                    rom = Integer.parseInt(sc.nextLine());

                    FilerNotebooks = filtrRom(FilerNotebooks, rom);
                    System.out.println(FilerNotebooks);
                }

                else if (command.equalsIgnoreCase("7")) {                    
                    System.out.println("Введите цвет ноутбука(например: черный, серебро, белый и тд.): ");
                    color = sc.nextLine();

                    FilerNotebooks = filtrСolor(FilerNotebooks, color);
                    System.out.println(FilerNotebooks);
                }

                else if (command.equalsIgnoreCase("8")) {                    
                    System.out.println("Печать отфильтрованного списка: ");
                    println(FilerNotebooks);
                }

                else if (command.equalsIgnoreCase("9")) {                    
                    System.out.println("Фильтр очищен!");
                    FilerNotebooks = lNotebooks;                }
                
                else {
                        throw new IllegalStateException("Ошибка! Такой команды нет!");
                    }                
               
        } sc.close();
    }

        //______________МЕТОДЫ ФИЛЬТРА__________________________________//

        //метод печатает все ноутбуки.
    public static void println (Set <Notebook> Notebooks){
        System.out.println(Notebooks);
    }
       //фильтр по производителю
    public static Set <Notebook> filtrMader (Set <Notebook> notebooks, String mader){
        Set <Notebook> filterNotebooks = new HashSet <>();
        for (Notebook notebook : notebooks) {            
            if (notebook.getMader().equalsIgnoreCase(mader)){
                filterNotebooks.add(notebook);
            }            
        }
        if (filterNotebooks.isEmpty()){
            System.out.println("Ноутбуков соответсвующих введенному значению нет.");
            filterNotebooks = notebooks;
        }
        return filterNotebooks;
    }

    //фильтр по размеру дисплея
    public static Set <Notebook> filtrdisplaySize (Set <Notebook> notebooks, int displaySize){
        Set <Notebook> filterNotebooks = new HashSet <>();
        for (Notebook notebook : notebooks) {            
            if (notebook.getDisplaySize()<= displaySize){
                filterNotebooks.add(notebook);
            }
        }
        if (filterNotebooks.isEmpty()){
            System.out.println("Ноутбуков соответсвующих введенному значению нет.");
            filterNotebooks = notebooks;
        }
        return filterNotebooks;    
    }

    //фильтр по типу жесткого диска
    public static Set <Notebook> filtrHdtype (Set <Notebook> notebooks, String hdtype){
        Set <Notebook> filterNotebooks = new HashSet <>();
        for (Notebook notebook : notebooks) {            
            if (notebook.getHdtype().equalsIgnoreCase(hdtype)){
                filterNotebooks.add(notebook);
            }
        }
        if (filterNotebooks.isEmpty()){
            System.out.println("Ноутбуков соответсвующих введенному значению нет.");
            filterNotebooks = notebooks;
        }
        return filterNotebooks;
    }

    //фильтр по размеру оперативный памяти
    public static Set <Notebook> filtrRam (Set <Notebook> notebooks, int ram){
        Set <Notebook> filterNotebooks = new HashSet <>();
        for (Notebook notebook : notebooks) {            
            if (notebook.getRam()<= ram){
                filterNotebooks.add(notebook);
            }
        }
        if (filterNotebooks.isEmpty()){
            System.out.println("Ноутбуков соответсвующих введенному значению нет.");
            filterNotebooks = notebooks;
        }
        return filterNotebooks;    
    }

    //фильтр по размеру жесткого диска
    public static Set <Notebook> filtrRom (Set <Notebook> notebooks, int rom){
        Set <Notebook> filterNotebooks = new HashSet <>();
        for (Notebook notebook : notebooks) {            
            if (notebook.getRom()<= rom){
                filterNotebooks.add(notebook);
            }
        }
        if (filterNotebooks.isEmpty()){
            System.out.println("Ноутбуков соответсвующих введенному значению нет.");
            filterNotebooks = notebooks;
        }
        return filterNotebooks;   
    }       
    
    //фильтр по цвету
    public static Set <Notebook> filtrСolor (Set <Notebook> notebooks, String color){
        Set <Notebook> filterNotebooks = new HashSet <>();
        for (Notebook notebook : notebooks) {            
            if (notebook.getColor().equalsIgnoreCase(color)){
                filterNotebooks.add(notebook);
            }            
        }
        if (filterNotebooks.isEmpty()){
            System.out.println("Ноутбуков соответсвующих введенному значению нет.");
            filterNotebooks = notebooks;
        }
        return filterNotebooks;
    }
}