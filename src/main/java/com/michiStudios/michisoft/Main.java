/*

 .:..                              ..::                                                                                                     
.^^^::..                        ..::^^^.                                                                                                    
.^:^^^^^:.                    .:^^^^^^^:                                                                                                    
.^:^!~^:^^:.   .:^^~~~^^.   .:^^:^~!^:^:                                                                                                    
.^:^!!!~^::::JGGB##&&###BG5::::^~!!!^:^:                                                                                                    
.:^^~!!!~^!YP######PP######GY!^~!!!!:^:.         ^JJJ^      :JJJ! .5#5.            ~JJ^        7BB~   ^7Y55J7:                !5BBY. .:.    
 :^:~!~7YB#######G7::~5#######BY7~!~:^:          ?@@@#^    .G@@@P  7Y7      ..     Y@@7  .     ^YJ: :P@@G55B@@Y.     ..      7@@G7~ :G&G:   
 .^::!5#########5::^^::J#########5!::^.          ?@@&@B:   5@@@@5 .5B5.  !PBBBBP!  J@@Y5B#BP~  ?BB~ !@@B^   !77.  7PBBBB5! .5&@@#B7!B@@@#P  
  ::?B#########G::^^^^^.5#########B7::           ?@@JP@G. Y@#J#@5 :B@B: 5@@J~~Y&&7 J@@B7~7&@&: Y@@!  ?B&&#BPJ~  .P@@J^^Y@@Y ^Y@@Y~:.!#@#!^  
   J####B5YY5G&Y::^^^^^:7&G5JJYG####?            ?@@7.B@5J@@~~&@5 :B@B.:@@B     .. J@@?   G@@^ Y@@! ..::^!?5&@G:^@@G    B@&: 7@@?   :B@B:   
  7&####B^  ..~?^:^^^^^:7!..  .P#####!           ?@@? ^&@@@? ~&@5 :B@B..B@&7..7GB7 J@@?   G@@^ Y@@! J@&J:..~B@@~.B@&!..7@@P. ?@@?   :#@#^   
 .B######B?^:..::^^^^^^^::::^7G######B.          7@&7  !#&J  ~#@5 :G@G: :Y#&##&#Y. J@@7   P@&^ J&@! .?B&&&&&#P!  :Y#&##&BJ.  7&@?    J#&&P  
 7&#########BB5^:^^^^^^::YBBB########&!          .::.   ..    ::.  .:.    .:^^:    .::.   .::  .::     .:^^:.      .:^^:     .::.     .:^:  
 .7G#########Y^:^::::::^:^J#########B?.                                                                                                     
    !5B####&5::^^::..::^^^.Y####&#P7.            [Integrantes]:                                
      :75B#&B!::^:::.::^::~B&##PJ^                   - Roberto Jimenez (Full-Stack, Arquitecto MVP)                       
         .~J5G?~:^::::::^JGPJ!:                      - Samul Castro (DBA / Data Engineer, Back-End)                       
           .^^~^:.::::::^~^^.                        - Alejandra Bolvar (Developer, Tester / QA)                               
           ~!!~~~::^^:.~~~!!~.                       - Esteban Jaimez (Developer)                                                                                    
           ~!!!~~:^!~^.~~!!!~.                                                                                                              
           .~^:.        .::~:                    Michisoft Studios - 2025 (Univercidad de Barranquilla)                                                                                       

*/

