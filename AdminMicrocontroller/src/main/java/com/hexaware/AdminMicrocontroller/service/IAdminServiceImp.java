package com.hexaware.AdminMicrocontroller.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hexaware.AdminMicrocontroller.dto.AdminDTO;
import com.hexaware.AdminMicrocontroller.dto.AssetAllocationDTO;
import com.hexaware.AdminMicrocontroller.dto.AssetDTO;
import com.hexaware.AdminMicrocontroller.dto.AssetRequestDTO;
import com.hexaware.AdminMicrocontroller.dto.AuditRequestDTO;
import com.hexaware.AdminMicrocontroller.dto.CredentialDTO;
import com.hexaware.AdminMicrocontroller.dto.ServiceRequestDTO;
import com.hexaware.AdminMicrocontroller.entities.Admin;
import com.hexaware.AdminMicrocontroller.entities.Credential;
import com.hexaware.AdminMicrocontroller.repository.IAdminRepository;
import com.hexaware.AdminMicrocontroller.repository.ICredentialRepository;

@Service
public class IAdminServiceImp implements IAdminService {

	@Autowired
	IAdminRepository adminRepo;
	
	@Autowired
	ICredentialRepository credentialRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public AdminDTO addAdmin(Admin admin) {
		
		adminRepo.save(admin);
		return adminentity2dto(admin);
		
	}

	@Override
	public AdminDTO updateAdmin(Admin admin){
		
		adminRepo.save(admin);
		return adminentity2dto(admin);
	}

	@Override
	public String deleteAdmin(int adminId){
		
		
		adminRepo.deleteById(adminId);
		return adminId+" deleted successfully";
	}

	@Override
	public AdminDTO getAdminById(int adminId) {

		
		Admin admin = adminRepo.findById(adminId).orElse(null);
		return adminentity2dto(admin);
	}

	@Override
	public List<AdminDTO> getAllAdmins() {
		
		List<Admin> admin = adminRepo.findAll();
		List<AdminDTO> admindto = adminentity2dtolist(admin);
		return admindto;
	}

	@Override
	public CredentialDTO addCredential(Credential credential) {
		
		credentialRepo.save(credential);
		return credential2dto(credential);
	}

	@Override
	public int updatePassword(String userName, String password) {
		
		return credentialRepo.updatePassword(userName, password);
	}

	@Override
	public String deleteCredential(int adminId) {
		
		credentialRepo.deleteById(adminId);
		return adminId+" credential deleted successfully";
	}

	@Override
	public CredentialDTO getCredentialByAdminId(int adminId) {
		
		Credential credential = credentialRepo.findById(adminId).orElse(null);
		return credential2dto(credential);
	}
	
	@Override
	public CredentialDTO getCredentialByUserName(String userName) {
		
		Credential credential = credentialRepo.findByUserName(userName);
		return credential2dto(credential);
	}

	@Override
	public List<CredentialDTO> getAllCredentials() {
		
		List<Credential> credential = credentialRepo.findAll();
		return credential2dtolist(credential);
	}

	@Override
	public CredentialDTO authenticate(String userName, String password) {
		
		Credential credential =  credentialRepo.authenticate(userName, password);
		return credential2dto(credential);
	}
	

	@Override
	public AssetDTO addAsset(AssetDTO asset) {
		
		return restTemplate.postForObject("api/asset/add", asset, AssetDTO.class);
	}

	@Override
	public AssetDTO getAssetByNo(int assetNo) {
		
		return restTemplate.getForObject("api/asset/getassetbyno/"+assetNo, AssetDTO.class);
	}

	@Override
	public List<AssetDTO> getAllAssets() {
		return restTemplate.getForObject("api/asset/getall", null);
	}

	@Override
	public List<AssetDTO> getAssetsByCategory(String category) {
		return restTemplate.getForObject("api/asset/getassetbycategory/"+category, null);
	}

	@Override
	public AssetDTO updateAsset(AssetDTO asset) {
		
		restTemplate.put("api/asset/update", asset, AssetDTO.class);
		return asset;
	}

	@Override
	public String deleteAsset(int assetNo) {
		
		restTemplate.delete("api/asset/getassetbycategory/"+assetNo);
		return assetNo+" deleted successfully";
	}

	@Override
	public AssetAllocationDTO allocateAssetToUser(int userId, int assetNo, LocalDate returnDate) {
		
		return restTemplate.postForObject("/api/assetallocation/allocateasset/"+userId+"/"+assetNo+"/"+returnDate, null, AssetAllocationDTO.class);
	}

	@Override
	public AssetAllocationDTO getAllocationById(int allocationId) {
		return restTemplate.getForObject("/api/assetallocation/getallocationbyid/"+allocationId, AssetAllocationDTO.class);
	}

	@Override
	public List<AssetAllocationDTO> getAllAllocations() {
		return restTemplate.getForObject("/api/assetallocation/getallallocations", null);
	}

	@Override
	public List<AssetAllocationDTO> getAllocationsByEmployeeId(int employeeId) {
		return restTemplate.getForObject("/api/assetallocation/getallocationbyemployeeid/"+employeeId, null);
	}

	@Override
	public String returnAsset(int allocationId) {
		
		restTemplate.put("/api/assetallocation/return/"+allocationId, null);
		return allocationId+" returned";
	}

	@Override
	public ServiceRequestDTO addServiceRequest(ServiceRequestDTO request) {
		
		return restTemplate.postForObject("/api/servicerequest/add", request, ServiceRequestDTO.class);
	}

