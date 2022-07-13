package lk.easyrental.service;

import lk.easyrental.dto.BookingDTO;

import java.util.ArrayList;
import java.util.List;

public interface BookingService {
    void saveBooking(BookingDTO dto);

    void deleteBooking(String id);

    BookingDTO searchBooking(String id);

    void updateBooking(BookingDTO dto);

    List<BookingDTO> getAllBooking();

//    String getLastID();
//
//    String getNewID();
//
//    List<BookingDTO> readByStatus(String status);
//
//    List<BookingDTO> getBookinginCid(String id);
//
//    List<BookingDTO> getBookingMultiStatus(String id);
//
//    List<BookingDTO> getBookinginId(String driverId);
}
