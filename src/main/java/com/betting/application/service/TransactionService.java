package com.betting.application.service;

import com.betting.application.domain.AccountHistoryPoint;
import com.betting.application.domain.BankAccount;
import com.betting.application.domain.Transaction;
import com.betting.application.domain.User;
import com.betting.application.domain.dto.transaction.TransactionCreatorDto;
import com.betting.application.domain.dto.transaction.TransactionDto;
import com.betting.application.repository.BankAccountRepository;
import com.betting.application.repository.TransactionRepository;
import com.betting.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public List<TransactionDto> getUserTransactions(Long userId){
        Optional<User> user = userRepository.findById(userId);
        List<TransactionDto> transactionDtos = new ArrayList<>();
        if(user.isPresent()){
            List<AccountHistoryPoint> accountHistoryPoints = user.get().getBetAccount().getAccountHistoryPointList();
            for(AccountHistoryPoint accountHistoryPoint : accountHistoryPoints){
                Transaction transaction = accountHistoryPoint.getTransaction();
                transactionDtos.add(new TransactionDto(transaction.getTransactionId(),
                        transaction.getAccountHistoryPoint(),
                        transaction.getPaymentDirection(),
                        transaction.getAmount(),
                        transaction.getBankAccount()));
            }
        } else {}
        return transactionDtos;
    }

    public void createUserTransaction(TransactionCreatorDto transactionCreatorDto){
        Optional<BankAccount> bankAccount = bankAccountRepository.findById(transactionCreatorDto.getBankAccountId());
        if(bankAccount.isPresent()){
            transactionRepository.save(new Transaction(transactionCreatorDto.getPaymentDirection(),
                    transactionCreatorDto.getAmount(),
                    bankAccount.get()));
        } else {}
    }
}
