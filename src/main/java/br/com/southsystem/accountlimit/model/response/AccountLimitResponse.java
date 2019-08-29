package br.com.southsystem.accountlimit.model.response;


import br.com.southsystem.accountlimit.model.entity.AccountLimit;

import java.math.BigDecimal;

public class AccountLimitResponse {

    private String idLimit;
    private BigDecimal value;

    public AccountLimitResponse(AccountLimit save) {
        idLimit = save.getId();
    }

    public String getIdLimit() {
        return idLimit;
    }

    public void setIdLimit(String idLimit) {
        this.idLimit = idLimit;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
