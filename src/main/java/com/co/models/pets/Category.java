package com.co.models.pets;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Represents a category for a pet. */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Category {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("name")
  private String name;
}
