import java.util.Scanner; 

  /**
* Se calcula el plan de desarrollo de proyecto más adecuado para el cliente
* @author Brayan Orlando Rivera Cepeda
* @version (14/06/2017)
*/
public class Plan
{
 
    Scanner teclado=new Scanner(System.in);
    Scanner tecla=new Scanner(System.in);
     private int dias;
     private double cuotaDiaria;
     private double costo;
    
/**
* Calcular plan de desarrollo
*@param se ingresa el estado financiero
*@param se ingresa el costo del proyecto
*/
public boolean crearPlan(BienestarFinanciero bienestar, double costo )
{
    //Variable de confirmación
    boolean confir=true;
    
    this.costo=costo;
    
    if((bienestar.getEstado().equals("Malo"))||(bienestar.getEstado().equals("Neutro")))
    {
    
    if(bienestar.getEstado().equals("Malo"))
    {
        System.out.println("Ahora no estás en condiciones de realizar ningún proyecto");
    }
    
    if(bienestar.getEstado().equals("Neutro"))
    {
         System.out.println("Ahora no estás en condiciones de realizar ningún proyecto");
    }
    confir=false;
 }
    else
    {
    System.out.println("\nEn cuántos días desea realizar su proyecto de "+costo);
    dias=teclado.nextInt();
    
    if(bienestar.getEstado().equals("Bueno"))
    {
       cuotaDiaria=costo/dias; 
    }
    
    if(bienestar.getEstado().equals("Excelente"))
    {
         cuotaDiaria=(costo/dias)*1.2; 
         
    }
  }
  
  System.out.println("\nPulse una tecla para continuar");
  tecla.nextLine();
  return confir;
}

    
/**
* Retorna la cuota diaria que se usará para el proyecto
*/
public double getcuotaDiaria()
{
    return cuotaDiaria;
}

    
/**
* Retorna el costo estimado del proyecto
*/
public double getCosto()
{
    return costo;
}

  
/**
* Retorna los días estimados para realizar el proyecto
*/
public int getDias()
{
    return dias;
}
}
