package com.oyo.HotelManagement2.service;


import com.oyo.HotelManagement2.dto.request.BookingRequestDto;
import com.oyo.HotelManagement2.dto.request.PriceRequestDto;
import com.oyo.HotelManagement2.dto.response.BookingResponseDto;
import com.oyo.HotelManagement2.dto.response.NotificationDataDto;
import com.oyo.HotelManagement2.entity.Booking;
import com.oyo.HotelManagement2.entity.Customer;
import com.oyo.HotelManagement2.interfaces.NotificationService;
import com.oyo.HotelManagement2.repository.BookingRepo;
import com.oyo.HotelManagement2.repository.CustomerRepo;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Builder
@Service
public class BookingService {

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    CustomerRepo cusrepo;

    @Autowired
    private PriceInventoryService priceInventoryService;

    public BookingResponseDto createBooking(BookingRequestDto bookingRequestDto) {
        // Validate request
        if (bookingRequestDto == null || bookingRequestDto.getHotelId() == null || bookingRequestDto.getRoomId() == null) {
            throw  new RuntimeException("wdfwg");
        }

        // Check availability and inventory
        boolean isNotAvailable = priceInventoryService
                .getPriceAndInvetoryForHotel(bookingRequestDto.getHotelId(), bookingRequestDto.getCheckin())
                .stream().anyMatch(details -> details.getIsSoldOut());

        if (isNotAvailable) {
            throw new RuntimeException("Room is not available for selected dates");
        }










        // Create booking with status 'CREATED'
        Customer customer = new Customer();

        // Create and save Customer first

        customer.setId(bookingRequestDto.getCustomerId());  // Set customer details if required
// Add more customer fields if needed here

        cusrepo.save(customer);  // Save customer to persist it in the database
        Booking booking = new Booking();
        booking.setCustomer(customer);
        booking.setHotelId(bookingRequestDto.getHotelId());
        booking.setBookingAmt(bookingRequestDto.getBookingAmount());
        booking.setCheckInDate(bookingRequestDto.getCheckin());
        booking.setChecOutDate(bookingRequestDto.getCheckout());
        booking.setRoomId(bookingRequestDto.getRoomId());
        booking.setStatus("Your booking is created");
        booking.setNumberOfGuest(bookingRequestDto.getNumberOfGuest());



        bookingRepo.save(booking);



        // Send notification
        NotificationDataDto notify = getNotificationSenderDto();
        notificationService.sendNotification(notify);

        // Return booking response
        BookingResponseDto response = new BookingResponseDto();
        response.setBookingId(booking.getId()); // Assuming the booking has an ID
        response.setStatus("Happy Booking:)");

        // Update inventory after booking
        PriceRequestDto priceRequestDto = new PriceRequestDto();
        // Assuming the quantity comes from booking request
        priceRequestDto.setDate(bookingRequestDto.getCheckin());
        priceRequestDto.setQty(1);
        priceRequestDto.setHotelId(bookingRequestDto.getHotelId());
        priceInventoryService.updateInventory(priceRequestDto,true);

        return response;
    }

    private NotificationDataDto getNotificationSenderDto() {
        NotificationDataDto notify = new NotificationDataDto();
        notify.setSubject("Booking confirmation");
        notify.setText("Congratulations! Your Booking is confirmed");
        notify.setUserEMail("bhattraipooja508@gmail.com"); // Replace with actual user email
        return notify;
    }

    public Boolean cancelBooking(Integer bookingId) {
        // Step 1: Validate booking existence and status
        Optional<Booking> optionalBooking = bookingRepo.findById(bookingId);
        if (!optionalBooking.isPresent()) {
            throw new RuntimeException("Booking not found.");
        }

        Booking booking = optionalBooking.get();
        if ("CANCELLED".equals(booking.getStatus())) {
            throw new RuntimeException("Booking is already cancelled.");
        }

        // Step 2: Update booking status
        booking.setStatus("CANCELLED");
        bookingRepo.save(booking);

        // Step 3: Increase inventory after cancellation
        PriceRequestDto priceRequestDto = new PriceRequestDto();
        // Assuming the quantity is stored in booking
        priceRequestDto.setHotelId(booking.getHotelId());
        priceRequestDto.setQty(1);
        priceRequestDto.setDate(booking.getCheckInDate());
        priceInventoryService.updateInventory(priceRequestDto ,false);

        // Step 4: Return success
        return true;
    }

    public BookingResponseDto getBooking(Integer bookingId) {
        // Implementation for getting booking details
        return null;
    }
}

