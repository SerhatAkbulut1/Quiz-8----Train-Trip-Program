# Train Trip Program

This program records information about train trips and provides functionality to manage the departure and arrival schedules of the trips. It uses a class called TripController that implements two interfaces, DepartureController and ArrivalController.

# Class Structure

The program consists of the following classes and interfaces:

Trip: Represents a train trip with properties such as trip name, departure time, duration, and status. It provides getter and setter methods for accessing and modifying these properties.

TripSchedule: Contains an array of Trip objects and provides methods for managing the trips.

DepartureController (Interface): Defines methods for managing the departure schedule of trips.

ArrivalController (Interface): Defines methods for managing the arrival schedule of trips.

TripController: Implements the DepartureController and ArrivalController interfaces. It uses a TripSchedule object to store and manage the trips. The TripController class handles sorting and outputting the departure and arrival schedules.

# Program Flow

1-The program reads the trip information from an input file.

2-The Trip objects are created with the provided information, and their arrival times are calculated.

3-The TripController object is created and initialized with the TripSchedule object.

4-The departure and arrival schedules are sorted using the departure and arrival controllers.

5-The sorted schedules are outputted to the output file.
