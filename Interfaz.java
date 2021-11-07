
/**
* Clase que representa la interfaz que interactuará con el usuario
* @author Brayan Orlando Rivera Cepeda
* @version (14/06/2017)
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileOutputStream;   
import java.io.ObjectOutputStream; 
import java.io.FileReader;
import java.io.BufferedReader;

public class Interfaz 
{
  Scanner lee=new Scanner(System.in); 
  Scanner le=new Scanner(System.in); 
  Scanner leer=new Scanner(System.in);
  Scanner ingreso=new Scanner(System.in);
  Scanner ingres=new Scanner(System.in);
  Scanner conti= new Scanner(System.in);
  Scanner leo=new Scanner(System.in);
  Scanner entrada=new Scanner(System.in);
  Scanner respuesta=new Scanner(System.in);
  
  
  Cliente c1=new Cliente();
  BienestarFinanciero B1=new BienestarFinanciero();
  Registros r1=new Registros(); 
  Conversor c=new Conversor();
  Internet i= new Internet();
  ControlDiario cd=new ControlDiario();
 
  
 

  /**
  * Inicia el desarrollo de la interfaz, pero por primera vez
  */   
public void Inicio()
{
   c1.Iniciar();
   B1.Bienestar(c1);
   menu();
   
}

/**
  * Inicia el desarrollo de la interfaz, pero ya existiendo datos de la aplicación
  */   
public void Inicio2()
{
    
    menu();
}

/**
  * Menú principal de la aplicación
  */   
private void menu()
   {
        
    
    int respuesta;
    System.out.println("\f\tMenú principal\n");
    System.out.println("1. Ir a hoy");
    System.out.println("2. Opciones financieras");
    System.out.println("3. Opciones personales");
    System.out.println("4. Ingresar proyecto");
    System.out.println("5. Mis proyectos");
    System.out.println("6. Noticias");
    System.out.println("7. Conversor de moneda");
    System.out.println("8. Ver mis datos");
    System.out.println("9. Acerca de");
    System.out.println("10. Salir\n");
    System.out.println(c1.getNombreUsado());
    System.out.println("Su estado financiero es "+B1.getEstado());
    respuesta=lee.nextInt();
   
    switch(respuesta)
    {
        case 1:
        hoy();
        menu();
        break;
        
        case 2:
        primerMenu();
        menu();
        break;
        
        case 3:
        segundoMenu();
        menu();
        break;
        
        case 4:
        crearProyecto();
        menu();
        break;
        
        case 5:
        proyectos();
        menu();
        break;
        
        case 6:
        int opc;
        System.out.println("\f\tDe qué desea informarse(?)\n");
         System.out.println("1. General");
         System.out.println("2. Política");
         System.out.println("3. Agricultura");
         System.out.println("4. Tecnología");
         System.out.println("5. Deportes");
         System.out.println("6. Menú principal");
        opc=ingres.nextInt();
      if(opc==6)
         menu();
         
       i.VerNoticias(opc);
        menu();
        break;
        
        case 7:
        convertir();
        menu();
        break;
        
        case 8:
        c1.Estado();
        menu();
        break;
        
        case 9:
        infor();
        menu();
        break;
        
        case 10:
        {
        System.out.println("\fGracias por usar nuestro software");
        le.nextLine();
        System.out.println("\f");
        
        //Leer .txt
        String entrada="";
        String entrada2="";
       try{
        
        FileReader lector=new FileReader("Entrada.txt");
        BufferedReader contenido=new BufferedReader(lector);

       
      while((entrada=contenido.readLine())!=null)
     {
       entrada2=entrada;
      }
         }
   
   catch(Exception e)
   {
   System.out.println("Error al leer sus datos, el programa se reiniciará\n");
   System.out.println("Lo lamentamos");

  }
  
  if(entrada2.equals(""))
        {guardar();}
    
        System.exit(0); 

    }   
        break;
    }  
    menu();
}

 
   /**
  * Menú de opciones financieras del usuario
  */   
 private void primerMenu()
{
    System.out.println("\f");
    int respuesta;
    
    System.out.println("1. Registrar ahorro");
    System.out.println("2. Registar deudas");
    System.out.println("3. Registrar préstamo");
    System.out.println("4. Registrar ingresos extra");
    System.out.println("5. Agregar servicios");
    System.out.println("6. Modificar mis datos");
    System.out.println("7. Regresar");
    
    respuesta=leo.nextInt();
    
    switch(respuesta)
    {
        case 1:
        c1.setAhorros();
        primerMenu();
        break;
        
        case 2:
        c1.Deudas();
        primerMenu();
        break;
        
        case 3:
        c1.Prestamo();
        primerMenu();
        break;
        
        case 4:
        c1.ingresosExtras();
        primerMenu();
        break;
        
        case 5:
        c1.setServicios();
        primerMenu();
        break;
        
        case 6:
        c1.DatosFinancieros();
        primerMenu();
        break;
        
        case 7:
        menu();
        break;
    }
    primerMenu();
}


