package br.com.southsystem.accountlimit.service;

import br.com.southsystem.accountlimit.model.entity.AccountLimit;
import br.com.southsystem.accountlimit.model.request.AccountLimitRequest;
import br.com.southsystem.accountlimit.model.response.AccountLimitResponse;
import br.com.southsystem.accountlimit.repository.AccountLimitRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountLimitService {

    private final AccountLimitRepository repository;
    @Value("${limit.default.value}")
    private BigDecimal limitValue;


    public AccountLimitService(AccountLimitRepository repository) {
        this.repository = repository;
    }

    public AccountLimitResponse create(AccountLimitRequest request) {
        AccountLimit accountLimit = new AccountLimit(request);
        accountLimit.setLimit(limitValue);
        return new AccountLimitResponse(repository.save(accountLimit));
    }

    public Page<AccountLimit> findAll(Pageable page) {
        return repository.findAll(page);
    }

    public Optional<AccountLimit> find(String id) {
        return repository.findById(id);
    }
}
