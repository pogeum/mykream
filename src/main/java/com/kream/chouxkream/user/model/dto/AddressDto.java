package com.kream.chouxkream.user.model.dto;

import com.kream.chouxkream.user.model.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@Setter
public class AddressDto {

    private Long addressNo; //필수
    private String receiverName; //필수
    private String receiverPhone; //필수
    private String zipcode; //필수
    private String address; //필수
    private String detailAddress; //필수 X
    private boolean defaultAddress;
}
