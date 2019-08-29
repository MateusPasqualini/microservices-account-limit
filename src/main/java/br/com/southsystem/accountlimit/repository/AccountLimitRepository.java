package br.com.southsystem.accountlimit.repository;

import br.com.southsystem.accountlimit.model.entity.AccountLimit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountLimitRepository extends MongoRepository<AccountLimit, String> {
}
