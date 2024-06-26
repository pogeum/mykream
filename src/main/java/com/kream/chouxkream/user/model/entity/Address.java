package com.kream.chouxkream.user.model.entity;


import lombok.*;


import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressNo;


    public void unFilleddetailAddress() {
        this.detailAddress = "Unfilled address details.";
    }

//    public Address(String receiverName, String receiverPhone, String zipcode, String address, boolean defaultAddress) {
//        this.receiverName = receiverName;
//        this.receiverPhone = receiverPhone;
//        this.zipcode = zipcode;
//        this.address = address;
//        this.defaultAddress = defaultAddress;
//    }

    @Column(nullable = false)
    private String receiverName;

    @Column(nullable = false)
    private String receiverPhone;

    @Column(nullable = false)
    private String zipcode;

    @Column(nullable = false)
    private String address;

    @Column(nullable = true)
    private String detailAddress;

    @Column(nullable = false, columnDefinition = "bit default 0")
    private boolean defaultAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no")
    private User user;

}
