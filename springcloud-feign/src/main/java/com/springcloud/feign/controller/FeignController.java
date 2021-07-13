package com.springcloud.feign.controller;

import com.springcloud.feign.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/feign")
public class FeignController {
    @Autowired
    private ProviderService providerService;

    @GetMapping("/answer")
    @ResponseBody
    public String answer(@RequestParam("name") String name) {
        return providerService.wantToDone(name);
    }

    @GetMapping("/echo")
    @ResponseBody
    public String echo() {
        return "I'm FeignService";
    }
}
