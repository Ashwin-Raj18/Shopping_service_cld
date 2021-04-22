package com.posoul.springDataJpa.MultiEntity.dto;


import com.posoul.springDataJpa.MultiEntity.entities.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderRequest {

    private  Customer customer;
}