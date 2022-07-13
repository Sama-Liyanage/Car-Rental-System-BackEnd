package lk.easyrental.service.impl;

import lk.easyrental.dto.BookingDTO;
import lk.easyrental.dto.BookingReturnDTO;
import lk.easyrental.entity.BookingReturn;
import lk.easyrental.repo.BookingRepo;
import lk.easyrental.repo.BookingReturnRepo;
import lk.easyrental.service.BookingReturnService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookingReturnsServiceImpl implements BookingReturnService {

    @Autowired
    ModelMapper mapper;

    @Autowired
    BookingReturnRepo bookingReturnRepo;

    @Override
    public void saveBookingReturn(BookingReturnDTO dto) {
        if (!bookingReturnRepo.existsById(dto.getReturnID())){
            bookingReturnRepo.save(mapper.map(dto, BookingReturn.class));
        }else{
            throw new RuntimeException("Already Returned!");
        }
    }

    @Override
    public void deleteBookingReturn(String id) {
        if (bookingReturnRepo.existsById(id)){
            bookingReturnRepo.deleteById(id);
        }else{
            throw new RuntimeException("Booking Not Exist..! Please Check ID");
        }
    }

    @Override
    public void updateBookingReturn(BookingReturnDTO dto) {
        if (bookingReturnRepo.existsById(dto.getReturnID())){
            bookingReturnRepo.save(mapper.map(dto, BookingReturn.class));
        }else{
            throw new RuntimeException("Booking Not Exist..! Please Check ID");
        }
    }


    @Override
    public BookingReturnDTO searchBookingReturn(String id) {
        if (bookingReturnRepo.existsById(id)) {
            return mapper.map(bookingReturnRepo.findById(id).get(), BookingReturnDTO.class);
        }else{
            throw new RuntimeException("No Booking made For " + id + " ..!");
        }
    }

    @Override
    public List<BookingReturnDTO> getAllBookingReturns() {
        return mapper.map(bookingReturnRepo.findAll(), new TypeToken<List<BookingDTO>>() {
        }.getType());
    }




}
