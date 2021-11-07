import java.util.ArrayList;
import java.util.Scanner;
/**
* Se lleva el registro de todos los proyectos hechos por el usuario, también los descartados
* @author Brayan Orlando Rivera Cepeda
* @version (14/06/2017)
*/

public class ControlDiario
{

   
    Scanner teclado= new Scanner(System.in);
    Scanner lee= new Scanner(System.in);
    Scanner entrada= new Scanner(System.in);
    
    
  
 /**
  * Muestra todos los proyectos sin terminar por orden de selección
  */   
public void mostrarDia(ArrayList<Proyecto> proyectos)
   {
       
        System.out.println("\n\tURGENTES");
         for(Proyecto proyect: proyectos)
    {
        if(proyect.getTipo().equals("urgente"))
        {
        System.out.println(proyect.getNombre());
        System.out.println(proyect.getTipo());
        System.out.println(proyect.getCuotaDiaria());
        
        }
    }
    
         System.out.println("\n\tIMPORTANTES");
               for(Proyecto proyect: proyectos)
    {
        if(proyect.getTipo().equals("importante"))
        {
        System.out.println(proyect.getNombre());
        System.out.println(proyect.getTipo());
        System.out.println(proyect.getCuotaDiaria());
        }
    }  
    
    
         System.out.println("\n\tNECESARIOS");
               for(Proyecto proyect: proyectos)
    {
        if(proyect.getTipo().equals("necesario"))
        {
        System.out.println(proyect.getNombre());
        System.out.println(proyect.getTipo());
        System.out.println(proyect.getCuotaDiaria());
        }
    }  
    
         System.out.println("\n\tOCIOS");
               for(Proyecto proyect: proyectos)
    {
        if(proyect.getTipo().equals("ocio"))
        {
        System.out.println(proyect.getNombre());
        System.out.println(proyect.getTipo());
        System.out.println(proyect.getCuotaDiaria());
        }
    }
    
}
   
   /**
  * Se realiza el pago u abono de un proyecto no desarrollado
  */ 
   public boolean pagar(Proyecto pro)
   {
       boolean resp;
     
       
       
       //variable local para desarrollo del proyecto
       double saldito=pro.getSaldo();
       double desarrollo=pro.getDesarrollo();
       double monto;
       double proc;
       double oper;
       double porcen;
       double saldo;
       System.out.println("\nPor favor ingrese el monto que va a abonar para el proyecto " + pro.getNombre());
       monto=teclado.nextDouble();
       proc=pro.getCosto();
       
       double resta=monto-saldito;
       
       
       if(monto>=saldito)
       {
       System.out.println("Su proyecto queda terminado, le restan $"+resta);
       System.out.println("\nPulse una tecla para continuar");
       entrada.nextLine();
       pro.setDesarrollo(100);
       
       pro.setSaldo(0);
       resp=true;
       }
       
       
       else
       {
       oper=(monto)/(proc/100);
       porcen=0+oper;//Verificación de un buen porcentaje
       pro.setDesarrollo(porcen);
       saldo=pro.getSaldo()-monto;
       pro.setSaldo(saldo);
       resp=false;
       }
      return resp;
    }
   
       
}
   