	@Override
	public ServiceRequestDTO updateServiceRequestStatus(int requestId, String status) {
		
		restTemplate.put("/api/servicerequest/update/"+requestId+"/"+status, ServiceRequestDTO.class);
		return restTemplate.getForObject("/api/servicerequest/getbyrequestid/"+requestId, ServiceRequestDTO.class);
	}

	@Override
	public List<ServiceRequestDTO> getAllRequests() {
		return restTemplate.getForObject("/api/servicerequest/getall", null);
	}

	@Override
	public List<ServiceRequestDTO> getAllRequestsByEmployeeId(int employeeId) {
		return restTemplate.getForObject("/api/servicerequest/getbyid/"+employeeId, null);
	}

	@Override
	public List<ServiceRequestDTO> getAllRequestsByStatus(String status) {
		return restTemplate.getForObject("/api/servicerequest/getbystatus/"+status, null);
	}

	@Override
	public List<ServiceRequestDTO> getAllRequestsByIssueType(String issueType) {
		return restTemplate.getForObject("/api/servicerequest/getbyissuetype/"+issueType, null);
	}

	@Override
	public AuditRequestDTO addAuditRequest(int employeeId, int assetNo) {
		
		return restTemplate.postForObject("/api/auditrequest/add/"+employeeId+"/"+assetNo, null, AuditRequestDTO.class);
	}

	@Override
	public List<AuditRequestDTO> getAuditRequestsByStatus(String status) {
		return restTemplate.getForObject("/api/auditrequest/getbystatus/"+status, null);
	}

	@Override
	public List<AuditRequestDTO> getAllAuditRequests() {
		return restTemplate.getForObject("/api/auditrequest/getall", null);
	}

	@Override
	public AuditRequestDTO updateAuditRequestStatus(int auditNo, String status) {
		
		restTemplate.put("/api/auditrequest/updatestatus"+auditNo+"/"+status, AuditRequestDTO.class);
		return null;
	}
	
	@Override
	public List<AuditRequestDTO> getAuditRequestsByEmployeeId(int employeeId) {
	
		return restTemplate.getForObject("/api/auditrequest", null);
	}
	
	@Override
	public List<AuditRequestDTO> getAuditRequestsByRequestId(int requestId) {
	
		return restTemplate.getForObject("/api/auditrequest", null);
	}

	@Override
	public AssetRequestDTO addAssetRequest(int employeeId, int assetNo) {
		
		return restTemplate.postForObject("/api/auditrequest/add"+employeeId+"/"+assetNo,null, AssetRequestDTO.class);
	}

	@Override
	public List<AssetRequestDTO> getAssetRequestsByEmployeeId(int employeeId) {
		
		return restTemplate.getForObject("/api/auditrequest/getbyemployeeid/"+employeeId, null);
	}

	@Override
	public List<AssetRequestDTO> getAssetRequestsByStatus(String status) {
		return restTemplate.getForObject("/api/auditrequest/getbystatus/"+status, null);
	}

	@Override
	public List<AssetRequestDTO> getAllAssetRequests() {
		
		return restTemplate.getForObject("/api/auditrequest/getall", null);
	}

	@Override
	public AssetRequestDTO updateAssetRequestStatus(int auditNo, String status) {
		
		restTemplate.put("/api/auditrequest/updatestatus/"+auditNo+"/"+status,AssetRequestDTO.class);
		return null;
	}
	
	@Override
	public AssetAllocationDTO grantAsset(int userId,int assetNo,LocalDate returnDate)
	{
		return restTemplate.postForObject("/api/assetallocation/allocateasset/"+userId+"/"+assetNo+"/"+returnDate, null, AssetAllocationDTO.class);
	}
	
	
	public static AdminDTO adminentity2dto(Admin admin)
	{
		AdminDTO adminDto = new AdminDTO();
		adminDto.setAdminId(admin.getAdminId());
		adminDto.setFirstName(admin.getFirstName());
		adminDto.setLastName(admin.getLastName());
		adminDto.setGender(admin.getGender());
		adminDto.setAddress(admin.getAddress());
		adminDto.setContactNumner(admin.getContactNumner());
		adminDto.setEmail(admin.getEmail());
		
		return adminDto;
	}
	
	public static List<AdminDTO> adminentity2dtolist(List<Admin> adminList)
	{
		List<AdminDTO> adminListDto = new ArrayList();
		for(Admin admin:adminList)
		{
			AdminDTO adminDto = new AdminDTO();
			adminDto.setAdminId(admin.getAdminId());
			adminDto.setFirstName(admin.getFirstName());
			adminDto.setLastName(admin.getLastName());
			adminDto.setGender(admin.getGender());
			adminDto.setAddress(admin.getAddress());
			adminDto.setContactNumner(admin.getContactNumner());
			adminDto.setEmail(admin.getEmail());
			
			adminListDto.add(adminDto);
		}
		return adminListDto;
	}
	
	public static CredentialDTO credential2dto(Credential credential)
	{
		CredentialDTO credentailDto = new CredentialDTO();
		credentailDto.setAdminId(credential.getAdminId());
		credentailDto.setPassword(credential.getPassword());
		credentailDto.setUserName(credential.getUserName());
		
		return credentailDto;
	}
	
	public static List<CredentialDTO> credential2dtolist(List<Credential> credentialList)
	{
		List<CredentialDTO> credentialListDto = new ArrayList();
		for(Credential credential:credentialList)
		{
			CredentialDTO credentailDto = new CredentialDTO();
			credentailDto.setAdminId(credential.getAdminId());
			credentailDto.setPassword(credential.getPassword());
			credentailDto.setUserName(credential.getUserName());
			
			credentialListDto.add(credentailDto);
		}
		return credentialListDto;
	}


	

    
}
