package com.co.models.bookings;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/** Represents the check-in and check-out dates for a booking. */
@Data
public class BookingDate {

  @JsonProperty("checkin")
  private String checkIn;

  @JsonProperty("checkout")
  private String checkOut;
}
