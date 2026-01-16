package com.co.models.pets;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Represents a pet. */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Pet {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("category")
  private Category category;

  @JsonProperty("name")
  private String name;

  @JsonProperty("photoUrls")
  private List<String> photoUrls;

  @JsonProperty("tags")
  private List<Tag> tags;

  @JsonProperty("status")
  private String status;
}
