package com.register.register.chatapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.register.register.chatapp.model.BidAmount;
@Repository
public interface BidAmountRepository  extends JpaRepository<BidAmount, Integer>{
  @Query(value =  "SELECT *FROM bid_amount WHERE amount = (SELECT MAX(amount) FROM bid_amount)", nativeQuery = true)
    Optional<BidAmount> findByMaxAmount();
}
