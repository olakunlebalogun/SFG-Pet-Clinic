package com.olakunle.sfgpetclinic;

import com.olakunle.sfgpetclinic.bootstrap.DataLoader;
import com.olakunle.sfgpetclinic.service.map.OwnerServiceMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class SfgPetClinicApplication {
    public static void main(String[] args) {
       SpringApplication.run(SfgPetClinicApplication.class, args);

    }


}
