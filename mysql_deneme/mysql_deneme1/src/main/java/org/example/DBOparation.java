package org.example;

import java.sql.*;

public class DBOparation {

    private static final String connectionUrl = "jdbc:mysql://localhost:3306/deneme1";

    private static final String userName = "root";

    private static final String password = "Hafiz1275";

    public static Connection openConnection () throws SQLException {

       return DriverManager.getConnection(connectionUrl, userName,password);

    }
    public  static ResultSet resultSet (String selectSql){
       try (Connection myConnection =openConnection()) {
          Statement myConnectionStatement = myConnection.createStatement();
          ResultSet myResultSet = myConnectionStatement.executeQuery(selectSql);
          return myResultSet;

       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }
    public static Integer updateProcces(String oneParamUpdateSql,String oneParamUpdateSql2,String oneParamUpdateSql3){
        try (Connection myConnection = openConnection()){
          PreparedStatement myPreparedStatement = myConnection.prepareStatement(oneParamUpdateSql);
            myPreparedStatement.setString(1,oneParamUpdateSql2);
            myPreparedStatement.setString(2,oneParamUpdateSql3);
            return myPreparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Integer InsertProcces(String oneParamUpdateSql,String ogrenci_isim,String ogrenci_id,String ogrenci_soyiism,String aktiflik_durumu){
        try (Connection myConnection = openConnection()){
            PreparedStatement myPreparedStatement = myConnection.prepareStatement(oneParamUpdateSql);
            myPreparedStatement.setString(1,ogrenci_isim);
            myPreparedStatement.setString(2,ogrenci_id);
            myPreparedStatement.setString(3,ogrenci_soyiism);
            myPreparedStatement.setString(4,aktiflik_durumu);
            return myPreparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Integer deleteProcces(String oneParamUpdateSql,String oneParamUpdateSql2){
        try (Connection myConnection = openConnection()){
            PreparedStatement myPreparedStatement = myConnection.prepareStatement(oneParamUpdateSql);
            myPreparedStatement.setString(1,oneParamUpdateSql2);
            return myPreparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}
