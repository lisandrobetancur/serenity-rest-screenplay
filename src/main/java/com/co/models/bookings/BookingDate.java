package com.co.models.bookings;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Represents the check-in and check-out dates for a booking. */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BookingDate {

  @JsonProperty("checkin")
  private String checkIn;

  @JsonProperty("checkout")
  private String checkOut;
}
