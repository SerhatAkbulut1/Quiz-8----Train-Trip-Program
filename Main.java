import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int listLenghtFinder(String input){
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(input)))){
            int listLenght = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                listLenght++;
            }return listLenght;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(args[0])))) {
            Trip[] trips = new Trip[listLenghtFinder(args[0])];
            int lineNumber = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] info = line.split("\t");
                String[] departureTime = info[1].split(":");
                LocalDateTime DepartureTime = LocalDateTime.of(2023,Month.JANUARY,1,Integer.parseInt(departureTime[0]),Integer.parseInt(departureTime[1]));
                Trip trip= new Trip(info[0],DepartureTime,Integer.parseInt(info[2]));
                trips[lineNumber] = trip;
                lineNumber++;
            }
            TripSchedule tripSchedule = new TripSchedule(trips);
            TripController TripController = new TripController(tripSchedule);
            TripController.outputPath = args[1];
            TripController.DepartureSchedule(trips);
            TripController.ArrivalSchedule(trips);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}