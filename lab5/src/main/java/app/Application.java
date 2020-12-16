package app;

import java.sql.*;
import java.util.Scanner;

public class Application {
    private static final String url =
            "jdbc:mysql://localhost:3306/julie_fliorko_db?useUnicode=true&serverTimezone=UTC&useSSL=false";
    private static final String user = "root";
    private static final String password = "julie";

    private static Connection connection=null;
    private static Statement statement=null;
    private static ResultSet rs=null;

    private static void readData() throws SQLException{
        rs=statement.executeQuery("SELECT COUNT(*) FROM review ");
        while(rs.next()){
            int count = rs.getInt(1);
            System.out.format("\ncount: %d\n", count);
        }

        rs=statement.executeQuery("SELECT * FROM review");
        System.out.format("\nTable Review-----------------------------\n");
        System.out.format("%3s| %-12s| %-12s| %-10s| %s\n", "ID", "Nickname", "Review text", "Date", "Film ID");
        while(rs.next()){
            int id = rs.getInt("id");
            String nick_name = rs.getString("nick_name");
            String review_text = rs.getString("review_text");
            String date = rs.getString("date");
            int film_id =rs.getInt("film_id");
            System.out.format("%3s| %-12s| %-12s| %-10s| %s\n", id, nick_name, review_text, date, film_id);
        }

        rs=statement.executeQuery("SELECT * FROM actor");
        System.out.format("\nTable Actor-----------------------------\n");
        System.out.format("%3s| %-20s| %-12s| %-10s\n", "ID", "Name", "Surname", "Date of birth");
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String date_of_birth = rs.getString("date_of_birth");
            System.out.format("%3s| %-20s| %-12s| %-10s\n", id, name, surname, date_of_birth);
        }

        rs=statement.executeQuery("SELECT * FROM country");
        System.out.format("\nTable Country-----------------------------\n");
        System.out.format("%-12s| %3s\n", "Country", "ID");
        while(rs.next()){
            String name = rs.getString("name");
            int id = rs.getInt("id");
            System.out.format("%-12s| %3s \n", name, id);
        }

        rs=statement.executeQuery("SELECT * FROM film");
        System.out.format("\nTable Film-----------------------------\n");
        System.out.format("%3s| %-30s| %-12s| %-10s| %-10s| %-10s| %-10s| %-10s\n", "ID", "Name", "Release date", "Runtime", "Rating/10", "City", "production_company_id", "country_id");
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String release_date = rs.getString("release_date");
            int rating_out_of_ten = rs.getInt("rating_out_of_ten");
            String origin_city = rs.getString("origin_city");
            int production_company_id = rs.getInt("production_company_id");
            int country_id = rs.getInt("country_id");
            System.out.format("%3s| %-30s| %-12s| %-10s| %-10s| %-10s\n", id, name, release_date, rating_out_of_ten, origin_city, production_company_id, country_id);
        }

        rs=statement.executeQuery("SELECT * FROM film_has_actor");
        System.out.format("\nTable film_has_actor-----------------------------\n");
        System.out.format("%3s| %3s| %3s\n", "Film ID", "Production company ID", "Actor ID");
        while(rs.next()){
            int film_id = rs.getInt("film_id");
            int film_production_company_id = rs.getInt("film_production_company_id");
            int actor_id = rs.getInt("actor_id");
            System.out.format("%3s| %3s| %3s\n", film_id, film_production_company_id, actor_id);
        }

        rs=statement.executeQuery("SELECT * FROM fun_fact");
        System.out.format("\nTable Fun Fact-----------------------------\n");
        System.out.format("%3s| %-10s| %-12s| %-10s| %-10s\n", "ID", "Source", "Fun Fact", "Date", "Film ID");
        while(rs.next()){
            int id = rs.getInt("id");
            String sourse = rs.getString("sourse");
            String fact_text= rs.getString("fact_text");
            String date = rs.getString("date");
            int film_id = rs.getInt("film_id");
            System.out.format("%3s| %-10s| %-12s| %-10s| %-10s\n", id, sourse, fact_text, date, film_id);
        }

        rs=statement.executeQuery("SELECT * FROM genre");
        System.out.format("\nTable Genre-----------------------------\n");
        System.out.format(" %3s| %-14s|\n", "ID", "Genre");
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("genreName");
            System.out.format("%3s| %-15s| \n", id, name);
        }

        rs=statement.executeQuery("SELECT * FROM genre_has_film");
        System.out.format("\nTable Genre has Film-----------------------------\n");
        System.out.format(" %3s| %-5s|\n", "Genre ID", "Film ID");
        while(rs.next()){
            int genre_id = rs.getInt("genre_id");
            int film_id = rs.getInt("film_id");
            System.out.format("%-9s| %-7s| \n", genre_id, film_id);
        }

        rs=statement.executeQuery("SELECT * FROM musics");
        System.out.format("\nTable Music-----------------------------\n");
        System.out.format(" %3s| %-5s|\n", "ID", "Name");
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String composor = rs.getString("composor");
            System.out.format("%4s| %-5s| \n", id, name, composor);
        }

        rs=statement.executeQuery("SELECT * FROM musics_has_film");
        System.out.format("\nTable Music has Film-----------------------------\n");
        System.out.format(" %3s| %-5s|\n", "Music ID", "Film ID");
        while(rs.next()){
            int music_id = rs.getInt("musics_id");
            int film_id = rs.getInt("film_id");
            System.out.format("%-9s| %-7s| \n", music_id, film_id);
        }
        rs=statement.executeQuery("SELECT * FROM production_company");
        System.out.format("\nTable Production company-----------------------------\n");
        System.out.format("%3s| %-28s| %-10s| %-10s|\n", "ID", "Name", "Foundation year", "Owner");
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String founded = rs.getString("founded");
            String website = rs.getString("website");
            String owner = rs.getString("owner");
            System.out.format("%3s| %-28s| %-15s| %-10s|\n", id, name, founded, website, owner);
        }
    }

    private static void updateDataCity() throws SQLException{
        Scanner input = new Scanner(System.in);
        System.out.println("Input country-name -- you want to update: ");
        String country = input.next();
        System.out.println("Update country-name for %s: "+ country);
        String countrynew = input.next();

        PreparedStatement preparedStatement;
        preparedStatement=connection.prepareStatement("UPDATE country SET name=? WHERE name=?");
        preparedStatement.setString(1, countrynew);
        preparedStatement.setString(2, country);
        int n=preparedStatement.executeUpdate();
        System.out.println("Count rows that updated: "+n);
    }
    public static void main(String[] args)  {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            readData();
            updateDataCity();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }finally {
            if(rs != null) try{rs.close();} catch(SQLException e){}
            if(statement != null) try{statement.close();} catch(SQLException e){}
            if(connection != null) try{connection.close();} catch(SQLException e){}
        }
    }
}

