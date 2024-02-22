package com.User.poolMicroService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "PoolService",
        url = "${pool_micro_service.url}"
)
public interface PoolService {
    @DeleteMapping(path = "pool/delete_reply{user_id}")
    void deleteUserReplies (@RequestParam Integer uId);
}
