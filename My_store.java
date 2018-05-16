package my_store;
import static java.lang.Boolean.TRUE;
import static java.lang.Integer.sum;
import javax.swing.*;	
import java.util.Date;

/**
 * @author kuznetsova_a
 */

//класс товар
class goods {
int id, kol;
String name; //???
float cost;

// конструктор единицы товара
goods (int id_c,  String name_c, float cost_c, int kol_c)
{  
id = id_c;  
name = name_c;
cost = cost_c;
kol = kol_c;
}

// метод вывести товар на экран
void print_good()
{
 System.out.println ("Товар №"+ id + ". " + name +  " цена " + cost + " руб. " + "в наличии " + kol + " шт."); 
}      
}

// класс покупка 
class purchases {
int id, kol;
float cost;
int delivery;
//boolean delivery;

purchases(int id_c, int kol_c, float cost_c, int delivery_c)
{
id = id_c; 
kol = kol_c;
cost = cost_c;
delivery = delivery_c;
}
}

// Класс заказ, по идее - массив объектов Покупка
class Order {
static purchases[] MyOrder = new purchases [4];

 void print_order(String[] args){
        for (int i = 0; i<4; i++){
            System.out.println(MyOrder[i]);
        }
   }
} 

/*
// класс заказ
class order
{
purchases[] my_order = new purchases[4]; // как задать неопределенное кол-во элементов массива???

order( purchases[] my_order_с )
{
    my_order = my_order_с;
} 

}*/

public class My_store {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {JOptionPane.showMessageDialog(null, "Добро пожаловать в магазин \n"  + "Выберите интересующий Вас товар");
    
    // Формируем витрину  
    goods good1 = new goods ( 1, "Клавиатура светящаяся", 500 , 6);   
    goods good2 = new goods ( 2, "Мышь", 200 , 6); 
    goods good3 = new goods ( 3, "Монитор 24 дюйма", 8000 , 2); 
    goods good4 = new goods ( 4, "Блок питания", 100 , 6); 

    
    // выводим товары
    good1.print_good();
    good2.print_good();
    good3.print_good();
    good4.print_good();
 
// диалог с пользователем 
int var=1,i=1; // переменная ук. выводить диалог 1- выводить/0 - не выводить больше 
int input_id, input_kol;
float input_cost;
float summ = 0;
int input_delivery = 1;

// пока пользователь не откажется от добавления товаров - выводить диалог и считать сумму
do {
input_id=Integer.parseInt(JOptionPane.showInputDialog("Введите номер товара:"));
input_kol=Integer.parseInt(JOptionPane.showInputDialog("Введите кол-во товара:"));

switch(input_id)
{
    case 1: input_cost = good1.cost; break; 
    case 2: input_cost = good2.cost; break;            
    case 3: input_cost = good3.cost; break;  
    case 4: input_cost = good4.cost; break;  
    default: input_cost = 0;
};
// создать новую покупку со свойствами ид товара, кол-во, цена и статус доставки
purchases purchase1 = new purchases(input_id, input_kol, input_cost,  input_delivery );

// ошибка, почему так нельзя присваивать?
//MyOrder[0] = new purchases(input_id, input_kol, input_cost,  input_delivery );

// Сумма покупки
summ = summ + purchase1.cost * purchase1.kol*purchase1.delivery;


var=Integer.parseInt(JOptionPane.showInputDialog("Хотите что-нибудь ещё проибрести? \n" +"Да - 1 \n" + "Нет - 0"));
}
while ( var == 1);
        
System.out.println ("Итоговая сумма " + summ + " руб."); 

    }

    }
    
