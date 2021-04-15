package cz.vutbr.feec.dbconnection.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cz.vutbr.feec.dbconnection.dbconn.DBConnection;

/**
 * 
 * @author Pavel ?eda (154208)
 *
 */
public class InsertQueries {

  public InsertQueries() {}


  /**
   * Template metoda, do kter? se d? vkl?dat libovoln? SQL INSERT p??kaz.
   * 
   * POZN: nen? vhodn? implementovat sv? metody t?mto zp?sobem, daleko vhodn?j?? je implementovat
   * konkr?tn? metody (nap?. insertNewUser(String email, char[] password) pomoc? PreparedStatements,
   * do kter?ch vkl?d?me konkr?tn? parametry)
   * 
   * @param insertQuery ?et?zec p?edstavuj?c? p??kaz INSERT
   */
  public void performInsertQuery(String insertQuery) {
    if (insertQuery == null) {
      throw new NullPointerException("query must not be null!");
    } else if (insertQuery.isEmpty()) {
      throw new IllegalArgumentException("query must not be empty!");
    }
    Connection conn = DBConnection.getDBConnection();
    try (PreparedStatement prStmt = conn.prepareStatement(insertQuery);) {
      int rowsInserted = prStmt.executeUpdate();
      // System.out.println("Bylo vlo?eno u?ivatel?: " + rowsInserted);
      System.out.println("Byl vlozen uzivatel s emailem: " + "myname123@stud.feec.vutbr.cz");
    } catch (SQLException e) {
      System.out.println("Uzivatel s emailem: " + "myname123@stud.feec.vutbr.cz "
          + "jiz byl vlozen nemusite jej vkladat znovu");
      // e.printStackTrace();
    }
  }

  /**
   * ?kol: Va??m ?kolem je p?i?adit INSERT p??kaz do prom?nn? insertUser, tak aby se vytvo?il nov?
   * u?ivatel dle zadan?ch parametr?
   * 
   * HINT: V t?to metod? jsou vyu?ity preparedStatements, tak?e se parametr emailu nastav? a?
   * pozd?ji p??kazem prStmt.setString(1, email)... Pro p?edstavu, jak se p?? prepared statements
   * se pod?vejte na n?sleduj?c? odkaz:
   * https://www.mkyong.com/jdbc/jdbc-preparestatement-example-insert-a-record/
   * 
   * @param email u?ivatele
   * @param name u?ivatele
   * @param surname u?ivatele
   */
  public void insertNewUser(String email, String name, String surname) {
    if (email == null || name == null || surname == null)
      throw new NullPointerException("Email, name and surname must be set.");

    Connection conn = DBConnection.getDBConnection();

    String insertUser = "INSERT INTO user (email,name,surname) VALUES (?, ?, ?)";
    //vkladam do tabulky user do stlpcov email, name, surname hodnoty, ktore su parametrom funkcie

    try (PreparedStatement prStmt = conn.prepareStatement(insertUser)) {
      prStmt.setString(1, email);
      prStmt.setString(2, name);
      prStmt.setString(3, surname);

      prStmt.executeUpdate();
      System.out.println("Novy uzivatel byl vlozen do databaze!");
    } catch (SQLException e) {
      System.out.println("Uzivatel uz byl vlozen nebo jste zadali spatny SQL prikaz INSERT");
      // e.printStackTrace();
    }
  }


}
