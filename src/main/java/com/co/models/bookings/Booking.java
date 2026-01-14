package com.co.models.bookings;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Represents a booking with details such as guest name, price, and dates. */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Booking {

  @JsonProperty("firstname")
  private String firstName;

  @JsonProperty("lastname")
  private String lastName;

  @JsonProperty("totalprice")
  private Integer totalPrice;

  @JsonProperty("depositpaid")
  private Boolean depositPaid;

  @JsonProperty("bookingdates")
  private BookingDate bookingDate;

  @JsonProperty("additionalneeds")
  private String additionalNeed;
}