/**
  * Menú para agregar ó modificar el nombre preferido del usuario 
  */   
     private void segundoMenu()
{
    System.out.println("\f");
    int respuesta;
    
   
    System.out.println("1. Cambiar apodo ó agregarlo");
    System.out.println("2. Regresar");
    
    respuesta=lee.nextInt();
    System.out.println("\f");
    
    switch(respuesta)
    {
       
        case 1:
        c1.SetApodo();
        break;
        
        case 2:
        menu();
        break;
        
      
    }

    menu();


}

/**
  * Muestra todos los proyectos a desarrollar, & un menú de opciones para los proyectos
  */   
private void hoy()
{
    int resp;
    String nompro;
    Proyecto pr;
    boolean conf;
    
    System.out.println("\f\tDeberes para hoy\n");
    cd.mostrarDia(r1.VerTodos());
    System.out.println("\nPulse una tecla para continuar");
    lee.nextLine();
    System.out.println("\n\nOpciones: \n");
    System.out.println("1. Pagar cuota diaria");
    System.out.println("2. Regresar");
    resp=respuesta.nextInt();
    
    if(resp==1)
    {
        System.out.println("\fPor favor ingrese el nombre del proyecto a pagar");
        nompro=lee.nextLine();
        pr=r1.VerUno(nompro);
        conf=cd.pagar(pr);
        
        if(conf==true)
        r1.completar(pr);
        
        hoy();
    }
    
    if(resp==2)
    {
        menu();
    }
    
  }

/**
  * Opción seleccionada anteriormente; agregar un nuevo proyecto
  */   
private void crearProyecto()
{
    //Objetos de plan tienen que tener diferente nombre
    int costo;
    System.out.println("\fUsuario "+ c1.getNombreUsado());
    System.out.println("\nPor favor digite el valor total del producto ó servicio que desea");
    System.out.println("empezar a agilizar");
    costo=lee.nextInt();
    Plan P1= new Plan();
    
    //variable para revisar si se puede crear proyecto
    boolean confir=true;
    
    confir=P1.crearPlan(B1, costo );
    //Objetos de proyecto tienen que tener diferente nombre
    
    if(confir==true)
    {
    Proyecto P= new Proyecto();
    P.CrearProyecto(P1);
    r1.añadir(P);
}
    menu();
}

/**
  * Menú de proyectos
  */   
private void proyectos()
{
    int esco;
    System.out.println("\f\tMenú de proyectos\n");
    System.out.println("1. Proyectos en desarrollo");
    System.out.println("2. Proyectos desarrollados");
    System.out.println("3. Menú principal");
    esco=leo.nextInt();
    
    switch(esco)
    {
        case 1:
        enDesarrollo();
        proyectos();
        break;
        
        case 2:
        desarrollados();
        proyectos();
        break;
        
        case 3:
        menu();
        break;
        
        
    }
} 
    
  /**
  * Menú de proyectos aún no terminados
  */   
private void enDesarrollo()
{
    int selec;
    
    System.out.println("\f\tProyectos en desarrollo\n");
    System.out.println("1. Ver uno");
    System.out.println("2. Ver todos");
    System.out.println("3. Eliminar");
    System.out.println("4. Regresar");
    System.out.println("5. Menú principal");
   
    selec=leo.nextInt();
    
    switch(selec)
    {
        case 1:
        verUno();
        enDesarrollo();
        break;
        
        case 2:
        verTodos();
        enDesarrollo();
        break;
        
        case 3:
        eliminaPro();
        enDesarrollo();
        break;
        
        case 4:
        proyectos();
        break;
        
        case 5:
        menu();
        break;
    }
    
    
    
}

/**
  * Opción de menú para ver un proyecto en especial
  */   
