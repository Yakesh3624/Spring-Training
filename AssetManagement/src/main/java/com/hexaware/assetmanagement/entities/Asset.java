package com.hexaware.assetmanagement.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Pattern.Flag;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Asset {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "asset_no")
	private Long assetNo;

	@NotBlank(message = "Asset name is required")
	@Size(min = 2, max = 50, message = "Asset name must be between 2 and 50 characters")
	@Column(nullable = false)
	private String assetName;

	@Pattern(regexp = "Laptop|Furniture|Car|Gadgets", flags = Flag.CASE_INSENSITIVE, message = "Category must be one of: Laptop, Furniture, Car, Gadgets")
	@Column(nullable = false)
	private String category;

	@Size(min = 1, max = 30, message = "Model must be between 1 and 30 characters")
	@Column(nullable = true, name = "model")
	private String assetModel;

	@NotNull(message = "Manufacturing date is required")
	@PastOrPresent(message = "Manufacturing date cannot be in the future")
	@Column(nullable = false)
	private LocalDate manufacturingDate;

	@Future(message = "Expiry date must be in the future")
	@Column(nullable = true)
	private LocalDate expiryDate;

	@DecimalMin(value = "0.0", inclusive = false, message = "Asset value must be greater than 0")
	@Column(nullable = false)
	private Double assetValue;

	@NotNull(message = "Availability should not be null")
	@Pattern(regexp = "available|unavailable", message = "Availability must be either 'available' or 'unavailable'")
	private String availability;

}
