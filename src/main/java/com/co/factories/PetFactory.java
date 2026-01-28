package com.co.factories;

import com.co.models.pets.Category;
import com.co.models.pets.Pet;
import com.co.models.pets.Tag;
import java.util.List;
import java.util.Map;

/**
 * Factory class to create Pet objects.
 */
public final class PetFactory {
  
  private PetFactory(){
    throw new IllegalStateException("Factory class");
  }

  /**
   * Creates a PetBuilder instance populated with data from a map.
   *
   * @param petData A map containing the pet data.
   * @return A PetBuilder instance with the populated data.
   */
  public static Pet.PetBuilder getPet(Map<String, Object> petData) {
    return Pet.builder()
        .id(Long.valueOf(petData.get("id").toString()))
        .category(
            Category.builder()
                .id(Long.valueOf(petData.get("category_id").toString()))
                .name(petData.get("category_name").toString())
                .build())
        .name(petData.get("name").toString())
        .photoUrls(List.of(petData.get("photo_url").toString()))
        .tags(
            List.of(
                Tag.builder()
                    .id(Long.valueOf(petData.get("tag_id").toString()))
                    .name(petData.get("tag_name").toString())
                    .build()))
        .status(petData.get("status").toString());
  }
}