private void verUno()
{
    System.out.println("\fApreciado "+c1.getNombreUsado()+" ingrese el nombre del proyecto a buscar\n");
    String iden;
    iden=entrada.nextLine();
    r1.imprimirUno(iden);
    System.out.println("\nPulse una tecla para continuar");
    leer.nextLine();
}

/**
  * Opción de menú para ver todos los proyectos en desarrollo
  */   
private void verTodos()
{
    System.out.println("\fUsuario "+ c1.getNombreUsado());
    System.out.println("Sus proyectos son los siguientes\n");
    r1.imprimirTodos();
    System.out.println("\nPulse una tecla para continuar");
    leer.nextLine();
}

/**
 *Opción de menú para eliminar un proyecto por decisión del usuario
 */
private void eliminaPro()
{
    System.out.println("\fApreciado "+c1.getNombreUsado()+" ingrese el nombre del proyecto a eliminar\n");
    String iden;
    String resp;
    Proyecto p;
    iden=entrada.nextLine();
    r1.imprimirUno(iden);
    p=r1.VerUno(iden);
    
    boolean superv=true;
    while(superv==true)
    {
    
    System.out.println("\nEstá seguro que desea eliminar este proyecto(?)(si/no)");
    resp=entrada.nextLine();
    
    
    if(resp.equals("si"))
    {
        r1.eliminar(p);
        superv=false;
    }
    else
    {
    if(resp.equals("no"))
    {
        System.out.println("\nProyecto conservado");
    }
    else
    {
        System.out.println("\nEntrada incorrecta, por favor inténtelo de nuevo: \n");
        
    }
  }
    }
    
    System.out.println("\nPulse una tecla para continuar");
    leer.nextLine();
}


/**
 * Opción de menú para ver un proyecto en especial
 */

private void desarrollados()
{
    System.out.println("\fUsuario "+ c1.getNombreUsado());
    System.out.println("Sus proyectos desarrollados son los siguientes\n");
    r1.imprimirEliminados();
    System.out.println("\nPulse una tecla para continuar");
    ingreso.nextLine();
}
    
    
    

/**
 * Menú para conversión de dividsas
 */
private void convertir()
{
    int opc;
    String moneda1, moneda2;
    
    System.out.println("\f\tConversor de moneda\n");
    System.out.println("1. Conversor local");
    System.out.println("2. Conversor web");
    System.out.println("3. Menú principal");
    opc=ingreso.nextInt();
    
    switch(opc)
    {
        case 1:
           System.out.println("\fPor favor escriba los nombres de las monedas: \n");
           System.out.println("\nPrimera moneda : ");
           moneda1=ingres.nextLine();
           System.out.println("\nSegunda moneda : ");
           moneda2=ingres.nextLine();
           c.Manual(moneda1 , moneda2);
           convertir();
           break;
           
        case 2:
        c.Auto();
        convertir();
        break;
        
         case 3:
        menu();
        break;
           
           
           
    }
    
}

/**
 * Información acerca de ADMINISTRADOR FINANCIERO PERSONAL:
 */
private void infor()
{
    System.out.println("\fAcerca de :\n");
    System.out.println("Administrador Financiero personal\n");
    System.out.println("No te preocupes por las cuentas de tu dinero, nosotros la manejamos");
    System.out.println("Qué esperas para comenzar a ingresar proyectos & alcanzar tus sueños(?)");
    System.out.println("No lo olvides nunca; no administramos tu dinero, administramos tus sueños y potencial");
    System.out.println("\nVersión 1.0");
    System.out.println("Muy pronto disponible en Android");
    System.out.println("Brayan Orlando Rivera Cepeda");
    System.out.println("Contáctanos: riveracepedabrayan@gmail.com");
    System.out.println("BlueJ. 2017");
    System.out.println("27/07/2017");
    System.out.println("UNIVERSIDAD INDUSTRIAL DE SANTANDER\n");
    System.out.println("Pulse una tecla para continuar");
    conti.nextLine();
  }

  /**
 * Guardar datos acerca de la entrada del usuario 
 */
public void guardar()
{
  
      System.out.println("Guardando");
        leer.nextLine();
  
                  try
       {
         File archivo=new File("Entrada.txt");
         FileWriter escribir=new FileWriter(archivo,false);
         escribir.write("datos");
         escribir.close();
       }

             catch(Exception e)
      {
       System.out.println("Error al escribir sus datos, el programa se reiniciará\n");
       System.out.println("Lo lamentamos");
      }
      
}
  
}
