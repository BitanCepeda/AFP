import java.util.Scanner;
   /**
* Servicios de Conversión de moneda
* @author Brayan Orlando Rivera Cepeda
* @version (14/06/2017)
*/
public class Conversor
{

    Scanner teclado=new Scanner(System.in);
    Scanner leer=new Scanner(System.in);
    Scanner entrada= new Scanner(System.in);
    
/**
*Convertir manualmente
*@param nombre de las dos monedas
*/
public void Manual(String moneda1, String moneda2)
{
    String continua;
    continua="si";
    while(continua.equals("si"))
    {
    
    //variable para la conversión
    double cambio;
    int con;
  System.out.println("\nUn "+moneda1+" son cuántos "+moneda2+" (?)");
  cambio=teclado.nextDouble();
  System.out.println("\nPulse una tecla para continuar");
  leer.nextLine();
  
  String continua2;
  continua2="si";
  while(continua2.equals("si"))
  {
  
  
  System.out.println("\fOpciones de conversión");
  System.out.println("\n1. Convertir de "+moneda1+" a "+moneda2);
  System.out.println("2. Convertir de "+moneda2+" a "+moneda1);
  con=leer.nextInt();
  
  if(con==1)
  {
      //variable mientras y resultado
      Double mientras, resultado;
      System.out.println("\fDigite la cantidad a convertir de "+moneda1+" a "+moneda2);
      mientras=teclado.nextDouble();
      resultado=(cambio*mientras);
      System.out.println("\nEquivale a "+resultado+" en "+moneda2);
      
  }
  else
  {
      //variable mientras y resultado
      double mientras, resultado;
      System.out.println("Digite la cantidad a convertir de "+moneda2+" a "+moneda1);
      mientras=teclado.nextInt();
      resultado=(mientras/cambio);
      System.out.println("Equivale a "+resultado+" en "+moneda1);
  }
  System.out.println("\nPulse una tecla para continuar");
  entrada.nextLine();
  
  System.out.println("Desea seguir trabajando con "+moneda1+" y "+moneda2+" (?)(si/no)");
  continua2=entrada.nextLine();
  
}

System.out.println("\nDesea seguir usando el conversor manual (?)(si/no)");
  continua=entrada.nextLine();
System.out.println("\nPulse una tecla para continuar");
leer.nextLine();
}
  
}

/**

/**
*Convertir en línea, usando el navegador
*/
public void Auto()
{
     String direccion = "http://www.xe.com/es/currencyconverter/";
         try
                {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + direccion);
                }
                catch(Exception err)
                {
                    
                }
}










}
