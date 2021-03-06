package lesson35.repository;

import lesson35.model.Hotel;

import java.util.ArrayList;

public class HotelRepository extends GeneralRepository<Hotel> {
    private String path = "/home/anton/HotelDB.txt";

    public ArrayList<Hotel> readFile() {
        return readFromFile();
    }

    public void addHotel(Hotel hotel) {
        addObject(hotel);
    }

    public void deleteHotel(long id) {
        deleteObject(id);
    }

    @Override
    public Hotel map(String str) {
        String[] array = str.split(".");
        return new Hotel(Long.parseLong(array[0].trim()), array[1].trim(), array[2].trim(), array[3].trim(), array[4].trim());
    }
}
