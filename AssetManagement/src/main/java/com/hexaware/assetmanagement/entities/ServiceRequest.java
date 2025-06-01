package com.hexaware.assetmanagement.entities;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@ToString(exclude = { "asset", "user" })
@Table(name = "service_request")
public class ServiceRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long requestId;

	@NotBlank(message = "Description is required")
	@Size(min=2,max=20)
	@Column(nullable = false, name = "description")
	private String assetDescription;

	@NotBlank(message = "Issue type is required")
	@Pattern(regexp = "Malfunction|Repair", flags = Flag.CASE_INSENSITIVE, message = "Issue type must be Malfunction or Repair")
	@Column(nullable = false, name = "issue_type")
	private String issueType;

	@NotNull(message = "Status is required")
	@Pattern(regexp = "Pending|Approved|Rejected|Completed", flags = Flag.CASE_INSENSITIVE, message = "Status must be one of: PENDING, APPROVED, REJECTED, COMPLETED")
	private String status="Pending";

	@NotNull(message = "Request timestamp is required")
	@Column(nullable = false, name = "requested_at")
	private Timestamp requestedAt = new Timestamp(System.currentTimeMillis());

	@ManyToOne
	@JoinColumn(name = "asset_no")
	private Asset asset;

	@ManyToOne
	@JoinColumn(name = "users_id")
	private Users user;

}
