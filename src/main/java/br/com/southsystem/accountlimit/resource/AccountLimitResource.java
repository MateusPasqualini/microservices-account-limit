package br.com.southsystem.accountlimit.resource;

import br.com.southsystem.accountlimit.model.entity.AccountLimit;
import br.com.southsystem.accountlimit.model.request.AccountLimitRequest;
import br.com.southsystem.accountlimit.model.response.AccountLimitResponse;
import br.com.southsystem.accountlimit.service.AccountLimitService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account-limit")
public class AccountLimitResource {
    private final AccountLimitService service;

    public AccountLimitResource(AccountLimitService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AccountLimitResponse> create(@RequestBody AccountLimitRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping
    public ResponseEntity<Page<AccountLimit>> getAll(Pageable page) {
        return ResponseEntity.ok(service.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountLimit> get(@PathVariable("id") String id) {
        return service.find(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}