package com.tttnbackend.tttnbackend.sevice.Impl;

import com.tttnbackend.tttnbackend.dto.BookingRequest;
import com.tttnbackend.tttnbackend.entity.Booking;
import com.tttnbackend.tttnbackend.entity.PaymentHistory;
import com.tttnbackend.tttnbackend.entity.User;
import com.tttnbackend.tttnbackend.exception.ResourceNotFoundException;
import com.tttnbackend.tttnbackend.repository.BookingRepository;
import com.tttnbackend.tttnbackend.repository.PaymentHistoryRepository;
import com.tttnbackend.tttnbackend.repository.TripRepository;
import com.tttnbackend.tttnbackend.repository.UserRepository;
import com.tttnbackend.tttnbackend.sevice.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final TripRepository tripRepository;
    private final PaymentHistoryRepository paymentHistoryRepository;

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking findById(Long id) {
        return bookingRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not found booking"));
    }

    @Override
    public List<Booking> findAllByPhone(String phone) {
        return bookingRepository.findAllByPhone(phone);
    }

    @Override
    public List<Booking> findAllByUsername(String username) {
        User foundUser = userRepository.findByUsername(username).orElseThrow(()-> new ResourceNotFoundException("Not found user"));
        return bookingRepository.findAllByUser(foundUser);
    }

    @Override
    public List<Booking> save(BookingRequest bookingRequest) {
        String[] selectSeats = bookingRequest.getSeatNumber();
        List<Booking> orderedBookings = new ArrayList<>();
        for (String seat: selectSeats) {

            orderedBookings.add(Booking.builder()
                    .trip(bookingRequest.getTrip())
                    .bookingType(bookingRequest.getBookingType())
                    .custFirstName(bookingRequest.getFirstName())
                    .custLastName(bookingRequest.getLastName())
                    .email(bookingRequest.getEmail())
                    .paymentDateTime(bookingRequest.getPaymentDateTime())
                    .totalPayment(bookingRequest.getTotalPayment())
                    .seatNumber(seat).build()
            );
        }
        var saveBookings = bookingRepository.saveAll(orderedBookings);
        List<PaymentHistory> paymentHistories = new ArrayList<>();
        for (Booking savedBooking: saveBookings) {
            paymentHistories.add(PaymentHistory.builder()
            .booking(savedBooking)
                    .oldStatus(null)
                    .newStatus(savedBooking.getPaymentStatus())
                    .statusChangeDateTime(savedBooking.getPaymentDateTime())
                    .build());
        }
        paymentHistoryRepository.saveAll(paymentHistories);
        return saveBookings;
    }

    @Override
    public Booking update(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public String delete(Long id) {
        if(bookingRepository.existsById(id)) {
            bookingRepository.deleteById(id);
            return "Delete booking success";
        }else{
            return "Not found booking";
        }
    }
}
