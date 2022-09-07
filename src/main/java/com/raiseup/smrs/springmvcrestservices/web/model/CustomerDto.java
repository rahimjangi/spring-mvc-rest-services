package com.raiseup.smrs.springmvcrestservices.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
public class CustomerDto {
    private UUID id;
    private String firstName;
    private String lastName;
}
