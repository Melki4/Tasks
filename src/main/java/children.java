public class children extends parent{

    static {
        System.out.println("Статический блок инициализации первый");
    }

    String str = "Строка в классе-наследнике";

    {
        System.out.println(str);
    }

    {
        System.out.println("Блок инициализации наследника второй");
    }

    static {
        System.out.println("Статический блок инициализации второй");
    }

    children(){
        str = "Ру-ру-ру-ру";
        System.out.println("Конструктор класса-наследника");
    }

    void pa(){
        System.out.println("pa");
    }

    {
        System.out.println("Блок инициализации наследника третий");
    }

    static {
        System.out.println("Статический блок инициализации третий");
    }
}


