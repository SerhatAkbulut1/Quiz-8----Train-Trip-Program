import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;

public class TripController implements DepartureController,ArrivalController {
    public String outputPath;
    public TripSchedule tripSchedule;

    public TripController(TripSchedule tripSchedule) {
        this.tripSchedule = tripSchedule;
    }

    public void DepartureSchedule(Trip[] trips) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter( outputPath,true))){
            // Sort the trips by departure time
            for (int i = 0; i < trips.length - 1; i++) {
                for (int j = i + 1; j < trips.length; j++) {
                    if (trips[i].getDepartureTime().isAfter(trips[j].getDepartureTime())) {
                        Trip temp = trips[i];
                        trips[i] = trips[j];
                        trips[j] = temp;
                    }
                    if(trips[i].getDepartureTime().isEqual(trips[j].getDepartureTime())){
                        trips[i].setDeparterState("DELAYED");
                        trips[j].setDeparterState("DELAYED");
                    }
                }
            }
            // Print the sorted list of trips by departure time

            writer.write("Departure Order:"+"\n");
            for (Trip trip : trips) {
                if (trip.getDepartureTime().getHour() < 10 && trip.getDepartureTime().getMinute() >= 10) {
                    writer.write(trip.getTripName() + " depart at  " + "0" + trip.getDepartureTime().getHour() + ":"
                            + trip.getDepartureTime().getMinute() + "   " + "Trip State:" + trip.getDeparterState()+"\n");
                }
                else if (trip.getDepartureTime().getMinute() < 10 && trip.getDepartureTime().getHour() >= 10) {
                    writer.write(trip.getTripName() + " depart at  " + trip.getDepartureTime().getHour() + ":0"
                            + trip.getDepartureTime().getMinute() + "   " + "Trip State:" + trip.getDeparterState()+"\n");
                }

                else if (trip.getDepartureTime().getHour() < 10 && trip.getDepartureTime().getMinute() < 10) {
                    writer.write(trip.getTripName() + " depart at  " + "0" + trip.getDepartureTime().getHour() + ":0"
                            + trip.getDepartureTime().getMinute() + "   " + "Trip State:" + trip.getDeparterState()+"\n");
                }

                else {
                    writer.write(trip.getTripName() + " depart at  " + trip.getDepartureTime().getHour()+":"+trip.getDepartureTime().getMinute() + "   " +"Trip State:"+ trip.getDeparterState()+"\n");
                }


            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void ArrivalSchedule(Trip[] trips) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath,true))){
            // Sort the trips by arrival time

            for (int i = 0; i < trips.length - 1; i++) {
                for (int j = i + 1; j < trips.length; j++) {
                    if (trips[i].getArrivalTime().isAfter(trips[j].getArrivalTime())) {
                        Trip temp = trips[i];
                        trips[i] = trips[j];
                        trips[j] = temp;
                    }
                    if (trips[i].getArrivalTime().isEqual(trips[j].getArrivalTime())) {
                        trips[i].setArrivalState("DELAYED");
                        trips[j].setArrivalState("DELAYED");
                    }
                }
            }
            writer.write("\n"+"Arrival Order:"+"\n");
            for (Trip trip : trips) {
                if (trip.getArrivalTime().getHour() < 10 && trip.getArrivalTime().getMinute() >= 10) {
                    writer.write(trip.getTripName() + " arrive at  " + "0" + trip.getArrivalTime().getHour() + ":"
                            + trip.getArrivalTime().getMinute() + "   " + "Trip State:" + trip.getArrivalState()+"\n");
                } else if (trip.getArrivalTime().getMinute() < 10 && trip.getArrivalTime().getHour() >= 10) {
                    writer.write(trip.getTripName() + " arrive at  " + trip.getArrivalTime().getHour() + ":0"
                            + trip.getArrivalTime().getMinute() + "   " + "Trip State:" + trip.getArrivalState()+"\n");
                }

                else if (trip.getArrivalTime().getHour() < 10 && trip.getArrivalTime().getHour() < 10) {
                    writer.write(trip.getTripName() + " arrive at  " + "0" + trip.getArrivalTime().getHour() + ":0"
                            + trip.getArrivalTime().getMinute() + "   " + "Trip State:" + trip.getArrivalState()+"\n");
                }

                else {
                    writer.write(trip.getTripName() + " arrive at  " + trip.getArrivalTime().getHour() + ":"
                            + trip.getArrivalTime().getMinute() + "   " + "Trip State:" + trip.getArrivalState()+"\n");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}