public class parent{

    static {
        System.out.println("Статический блок первый");
    }

    String str = "Строка предка";

    {
        System.out.println(str + " блок инициализации первый");
    }

    static {
        System.out.println("Статический блок второй");
    }

    parent(){
        System.out.println("Конструктор класса предка");
    }

    {
        System.out.println(str + " блок инициализации второй");
    }

    static {
        System.out.println("Статический блок третий");
    }
}