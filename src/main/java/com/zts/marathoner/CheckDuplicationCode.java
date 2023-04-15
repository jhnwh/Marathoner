package com.zts.marathoner;

import com.zts.marathoner.dict.StatusCode;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Order(1)
@Component
public class CheckDuplicationCode implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        HashSet<Integer> codeSet = new HashSet<>();
        for (StatusCode value : StatusCode.values()) {
            if(codeSet.contains(value.getCode())){
                System.out.println("状态码存在重复，请检查！重复值为" + value.getCode());
                System.exit(1);
            } else {
                codeSet.add(value.getCode());
            }
        }
    }
}
