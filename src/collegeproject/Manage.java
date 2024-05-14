package collegeproject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Manage extends Flight implements Manageable{

    File file = new File("flights history.txt");
    // Gets the path of the file
    Path path = file.toPath();

    BufferedReader br = new BufferedReader( new FileReader("flights history.txt"));
    FileWriter fr = new FileWriter("flights history.txt", true);
    PrintWriter pr = new PrintWriter(fr,true);

    Scanner in = new Scanner(System.in);

    public Manage() throws IOException {}
    public Manage(String to, String from, int numOfSeats, int takeOffMinute, int takeOffHour, int takeOffDay, int takeOffMonth, int takeOffYear,int flightDuration,int landingMunite,int landingHour,int landingDay,int landingMonth,int landingYear) throws IOException {
        super(to, from, numOfSeats, takeOffMinute, takeOffHour, takeOffDay, takeOffMonth, takeOffYear,flightDuration,landingMunite,landingHour,landingDay,landingMonth,landingYear);
    }

    public Manage(double cost, String FlayingClass, String ownerName,String phoneNumber) throws IOException {
        super(cost,FlayingClass,ownerName,phoneNumber);
    }

    public Manage(String firstName, String secondName, String e_mail, String gender, String number, String passportNum, int age) throws IOException {
        super(firstName,secondName,e_mail,gender,number,passportNum,age);
    }

    @Override
    public  void addFlight(Manage m1) throws IOException {




        arrayList.add(new Flight(m1.getTo(), m1.getFrom(), m1.getNumOfSeats() ,m1.getTakeOffMinute(),m1.getTakeOffHour(), m1.getTakeOffDay(), m1.getTakeOffMonth(), m1.getTakeOffYear()
                ,m1.getFlightDuration(),m1.getLandingMinute(),m1.getLandingHour(),m1.getLandingDay(),m1.getLandingMonth(),m1.getLandingYear()));
        //flightNum++;




        try {
            // Gets the current date and time
            LocalDateTime now = LocalDateTime.now();
            // Converts the date and time to a file time object
            FileTime fileTime = FileTime.from(now.atZone(ZoneId.systemDefault()).toInstant());
            // Sets the last modified time of the file
            Files.setLastModifiedTime(path, fileTime);
            // Prints the last modified time of the file
            //System.out.println("File last modified: " + Files.getLastModifiedTime(path));
            pr.println("a flight has been added at"+now+"\n"+"flight details are:"+m1);
        } catch (IOException e) {
            // Handles the exception
            e.printStackTrace();
        }
    }


    @Override
    public void deleteFlight(int num) {
        int counter =0;
        arrayList.remove(num-1);

        try {
            // Gets the current date and time
            LocalDateTime now = LocalDateTime.now();
            // Converts the date and time to a file time object
            FileTime fileTime = FileTime.from(now.atZone(ZoneId.systemDefault()).toInstant());
            // Sets the last modified time of the file
            Files.setLastModifiedTime(path, fileTime);
            // Prints the last modified time of the file
            //System.out.println("File last modified: " + Files.getLastModifiedTime(path));
            pr.println("a flight has been deleted at"+now+"\n"+"flight number:"+num);
        } catch (IOException e) {
            // Handles the exception
            e.printStackTrace();
        }

        for(int i=num-1;i<arrayList.size();i++){
            arrayList.get(i).setFlightNumber2(num+counter);// arrayList.get(i).setFlightNumber2(getFlightNumber2-1)
            counter++; // arrayList.get(i).setFlightNumber2(getFlightNumber2-1)
        }
        //    arrayList.add(num-1,null);
    }


    @Override
    public void updateFlight(Flight F) {
        boolean flag = false;
        while (flag == false){
            System.out.println("""
                           Choose what you want to update
                           1.From\t2.to
                           3.Take Off Minute\t4.Take Off Hour\t5.Take Off Day\t6.Take Off month\t7.Take Off year
                           8.Flight Duration\t9.Number Of Seats""");
            int x = in.nextInt();
            System.out.println("Enter new value");
            if ( x == 1 ) { F.setFrom(in.next()); flag = true; }
            else if ( x == 2 ) { F.setTo(in.next()); flag = true; }
            else if ( x == 3 ) { F.setTakeOffMinute(in.nextInt());int[] landinDate=F.calculateLandingTime(F.takeOffMinute,F.takeOffHour,F.takeOffDay,F.takeOffMonth,F.takeOffYear,F.flightDuration);
                F.setLandingMinute(landinDate[0]);
                F.setLandingHour(landinDate[1]);
                F.setLandingDay(landinDate[2]);
                F.setLandingMonth(landinDate[3]);
                F.setLandingYear(landinDate[4]);
                flag = true; }
            else if ( x == 4 ) { F.setTakeOffHour(in.nextInt());int[] landinDate=F.calculateLandingTime(F.takeOffMinute,F.takeOffHour,F.takeOffDay,F.takeOffMonth,F.takeOffYear,F.flightDuration);
                F.setLandingMinute(landinDate[0]);
                F.setLandingHour(landinDate[1]);
                F.setLandingDay(landinDate[2]);
                F.setLandingMonth(landinDate[3]);
                F.setLandingYear(landinDate[4]);
                flag = true; }
            else if ( x == 5 ) { F.setTakeOffDay(in.nextInt());int[] landinDate=F.calculateLandingTime(F.takeOffMinute,F.takeOffHour,F.takeOffDay,F.takeOffMonth,F.takeOffYear,F.flightDuration);
                F.setLandingMinute(landinDate[0]);
                F.setLandingHour(landinDate[1]);
                F.setLandingDay(landinDate[2]);
                F.setLandingMonth(landinDate[3]);
                F.setLandingYear(landinDate[4]);
                flag = true; }
            else if ( x == 6 ) { F.setTakeOffMonth(in.nextInt());int[] landinDate=F.calculateLandingTime(F.takeOffMinute,F.takeOffHour,F.takeOffDay,F.takeOffMonth,F.takeOffYear,F.flightDuration);
                F.setLandingMinute(landinDate[0]);
                F.setLandingHour(landinDate[1]);
                F.setLandingDay(landinDate[2]);
                F.setLandingMonth(landinDate[3]);
                F.setLandingYear(landinDate[4]);
                flag = true; }
            else if ( x == 7 ) { F.setTakeOffYear(in.nextInt());int[] landinDate=F.calculateLandingTime(F.takeOffMinute,F.takeOffHour,F.takeOffDay,F.takeOffMonth,F.takeOffYear,F.flightDuration);
                F.setLandingMinute(landinDate[0]);
                F.setLandingHour(landinDate[1]);
                F.setLandingDay(landinDate[2]);
                F.setLandingMonth(landinDate[3]);
                F.setLandingYear(landinDate[4]);
                flag = true; }
            else if ( x == 8)  {
                F.setFlightDuration(in.nextInt());
                int[] landinDate=F.calculateLandingTime(F.takeOffMinute,F.takeOffHour,F.takeOffDay,F.takeOffMonth,F.takeOffYear,F.flightDuration);
              /*  int nlandingMunite =landinDate[0];
                int nlandingHour =landinDate[1];
                int nlandingDay =landinDate[2];
                int nlandingMonth =landinDate[3];
                int nlandingYear =landinDate[4]; */
                F.setLandingMinute(landinDate[0]);
                F.setLandingHour(landinDate[1]);
                F.setLandingDay(landinDate[2]);
                F.setLandingMonth(landinDate[3]);
                F.setLandingYear(landinDate[4]);

                flag=true;
            }
            else if ( x == 9 ) { F.setNumOfSeats(in.nextInt()); flag = true; }
            else { System.out.println("invalid choice"); }
        }
    }


    @Override
    public void showFlights() {
        for(int i=0;i<arrayList.size();i++){
            // if ( arrayList.get(i).equals(null) )
            //   continue;
            //else
            System.out.println(arrayList.get(i)+"\n");
        }
    }

    @Override
    public void searchSpecificFlight(int num) {
        System.out.println(arrayList.get(num-1).toString());
        System.out.println("");
    }

    public void showFlightsHistory() throws IOException {

        String line = br.readLine();

        while ( line != null ){
            System.out.println(line);
            line = br.readLine();
        }

    }

}