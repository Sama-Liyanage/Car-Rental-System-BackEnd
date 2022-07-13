package lk.easyrental.service.impl;

import lk.easyrental.dto.AdminDTO;
import lk.easyrental.dto.BookingDTO;
import lk.easyrental.entity.Admin;
import lk.easyrental.entity.Booking;
import lk.easyrental.repo.BookingRepo;
import lk.easyrental.service.BookingReturnService;
import lk.easyrental.service.BookingService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    ModelMapper mapper;

    @Autowired
    BookingRepo bookingRepo;

    @Override
    public void saveBooking(BookingDTO dto) {
        if (!bookingRepo.existsById(dto.getBookingID())){
            bookingRepo.save(mapper.map(dto, Booking.class));
        }else{
            throw new RuntimeException("Already Booked! Try Again");
        }
    }

    @Override
    public void deleteBooking(String id) {
        if (!bookingRepo.existsById(id)) {
            bookingRepo.deleteById(id);
        }
        throw new RuntimeException("No Booking for Delete!");
    }

    @Override
    public void updateBooking(BookingDTO dto) {
        if(bookingRepo.existsById(dto.getBookingID())){
            bookingRepo.save(mapper.map(dto,Booking.class));
        };
    }

    @Override
    public BookingDTO searchBooking(String id) {
        if (bookingRepo.existsById(id)) {
            return mapper.map(bookingRepo.findById(id).get(), BookingDTO.class);
        }else{
            throw new RuntimeException("No Booking made For " + id + " ..!");
        }
    }

    @Override
    public List<BookingDTO> getAllBooking() {
        return mapper.map(bookingRepo.findAll(), new TypeToken<List<BookingDTO>>() {
        }.getType());
    }

}