/* 📖 Glosario de conceptos (Estructurado para el proyecto MichiSoft):

   [+] Conversión Explícita (Casting) {1}
      - Permite convertir un valor de un tipo de dato a otro.
      - Ejemplo: (String), (int), (double)
      - Uso típico: cuando un método devuelve un Object
        y necesitamos tratarlo como un tipo específico.
        Ej: String valor = (String) comboBox.getSelectedItem();

   [+] ArrayList {2}
      - Colección dinámica de elementos en Java.
      - A diferencia de los arrays, su tamaño puede crecer o reducirse.
      - Métodos comunes:
         .add()    → Agregar un elemento
         .get(i)   → Obtener un elemento en la posición i
         .size()   → Saber cuántos elementos tiene
      - Ejemplo:
         ArrayList<String> nombres = new ArrayList<>();
         nombres.add("Carlos");
         System.out.println(nombres.get(0)); // "Carlos"

   [+] DefaultTableModel {3}
      - Clase de Swing que facilita manejar datos en tablas (JTable).
      - Permite agregar, eliminar o actualizar filas/columnas dinámicamente.
      - Métodos comunes:
         .addRow(Object[])  → Agregar una fila
         .setRowCount(0)    → Limpiar la tabla
         .getValueAt(i, j)  → Obtener un valor en fila i y columna j
      - Ejemplo:
         DefaultTableModel modelo = new DefaultTableModel();
         modelo.addColumn("Nombre");
         modelo.addRow(new Object[]{"Carlos"});

   [+] Map<K,V> {4}
      - Estructura de datos que almacena pares clave-valor.
      - Permite acceder rápidamente a un valor usando su clave.
      - Métodos comunes:
         .put(k, v)    → Insertar un par
         .get(k)       → Obtener el valor asociado a la clave k
         .remove(k)    → Eliminar un par por clave
         .keySet()     → Obtener todas las claves
      - Ejemplo:
         Map<String, String> productos = new HashMap<>();
         productos.put("001", "Laptop");
         System.out.println(productos.get("001")); // "Laptop"

   [+] Try-Catch (Manejo de Excepciones) {5}
      - Estructura que permite manejar errores en tiempo de ejecución.
      - Si ocurre un error dentro de try, el bloque catch captura la excepción.
      - Ejemplo:
         try {
            int num = Integer.parseInt("abc"); // Error
         } catch (NumberFormatException e) {
            System.out.println("Error al convertir número");
         }

   [+] BufferedWriter / FileWriter {6}
      - Clases usadas para escribir texto en archivos.
      - BufferedWriter mejora el rendimiento al usar un buffer de escritura.
      - Ejemplo:
         try(BufferedWriter bw = new BufferedWriter(new FileWriter("factura.txt"))){
            bw.write("Factura N°1");
         } catch(IOException e){
            System.out.println("Error al guardar archivo");
         }

   [+] DateTimeFormatter / LocalDateTime {7}
      - API moderna de fechas y horas en Java.
      - Permite obtener la fecha y hora actual con un formato específico.
      - Ejemplo:
         LocalDateTime ahora = LocalDateTime.now();
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
         System.out.println(dtf.format(ahora)); 

   🔗 Referencias:
     {1} https://codersfree.com/posts/conversion-de-tipos-en-java#:~:text=Conversi%C3%B3n%20Expl%C3%ADcita%20(Casting)
         https://es.stackoverflow.com/questions/1487/guia-definitiva-de-conversi%C3%B3n-de-tipos-en-java
     {2} https://www.w3schools.com/java/java_arraylist.asp
     {3} https://docs.oracle.com/javase/8/docs/api/javax/swing/table/DefaultTableModel.html
     {4} https://www.w3schools.com/java/java_hashmap.asp
     {5} https://www.geeksforgeeks.org/exceptions-in-java/
     {6} https://docs.oracle.com/javase/8/docs/api/java/io/BufferedWriter.html
     {7} https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
 */



package com.michiStudios.michisoft;

//Panel Login
import com.michiStudios.michisoft.Model.loginModel;
import com.michiStudios.michisoft.View.loginView;
import com.michiStudios.michisoft.Precenter.loginPrecenter;

//Importacion de la DB y PreDB, FileManager
import com.michiStudios.michisoft.database.DataBase;
import com.michiStudios.michisoft.database.preData;
import com.michiStudios.michisoft.database.FileManage.MainFileManager;

/**
 *
 * @author ROBERTO JIMENEZ
 */

public class Main {

    public static void main(String[] args) {
        DataBase db = new DataBase();
    
        //Cargador de datos de prueba
        /*
        preData preData1 = new preData(db);
        preData1.cargarDatosPrueba();
        */
    
        // File manager
        MainFileManager fm = new MainFileManager();
        fm.cargar(db);
        fm.registrarAutoGuardado(db);
    
        // Cargador de: modelo, presentador y vista (Login)
        loginModel loginModel = new loginModel(db);
        loginPrecenter loginPrecenter = new loginPrecenter(loginModel,db, fm);
        loginView loginView = new loginView(loginPrecenter);
    
        //Inicio del codigo
        loginPrecenter.start();
        loginView.setVisible(true);
    }
}
