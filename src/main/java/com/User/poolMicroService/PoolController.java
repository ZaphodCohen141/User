package com.User.poolMicroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pool")
public class PoolController {
    @Autowired
    private PoolService poolService;

    @DeleteMapping
    public void deleteRepliesByUserId(@RequestParam Integer id){
        poolService.deleteUserReplies(id);
    }
}
