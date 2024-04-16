package com.kream.chouxkream.user.service;

import com.kream.chouxkream.product.model.entity.ProductSize;
import com.kream.chouxkream.user.model.entity.User;
import com.kream.chouxkream.user.model.entity.Wishlist;
import com.kream.chouxkream.user.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WishlistService {
    private final WishlistRepository wishListRepository;

    public List<Wishlist> getUserWishList (User user) {
        return this.wishListRepository.findAllByUserNo(user.getUserNo());
    }

    public boolean updateWishlist (User user, ProductSize productSize) {
        if (!wishListRepository.existsByUserAndProductSize(user, productSize)){ //없으면 추가
            Wishlist wishlist = new Wishlist();
            wishlist.setProductSize(productSize);
            wishlist.setUser(user);
            user.getWishlist().add(wishlist);
            this.wishListRepository.save(wishlist);

//            productSize.setWishlist(wishlist);
//            this.wishListRepository.save(wishlist);
            return true;
        } else { //있는 경우
            List<Wishlist> wishlists = user.getWishlist();
            for (Wishlist w : wishlists) {
                if (w.getProductSize().getProductSizeNo() == productSize.getProductSizeNo()){
                    this.wishListRepository.delete(w);
                }
            }
//            Wishlist wishlist = productSize.getWishlist().;
//            this.wishListRepository.delete(wishlist);
            return false;
        }
    }




}
