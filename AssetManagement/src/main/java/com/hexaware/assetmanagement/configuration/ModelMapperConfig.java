package com.hexaware.assetmanagement.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hexaware.assetmanagement.dto.AssetAllocationDTO;
import com.hexaware.assetmanagement.dto.AssetRequestDTO;
import com.hexaware.assetmanagement.dto.AuditRequestDTO;
import com.hexaware.assetmanagement.dto.ServiceRequestDTO;
import com.hexaware.assetmanagement.entities.AssetAllocation;
import com.hexaware.assetmanagement.entities.AssetRequest;
import com.hexaware.assetmanagement.entities.AuditRequest;
import com.hexaware.assetmanagement.entities.ServiceRequest;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // AssetAllocation mapping
        modelMapper.typeMap(AssetAllocation.class, AssetAllocationDTO.class).addMappings(mapper -> {
            mapper.map(src -> src.getAsset().getAssetNo(), AssetAllocationDTO::setAssetNo);
            mapper.map(src -> src.getUser().getUsersId(), AssetAllocationDTO::setUsersId);
        });
        
        // AuditRequest mapping
        modelMapper.typeMap(AuditRequest.class, AuditRequestDTO.class).addMappings(mapper -> {
        	mapper.map(src -> src.getAsset().getAssetNo(), AuditRequestDTO::setAssetNo);
        	mapper.map(src -> src.getUser().getUsersId(), AuditRequestDTO::setUsersId);
        });

        // AssetRequest mapping
        modelMapper.typeMap(AssetRequest.class, AssetRequestDTO.class).addMappings(mapper -> {
            mapper.map(src -> src.getAsset().getAssetNo(), AssetRequestDTO::setAssetNo);
            mapper.map(src -> src.getUser().getUsersId(), AssetRequestDTO::setUsersId);
        });

        // ServiceRequest mapping
        modelMapper.typeMap(ServiceRequest.class, ServiceRequestDTO.class).addMappings(mapper -> {
            mapper.map(src -> src.getAsset().getAssetNo(), ServiceRequestDTO::setAssetNo);
            mapper.map(src -> src.getUser().getUsersId(), ServiceRequestDTO::setUsersId);
        });

        return modelMapper;
    }
}
