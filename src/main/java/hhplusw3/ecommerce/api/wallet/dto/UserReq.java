package hhplusw3.ecommerce.api.wallet.dto;

import lombok.Data;

@Data
public class UserReq {
    private long id;
    private String name;
    private long money;
}
