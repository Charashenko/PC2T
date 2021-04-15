package cz.vutbr.feec.dbconnection;

import java.sql.PreparedStatement;
import java.util.Scanner;

import cz.vutbr.feec.dbconnection.crud.DeleteQueries;
import cz.vutbr.feec.dbconnection.crud.InsertQueries;
import cz.vutbr.feec.dbconnection.crud.SelectQueries;
import cz.vutbr.feec.dbconnection.crud.UpdateQueries;
import cz.vutbr.feec.dbconnection.dbconn.DBConnection;

/**
 * POZN. V úkolech je èasté doimplementovat pøíkaz nebo celou metodu, proto pokud se z této tøídy
 * chcete dostat k implementaci metody zmáèknìte tlaèítko Control a pravým najeïte na metodu, kterou
 * máte implementovat a kliknìte na Open Implementation.
 * 
 * @author Pavel Šeda (154208)
 *
 */
public class RunApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int choice = 0;
    boolean run = true;
    int iteration = 0;

    while (run) {
      if (iteration == 0)
        iteration++;
      else
        System.out.println(System.lineSeparator());
      System.out.println("Vyberte pozadovanou cinnost:");
      System.out.println("1 .. vlozeni uzivatele s emailem myname123@stud.feec.vutbr.cz");
      System.out.println("2 .. vlozeni libovolneho zadaneho uzivatele");
      System.out.println("3 .. vypis emailu, jmena a prijmeni o vsech uzivatelich");
      System.out.println("4 .. vypis vsech uzivatelu s roli USER");
      System.out.println("5 .. zvyseni platu uzivatele s emailem: myname@stud.feec.vutbr.cz o 20%");
      System.out.println("6 .. smazani uzivatele");
      System.out.println("7 .. vypis vsech roli v systemu");
      System.out.println("8 .. ukonceni aplikace");
      choice = ConsoleInput.readNumberInputFromConsole(sc);
      switch (choice) {
        case 1:
          // tento pøíklad znázoròuje vložení uživatele s emailem: myname123@stud.feec.vutbr.cz,
          // jménem Jon, pøijmením Doe, vìkem 30 let a výší platu 10 000
          InsertQueries i = new InsertQueries();
          i.performInsertQuery("INSERT INTO user " + "(email,name,surname,age,salary)"
              + "VALUES('myname123@stud.feec.vutbr.cz', 'Jon','Doe', 30, 10000)");
          break;
        case 2:
          System.out.println("Zadejte email uzivatele");
          String email = sc.next();
          SelectQueries testUserExistence = new SelectQueries();
          if (testUserExistence.testIfUserExists(email)) {
            String userEmailToCreate = "";
            do {
              System.out.println(
                  "Uzivatel s takovymto emailem jiz existuje prosim zadejte email znovu: ");
              userEmailToCreate = sc.next();
            } while (testUserExistence.testIfUserExists(userEmailToCreate));
          }

          System.out.println("Zadejte jmeno uzivatele");
          String name = sc.next();
          System.out.println("Zadejte prijmeni uzivatele");
          String surname = sc.next();

          InsertQueries i2 = new InsertQueries();
          i2.insertNewUser(email, name, surname);
          break;
        case 3:
          SelectQueries se = new SelectQueries();
          // doplòtì tuto metodu dle zadání v metodì
          se.getAllUserEmailAndNameAndSurname();
          break;
        case 4:
          SelectQueries selectUserRoles = new SelectQueries();
          // prostudujte si tuto metodu a zjistìte, jak funguje JOIN tabulek
          selectUserRoles.getAllUsersWithRoleUser();
          break;
        case 5:
          SelectQueries selectUser = new SelectQueries();
          System.out.println("Email a plat uzivatele pred zvysenim platu o 20%");
          selectUser.printUserEmailAndSalary("myname@stud.feec.vutbr.cz");
          UpdateQueries updateQuery = new UpdateQueries();

          // doplòte tuto metodu, tak abyste tomuto uživateli zvýšili plat o 20%
          updateQuery.increase20PercentOfSalary("myname@stud.feec.vutbr.cz");

          System.out.println("Email a plat uzivatele po zvyseni platu o 20%");
          selectUser.printUserEmailAndSalary("myname@stud.feec.vutbr.cz");
          break;
        case 6:
          System.out.println(
              "Zadejte email uzivatele, ktereho chcete vymazat z databaze (napr. myname123@stud.feec.vutbr.cz)");
          String userName = sc.next();
          SelectQueries s = new SelectQueries();
          if (s.testIfUserExists(userName)) {
            DeleteQueries d = new DeleteQueries();

            // doplòte metodu na vymazání uživatele dle emailu
            d.deleteUserByEmail(userName);
          } else {
            System.out
                .println("Uzivatel se zadanym emailem neexistuje, zkuste zadat email spravne.");
            break;
          }
          break;
        case 7:
          SelectQueries roles = new SelectQueries();
          // implementuje celou metodu printAllRolesInDB, tak aby vypsala všechny role v DB
          roles.printAllRolesInDB();
          break;
        default:
          run = false;
          DBConnection.closeConnection();
          break;
      }
    }
  }
}
