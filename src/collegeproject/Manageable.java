package collegeproject;


import java.io.IOException;

public interface Manageable {

    void addFlight(collegeproject.Manage m1) throws IOException;
    void deleteFlight(int num);
    void updateFlight(Flight F);
    void showFlights();
    void searchSpecificFlight(int num);
    void showFlightsHistory() throws IOException;
}

